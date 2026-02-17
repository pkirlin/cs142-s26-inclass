# Self-Driving Cars, Part 2

## Group members:

1. name
2. name
3. name

In this lab, you will practice more with using classes written
by others, and writing your own classes as well.  

## Part A: Detecting crashes

- In last week's lab, you discovered that the basic code for
the self-driving cars did not detect when cars occupied the
same square on the board; the cars just drove past each other,
ignoring the presence of the other car.  Today we will make
cars detect when they occupy the same square as another car, and
we will later change the way cars drive, so they avoid each other.

- First, take a look at the `CameraView` class.  Remember, each 
self-driving car has three cameras mounted on it, viewing what
is directly in front of the car, what is to the left, and what
is to the right.  However, the cameras have been upgraded, and 
now the three cameras can see not only the ground on either side 
of the car, but also if there's another *Car* immediately in front, or 
to the left or right.  The `CameraView` class is in charge of storing
the view from *one single camera*, which is why this class has two 
instance variables: a `char` called `ground`, which stores what the 
road looks like, either a '*' for the road or a '.' for grass; 
and a `Car` object called `car`, which stores the `Car` object the camera
sees, if there is one.  The mental model you should have of a car
is that it has three cameras mounted on top of the roof of the car,
with one aimed towards the front of the car, one aimed to the left,
and one aimed to the right.  Each camera, accessed through the `CameraView`
objects, can therefore see what the ground looks like in front of the car,
to the left of the car, and to the right of the car, as well as if
there is an additional car in front of, to the left of, or to the right
of the car.

- Now, open up the Car class and go to the drive() method.  This code
probably looks very similar to the code you wrote last week (only
focus on the code for red and blue cars for now).  Notice how
drive() is now given three CameraView objects as parameters, and 
you can call getGround() and getCar() on these objects to see 
what the three cameras on the car see.  (See the examples of 
calling aheadOfMe.getGround() and leftOfMe.getGround()).

- Open up RaceDemos and run the code (demo1 should run).  Make 
sure you see the red and blue cars driving around the track 
before continuing.

- At the top of the drive() method, write a print
statement that prints both the ground character that the "aheadOfMe"
camera sees, and the car object that this same camera sees.
(You should also add a string "label" in this print
statement so you can distinguish the output from the other printing 
that happens in the program.)

- Run the code.  Which color car is eventually seen by an aheadOfMe 
camera?

__Your answer here__

- Which color car's aheadOfMe camera detected this car ahead of it?

__Your answer here__

- Why did only one car "see" the other car ahead of it?  Why didn't 
each car detect the opposite car ahead of it?

__Your answer here__

- What special word does the print statement print for a car when
no car is detected by the camera?

__Your answer here__

- Now open the RaceTrack class.  Find the startCars() method and
scroll to the end to find the section that detects crashes (it's
marked with a comment.)  Notice how there's a line of code that
calls the crashInto() method in the Car class when a crash is
detected.  Find the crashInto() method in the Car class and add
a print statement inside this method to print out that a crash
has happened, along with the color of the car that is "doing" 
the crashing and the color of the car that is being crashed into.

