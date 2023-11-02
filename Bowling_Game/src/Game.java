import java.util.Scanner;



public class Game {

    private static int frames = 10;

    private static int trysEachRound = 2;

    private static String start = "go";

    private static int score = 0;

    private static boolean spare = false;

    private static boolean strike = false;

    public static void main(String[] args) throws Exception {


        System.out.println("Welcome to my Bowling Game.\nType - go - in the console to knock down the pins\n ");

        for(int i = 1; i < frames ; i++){            
            generateRound(i, trysEachRound);            
            
        }

        System.out.println("Congratulations youve finished the game.\nYour final score is : " + score);
        


    }


    // --generateHit-- A Method to generate a random Number between zero and the pins that are left 

    public static int generateHit(int max){
        int range = max + 1;
        return (int)(Math.random() * range) ;
    }

    // --generateRound-- A Method to start each round and calculate the Players score

    public static void generateRound(int counter, int trys){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Frame " + counter + " : youve got " + trys + " trys left, good luck! ");

        int firstHit = 0;
        int secondHit = 0;
        

        int pins = 10;
        
        String try01  = scanner.nextLine();

            if(try01.equals(start)){
                firstHit += generateHit(pins);                
                trys--;
                score += firstHit;
                pins = pins - firstHit;
                System.out.println("Your hitcount is : " + firstHit);
                System.out.println("There are " + pins + " pins left");
                
                if(pins == 0){
                    System.out.println("WOW!! STRIKE!!");                    
                    strike = true;
                    trys = 0;                    
                    
                }else{

                System.out.println("Youve got " + trys + " try left, youre current score is : " + score);

                }

                if(spare){
                    score += firstHit;
                    System.out.println("Because you scored a spare last frame, you gained additional " + firstHit + " points, and your score ist now " + score);
                    spare = false;
                }
               
            }

            if(trys > 0){

            String try02 = scanner.nextLine();

                if(try02.equals(start)){
                        secondHit += generateHit(pins);                    
                        trys--;
                        pins = pins - secondHit;                    
                        score += secondHit;
                        System.out.println("Your hitcount is : " + secondHit);
                        System.out.println("There are " + pins + " pins left");
                        System.out.println("Youve got " + trys + " trys left, youre current score is : " + score);

                        if(pins == 0){
                            System.out.println("Congratulations!! a Spare");
                            spare = true;
                            
                        }

                        if(strike){
                            int strikeSum = firstHit + secondHit;
                            score += strikeSum;
                            System.out.println("Because you scored a Strike last round, you gained addtitional  " + strikeSum + " points, and your score ist now " + score);
                            strike = false;
                    }


                }
            }
            
            if(counter == 10 && spare || strike){
                
                String try03 = scanner.nextLine();

                if(try03.equals(start)){
                    /*
                     * Muss ich nochmal drüber nachdenken.
                     * Evtl muss die Bedingung schon in try01, try02 greifen.                     * 
                     * 
                     */
                }
            }

    }
}
