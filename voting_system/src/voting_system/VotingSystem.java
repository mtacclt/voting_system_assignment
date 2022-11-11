package voting_system;


import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.IntStream;

public class VotingSystem {
    static int candidateNum = 3;
    static int[] candidateVotes = new int[candidateNum];

    public static void main(String[] args){

        //set main thread name for debugging
        Thread.currentThread().setName("VotingSystem");

        //initialization
        long start = System.currentTimeMillis();
        long end = start + 60 * 1000;
        int voterNumber = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date votingStartTime = new Date(start);
        Date votingEndTime = new Date(end);

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
        System.out.println("The voting has ended!");
        System.out.println("The votes for candidates are: "+ Arrays.toString(candidateVotes));
        System.out.println("The number of total votes was "+(Arrays.stream(candidateVotes).sum()));
        System.out.println("The voting started at: "+sdf.format(votingStartTime)+" and ended at "+sdf.format(votingEndTime));
        System.out.println("Candidate " + (indexOf(candidateVotes,Arrays.stream(candidateVotes).max().getAsInt())+1) + " has won with " + Arrays.stream(candidateVotes).max().getAsInt() + " votes");


    }

    public static int indexOf(int[] arr, int val) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
    }
}
