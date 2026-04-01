package lab9;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Matcher {
    /** The list of all people. */
    private ArrayList<String> peopleList;

    /** The list of all possible choices each person can pick from. */
    private ArrayList<String> choicesList;

    /**
     * HashMaps aren't studied until 241, so you can ignore this variable,
     * but it stores the associations between which person desires which choices.
     */
    private HashMap<String, ArrayList<String>> desiredChoices;

    /** The answer list of all possible matches. */
    private ArrayList<ArrayList<String>> allPossibleMatches;

    /**
     * Create a new Matcher.
     */
    public Matcher(String filename) {
        peopleList = new ArrayList<String>();
        choicesList = new ArrayList<String>();
        desiredChoices = new HashMap<String, ArrayList<String>>();
        allPossibleMatches = new ArrayList<ArrayList<String>>();
        loadFile(filename);
    }

    /**
     * Load info from the given file.
     */
    private void loadFile(String filename) {
        InputStream is = Matcher.class.getResourceAsStream(filename);
        if (is == null) {
            System.err.println("Could not open file: " + filename);
            System.exit(1);
        }
        Scanner scan = new Scanner(is);

        String[] peopleArray = scan.nextLine().split(" "); // read first line of file and split it
        Collections.addAll(peopleList, peopleArray); // convert array to arraylist
        String[] choicesArray = scan.nextLine().split(" "); // read second line of file and split it
        Collections.addAll(choicesList, choicesArray); // convert array to arraylist

        while (scan.hasNextLine()) {
            String[] array = scan.nextLine().split(" ");
            ArrayList<String> theseChoices = new ArrayList<String>();
            for (int i = 1; i < array.length; i++) {
                theseChoices.add(array[i]);
            }
            desiredChoices.put(array[0], theseChoices);
        }
    }

    /**
     * Retrieve the list of possible choices for a given person.
     */
    public ArrayList<String> getChoicesForPerson(String personName) {
        return desiredChoices.get(personName);
    }

    /**
     * Create a nicely-formatted string containing people and their matches so far.
     */
    public String createMatchingString(ArrayList<String> partialMatchingList) {
        if (partialMatchingList.isEmpty()) {
            return "{}";
        }
        String str = "";
        for (int i = 0; i < partialMatchingList.size(); i++) {
            str += (peopleList.get(i) + "=" + partialMatchingList.get(i) + " ");
        }
        return "{" + str.substring(0, str.length() - 1) + "}";
    }

    /**
     * Run the matcher to find just one match.
     */
    public void findOneMatch() {
        ArrayList<String> partialMatchingList = new ArrayList<String>();  // match list begins empty
        ArrayList<String> finalMatch = computeOneMatch(partialMatchingList);
        if (finalMatch == null) {
            System.out.println("No match found.");
        } else {
            System.out.println("Final matching:");
            System.out.println(createMatchingString(finalMatch));
        }
    }

    /**
     * Run the matcher to find all matches.
     */
    public void findAllMatches() {
        ArrayList<String> partialMatchingList = new ArrayList<String>();  // match list begins empty
        computeAllMatches(partialMatchingList);
        if (allPossibleMatches.size() == 0) {
            System.out.println("No matches found.");
        } else {
            System.out.println("All matchings:");
            for (int i = 0; i < allPossibleMatches.size(); i++) {
                System.out.println(createMatchingString(allPossibleMatches.get(i)));
            }
        }
    }

    /**
     * Compute one possible matching.
     */
    private ArrayList<String> computeOneMatch(ArrayList<String> partialMatchingList) {
        // nicely format a list of people and their matches to print them.
        String partialMatchString = createMatchingString(partialMatchingList);
        System.out.println("Current partial matching is " + partialMatchString);

        // Is the matching done? (base case)
        if (partialMatchingList.size() == peopleList.size()) {
            System.out.println("Found complete match: " + createMatchingString(partialMatchingList));
            return partialMatchingList;
        } else { // matching not done.
            int numNextPerson = partialMatchingList.size(); // find first unassigned person
            String nextPersonName = peopleList.get(numNextPerson);
            ArrayList<String> possibChoices = getChoicesForPerson(nextPersonName); // get their possible choices

            System.out.println("Matching " + nextPersonName + ", choices are " + possibChoices);

            for (int i = 0; i < possibChoices.size(); i++) // iterate through this person's possible choices
            {
                String choice = possibChoices.get(i);

                if (!partialMatchingList.contains(choice)) { // don't assign a choice that is already taken
                    partialMatchingList.add(choice); // assign this person this choice
                    ArrayList<String> finalMatchingList = computeOneMatch(partialMatchingList); // recurse

                    if (finalMatchingList != null) { // success!
                        return finalMatchingList;
                    }

                    // If we get here, this particular choice for this person didn't work,
                    // so try the next one in the list of possible choices.
                    partialMatchingList.remove(partialMatchingList.size() - 1);  // remove last item in list
                }
            }
            // If we get here, that means the match failed for all the possible choices
            // for this person.  Therefore, this partial match is a complete failure,
            // and we must backtrack so the *previous* person will get a new choice.

            System.out.println("The partial match " + partialMatchString + " failed, backtracking!");
            return null; // null means failure for this partial match.
        }
    }

    /**
     * Compute all possible matchings.
     */
    private void computeAllMatches(ArrayList<String> partialMatchingList) {
        // nicely format a list of people and their matches to print them.
        String partialMatchString = createMatchingString(partialMatchingList);
        System.out.println("Current partial matching is " + partialMatchString);

        // Is the matching done? (base case)
        if (partialMatchingList.size() == peopleList.size()) {
            System.out.println("Found complete match: " + createMatchingString(partialMatchingList));
            allPossibleMatches.add(partialMatchingList);
        } else { // matching not done.
            int numNextPerson = partialMatchingList.size(); // find first unassigned person
            String nextPersonName = peopleList.get(numNextPerson);
            ArrayList<String> possibChoices = getChoicesForPerson(nextPersonName); // get their possible choices

            System.out.println("Matching " + nextPersonName + ", choices are " + possibChoices);

            for (int i = 0; i < possibChoices.size(); i++) // iterate through this person's possible choices
            {
                String choice = possibChoices.get(i);
                if (!partialMatchingList.contains(choice)) { // don't assign a choice that is already taken
                    ArrayList<String> newPartialMatchingList = new ArrayList<String>(partialMatchingList); // copy old arraylist into new
                    newPartialMatchingList.add(choice); // assign this person this choice
                    computeAllMatches(newPartialMatchingList); // recurse
                }
            }
            // When we get here, we have finished iterating over the possible choices
            // for this person.  We may have found some complete matches, we may have
            // found none, but we must backtrack anyway because we want to find *all*
            // possible matches.

            System.out.println("Done with partial match " + partialMatchString + ", backtracking!");
        }
    }
}