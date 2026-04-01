package lab9;

public class RunMatcher
{
    public static void main(String[] args)
    {
        Matcher matcher = new Matcher("match-club.txt");
        matcher.findOneMatch();
        //matcher.findAllMatches();
    }
}
