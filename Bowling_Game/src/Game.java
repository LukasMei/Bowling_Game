import java.util.Scanner;

public class Game {

    private static int frames = 10;

    private static int trysEachRound = 2;

    private static String start = "go";

    private static int score = 0;

    private static boolean spare = false;

    private static boolean strike = false;

    public static void main(String[] args) {

        Game game = new Game();
        game.playGame();

    }

    public void playGame() {

        System.out.println("Welcome to my Bowling Game.\nType - go - in the console to knock down the pins\n ");

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= frames; i++) {
            generateRound(i, trysEachRound, scanner);

        }

        scanner.close();

        System.out.println("Congratulations youve finished the game.\nYour final score is : " + score);

    }

    // --generateHit-- A Method to generate a random Number between zero and the
    // pins that are left

    public static int generateHit(int max) {
        int range = max + 1;
        return (int) (Math.random() * range);
    }

    // --generateRound-- A Method to start each round and calculate the Players
    // score

    public static void generateRound(int counter, int trys, Scanner scanner) {

        System.out.println("Frame " + counter + " : youve got " + trys + " trys left, good luck! ");

        int firstHit = 0;
        int secondHit = 0;

        int pins = 10;

        String firstAttempt = scanner.nextLine();

        // Check the first hit , calculate the score and pins
        if (firstAttempt.equals(start)) {
            firstHit += generateHit(pins);
            trys--;
            score += firstHit;
            pins = pins - firstHit;
            System.out.println("Your hitcount is : " + firstHit);
            System.out.println("There are " + pins + " pins left");

            // Check for a strike, if true the frame ends
            if (pins == 0) {
                System.out.println("WOW!! STRIKE!!");
                strike = true;
                trys = 0;

            } else {

                System.out.println("Youve got " + trys + " try left, youre current score is : " + score);

            }

            // Check if there was a spare last round, if true calculate a new score
            if (spare) {
                score += firstHit;
                System.out.println("Because you scored a spare last frame, you gained additional " + firstHit
                        + " points, and your score ist now " + score);
                spare = false;
            }

            // Check for a strike in the last frame
            if (frames == 10 && strike) {
                /*
                 * here goes youre code
                 */
            }

        }

        if (trys > 0) {

            String secondAttempt = scanner.nextLine();

            // Check the second hit and calculate the score, pins
            if (secondAttempt.equals(start)) {
                secondHit += generateHit(pins);
                trys--;
                pins = pins - secondHit;
                score += secondHit;
                System.out.println("Your hitcount is : " + secondHit);
                System.out.println("There are " + pins + " pins left");
                System.out.println("Youve got " + trys + " trys left, youre current score is : " + score);

                // Check for a spare
                if (pins == 0) {
                    System.out.println("Congratulations!! a Spare");
                    spare = true;

                }

                // Calculate the new Score when there was strike last frame
                if (strike) {
                    int strikeSum = firstHit + secondHit;
                    score += strikeSum;
                    System.out.println("Because you scored a Strike last round, you gained addtitional  " + strikeSum
                            + " points, and your score ist now " + score);
                    strike = false;
                }

                // Check for a spare in the last frame
                if (frames == 10 && spare) {
                    /*
                     * here goes youre code
                     */
                }

            }
        }

    }
}
