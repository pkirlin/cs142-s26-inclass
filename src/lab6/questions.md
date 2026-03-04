# Lab 6: Mapping Memphis

## Group members:

1. name
2. name
3. name

The purpose of this lab is to introduce you to a two new
Java concepts: ArrayLists and file reading.  You will also
become more proficient at using classes written by others
and designing your own.

## Part A: Introduction to ArrayLists and file reading

You will remember that Java has built-in arrays that we
have been using analogously to Python lists.  However,
the biggest difference is that in Java, the programmer 
*must* state the size of the array when it is first declared.
That's why we *have* to say things like 
`int[] array = new int[10];` to make an array of 10 integers.
Furthermore, these Java arrays can never grow nor shrink
in size once they are created; they are fixed-size arrays.
In Python, in CS 141, we got used to making lists that
started off empty and then we used the `append()` function
to attach elements to the end of the list, so the list
grew to how ever many items it needed to hold.

Java has a data type that more closely parallels Python's
lists that can grow and shrink; they are called *ArrayLists*.

Open Introduction.java and look at the arrayListDemo()
function.  Run the main() method which calls this function
and examine the output.  Try to figure out how the code
works and answer the following questions.

- What is the name of the Java method used in the code
  that is the equivalent of Python's append() function?

__Your answer here__

- What is the name of the Java method used in the code
  that is the equivalent of the .length variable for
  regular Java arrays? 

__Your answer here__

- Notice how you can't use square brackets with ArrayLists
to access each element.  What method call do you use
instead?

__Your answer here__

- The complete data type of an ArrayList always includes
the name of the data type that the ArrayList holds.
So the data type of `listOfInts` is `ArrayList<Integer>`.
Try changing this to `ArrayList<int>`.  What error message
does this produce?

__Your answer here__

You will notice that the error message references "primitives."
Remember that a "primitive" in Java is any of the simple,
built-in data types: int, long, float, double, boolean, char.
The reason for this error is that ArrayLists can only hold
object data types, not primitives (primitives are not objects).
Therefore, Java includes "wrapper" classes that allow us
to store primitives as objects of these classes.  Each
primitive in Java has a wrapper class.
The two ones we'll use today are:

int -> Integer
double -> Double
(there are others for each primitive)

Each wrapper class contains a bit of behind-the-scenes
"magic" that allows seamless interactions between primitives
and objects.  For instance, this allows us to write code
like: `int itemInTheList = listOfInts.get(i);` Because
`listOfInts` is an ArrayList of Integers (not ints), the
get() method would normally return an Integer (as an object,
not as a primitive).  However, the wrapper classes will
automatically convert between the primitive type and the
object type, which allows us to assign the result of get()
direction to int itemInTheList.  This also works in the
other direction: when we call add(2), for instance, the 2
is a primitive (an int), not an object (Integer).  However,
Java does the conversion automatically.

### Keep going if this makes sense.  Otherwise check-in.

Now comment out the call to arrayListDemo() in main(), 
and uncomment the next call to fileReadingDemo().  Run
the code and take a look at the code for fileReadingDemo.
You will find it helpful to open sample.txt as well.
You should be able to understand what each line is doing
based on the names of the variables and the methods used.
The only complicated part is where the file is first opened.
The "Introduction.class.getResourceAsStream" thing is used
in Java to automatically look in the same folder as a class.
So this line of code tells Java to find the "Introduction"
class (that's the one we're looking at), and getResourceAsStream
takes a String corresponding to the name of a file in that
same folder (in this case, sample.txt).

Answer the following questions:

- What do you think the test `if (is == null)` does?

__Your answer__

- What do you think the line `while (scan.hasNextLine())`
means (in terms of what does this loop condition do?)

__Your answer__

- What do you think the Integer.parseInt() function does?

__Your answer__

### Keep going if this makes sense.  Otherwise, check in with me.

In main(), comment out the call to fileReadingDemo()
and uncomment the call to fileReadingDemo2().  Open
sample2.txt at the same time.  Then run the code.
See if you can figure out how it works.  Answer these
questions:

- What does `String[] pieces = line.split(",");` do?

__Your answer__

- Look at sample2.txt.  Why did we have to use commas
to separate the three pieces of each line?  Why not
a space?

__Your answer__

- Add code to the while loop that calculates the
average score of all the numbers in the file and prints
it out.  

## End of Part A.  Please check-in here.

## Part B: The roads of Memphis

In Part B, you will investigate a number of classes
that work together to create a visual map of the road
network of Memphis.

Start by opening LatLong.java.  This class is designed
to hold a geographical location as a latitude-longitude
pair of doubles.

Notice that I made the doubles public.  This is one of
the few cases where I think the simplicity of using
public instance variables outweighs the downsides. For 
a small, simple class like this, it saves a lot of time
rather than using getters/setters.

Now open RoadSegment.java.  This class stores a segment
of a road, which is any straight-line segment of something
a car drives on.  Notice it has just 2 LatLongs, a start
and an end, and we assume the road goes straight between
those two geographic points.  So for a curvy road, there
would be multiple RoadSegment objects in a sequence
to approximate the curve.  A "road" like interstate 240
would be made up of hundreds of these!

