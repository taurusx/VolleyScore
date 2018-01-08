package com.example.android.volleyscore;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Tracks the score for Team A.
    int scoreTeamA = 0;
    // Tracks the score for Team B.
    int scoreTeamB = 0;
    // Tracks no. of points by attack ("kills") for Team A.
    int attackTeamA = 0;
    // Tracks no. of points by block for Team A.
    int blockTeamA = 0;
    // Tracks no. of points by service ace for Team A.
    int serviceAceTeamA = 0;
    // Tracks no. of points by opponent error for Team A.
    int opponentErrorTeamA = 0;
    // Tracks no. of points by attack ("kills") for Team B.
    int attackTeamB = 0;
    // Tracks no. of points by block for Team B.
    int blockTeamB = 0;
    // Tracks no. of points by service ace for Team B.
    int serviceAceTeamB = 0;
    // Tracks no. of points by opponent error for Team B.
    int opponentErrorTeamB = 0;
    // Tracks the score of sets for Team A.
    int scoreSetsTeamA = 0;
    // Tracks the score of sets for Team B.
    int scoreSetsTeamB = 0;
    // Keeps current set number.
    int setNumber = 1;
    // Max score in current set.
    int maxScore = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Adds 1 points to attack and score for Team A.
     */
    public void addAttackTeamA (View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        attackTeamA += 1;
        displayAttackForTeamA(attackTeamA);
        checkSetScoreA(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 point to block and score for Team A.
     */
    public void addBlockTeamA (View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        blockTeamA += 1;
        displayBlockForTeamA(blockTeamA);
        checkSetScoreA(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 point to opponent error and score for Team A.
     */
    public void addErrorTeamA (View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        opponentErrorTeamA += 1;
        displayErrorForTeamA(opponentErrorTeamA);
        checkSetScoreA(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 point to ace and score for Team A.
     */
    public void addAceTeamA (View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        serviceAceTeamA += 1;
        displayAceForTeamA(serviceAceTeamA);
        checkSetScoreA(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 points to attack and score for Team B.
     */
    public void addAttackTeamB (View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        attackTeamB += 1;
        displayAttackForTeamB(attackTeamB);
        checkSetScoreB(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 points to block and score for Team B.
     */
    public void addBlockTeamB (View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        blockTeamB += 1;
        displayBlockForTeamB(blockTeamB);
        checkSetScoreB(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 point to opponent error and score for Team B.
     */
    public void addErrorTeamB (View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        opponentErrorTeamB += 1;
        displayErrorForTeamB(opponentErrorTeamB);
        checkSetScoreB(scoreTeamA, scoreTeamB);
    }

    /**
     * Adds 1 point to opponent error and score for Team B.
     */
    public void addAceTeamB (View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        serviceAceTeamB += 1;
        displayAceForTeamB(serviceAceTeamB);
        checkSetScoreB(scoreTeamA, scoreTeamB);
    }

    /**
     * Resets scores (except sets scores) for Team A and B.
     */
    public void resetScore (View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        attackTeamA = 0;
        blockTeamA = 0;
        serviceAceTeamA = 0;
        opponentErrorTeamA = 0;
        attackTeamB = 0;
        blockTeamB = 0;
        serviceAceTeamB = 0;
        opponentErrorTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAttackForTeamA(scoreTeamA);
        displayAttackForTeamB(scoreTeamB);
        displayBlockForTeamA(scoreTeamA);
        displayBlockForTeamB(scoreTeamB);
        displayErrorForTeamA(scoreTeamA);
        displayErrorForTeamB(scoreTeamB);
        displayAceForTeamA(scoreTeamA);
        displayAceForTeamB(scoreTeamB);
    }

    /**
     * Resets sets scores for Team A and B.
     */
    public void resetSetsScore (View view) {
        scoreSetsTeamA = 0;
        scoreSetsTeamB = 0;
        displaySetsForTeamA(scoreSetsTeamA);
        displaySetsForTeamB(scoreSetsTeamB);
        maxScore = 25;
        setNumber = 1;
    }

    /**
     * Resets all scores for Team A and B.
     */
    public void resetAll (View view) {
        resetScore(view);
        resetSetsScore(view);
    }

    /**
     * Displays the given score after attack for Team A.
     */
    public void displayAttackForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.attack_score_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after block for Team A.
     */
    public void displayBlockForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.block_score_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after opponent error for Team A.
     */
    public void displayErrorForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.opponent_error_score_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after ace for Team A.
     */
    public void displayAceForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.service_ace_score_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after attack for Team B.
     */
    public void displayAttackForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.attack_score_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after block for Team B.
     */
    public void displayBlockForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.block_score_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after opponent error for Team B.
     */
    public void displayErrorForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.opponent_error_score_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score after ace for Team B.
     */
    public void displayAceForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.service_ace_score_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given set score for Team A.
     */
    public void displaySetsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_sets_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given set score for Team B.
     */
    public void displaySetsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_sets_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Checks if Team A won current set and displays the given set score.
     */
    public void checkSetScoreA(int scoreA, int scoreB) {
        changeMaxScore(setNumber);
        if(scoreA >= maxScore) {
            if(scoreA - scoreB >= 2) {
                View view = findViewById(R.id.activity_main);
                resetScore(view);
                scoreSetsTeamA += 1;
                displaySetsForTeamA(scoreSetsTeamA);
                Toast toast = Toast.makeText(MainActivity.this,
                        "Team A won set no. " + setNumber, Toast.LENGTH_LONG);
                toast.show();
                setNumber += 1;
                checkEndMatch(view);
            }
        }
    }

    /**
     * Checks if Team B won current set and displays the given set score.
     */
    public void checkSetScoreB(int scoreA, int scoreB) {
        changeMaxScore(setNumber);
        if(scoreB >= maxScore) {
            if(scoreB - scoreA >= 2) {
                View view = findViewById(R.id.activity_main);
                resetScore(view);
                scoreSetsTeamB += 1;
                displaySetsForTeamB(scoreSetsTeamB);
                Toast toast = Toast.makeText(MainActivity.this,
                        "Team B won set no. " + setNumber, Toast.LENGTH_LONG);
                toast.show();
                setNumber += 1;
                checkEndMatch(view);
            }
        }
    }

    /**
     * Chooses maximum score team can get in current set.
     */
    public void changeMaxScore(int setNumber) {
        if(setNumber < 5) {
            maxScore = 25;
        } else {
            maxScore = 15;
        }
    }

    /**
     * Checks if any team won the match already. With a snippet for making Toast longer.
     */
    public void checkEndMatch (View view) {
        if(scoreSetsTeamA == 3) {
            final Toast toast = Toast.makeText(MainActivity.this,
                    "Team A won match, congratulations!" +
                    "\nScore:   ( Team A ) " + scoreSetsTeamA + " : " + scoreSetsTeamB +
                    " ( Team B )", Toast.LENGTH_LONG);
            toast.show();

            //Code snippet for extending Toast message length.
            new CountDownTimer(9000, 1000) {
                public void onTick(long millisUntilFinished) {toast.show();}
                public void onFinish() {toast.show();}
            }.start();

            //Reset all scores to start new game.
            resetSetsScore(view);
            resetScore(view);
        } else if(scoreSetsTeamB == 3) {
            final Toast toast = Toast.makeText(MainActivity.this,
                    "Team B won match, congratulations!" +
                    "\nScore:   ( Team A ) " + scoreSetsTeamA + " : " + scoreSetsTeamB +
                    " ( Team B )", Toast.LENGTH_LONG);
            toast.show();

            //Code snippet for extending Toast message length.
            new CountDownTimer(9000, 1000) {
                public void onTick(long millisUntilFinished) {toast.show();}
                public void onFinish() {toast.show();}
            }.start();
            //Reset all scores to start a new game.
            resetSetsScore(view);
            resetScore(view);
        }
    }
}
