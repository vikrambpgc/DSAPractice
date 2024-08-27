package com.australia.sorting;

import java.util.*;

public class BallotVoting {

    BallotVoting() {
    }

    List<String> getResults(List<Ballot> ballots) {
        Map<String, Integer> candidatePoints = new HashMap<>();
        Map<String, int[]> candidateTieBreakerPoints = new HashMap<>();


        for(Ballot ballot: ballots) {
            String[] votes = ballot.votes;
            for (int i=0; i<votes.length;i++) {
                int currentPoints = candidatePoints.getOrDefault(votes[i], 0);
                /**
                 * i = 0, 3 points = 3 -i
                 * i = 1, 2 points
                 * i = 2, 1 points
                 */
                currentPoints += (3 - i);
                candidatePoints.put(votes[i], currentPoints);
                //Recording for tie breaker
                int[] points = candidateTieBreakerPoints.getOrDefault(votes[i], new int[3]);
                points[i] += (3 - i);
                candidateTieBreakerPoints.put(votes[i], points);
            }
        }

        List<String> candidates = new ArrayList<String>(candidatePoints.keySet());
        Collections.sort(candidates, (a, b) -> {
            int returnValue = candidatePoints.get(b) - candidatePoints.get(a);

            if (returnValue == 0) {
                //tiebreaker criteria
                for (int i=0; i < 3; i++) {
                    if (candidateTieBreakerPoints.get(b)[i] != candidateTieBreakerPoints.get(a)[i]) {
                        return candidateTieBreakerPoints.get(b)[i] - candidateTieBreakerPoints.get(a)[i];
                    }
                }
            }

            return returnValue;
        });

        return candidates;
    }
}


class Ballot {
    String[] votes;

    public Ballot(String... votes) {
        this.votes = votes;
    }

}