Take a look at the constructor for RoadSegment.  Notice
that the parameters in the constructor have the same
names as the instance variables in the class!  What do you
think the "this" part means in the body of the constructor?

__Your answer__

Open MemphisMap.java and MemphisMapDemo.java.  Run the
MemphisMapDemo file.  Take a look at all the roads!

Let's investigate how this works!

Find the loadRoadSegs() method in MemphisMap.  

- What text file does this code open and read from?

__Your answer__

- What "separator character" does this text file use
to separate the pieces on each line of the file?

__Your answer__

There are 7 pieces on each line.  What does each piece
mean?  Use the code to help you, since the meaning of
some of the numbers aren't 100% clear from the text file
alone.

__Your answer__

- Find the line of code near the end of this method that
says `listOfRoadSegs.add(roadSeg);`.  What data type is
the variable listOfRoadSegs and where is it declared?
Is it an instance variable or a local variable?

__Your answer__

- Now go to the draw() method in MemphisMap.  Notice how
this function does little other than loop over every
RoadSegment in listOfRoadSegs and draw the line corresponding
to that segment.  In memphis-roads.txt, how many total
roads are there?  (Scroll to the end of the file and
note the line numbers.)

__Your answer__

- Add some code after the loop is done to print out
the total number of roads that are displayed on the canvas.
Hint: this is one line of code to print out the number of
elements in the ArrayList that holds the road segments.
Verify the number of road segments matches what you think
it should be!

- Add some code inside the draw() loop that draws every 
road segment that has a speed limit of at least 55 miles
per hour in a different color, and in a thicker line.
Hint: use a setLineThickness of 2 or 3 for these roads,
and one for the slower roads.  Optional question: 
is the speed limit data in memphis-roads.txt entirely
accurate?  :)

__Your answer__

## End of Part B.  Please check-in here.

## Part C: Mapping Memphis parks

Memphis has a lot of parks within the city limits.  In this
section, we will write some code to add them to our map.

Begin by opening memphis-parks.txt.  This file is
set up similarly to the roads file.  Each line has 4 pieces:

- The name of the park
- Latitude
- Longitude
- Zip code of the park
- Size of the park in acres

Next, open up Park.java.  Design a Park class to hold
all the details of one park.  This class should work
analogously to the RoadSegment class, so use that as a 
guide.  You need four instance variables.  Each one needs
a getter.  You don't need any setters, provided your
constructor allows you to set all four variables when
the Park is created.

Now we will add code in MemphisMap.java to read the
memphis-parks.txt file.

- Go to the top of MemphisMap and add an instance variable
that will be an ArrayList designed to hold all the parks
that we read from the file.  What should the data type of
this variable be?

__Your answer__

- Go to the constructor and initialize the ArrayList
you just created.

- Your next task is to write a method similar to
loadRoadSegments() except it should read the text file
of parks and load them into your parks ArrayList instead.
I suggest copying-and-pasting the loadRoadSegments code
and modifying it as appropriate.  Use print statements
as you go along to verify that you're reading things
in from the file correctly.  Also when you're ready to 
start testing the code, don't forget to call your new
method inside the MemphisMap constructor.

- Once you have all the parks read into your ArrayList,
now we need to modify draw() to see them on the map.
In draw(), write a loop below the "draw roads" loop (it's
marked where you should do this) that iterates over your
parks ArrayList and draws each park as a small green circle.
Radius 2 or 3 works well here.

- Once you've verified you can see all the parks, modify
your drawing code to change the size of the circle based
on the number of acres in the park.  Bigger parks need
bigger circles!  What I've found works pretty well is if
the park is 5 acres or smaller, just draw a normal circle
like you've been doing.  Otherwise, make the radius of
the circle equal to the *square root* of the number of 
acres in the park.

- You should now see small and large circles for the parks!

## End of Part C.  Please check-in here.

## Part D: Finding the closest park to someone

In this last section, we will write some code to let
the user click on the map, and it will tell us the closest
park to where the user clicked.

First, write code in MemphisMapDemo (not MemphisMap!)
so that after the map is drawn, the user will be allowed
to click on the map.  Reminder: this involves a call to
canvas.waitForClick(), then you can retrieve the location
of the click with canvas.getMouseClickX() and
canvas.getMouseClickY().  Print out the x/y location
where the user has clicked.

There is a function in MemphisMap called
convertXYToLatLong.  Use this function to convert your x/y
point to a lat/long point.  Print the lat/long 
coordinates to verify it works.

Lastly, write a method in MemphisMap called 
findClosestPark().  This method should take a LatLong
parameter that contains the lat/long of where the user 
clicked on the map.  This method should iterate through
the ArrayList of parks to find the closest park to the 
mouse click and return it.  Hint: there's a function in 
MemphisMap called distanceBetweenLatLongs that will
give you the distance in miles between two LatLongs.
Call your function from your code in MemphisMapDemo,
and print the park!

