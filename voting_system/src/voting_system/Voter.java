package voting_system;

import java.util.Random;

public class Voter implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        int vote = (int) random.nextInt(VotingSystem.candidateNum);
        System.out.println(Thread.currentThread().getName()+" casting vote for candidate "+(vote+1));

        synchronized (VotingSystem.candidateVotes){
            VotingSystem.candidateVotes[vote] = VotingSystem.candidateVotes[vote]+1;
        }
    }
}
