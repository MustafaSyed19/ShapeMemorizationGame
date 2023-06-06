package com.example.shapeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class leaderboard extends AppCompatActivity {

    @Override
    /*Leaderboard sets the view to the leaderboard screen and sets onclicklisteners to the buttons as well as
    sets the rankings of the leaderboard if the entries of the leaderboards are not null. */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        findViewById(R.id.MainMenuLeaderboard).setOnClickListener(buttonClickListener);
        defineText();

    }
    //Sets the text in the leaderboard by setting the name and the level in order of the highest level score, from 1 to 10
    private void defineText() {
        TextView rank1 = (TextView) findViewById(R.id.firstRankLeaderboard);
        TextView rank2 = (TextView) findViewById(R.id.secondRankLeaderboard);
        TextView rank3 = (TextView) findViewById(R.id.thirdRankLeaderboard);
        TextView rank4 = (TextView) findViewById(R.id.fourthRankLeaderboard);
        TextView rank5 = (TextView) findViewById(R.id.fifthRankLeaderboard);
        TextView rank6 = (TextView) findViewById(R.id.sixthRankLeaderboard);
        TextView rank7 = (TextView) findViewById(R.id.seventhRankLeaderboard);
        TextView rank8 = (TextView) findViewById(R.id.eightRankLeaderboard);
        TextView rank9 = (TextView) findViewById(R.id.ninthRankLeaderboard);
        TextView rank10 = (TextView) findViewById(R.id.tenthRankLeaderboard);
        if (HelperMethods.Leaderboard[0] != null) {
            rank1.setText(String.format("1. %s, Score: %d ", HelperMethods.Leaderboard[0].getName(), HelperMethods.Leaderboard[0].getLevel()));
        }
        if (HelperMethods.Leaderboard[1] != null) {
            rank2.setText(String.format("2. %s, Score: %d ", HelperMethods.Leaderboard[1].getName(), HelperMethods.Leaderboard[1].getLevel()));
        }
        if (HelperMethods.Leaderboard[2] != null) {
            rank3.setText(String.format("3. %s, Score: %d ", HelperMethods.Leaderboard[2].getName(), HelperMethods.Leaderboard[2].getLevel()));
        }
        if (HelperMethods.Leaderboard[3] != null) {
            rank4.setText(String.format("4. %s, Score: %d ", HelperMethods.Leaderboard[3].getName(), HelperMethods.Leaderboard[3].getLevel()));
        }
        if (HelperMethods.Leaderboard[4] != null) {
            rank5.setText(String.format("5. %s, Score: %d ", HelperMethods.Leaderboard[4].getName(), HelperMethods.Leaderboard[4].getLevel()));
        }
        if (HelperMethods.Leaderboard[5] != null) {
            rank6.setText(String.format("6. %s, Score: %d ", HelperMethods.Leaderboard[5].getName(), HelperMethods.Leaderboard[5].getLevel()));
        }
        if (HelperMethods.Leaderboard[6] != null) {
            rank7.setText(String.format("7. %s, Score: %d ", HelperMethods.Leaderboard[6].getName(), HelperMethods.Leaderboard[6].getLevel()));
        }
        if (HelperMethods.Leaderboard[7] != null) {
            rank8.setText(String.format("8. %s, Score: %d ", HelperMethods.Leaderboard[7].getName(), HelperMethods.Leaderboard[7].getLevel()));
        }
        if (HelperMethods.Leaderboard[8] != null) {
            rank9.setText(String.format("9. %s, Score: %d ", HelperMethods.Leaderboard[8].getName(), HelperMethods.Leaderboard[8].getLevel()));
        }
        if (HelperMethods.Leaderboard[9] != null) {
            rank10.setText(String.format("10. %s, Score: %d ", HelperMethods.Leaderboard[9].getName(), HelperMethods.Leaderboard[9].getLevel()));
        }
    }
    //
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        /*Defines the actions that happen when a button is clicked, and case switches
        depending on which button is pressed in the leaderboard. */
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);

        }
    };
}