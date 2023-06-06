package com.example.shapeit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class new_game extends AppCompatActivity {
    @Override
    //sets the view to the new game and defines all the buttons to onclicklisteners
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        findViewById(R.id.submissionNewGame).setOnClickListener(buttonClickListener);
    }
    /*
    the buttons will redirect to the level page using intents assuming the name is not in the
    leaderboard array and the name is 3 letters.
     */
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            openLevel(view);
        }
        private void openLevel(View view) {
            EditText name=(EditText) findViewById(R.id.NameNewGame);
            String leaderBoardName=name.getText().toString();
            HelperMethods.currentPlayer=new Player(leaderBoardName);
            if(leaderBoardName.length()==3 && HelperMethods.verifyName(leaderBoardName)) {
                HelperMethods.StartGame(leaderBoardName);
                Intent intent = new Intent(view.getContext(), level.class);
                startActivity(intent);
            }
        }
    };
}