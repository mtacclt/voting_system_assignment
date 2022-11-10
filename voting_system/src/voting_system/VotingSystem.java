package voting_system;


import java.lang.reflect.Array;
import java.util.Arrays;

public class VotingSystem {
    static int candidateNum = 3;
    static int[] candidateVotes = new int[candidateNum];

    public static void main(String[] args){

        //set main thread name for debugging
        Thread.currentThread().setName("VotingSystem");

        //initialization
        long start = System.currentTimeMillis();
        long end = start + 30 * 1000;
        int voterNumber = 0;

//        for(int i =0 ; i< 3 ; i ++){
//            new Thread(new Candidate(), "Candidate "+(i+1)).start();
//        }


        //main business logic
        while (System.currentTimeMillis() < end) {
            System.out.println();
            new Thread(new Voter(), "Voter number "+voterNumber).start();
            voterNumber++;

//            if (voterNumber % 100 == 0){
//
//            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //metrics

        System.out.println("The votes for candidates are: "+ Arrays.toString(candidateVotes));


    }
}
