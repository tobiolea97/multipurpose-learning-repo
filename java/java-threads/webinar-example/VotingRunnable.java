package threads;

/**
 * Contains code that represents the voting process.
 * It will keep track of what cake designs are getting votes.
 */

public class VotingRunnable implements Runnable { // Ch02-Step 1 - Implement class by the Runnable interface

    private Design d;
    protected boolean doStop = false;

    public VotingRunnable(Design d) {
        this.d = d;
    }

    // Ch02-Step 2 - Override the run() method
    @Override
    public void run() {
        System.out.println("Voting going on for design " + d.getName());
        d.getVotes().add(1L);
    }
}
