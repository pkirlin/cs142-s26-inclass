# Wheel of Fortune

Team members (edit these):

1. Team member 1
2. Team member 2
3. Team member 3

## Goals

By the time that you are done with this activity, you and your partner
should be able to:

* remember how to use `for` loops to iterate over arrays,
* use arrays in different ways to solve problems,
* learn some things about Strings in Java,
* and work more effectively as a team.

## Playing the Game

Run `WheelOfFortune.java` to play the game. It is a two-player game:
the first player should enter an English phrase in all lowercase letters
that the second player will have to guess, letter by letter.
You and your partner should play a few times before getting together
to answer the questions. Limit yourself to ~5 minutes.

Note that to answer these questions, you may need to go back and play
the game again to answer some of the questions to come. But you should
do so __deliberately__, in order to find something out, not just because
you got bored with the conversation or thought you could answer a question
better on your own.

## Part A:

- When is the game won?

  __Answer__:

- Can you guess the same letter twice?  What happens when you do this?

  __Answer__:

- What happens if you enter a secret phrase in uppercase and lowercase letters,
  and then guess letters in the opposite case?  (Like the puzzle has a capital "A"
  but you guess a lowercase "a"?)

  __Answer__:

- Is it possible to lose the game (without deliberately crashing the program)?
  Why or why not?

  __Answer__:

### If you and your partner feel comfortable with the game, go onto Part B.
### Otherwise, check-in with me to clear up any confusion.

## Part B:

In Part B, you and your partner will explore the inner workings of this game
and how it is implemented in Java.

- What is the data type of the secretArray variable first declared on line 17?

  __Answer__:

- What is the data type of the guessedLetters variable first declared on line 12?

  __Answer__:

These data types are different!  They are both used to store sequences of
characters, and we could have written the program using only one type, but
I wanted you to practice with both types.

Now look at the countLetter function.

- What data type does this function return?

  __Answer__:

- What does the variable `secretArray.length` correspond to?

  __Answer__:

- Explain what the line of code `if (secretArray[i] == letter)` does:

  __Answer__:

- Once you understand that line, write a sentence or two explaining how
  the entire function works.  Don't just repeat *what* the function does, tell
  me *how* it does it in a way another COMP142 student could understand.

  __Answer__:

- Would this function work if I moved the line of code `return count` inside
  the for loop?  Why or why not?

  __Answer__:

- Would this function work if I moved the line of code `int count = 0` inside
  the for loop?  Why or why not?

  __Answer__:

### Stop and check-in with me.  If I'm busy, make sure I know you're waiting
### but then go onto the next section.

## Part C

- Go back to the main function.  Explain what the line of code
  `guessedLetters += letter;` (line 36) does.  Hint: This would work
  the same way in Python.

  __Answer__:

- Now look at the makePuzzleArray function.  What data type does this function
  return?

  __Answer__:

- Explain what the line `char[] puzzleArray = new char[secretArray.length];` does.
  In particular, how big is the new array compared to the old array?

  __Answer__:

- Look in the official Java documentation online for the String class, then find
  the `indexOf` function inside this class.  To do this, google for "Java 21 API" then
  search for "String" in the search box in the upper right corner.  Choose "java.lang.String,"
  then find "indexOf" under "Methods."  What does the `indexOf` function do?

  __Answer__:

- When does indexOf return -1?

  __Answer__:

- Using what you now know about indexOf, explain what the line of code
  `if (guessedLetters.indexOf(secretArray[i]) != -1)` checks for.

  __Answer__:

- Comment out lines 57 and 58 (place double-slashes before each line) and re-run
  the game.  (So you are commenting out the "else if" section.)  
  What changes about the way the puzzles are displayed?

  __Answer__:

- Uncomment lines 57 and 58.  Explain why these two lines are needed in the program.

  __Answer__:

- Comment out lines 59 and 60 (place double-slashes before each line) and re-run
  the game.  (You are commenting out the "else" section.)  
  What changes about the way the puzzles are displayed?

  __Answer__:

- Uncomment lines 59 and 60.  Explain why these two lines are needed in the program.

  __Answer__:

- Back in main(), why is line 39 needed in the program?  (This one:)
  `puzzleArray = makePuzzleArray(secretArray, guessedLetters)`?
  If you're not sure, comment out this line and play the game!

  __Answer__:

### Stop and check-in with me.  If I'm busy, make sure I know you're waiting
### but then go onto the next section.

## Part D

In this last section, you will add some enhancements to the program!

- The first change is to prevent the user from guessing the same letter twice
  (or at least print an error message when they do so).  
  Modify the program to make this change (print an error message if they try to
  guess a letter they've already guessed.)
  Hint: Use indexOf on the `guessedLetters` variable in the main function.

- Next, in the real Wheel of Fortune game on TV, each player may spin a large wheel
  before they guess a letter than has various amounts of money on segments of
  the wheel.  When they guess a letter that appears in the puzzle, they earn the
  amount of money the wheel is pointing to *per* letter in the puzzle that they
  guess.  For instance, if the wheel lands on $200, and they guess the letter "T,"
  and the puzzle has three "T"'s, then they earn $200 x 3 = $600 total.  Change
  the game so before the contestant guesses a letter, the program generates
  a random number between 1 and 1000 that will be the amount of money they spin.
  If they successfully guess a letter, they earn that amount of money times
  the number of times the letter appears.

- Lastly, in the real game, vowels work differently: they *cost* money!
  Modify the game so that if the contestant guesses a vowel, they don't earn
  money, but $100 per guessed vowel in the puzzle is deducted from their total 
  amount of money.
