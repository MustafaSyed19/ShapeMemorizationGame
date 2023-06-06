package com.example.shapeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pause extends AppCompatActivity {

    @Override
    // Pause sets the view to the pause screen and sets onclicklisteners to the buttons
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
        defineButtons();
    }
    // sets on click listeners to all the buttons
    private void defineButtons()
    {
        findViewById(R.id.ContinuePause).setOnClickListener(buttonClickListener);
        findViewById(R.id.LeaderboardPause).setOnClickListener(buttonClickListener);
        findViewById(R.id.MainMenuPause).setOnClickListener(buttonClickListener);
    }
    private View.OnClickListener buttonClickListener=new View.OnClickListener() {
        @Override
        // Pause screen has simple redirects as well using intents.
        public void onClick(View view) {
            switch(view.getId())
            {
                case R.id.ContinuePause:
                    continueGame(view);
                    break;
                case R.id.LeaderboardPause:
                    openLeaderboard(view);
                    break;
                case R.id.MainMenuPause:
                    openMainMenu(view);
                    break;
            }
        }
        private void continueGame(View view)
        {
            Intent intent=new Intent(view.getContext(),level.class);
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