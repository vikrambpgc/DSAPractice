package com.australia.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallotVotingTest {

    @Test
    void getResults() {
        BallotVoting ballotVoting = new BallotVoting();

        List<Ballot> ballots = new ArrayList<>();
        Ballot ballot1 = new Ballot("A", "B", "C");
        Ballot ballot2 = new Ballot("D", "B", "C");
        Ballot ballot3 = new Ballot("E", "F", "A");
        ballots.add(ballot1);
        ballots.add(ballot2);
        ballots.add(ballot3);
        List<String> results = ballotVoting.getResults(ballots);
        for (String candidate: results) {
            System.out.println(candidate);
        }
        //B
        //A,D
        //C
    }
}