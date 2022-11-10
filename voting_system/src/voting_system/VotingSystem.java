package voting_system;


import java.lang.reflect.Array;
import java.util.Arrays;

public class VotingSystem {

    static int[] candidateVotes ={0,0,0};
    public static void main(String[] args) throws InterruptedException {

        //set main thread name for debugging
        Thread.currentThread().setName("VotingSystem");

        //initialization
        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;
        int voterNumber = 0;


        //main business logic
        while (System.currentTimeMillis() < end) {
            System.out.println();
            new Thread(new Voter(), "Voter number "+voterNumber).start();
            voterNumber++;
            Thread.sleep(10);
        }

        //metrics
        System.out.println("The votes for candidates are: "+ Arrays.toString(candidateVotes));


    }
}
