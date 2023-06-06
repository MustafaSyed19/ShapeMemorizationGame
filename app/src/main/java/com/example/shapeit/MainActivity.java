package com.example.shapeit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    /*
    All the buttons will redirect to different pages using intents. Most notable is the quit
    button which simply crashes the game.

     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineButtons();
    }
    //sets on click listeners to all the buttons
    private void defineButtons() {
        findViewById(R.id.NewGameStartUp).setOnClickListener(buttonClickListener);
        findViewById(R.id.ContinueStartUp).setOnClickListener(buttonClickListener);
        findViewById(R.id.LeaderboardStartUp).setOnClickListener(buttonClickListener);
        findViewById(R.id.QuitStartUp).setOnClickListener(buttonClickListener);
    }
    public View.OnClickListener buttonClickListener=new View.OnClickListener() {
        @Override
        //sets the view to the main activity/startup screen and defines all the buttons to onclicklisteners
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.NewGameStartUp:
                    openNewGame(view);
                    break;
                case R.id.ContinueStartUp:
                    if(HelperMethods.currentPlayer.getName().equals("dweqweqw")) {
                        break;
                    } else {
                        openLevel(view);
                        break;

                    }
                case R.id.LeaderboardStartUp:
                    openLeaderboard(view);
                    break;
                case R.id.QuitStartUp:
                    closeApp();
                    break;
            }
        }
        private void openNewGame(View view)
        {
            Intent intent=new Intent(view.getContext(),new_game.class);
            startActivity(intent);
        }
        private void openLevel(View view)
        {
            Intent intent=new Intent(view.getContext(),pause.class);
            startActivity(intent);
        }
        private void openLeaderboard(View view)
        {
            Intent intent=new Intent(view.getContext(),leaderboard.class);
            startActivity(intent);
        }
        private void closeApp()
        {
            finish();
            System.exit(0);
        }
    };
}
