import java.util.*;

public class ElectionServiceImplementation extends ElectionService {
    private List<Voter> voters = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    @Override
    public void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.getName());
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    @Override
    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter voter = findVoter(voterId);
        if (voter == null) {
            System.out.println("Voter not found!");
            return;
        }
        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already voted!");
        }

        Candidate candidate = findCandidate(candidateId);
        if (candidate == null) {
            System.out.println("Candidate not found!");
            return;
        }

        votes.add(new Vote(voterId, candidateId));
        voter.markVoted();
        candidate.addVote();
        System.out.println("Vote cast successfully!");
    }

    @Override
    public void showResults() {
        System.out.println("\nElection Results");
        for (Candidate c : candidates) {
            System.out.println(c.getName() + " : " + c.getVotes() + " votes");
        }
    }

    private Voter findVoter(int id) {
        for (Voter v : voters) if (v.getVoterId() == id) return v;
        return null;
    }

    private Candidate findCandidate(int id) {
        for (Candidate c : candidates) if (c.getCandidateId() == id) return c;
        return null;
    }
}
