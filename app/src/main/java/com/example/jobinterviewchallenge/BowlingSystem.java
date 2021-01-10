/*
 * This is the bowling system, which handles frames and scoring
 * By Emily Chen
 */

package com.example.jobinterviewchallenge;


public class BowlingSystem extends BowlingGame {

    private int ValueResults;
    private int settwo;

    String welcomeMessage;

    public String welcomeMessage() {

        welcomeMessage = "Welcome to the game of Bowling! \nPlease enter the numbers of your score.";
        return welcomeMessage;
    }

    public int getScores(int score) {


        if (score >= 0 || score <= 10) {


            return score;

        } else {

            return 0;
        }

    }

    public static int spareValue(int SV, int enterScoreValue) {

        int sumOfBallValue = SV + enterScoreValue;
        return sumOfBallValue;
    }

    public void setfinalValueResults(int ValueResults) {

        this.ValueResults = ValueResults;
    }

    public int updateFinalValueResults(int finalValueScore) {

        ValueResults = finalValueScore + ValueResults;

        return ValueResults;

    }

    public int getfinalValueResults() {

        return ValueResults;

    }

    ///////2
    public void set2(int settwo) {

        this.settwo = settwo;
    }

    public int update2(int updateTwo) {

        settwo = updateTwo + settwo;

        if (settwo == 2) {

            return settwo;
        } else

            return settwo;
    }

    public int get2() {

        return settwo;

    }




}
