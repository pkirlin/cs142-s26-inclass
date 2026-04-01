# Lab 9: Recursion and Backtracking

## Names:
- Name 1
- Name 2
- Name 3

Backtracking is a general computational technique for finding
solutions to certain kinds of computational problems.  Backtracking
incrementally builds candidate solutions, and abandons a candidate
("backtracks") as soon as it determines that the candidate cannot
possibly be completed to a valid solution.  Backtracking is
often implemented recursively, though it does not have to be.

## Introduction: Matching Algorithms

Many real world situations can be phrased as "matching" problems.
Such problems involve one or more categories of objects, and the
goal is to match objects together, usually in pairs, so that
every object is paired with another.  The complicating factor is
that usually each specific object is only allowed to be matched
with certain other specific objects.

For instance, matching roommates can be phrased this way, with one
large group of students, and each student has preferences for which
other students they would be willing to share a room with.  Another
example is matching roommates (once they are paired) with rooms
themselves.  Each person has certain rooms they would be willing to live
in, and others that they don't want.

Perhaps one of the best-known examples of real world matching is
the National Resident Matching Program, which is designed to place
U.S. medical school students into residency training programs located
in United States teaching hospitals.  Every student has certain hospitals
they would like to be placed in, but each hospital only has a certain
number of students they can take, so each student cannot often be placed
in their first-choice hospital.

In this lab, we will explore two general-purpose matching algorithms
that can be used in multiple situations.  Each one is written recursively
with backtracking.  The algorithms are:

- Find any matching (any valid assignment of objects)
- Find all matchings (all valid assignments of objects)

## Part A: Matching club officers by hand

Suppose we have a student club with four members who need to
be assigned leadership roles.  The members are Alice, Bob,
Carol, and Dan, and they need to take on the President, Vice
President, Secretary, and Treasurer roles for their club.
Each person has certain roles they would be willing to do, and
others that they are not willing to do.  Furthermore, each
person can only fulfill one role.

Open match-club.txt.  The first line of the file lists the
names of the people, and the second line the possible roles.
The next few lines all list, for each person, the roles they
would be willing to do.  The order of the jobs on a line has
no particular meaning.  For example, Alice is willing to be
president or treasurer, but has no preference for one over
the other.  However, she is *not* willing to be VP or Secretary.

- Manually, by hand, find a valid matching.  That is, match
  each person with a role they are willing to do, so that
  everyone has exactly one role (no roles are left out, and no
  people are left out).  What matching did you find?

__Your answer here__

- Write a sentence or two explaining how you constructed this
  match.  Where did you start?  How did you figure out whom to
  give each role to?

__Your answer here__

- As you were creating the match, did you happen to assign
  someone a role and then figure out that it wouldn't work, and
  you'd have to give them a different role?  If so, explain
  what you tried to do and why you had to switch someone's roles.

__Your answer here__

The situation described above is called *backtracking*.  We
will explore a matching algorithm that works incrementally, by
creating a match one person/role pairing at a time.  If it ever
arises that the current matching of people with roles causes
a situation where we can't finish the rest of the match, we
will remove the most recent role assignment and try to switch
it to something else.  That's backtracking.

Here's an outline of the algorithm we will use to find *ONE* valid
match.  We don't care about how many possible matches there are,
or prefer one over others.  We only care about finding *ONE*
match, even if more than one is possible.

1. Begin with an empty list of person-job pairings.
2. Assign the first person the first job they are willing to do, and
   add this to the list.
3. Assign the second person the first job they are willing to do,
   that isn't already being done by the first person, and
   add this to the list.
4. Continue in this fashion with each new person.  If we ever reach
   a situation where we must assign a person a job, but all the jobs
   the person is willing to do are already taken, then remove the
   most recently-added person-job pair, and re-assign the *previous*
   person a new job from that person's list.

Let's work through the example with the club members.  We can
illustrate this process with a diagram.  We will proceed through
the club members in the order they are given in the file, and try
to assign each person a job from the order the jobs are given on
that person's preference line.

(top of diagram)
+-- Try to match Alice
+-- Assign Alice=President
    +-- Try to match Bob
    +-- Assign Bob=Secretary
        +-- Try to match Carol
        +-- Assign Carol=VP
            +-- Try to match Dan

- What does wrong when we try to match Dan?

__Your answer here__

At this point, we must BACKTRACK.  This means we move back up
the diagram, and try to re-assign the most recently-assigned person.

(top of diagram)
+-- Try to match Alice
+-- Assign Alice=President
    +-- Try to match Bob
    +-- Assign Bob=Secretary
        +-- Try to match Carol
        +-- Assign Carol=VP
            +-- Try to match Dan
            +-- Dan can't be matched
        +-- Assign Carol=Treasurer

- What goes wrong now?

__Your answer here__

At this point, Carol has now run out of jobs, so she can't be matched:

(top of diagram)
+-- Try to match Alice
+-- Assign Alice=President
    +-- Try to match Bob
    +-- Assign Bob=Secretary
        +-- Try to match Carol
        +-- Assign Carol=VP
            +-- Try to match Dan
            +-- Dan can't be matched
        +-- Assign Carol=Treasurer
            +-- Try to match Dan
            +-- Dan can't be matched
        +-- Carol can't be matched

