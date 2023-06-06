package com.example.shapeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class loss extends AppCompatActivity {

    @Override
    /*
    Loss: Loss sets the view to the loss screen and sets onclicklisteners to the buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);
        defineButtons();
        TextView Score=(TextView) findViewById(R.id.ScoreLoss);
        HelperMethods.manageLeaderBoard(HelperMethods.currentPlayer);
        Score.setText(String.format("Your Score Was: %d",HelperMethods.currentPlayer.getLevel()));

    }
    // sets on click listeners to all the buttons
    private void defineButtons()
    {
        findViewById(R.id.NewGameLoss).setOnClickListener(buttonClickListener);
        findViewById(R.id.LeaderboardLoss).setOnClickListener(buttonClickListener);
        findViewById(R.id.MainMenuLoss).setOnClickListener(buttonClickListener);
    }
    private View.OnClickListener buttonClickListener=new View.OnClickListener() {
        @Override

        //  Loss screen redirects using its different buttons.
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.NewGameLoss:
                    openNewGame(view);
                    break;
                case R.id.LeaderboardLoss:
                    openLeaderboard(view);
                    break;
                case R.id.MainMenuLoss:
                    openMainMenu(view);
                    break;
            }
        }
        private void openNewGame(View view)
        {
            Intent intent=new Intent(view.getContext(),new_game.class);
            startActivity(intent);
        }
        private void openLeaderboard(View view)
        {
            Intent intent=new Intent(view.getContext(),leaderboard.class);
            startActivity(intent);
        }
        private void openMainMenu(View view)
        {
            Intent intent=new Intent(view.getContext(),MainActivity.class);
            startActivity(intent);
        }
    };
}