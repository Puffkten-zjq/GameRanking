import java.util.Random;
import java.util.Scanner;
public class GameRanking {
    public static void main(String[] args) {
        String []name = new String[3];  //create an array to record their name
        int []score = new int[3];   //create an array to record their score
        int[] score1 = new int[3];  //create an array to back up their score
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        for (int n = 0; n < 3; n++) {   //three people join this game
            System.out.println("Enter your nickname: ");
            name[n] = sc.nextLine();
            int s = 0;  //a variable to record score in the loop
            int i = 1;  //one person can play three times against the system
            while(i <= 3){
                System.out.println("Round " + i +": "); //show what inning you're in
                String st = sc.nextLine();

                while (!"rock、paper、scissors".contains(st)){
                    System.out.println("input error,Round " + i +": "); //you can only input rock,paper or scissors
                    st = sc.nextLine();
                }

                int num = rand.nextInt(3);  //the system randomly generates an option
                switch(num){
                    case 0:
                        String s1 = "rock";
                        System.out.println(s1);
                        if(st.equals(s1)){
                            System.out.println("Draw!");
                            s++;
                        }else if(st.equals("scissors")){
                            System.out.println("You lose!");
                        }else{
                            System.out.println("You win!");
                            s+=2;
                        }
                        break;
                    case 1:
                        String s2 = "paper";
                        System.out.println(s2);
                        if(st.equals(s2)){
                            System.out.println("Draw!");
                            s++;
                        }else if(st.equals("rock")){
                            System.out.println("You lose!");
                        }else{
                            System.out.println("You win!");
                            s+=2;
                        }
                        break;
                    case 2:
                        String s3 = "scissors";
                        System.out.println(s3);
                        if(st.equals(s3)){
                            System.out.println("Draw!");
                            s++;
                        }else if(st.equals("paper")){
                            System.out.println("You lose!");
                        }else{
                            System.out.println("You win!");
                            s+=2;
                        }
                        break;  //the above is based on the rule of rock-paper-scissors
                }
                i++;
            }
            System.out.println("Game over! Your score is: " + s);
            score[n] = s;   //everyone's score is recorded in score[]
        }
        System.arraycopy(score,0,score1,0,score.length);    //copy the data from score[] to score1[],like making a backup

        for(int a = 0; a < score.length; a++){
            for(int b = 0; b < score.length-a-1; b++){
                if(score[b] < score[b+1]){
                    int temp = score[b];
                    score[b] = score[b+1];
                    score[b+1] = temp;
                }
            }
        }   //rank their score
        System.out.println();
        System.out.println("Your final ranking is:");
        for(int m = 0; m < score.length; m++){
            for (int k = 0; k < score.length; k++){
                if (score1[k] == score[m]){     //find the position in the original array
                    System.out.println(name[k] + "-->" + score[m]); //match our name to our score
                    score1[k] = -1;     //destroy it,in case our name cannot appear twice if we get same score
                }
            }
        }
    }
}

