package javagames;

import java.util.Scanner;

public class WrestleStory {

  private static void interviewQuestion(String name, String question) {
    System.out.println(name + ", " + question);
  }

  private static void interviewResponse(String name, String response) {
    System.out.println(name + ": " + response);
  }

  private static String[] generateMatchInfo(String name, String gimmick) {
    // Generate a random opponent for the user's wrestler
    String opponentName = generateOpponentName();

    // Generate a random setting for the match
    String setting = generateSetting();

    // Generate a random outcome for the match
    String outcome = generateOutcome();

    // Generate a random match time
    int matchTime = generateMatchTime();

    // Generate a random victory method
    String victoryMethod = generateVictoryMethod();

    // Determine whether the user's wrestler won or lost
    boolean didWin = outcome.equals("emerged victorious") || outcome.equals("walked away with the championship") || outcome.equals("pulled off a shocking upset");

    // Combine the generated elements into a match story
    String story = name + ", the " + gimmick + ", was set to face off against " + opponentName + " in a " + setting + " match. " + name + " put up a valiant effort, but in the end, " + outcome + ".";
    String[] matchInfo = {
      story,
      victoryMethod,
      Integer.toString(matchTime),
      Boolean.toString(didWin),
      opponentName
    };

    return matchInfo;
  }

  private static String generateOpponentName() {
    String[] names = {
      "The Crusher",
      "The Bruiser",
      "The Dominator",
      "The Destroyer",
      "The Conqueror"
    };
    int index = (int)(Math.random() * names.length);
    return names[index];
  }

  private static String generateSetting() {
    String[] settings = {
      "steel cage",
      "ladder",
      "tables, ladders, and chairs",
      "hell in a cell",
      "no holds barred",
      "falls count anywhere",
      "extreme rules",
      "iron man"
    };
    int index = (int)(Math.random() * settings.length);
    return settings[index];
  }
  private static String generateOutcome() {
    String[] outcomes = {
      "emerged victorious",
      "was defeated",
      "pulled off a shocking upset",
      "walked away with the championship",
      "was left battered and bruised"
    };
    int index = (int)(Math.random() * outcomes.length);
    return outcomes[index];
  }

  private static int generateMatchTime() {
    return (int)(Math.random() * 31) + 5;
  }

  private static String generateVictoryMethod() {
    String[] methods = {
      "pinfall",
      "submission",
      "knockout"
    };
    int index = (int)(Math.random() * methods.length);
    return methods[index];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to WrestleStory!");
    System.out.println("Please enter your wrestler's name:");
    String name = scanner.nextLine();

    System.out.println("Please enter your wrestler's gimmick:");
    String gimmick = scanner.nextLine();

    scanner.close();

    System.out.println("Generating your match story...");

    // Generate the match story based on the user's input
    String[] matchInfo = generateMatchInfo(name, gimmick);
    String story = matchInfo[0];
    String victoryMethod = matchInfo[1];
    int matchTime = Integer.parseInt(matchInfo[2]);
    boolean didWin = Boolean.parseBoolean(matchInfo[3]);

    // Output the match story to the user
    System.out.println(story);

    // Output the commentary on the match
    System.out.println("\nCommentary:");
    System.out.println("What a match! " + name + " and " + matchInfo[4] + " really brought it tonight.");
    if (didWin) {
      System.out.println("After " + matchTime + " minutes of back-and-forth action, " + name + " was able to secure a " + victoryMethod + " victory.");
      System.out.println("The crowd is on their feet, cheering for the victor as they celebrate in the ring.");
    } else {
      System.out.println("After " + matchTime + " minutes of intense competition, " + matchInfo[4] + " was able to come out on top with a " + victoryMethod + " victory over " + name + ".");
      System.out.println("The crowd is stunned, as they watch " + name + " exit the ring, clearly disappointed with the result.");
    }

    // Output the post-match interview
    System.out.println("\nPost-Match Interview:");
    System.out.println("We're here with " + name + " after that " + victoryMethod + " " + (didWin ? "victory." : "defeat."));

    if (didWin) {
      interviewQuestion(name, "congratulations on your " + victoryMethod + " victory tonight. How are you feeling?");
      interviewResponse(name, "Thanks, I'm feeling great! It was a tough match, but I knew I could come out on top with my " + victoryMethod + ".");
      if (victoryMethod.equals("pinfall")) {
        interviewQuestion(name, "And how did it feel to get that three-count and win the match in " + matchTime + " minutes?");
        interviewResponse(name, "It was an incredible feeling to hear the ref count to three and know that I had won. The match was " + matchTime + " minutes long, and I had to really dig deep to come out on top.");
      } else if (victoryMethod.equals("submission")) {
        interviewQuestion(name, "And how did you manage to make your opponent submit after " + matchTime + " minutes of competition?");
        interviewResponse(name, "I've been working on my submission game in the gym, and I knew that I could lock in that hold and make my opponent tap out. The match was " + matchTime + " minutes long, and I had to really wear down my opponent to get them to submit.");
      } else {
        interviewQuestion(name, "And how were you able to knock out your opponent and win the match after " + matchTime + " minutes of back-and-forth action?");
        interviewResponse(name, "I was really focused on landing that knockout blow, and I knew that if I could connect with a good shot, I could put my opponent down for the count. The match was " + matchTime + " minutes long, and I had to stay patient and wait for the right opportunity to strike.");
      }
      interviewQuestion(name, "And how do you plan to celebrate your victory tonight?");
      interviewResponse(name, "I'm going to go out and party with my fans tonight! They deserve it for all their support.");
    } else {
      interviewQuestion(name, "tough loss out there tonight after " + matchTime + " minutes of competition. What went wrong?");
      interviewResponse(name, "It just wasn't my night. " + matchInfo[4] + " is a tough competitor, and they were able to get the better of me tonight.");
      if (victoryMethod.equals("pinfall")) {
        interviewQuestion(name, "And how did it feel to be pinned and lose the match after " + matchTime + " minutes of competition?");
        interviewResponse(name, "It was a tough feeling to know that I had been pinned and that the match was over. The match was " + matchTime + " minutes long, and I gave it my all, but my opponent was just too strong.");
      } else if (victoryMethod.equals("submission")) {
        interviewQuestion(name, "And how did you manage to avoid tapping out for " + matchTime + " minutes of competition?");
        interviewResponse(name, "I've been working on my submission defense in the gym, and I knew that I could tough it out and avoid tapping out for as long as possible. The match was " + matchTime + " minutes long, and I was able to hold on for a while, but my opponent was just too strong and I had to submit in the end.");
      } else {
        interviewQuestion(name, "And how did it feel to be knocked out and lose the match after " + matchTime + " minutes of back-and-forth action?");
        interviewResponse(name, "It was a tough feeling to be knocked out and know that the match was over. The match was " + matchTime + " minutes long, and I gave it my all, but my opponent was just too powerful and I couldn't keep up with them.");
      }
      interviewQuestion(name, "And what's next for you after this defeat?");
      interviewResponse(name, "I'll be back in the gym tomorrow, working even harder to get back on top. This isn't the end for me.");
    }

  }

}