- When Carol can't be matched, who do we look at now, to try
  to find them a new job?

__Your answer here__

- What job do we give them?

__Your answer here__

- Fill in the rest of the diagram above.  You can also do it on
  paper if that's easier.  What is the final matching found?
  Hint---there shouldn't be any more backtracking needed.

__Your answer here__

### STOP AND CHECK-IN

## Part B: Matching with an algorithm

- Open Matcher.java and RunMatcher.java.  Run RunMatcher.
  What matching does it find?  It should be the same one
  you found above.

__Your answer here__

Let's see if we can work through this code.  Find the constructor
in Matcher.java.  Go to the end of the constructor, after loadFile
is called.  Print out peopleList at this point.  What does it print?

__Your answer here__

- From which line of match-club.txt do you think this info comes?

__Your answer here__

- Notice how RunMatcher calls matcher.findOneMatch(), so let's look
  at findOneMatch() in Matcher.  findOneMatch() calls computeOneMatch().
  What argument is passed to computeOneMatch()?  What data type is it?

__Your answer here__

- What is returned from computeOneMatch()?  What data type is it?

__Your answer here__

- In findOneMatch(), there is an if/else statement that determines if
  finalMatch is null.  Based on reading the code nearby, what do you think
  it means if finalMatch is null?

__Your answer here__

Inside the else (if finalMatch is not null), print out peopleList
and finalMatch.  What do you notice about the lengths of these lists?

__Your answer here__

- Since finalMatch is just a list of jobs, how do we know who is
  actually matched with each job in the final match?

__Your answer here__

- What does the createMatchingString function do?

__Your answer here__

- Earlier, we pointed out how findOneMatch called computeOneMatch.
  ComputeOneMatch is the recursive function that does most of the work here.
  Let's look at it.  Find the base case.  Explain the base case in your
  own words.  In particular, what is (partialMatchingList.size() == peopleList.size())
  checking for?

__Your answer here__

- Now find the recursive case (this is the 'else' section).  Read through
  the code and answer these questions:

- Explain what the variable numNextPerson represents, and how it is determined.

__Your answer here__

- Explain what if (!partialMatchingList.contains(choice)) is testing for.

__Your answer here__

- Inside that if statement, we do partialMatchingList.add(choice), but then
  at the end, we do partialMatchingList.remove(partialMatchingList.size() - 1),
  which just undoes the .add(choice) from earlier.  Why do we do this?

__Your answer here__

- The recursive call is made here:
  ArrayList<String> finalMatchingList = computeOneMatch(partialMatchingList);
  and then we check if (finalMatchingList != null).  Since finalMatchingList
  is being assigned whatever the recursive call computeOneMatch() returns,
  where is it possible for computeOneMatch() to return null?

__Your answer here__

- If this happens (computeOneMatch() returning null), what does this
  indicate has occurred?

__Your answer here__

- There are two places in the code for the recursive case that have
  comments that are phrased like "If we get here..."  Notice that both
  of these comments are for sections of code to handle "failed" matches
  (either replacing the current person's job with another job, or indicating
  that we have to backtrack).  Explain what in the code prevents Java
  from getting to either of those sections of code if the match succeeded.

__Your answer here__

### STOP AND CHECK IN

## Part C: Finding all matches

- So there are actually three possible matchings for these club
  officers.  Find them by hand:

__Your answer here__

- In RunMatcher, switch the commented-out code so we will run
  findAllMatches rather than findOneMatch.  Run the code now.
  Do you see the same three matches?

__Your answer here__

- In Match, compare the code for findOneMatch and findAllMatches.
  (Note--we aren't looking at the *compute* functions yet.) Notice
  that the biggest difference is in findAllMatches there's an extra
  variable: allPossibleMatches.  Where is this variable first
  declared?  What is its data type?

__Your answer here__

Explain why we need this data type to hold all the possible matches.

__Your answer here__

Now we will examine the computeAllMatches function.  The biggest
difference between computeOneMatch and computeAllMatches
is that computeAllMatches has to backtrack more frequently; in fact,
it must *always* backtrack.  Because we are looking for all matches
rather than just one, even if we find a complete, valid matching
of all the club officers, we still must try all possible jobs
for each possible person.

- Explain why computeAllMatches is a void function (returns void),
  but computeOneMatch returned ArrayList<String>.  Hint: Where does
  the answer "go" in each of these two functions?

__Your answer here__

- Another big difference in computeAllMatches vs computeOneMatch
  is that computeOneMatch re-uses the same partialMatchingList variable
  to create its matches.  Recall that every time we assign a job
  in computeOneMatch, we .add() it to partialMatchingList, and then
  .remove() it if it happened to not work out.  But in computeAllMatches,
  we create a brand new ArrayList instead:

ArrayList<String> newPartialMatchingList = new ArrayList<String>(partialMatchingList);
newPartialMatchingList.add(choice); // assign this person this choice

Why is this necessary?  Hint: Remember that new ArrayLists are only created
with the "new" keyword.  Think about how many solutions we needed to find
in computeOneMatch and how many new ArrayLists we created.  Then think
about how many solutions we need to find in computeAllMatches.

__Your answer here__