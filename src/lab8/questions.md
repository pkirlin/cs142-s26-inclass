# Lab 8: Recursion

## Partner names:

- name 1
- name 2
- name 3

## Part A: Factorial, Fibonacci, and Funky

Open RecursiveFunctions.java.  In this file, there are three
recursive functions written for you near the top (after main and
some test functions).  Factorial and Fibonacci you are already 
familiar with.  "Funky" is a variant of the "weird" function from 
last week.

Recall that earlier we learned how to draw "recursion diagrams"
which illustrate how a call to a recursive functions calls itself
repeatedly.  For example, take a look at the recursion diagram 
illustrating a call to fact(3).  [Open recursion-diagram-fact3.jpg
in the lab folder].

Notice how the diagram states at the top what the original function
call is (here, fact(3)), and uses indentation below to show what
that call does.  Recursion diagrams are flexible; as long as they show
the sequence of recursive calls and the return values, that's fine.
I like to use arrows to show how the return values are substituted
into return statements or calculations.  You don't need to use different
colors.

- Draw a recursion diagram for fact(4).

__Draw this on a separate sheet of paper (or a separate area
of the same paper).__

- How many total calls, including the first one, are there to the 
factorial function in your diagram?  In other words, when you call
fact(4), how many times is the fact function called (including the 
initial call)?

__Your answer here__

- Now extrapolate a general formula for how many total function
calls calling fact(n) [where n is an arbitrary integer] will take.
In other words, you should give me a formula in terms of n.

__Your answer here__

Now open recursion-diagram-fib3.jpg, which is a recursion diagram
for fib(3).  Notice because the fibonacci function makes *2* recursive 
calls per original call, the diagram is longer and slightly 
more complicated.  It is also important to note the *order* in which
the recursive calls are made.  In the diagram, time flows downward,
so it's important to note that though fib(3) recursively calls fib(2)
and fib(1), the call to fib(2) finishes *all* of its work before
the call to fib(1) begins.

- Draw a recursion diagram for fib(4).

__Draw this on a separate sheet of paper.__

- How many total calls, including the first one, are there to the
  Fibonacci function in your diagram?  In other words, when you call
  fib(4), how many times is the fib function called in total?

__Your answer here__

- Break down your answer above: when fib(4) is called, how many
times is fib(3) called?  How many times is fib(2) called?  
fib(1)?  fib(0)?

__Your answer here__

The takeaway here is that this version of the fibonacci function is
extremely inefficient.  Why should we call fib(2) more than once when
the *answer* to fib(2) is the same every time?  This applies to fib(1)
and fib(0) as well.  Later on, you will learn multiple ways to 
make this computation more efficient that can be extrapolated to 
other types of problems as well.

- Let's examine the funky function now.  Notice that it *also* has
two recursive calls for each original call.  *Before* running this
function, try to draw the recursion diagram for funky(3) and while
you are doing this, keep track of the output of the function on paper 
as well.  This is easiest to do if you keep track of the print 
statements in the recursion diagram itself.

__Draw this on a separate sheet of paper.__

- Now in main, run funky(3) and verify that your predicted output
is correct.  Then run funky(4) and funky(5).  What is the pattern that
connects the output of funky(n) to the output of funky(n-1)?

__Your answer here__

### STOP AND CHECK-IN

## Part B: Two new recursive functions

We will write a recursive function to calculate the sum of the
first n integers, starting from 1.  Here are examples:

sumOfFirstN(1) = 1
sumOfFirstN(2) = 1 + 2 = 3
sumOfFirstN(3) = 1 + 2 + 3 = 6
sumOfFirstN(4) = 1 + 2 + 3 + 4 = 10
sumOfFirstN(5) = 1 + 2 + 3 + 4 + 5 = 15
etc

Notice the pattern in the way this function works.  Each sum of
the first n numbers involves computing the sum of a slightly smaller
range of numbers from the line immediately above.

- Write a formula for sumOfFirstN(5) that involves sumOfFirstN(4).

__Your answer here__

- Write a formula for sumOfFirstN(4) that involves sumOfFirstN(3).

__Your answer here__

- Do you see the pattern yet?  What is the general *recursive case*?
In other words, what is the general formula for sumOfFirstN(n),
and how big must n be for this formula to apply?

__Your answer here__

- What is the base case?  In other words, for what number(s) does
the recursive case *not* apply, and what is/are the formula(s) in 
that/those cases?

- Transform your recursive formulation into Java code.  There is 
a blank function already set up for you in RecursiveFunctions.java.
When you are done, test your code in main however you feel appropriate
(you can write a separate test function like testFac/testFib,
for instance)

__Write answer in the Java file__

Now we will repeat this process for another recursive function,
computing the powers of 2.

twoToNthPower(0) = 2^0 = 1
twoToNthPower(1) = 2^1 = 2
twoToNthPower(2) = 2^2 = 2 * 2 = 4
twoToNthPower(3) = 2^3 = 2 * 2 * 2 = 8
twoToNthPower(4) = 2^4 = 2 * 2 * 2 * 2 = 16
twoToNthPower(5) = 2^5 = 2 * 2 * 2 * 2 * 2 = 32
twoToNthPower(6) = 2^6 = 2 * 2 * 2 * 2 * 2 * 2 = 64
etc

