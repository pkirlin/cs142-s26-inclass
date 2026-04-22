# Lab 11
## Running Time of Algorithms (Big-Oh)

Names:
- Name 1
- Name 2
- Name 3

In this lab we will explore two new topics.  
First, we will learn about the main technique that
computer scientists use to measure "how fast" an
algorithm runs, which is known as Big-Oh notation.
Second, we will learn about an important function in Java
classes that is often necessary in real-world applications.

## Part A: Measuring the running time of algorithms

The first section of this lab serves as an introduction to
how computer scientists measure how fast algorithms run.
There are many situations where we need to determine 
the speed or efficiency of an algorithm.  For example,
perhaps we have two different algorithms that solve the
same problem, and we want to (obviously) pick the one
that is faster.  Or, perhaps we have two different 
algorithms for the same problem, but one is faster only
in certain situations, and we want to figure out which
situations those are.

One simple way we can measure how fast an algorithm runs
is to literally time it, like with a stopwatch.  All
computers have an internal clock that keeps a pretty
accurate time (nowadays computer clocks are often
synchronized over the internet with a much more accurate
clock online, but pre-internet you used to have to set
your computer's clock manually).  Though our operating
systems normally report the time as a regular calendar
date, internally the computer clock is just a big 
integer counter variable that is always ticking up.

- In the official java API documentation, look up the 
System class and find the method called currentTimeMillis().
Explain in a sentence or two what this function does.

__Your answer here__

Open the Stopwatch class in this folder and look at the code. 
Notice how there are two variables to keep track of the
"start time" and "stop time", and methods to start, stop,
and reset the watch.  The code uses System.currentTimeMillis()
to get the computer's clock time, and the
getElapsedTimeInSeconds() function subtracts these two
times to get the difference and divides by 1000 to convert
from milliseconds to seconds.

- Does this class make sense?

__Your answer here__

We will use this Stopwatch class to measure how long
different sections of code take to run.  **To make the
stopwatch as accurate as possible, close all unnecessary
programs on your computer, within reason.  For instance,
if you can, close everything besides IntelliJ and maybe
your internet browser in case you need to look stuff up**.

**VERY IMPORTANT NOTE:**  When you run the code to measure
the running time of the algorithms in parts A, B, and C, use
the DEBUG button rather than the RUN button in IntelliJ.
If you use the Run button, IntelliJ will often optimize the
code while it's running and your measurements will not be
accurate.

HOW DO COMPUTER SCIENTISTS MEASURE THE SPEED OF
ALGORITHMS?  Because every person's computer is different,
a section of code might run faster or slower on someone
else's computer.  The actual speed that code runs depend
on how fast your computer's processor is, and how many
different programs you're trying to run at once.  I asked
you to close all unnecessary programs so that your 
computer can devote as much power as possible just to
IntelliJ.

Because it's not very useful to say "This algorithm
takes 4.287 seconds to run" --- because that number might
change on someone else's computer, computer scientists
often measure the speed of an algorithm by determining
how the running time *changes* as we give the algorithm
more data to process.  As an example, consider an algorithm
that adds up all the numbers in an array or arraylist.
You've written this algorithm probably many times.  However,
this algorithm will run slower if the array is larger:
this should not be surprising.  If you have an array with
10 elements in it, the computer must add up 10 numbers.
If you have an array with 20 elements, the computer must
add up 20 numbers, and just like for people, a computer
will take longer to add up 20 numbers than 10.  Computer
scientists can *compare* the amount of time it takes
to add up 20 numbers versus 10, and that gives us information
about how "efficient" the algorithm is.  For instance,
when we change from adding 10 numbers to 20 numbers, does
the algorithm take twice as long?  Ten times as long?
The same time?  Those are questions we can answer and will
give us valuable information.

We often call the "amount of stuff an algorithm must
process" the **input size** of the algorithm.  For example,
if our algorithm is "add up all the numbers in an array"
then the "input size" would be the size of the array.
In this next section, we will examine a class that can
run a section of code multiple times with different
input sizes.  For example, we can use this code to add
up all the numbers in an array for arrays of size 10, 20,
50, 100, 1000, 10000, etc. and see how the algorithm's
speed changes.

Open the CodeTimer class.  This is an *abstract* class
designed to run a section of code with multiple input
sizes.  There are only two functions.  The first one,
measureTimeOnAllSizes(), takes a List of the input
sizes you want to run the code on, and calls
measureTimeOnOneSize() on each input size.  Notice that
measureTimeOnOneSize() is ABSTRACT.  You will write some
classes that extend CodeTimer and implement
measureTimeOnOneSize() --- this is where you will put
the code to run whatever algorithm we choose that we
want to measure the time for.

Open the ArraySumTimer class.  PAY ATTENTION TO HOW
THIS CODE WORKS.  The idea is we want to time how long
it takes to add up all the elements in an array of
a variable length (that variable is called inputSize).
We make a random array of that size, and then we calculate
its sum (add up all the numbers).  Now because modern 
computers are *very* fast, I added a for loop to repeat the
entire summation a million times (this is the for loop with
the "counter" variable).  Repeating the summation a million
times doesn't change the algorithm itself, but it stretches 
the time it takes to run so we can clearly see the effects 
of the algorithm's efficiency and compare different algorithms 
more easily.

In short, by running the summation code in a loop one million
times, we're amplifying the runtime so we can measure and 
understand the time more accurately.

Run the CodeTimerDemos code.  The main function is set
up already to run the ArraySumTimer on input sizes
of 1000, 2000, 4000, etc.  Remember those numbers are
the size of the arrays we are using.  Note the elapsed
time for each input size.  These times will depend
on the speed of your computer.  If any elapsed time
is getting longer than 30 seconds, you may want to change
ArraySumTimer to run for 100,000 iterations rather than
one million.

We will now plot the input size versus elapsed time
on a graph. Go to https://www.desmos.com/calculator
Click the Plus sign in the upper left corner (under
untitled graph).  Click table.  In the x column, put
in the input sizes (1000, 2000, etc).  In the y column,
put in the elapsed times.  

(Fix zoom issues:) After entering all of the x and y 
values, to the left of the table, there is a magnifying 
glass symbol with a plus sign in it.  Click it so all the 
points will be viewable on the graph.

(Draw lines connecting the points:) Next, click
the gear icon above and to the right of the table, then
click the green circle by the "y" column heading, then
click the toggle button for "lines" so it will draw lines 
between the points.  

AT THIS POINT, THE ENTIRE GRAPH SHOULD BE VISIBLE ON THE SCREEN
AND THE POINTS SHOULD BE CONNECTED BY LINES.

- What does this graph look like?  It won't be
exact, but is this a line, a parabola, a cubic function, 
etc?

__Your answer here__

TAKE A SCREENSHOT OF THIS GRAPH AND SAVE IT FOR LATER.
Name it something like ArraySumGraph.  You can also use
the "share graph" button at the top of the webpage.

- Notice that the input sizes we used here were chosen
specifically because each one is twice as big as 
the previous one.  Use a calculator (your phone or
google is fine) to calculate the ratio between each pair
of successive elapsed times.  What are these ratios?
  (each one should be close to 2)

__Your answer here (list each ratio)__

You should have plotted a LINE on your graph, and 
determined that when the input size doubles, the time
the algorithm takes also doubles.  This should make
sense for this kind of algorithm, because if you have
to add up 100 numbers, then adding up 200 numbers will
take roughly twice as long.  This is called a 
**linear-time algorithm**.

We will now explore the running time of a different
algorithm: calculating the sum of the numbers in a 2D
array.

Open the Array2DSumTimer class.  This class works
similarly to ArraySumTimer, except the array is now
2-dimensional.  Fill in the code inside the for loop
to add up all the numbers in a 2D array.  Remember, the
for loop that is already written is *not* part of the
algorithm; it's just there to slow the computer down.
You should write nested for loops in the WRITE CODE HERE
section.  So the end result will be three nested loops:
two for the actual algorithm, and the one pre-written
loop (using the counter variable) that doesn't actually matter
and is just there to take up time.

Now skip over to CodeTimerDemos and change the main
function to run measureSumOf2DArray() instead.  **You may
need to play around with the number of times the "counter" loop
runs in Array2DSumTimer if the code is running too fast
or too slow.  In general, try to have the elapsed time be 
somewhere between 0.1 seconds and 0.5 seconds for the first
input size (1000), so then the elapsed time won't grow too 
big too quickly.

Repeat the steps from above again to graph these times.
Take a screenshot.

- Use a calculator (your phone or
  google is fine) to calculate the ratio between each pair
  of successive elapsed times.  What are these ratios?

__Your answer here__

- What do these ratios and the shape of the graph
tell you about this algorithm (sum of a 2d array) 
especially as compared to the first algorithm
(sum of a 1d array)?

__Your answer here__

## CHECK IN

Now we have two different algorithms with two different
*rates of growth* as the input size grows.  

## Part B: Measuring the running time of Fibonacci

The algorithm we looked at earlier in the semester for computing
the Fibonacci sequence is *notoriously* slow.  Let's examine
how slow.  Because this algorithm doesn't use an array,
the "inputSize" that we will use here simply corresponds
to the element of the Fibonacci sequence that we want.
In other words, if inputSize is 1, we want the first 
element, if it's 10, we want the 10th element, and so on.

Open Fibonacci.java.  Look at the code for the fib()
function.  It should look familiar.

Open FibonacciTimer.java.  Notice how the code just
calls fib(inputSize) to compute the appropriate element
of the Fibonacci sequence.  

Repeat the steps earlier to produce a graph for the
Fibonacci function.  There is already code in CodeTimerDemos
to do most of the work for you.  Notice that the code
uses input sizes of 5, 10, 15, and then counts by ones. 
This is because this function eventually becomes 
sooooo slow that we need to keep the numbers small.
You may need to adjust the for loop in FibonacciTimer
if it's running too slowly.  I used 100,000 but even that
might be too many times.  Take a screenshot of your
graph. Hint: The curve grows very quickly.

It turns out there is a different algorithm for 
Fibonacci that is much faster!  It uses a while loop
an array to keep track of earlier values of the sequence
rather than re-computing them each time.  Open 
Fibonacci.java and look at fastfib.  Then run
FibonacciTest.java to verify that the values are the
same for fib() and fastfib().

Then, in FibonacciTimer.java, switch the code from using
fib() [the slow version] to fastfib() [the fast version].
Run CodeTimerDemos and graph the results.  Take a
screenshot.  This graph should grow at a much more 
reasonable rate.

YOU SHOULD NOW HAVE FOUR GRAPHS SO FAR (one for summing
an array, one for summing a 2-d array, and 2 for Fibonacci).

### CHECK-IN

## Part C: Measuring the running time of binary search

Repeat the process above for the binary search function.
In CodeTimerDemos, this is the function called measureBinarySearch().
You shouldn't need to write any code, just run the function
and graph it.  

You will notice that the running time of this algorithm
grows very slowly!  In other words, the algorithm is so fast,
that when you double the input size, the running time does not
change much at all.

Of the five algorithms we've looked at today, which one grows 
the slowest?  Which one grows the fastest?  This question is
asking, if you plotted all five algorithms on the same graph
and looked very very far to the right, where the input size
gets very big, which algorithm would have the smallest numbers
(slowest-growing algorithm), and which one would have the 
largest numbers (fastest-growing algorithm)?

__Your answer here__

## CHECK-IN

For the 2nd half today's lab, we will examine how Java 
compares objects for equality.  This has nothing to do
with the first part of the lab, but will help you with
future java projects!

## Part D: The `equals()` method

When designing classes in Java, there are a number of
important methods that one often overrides.  Remember
that *all* classes in Java are part of a single hierarchy
of classes, and at the top of this hierarchy is the
"Object" class.  All classes inherit (extend) this "Object"
class, either directly or indirectly.  Remember that when
you make a class, if you do not specify that the class
extends anything, by default Java automatically extends
it from Object.

Take a look at the methods that are part of the Object
class:  (open the link)

https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html

Find the toString() method in the listing of methods.
We have talked a lot about the toString() method, which
returns a String that is automatically printed by println()
whenever an object needs to be printed.

Find the equals() method in the listing of methods and
read its description.

- What data type does equals() return?  Explain the meaning
  of this return value.  (This is not supposed to be
  tricky; it should be straightforward.)

__Your answer here__

Open the Point class.  This class represents a 2-d point
in space.  It has an x-coordinate and a y-coordinate, along
with getters for x and y, a toString() method, and an
equals() method that is commented out.

Open EqualsDemo.  Read the code for testPointEquals().
Notice how the code makes four Points, p1 through p4,
and first tests a few Points for equality with the ==
operator.  **For classes, the == operator ALWAYS tests
whether the two objects being compared refer to the same
location in memory (the exact same object).**

Look at the output for the four == tests.

- Why is p1 == p4 true?

  __Your answer here__

- Why is p1 == p3 false, even though they both represent
  the point (1, 2)?

  __Your answer here__

- Suppose we added a test for if p4 == p3.  Would this
  be true or false?  Why?  Use a print statement to
  verify your answer.

  __Your answer here__

The Point class has its equals() method commented out.
When a class does not override equals(), that class
inherits the equals() method from Object (this shouldn't
be a surprise; that's how inheritance works).  The
equals() code in Object simply compares the two objects
with the == operator, so by default, the equals() method
does the same thing as ==.

The next section of code runs the same four tests
on the Points, but uses equals() instead of ==.  Verify
that the output is the same, which should indicate that
right now, the equals() method for a Point is just doing
the same thing as == does.

- Does the output match?

  __Your answer here__

Go back to the Point class and uncomment the equals()
method.  There is a "standard way" of writing an equals
method.  There are normally three steps:

1. Compare the "this" object (ourselves) against the
   other object passed in, using ==.  Return true if
   they match. This is only true if we compare an object
   literally against itself.

2. Test if the other object passed in is an instanceof
   our class.  If it's not, they can't be equal, so return
   false.

3. Since we now know that the other object *is* an
   instance of our class, cast it to our class and make
   a new variable to hold a reference to this cast object.
   At this point you can choose which instance variables
   to compare for equality between the two objects (ourselves
   and the other object).  Here, we compare x and y to see
   if they match, and return true if they do.  Notice that
   we don't bother writing an if statement, we just return
   the result of the comparison itself.

If you ever find yourself writing:
if (someBooleanTest) {
    return true;
}
else {
    return false;
}

You can shorten that to:

return someBooleanTest;

- Re-run the equals demo code.  Now the four tests
  using == shouldn't match all the tests for equals().
  Which ones have changed and why did they change?

  __Your answer here__

The next section in the demo code adds our four Points
to an arraylist, and then tries to remove a "new" Point
(1, 2).

- According to the output, how many points were in the
  list before removing, and how many are there after
  removing?

  __Your answer here__

- It turns out there are two versions of remove() for
  ArrayLists.  Open the link below, and find the two
  versions.

https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html

- How do the two versions of remove() differ?

  __Your answer here__

- Why did the code, when calling remove() on the Point
  (1, 2) not remove *all* copies of this point?

  __Your answer here__

- Change the code to so it removes all copies of the
  Point (1, 2).  (You can just add a few more calls to
  remove()).

### CHECK-IN

## Part E: Writing our own `equals()`

Open the Person class.  This class represents a person
who has a first name and a last name.  Follow the model
in Point to write an equals() method for Person that
will return true (say two people are equal) if they
have the same first name and last name.  REMEMBER that
when you compare Strings for equality in the Person's
equals() method, you must use the String equals() method!

- When you're done, comment out the call to testPointEquals
  and uncomment testPersonEquals.  Verify that Person p1
  is still not == to Person p2, but they should be equal().
  PASTE YOUR CODE for equals() here:

  __Your answer here__

- Now let's see if we can make equals() determine that
  two people are "equal" if their first and last names
  match, but uppercase/lowercase letters don't need to
  match exactly.  Change your equals() method so that
  all three of p1, p2, and p3 are now equal() to each
  other.  Hint: there is a method in the String class called
  equalsIgnoreCase().

PASTE YOUR NEW CODE for equals() here:

__Your answer here__

### CHECK-IN
