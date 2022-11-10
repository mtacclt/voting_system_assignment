package voting_system;

import java.util.Random;

import static voting_system.VotingSystem.candidateVotes;

public class Voter implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        int vote = (int) random.nextInt(3);
        System.out.println(Thread.currentThread().getName()+" casting vote for candidate "+(vote+1));

        synchronized (candidateVotes){
            candidateVotes[vote] = candidateVotes[vote]+1;
        }
    }
}