- Following the same process as above, write formulas below
for the base case and recursive case.  Each case should also specify
for which values of n they apply (e.g., n == 1 only, or n >= 3, etc).

__Your answer here__

- Transform your recursive formulation into Java code.  There is
  a blank function already set up for you in RecursiveFunctions.java.
  When you are done, test your code in main however you feel appropriate
  (you can write a separate test function like testFac/testFib,
  for instance)

__Write answer in the Java file__

### STOP AND CHECK-IN

## Part C: The Tower of Hanoi

The *Tower of Hanoi* is a famous puzzle with a deceptively simple 
recursive solution.  

There are many made-up stories about the origin of this puzzle, 
but supposedly in Hanoi there is a temple or monastery with three 
tall posts.  At some point in history, 64 golden disks of different 
sizes were placed on one of the posts, each disk resting on the disk
of the next largest size.  Supposedly, the priests of the temple or
the monks of the monastery must transfer all the disks from the first
post to the third post, but this must be done in such a way that
a disk always rests on top of a larger size disk.  In other words, 
the priests or monks may only move one disk at a time, from one post
to another post, but only if the disk they are moving can be placed
on top of a larger size disk.

Open up this link to see how the game works for 3 disks:

https://www.mathsisfun.com/games/towerofhanoi.html

- Play the game for 3 disks on the webpage.  Use your mouse to drag the 
disks from post to post, but you must never drag a larger disk onto 
a smaller one. How many moves did it take you?  (the webpage counts for you)

__Your answer here__

- Play the game for 4 disks.
  How many moves did it take you?  

__Your answer here__

There is a "simple" recursive solution to solve this puzzle for any
number of disks.  The recursion is as follows:

To move the top "n" disks from tower A to tower C using tower B
as an intermediate spot:

  - If n == 1, then move the one disk directly from A to C.
  - If n > 1, do the following:
    - (1) Move the topmost n-1 disks from A to B, using C as the 
          intermediate tower.
    - (2) Move the one remaining disk on A to C.
    - (3) Move the stack of n-1 disks currently on B (that we moved in step #1)
          to C (using A as the intermediate).

This remarkable algorithm works because it describes how to move a stack of n
disks as moving a stack of n-1 disks to the "intermediate" post B, 
followed by moving one disk from A to C, then moving the stack on intermediate
post B to its final destination.  Now, of course we cannot move a stack of n-1
disks all at once, so steps (1) and (3) are done recursively.  It is interesting
that this algorithm never causes a larger disk to be placed on top of a smaller 
one.  

Open TowerOfHanoi.java and TowerOfHanoiDemo.java.  Run TowerOfHanoiDemo.  You 
will see the solution for 3 disks run.  You can change the arguments to the
TowerOfHanoi constructor (3, 1000) to alter the number of disks and the pause
time between moves.  Run this for larger numbers of disks: try at least 3, 4, and 5,
though this will handle larger numbers!  (Try 10 or 20 or 64!)

Though this puzzle seems like an interesting use of recursion, it's not quite
clear why it's useful to study, but it turns out the solution has a number of
interesting properties.  First we will look at the *number of moves* that the
recursive algorithm makes in total for n disks.

- Modify the Java code to count the total number of moves the algorithm makes.
A "move" is only when the algorithm actually moves a single disk between posts,
not a recursive call.  Your code should print out the total number of moves
that are made in the game.  Hint: add a new variable to use as a counter,
and increment it whenever A SINGLE DISK IS MOVED.  You can do this by modifying
the base case code, since the base case is where a single disk is moved.  
Another hint: 2 disks requires 3 moves, and 3 disks requires 7 moves.

- How many moves does 4 disks require?  5 disks?  6 disks?  Keep running on 
larger numbers of disks until you figure out the pattern in the number of
required moves.  Hint: It is connected to a function you wrote earlier today.
What is the pattern/formula for number of moves if you start with n disks?

__Your answer here__

- There is another interesting pattern as well.  Adjust the program to run with
just 2 disks, and have the pause time be long enough that you can follow *which*
disk is moving at every step.  If we call the smaller disk size 1, and the larger
disk size 2, write down the size of the disk that moves at each of the three
steps of this puzzle:  (so you should write 3 numbers below)

__Your answer here__

- This gets tedious and harder to do by hand as we add more disks, so let's have 
Java print the size of the disk that is moving for us instead.  Modify the Java 
code to do this.  Hint: this is the variable "topDisk" in the recursive function.
Run your code for 2 disks (verify it matches your answer above), 3 disks, 4 disks,
and 5 disks.  Where have you seen this pattern before?

__Your answer here__

- Compare the tower of Hanoi recursive function to the other recursive function
that produces this same pattern, in particular the *recursive* cases of each
function.  Why do you think each function, even though they are written for 
completely different tasks, produces the same output?

__Your answer here__

- Often, the Tower of Hanoi puzzle backstory includes a claim that after the monks
or priests move all 64 disks from the first post to the last one, following the
rules, the world will end.  Assuming they can move one disk per second, how long
will it take them to finish?  Give your answer in number of years.

__Your answer here__