- When you run the code after adding this print statement, you 
should the see details of the crash when it happens (even though the
cars don't stop).  Which color car does the crashing and which 
color car is crashed into?

__Your answer here__

- Change the starting positions of the red and blue cars in 
the demo1() code in RaceDemos so the roles of the
"crashing car" and "crashed-into car" are reversed.
What did you change and why did this reverse the roles?

__Your answer here__

### Check in with me here.  Feel free to go on if I'm helping others.

## Part B: Handling crashes and avoiding them

- Now that you know how crashes are detected, let's make our code
a bit smarter.  Notice that the Car class has a new instance 
variable that it didn't have last week, called `isBroken`.  Inside
the `crashInto()` method in Car, add `isBroken = true;` when a
crash occurs.

- Run the demo.  What changes visually in the demo?  Does this
change happen to the car that does the crashing or the crashed-into
car?  

__Your answer here__

- Find the code in draw() in RaceTrack that draws the cars.  What `if`
test is used to draw crashed cars differently from non-crashed cars?
  (Hint: look near line 160.)

__Your answer here__

- Broken cars probably shouldn't keep moving around the track
after they crash.  Change crashInto() so that when a car crashes,
it stops moving around the track.  Hint: can you change the speed
of the car?  What line of code did you add to crashInto()?

__Your answer here__

- Change crashInto() so that when a crash happens, the *crashed-into*
car breaks and stops moving rather than the car that does the
crashing.  Paste the lines you changed here:

__Your answer here__

- Change crashInto() so *both* cars break and stop moving.  Paste
the lines you changed here:

__Your answer here__

- So now we can do different things when a crash occurs, but we should
probably have our cars avoid crashes in the first place.  Modify
your code in drive() so that when a car determines which direction it
wants to drive, it also checks is there is a Car object in that 
direction.  In that case, to avoid a crash, have drive() pull off on the
side of the road and stop the car.  This is easier than it seems.
To "pull off" the road, return 0 or 1 or -1 indicating the car should drive
onto a patch of grass rather than the road.  And you already learned
how to stop a car from moving.  

Hint: The special word for the absence of an object in a reference
variable you saw earlier is null.  You can compare a variable with ==
or != to check if it is null; this can be used to check if a camera 
sees a car or not.  e.g., you could write:

```java
Car carAhead = aheadOfMe.getCar();
if (carAhead == null)
```

or

```java
Car carAhead = aheadOfMe.getCar();
if (carAhead != null)
```

or even just `if (aheadOfMe.getCar() ==/!= null` (pick which
comparison you want.)

**Call me over when your cars avoid crashes.  Note that when
a crash is about to occur, only one car should pull off the road
and stop; the other one can keep going.**  If I'm tied up, answer
this bonus question: Why is line 109 in RaceTrack
`if (cars[k] == currentCar) { continue; }` necessary?

### Check in with me here.  Feel free to go on if I'm helping others.

## Part C: Driving more complicated tracks

So far, our cars only ever drive in one direction and never have
a "choice" about where to drive, since the road is only one square
wide and cars can't turn around.  In Part C, we will allow cars
to make choices and we will have them drive in a figure-8 pattern.

- In RaceDemos, comment out the call to demo1() in main and uncomment
demo2().  Run the demo.  You should see a yellow car driving around the
track.  Your job is to make the car drive in a figure-8 pattern.  This
will be done by following the numbers on the track, which are called
"flags."

- First, we will modify the cameras on the car to detect flags
that it sees on the track.  In the CameraView class, add a third 
instance variable for an integer called `flag`, and also add a getter for 
the flag variable.  Also modify the constructor to take the flag 
as a third parameter that will set the flag instance variable. 
(This will break other parts of the code, but we'll fix it next.)

- Second, we must fix the RaceTrack class, which is now broken, because
we changed the parameters to the CameraView constructor and now when
the RaceTrack creates those CameraView objects, we must provide the
extra argument that the constructor needs.  Go to line 60 of RaceTrack,
and notice how this section of code creates integer variables representing
the flags surrounding the car that is currently being driven (4 int
variables = 4 total flags, one per neighboring square of the car).
Immediately below this section is where the CameraView objects are 
created.  Change the calls to the CameraView constructors to pass 
in the appropriate flag variables.  The code should
run correctly now (in that all the red squiggles should be gone, but
the car won't do anything different).

- Now is the fun part!  We are going to modify our Car class to use
the cameras to detect flags.  The car should look for flags in increasing
numerical order.  So when the car passes near flag 1, it should turn
in that direction, then look for flag 2, and turn in that direction, etc.
When it reaches flag 4, it will start looking again for flag 1.  If you
look at the picture of the track, you should see how this will cause the
car to drive in a figure-8 pattern.  

- To make this happen, you need to add a new instance variable to your
Car class to keep track of the **current flag the car is looking for.**  
Add a new instance variable for this (you can pick the name of this
variable).  Inside the Car constructor, initialize this variable to the
value 1, since each car should start by looking for flag #1.

- Now we must change the drive() method so when the car "sees" the flag
its looking for, it will turn in that direction.  Modify the driving
algorithm for yellow/magenta cars so that if any of the 3 cameras on the
car "see" the flag that the car is looking for, the car should turn towards
that flag.  Notice the flags are placed specifically where the car can 
see multiple sections of road at once, so the flag will determine the
correct turning direction for the car. Don't forget that after a flag is 
seen, the car should start looking for the next flag.

- If none of the 3 cameras see a flag, and the car sees multiple sections
of road, the car should prioritize driving straight.  Otherwise, follow
the same driving algorithm that we've been using up to this point (turn
in the direction where the road is.)

- At this point, your car should follow a figure-8 pattern around the track.
**Let me know if you can't get this to work.**

- Uncomment the code in demo2() that adds a magenta car.  Verify that
the magenta car also drives in a figure 8 pattern.  Don't forget you'll
also need to change the numCars argument in the call to the RaceTrack
constructor.

- Bonus: Is it possible for the yellow and magenta cars to crash?

__Your answer here__