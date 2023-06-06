package com.example.shapeit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import android.os.Handler;
import android.widget.TextView;

import org.w3c.dom.Text;

public class level extends AppCompatActivity {

    @Override
    /*
    sets the view to the new game and defines all the buttons to onclicklisteners, sets the
    textview to the level as well as the amount of lives and redirects to loss if the lives
    of the current player is 0.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        if (HelperMethods.currentPlayer.getLevel() == 0) {
            Intent intent = new Intent(this, loss.class);
            startActivity(intent);
        }
        defineButtons();
        TextView level = (TextView) findViewById(R.id.LevelLevel);
        level.setText("Level" + HelperMethods.currentPlayer.getLevel());
        Lives();
    }
    // sets the on click listeners to all the buttons
    private void defineButtons() {
        findViewById(R.id.PauseLevel).setOnClickListener(buttonClickListener);
        findViewById(R.id.startGameButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape1).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape2).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape3).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape4).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape5).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape6).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape7).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape8).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape9).setOnClickListener(buttonClickListener);
        findViewById(R.id.shape10).setOnClickListener(buttonClickListener);
        findViewById(R.id.startGameButton).setOnClickListener(buttonClickListener);
    }
    /*
    Sets the stars as visible or invisible based on the amount of lives the user has.
    The lives do not reset on each level. This idea was overwritten because it
    makes the game both too easy and too long.
    This also uses getLives() method of the player class to get the amount of lives the
    currentPlayer has remaining and goes through three if statements that have
    3,2,1 and 0 lives respectively.
     */
    private void Lives() {
        ImageView LifeOne = (ImageView) findViewById(R.id.LifeOne);
        ImageView LifeTwo = (ImageView) findViewById(R.id.LifeTwo);
        ImageView LifeThree = (ImageView) findViewById(R.id.LifeThree);
        TextView level = (TextView) findViewById(R.id.LevelLevel);
        level.setText("Level " + HelperMethods.currentPlayer.getLevel());

        if (HelperMethods.currentPlayer.getLives() == 3) {
            LifeOne.setVisibility(View.VISIBLE);
            LifeTwo.setVisibility(View.VISIBLE);
            LifeThree.setVisibility(View.VISIBLE);
        } else if (HelperMethods.currentPlayer.getLives() == 2) {
            LifeOne.setVisibility(View.VISIBLE);
            LifeTwo.setVisibility(View.VISIBLE);
            LifeThree.setVisibility(View.INVISIBLE);
        } else if (HelperMethods.currentPlayer.getLives() == 1) {
            LifeOne.setVisibility(View.VISIBLE);
            LifeTwo.setVisibility(View.INVISIBLE);
            LifeThree.setVisibility(View.INVISIBLE);
        } else {
            LifeOne.setVisibility(View.INVISIBLE);
            LifeTwo.setVisibility(View.INVISIBLE);
            LifeThree.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, loss.class);
            startActivity(intent);
        }
    }


    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override

        /*
       The pause, and all game buttons redirect if the user has zero lives,
       because of the condition in onCreate that redirects it.
       Each and every button adds a number to the player sequence based on which button is clicked
       it is then verified based on if the player sequence and computer decides
       (random generated sequence) are the same.

        The start game button causes all of this to occur. Many methods are occurring at the same time
        (randomizing button shape using a set of backgrounds, delaying the color so it gives the
        appearance that the button is blinking, sound coming from each button blink both the user and computer have).
        You cannot click the buttons of the game or you will lose lives
        (this is until the canPlay boolean is eventually set to true in an alternate method.
         */

        public void onClick(View view) {
            final MediaPlayer reaver=MediaPlayer.create(getApplicationContext(),R.raw.button);
            switch (view.getId()) {
                case R.id.startGameButton:
                    startGame();
                    ButtondelayClicks();
                    break;
                case R.id.PauseLevel:
                    reaver.start();
                    openPauseMenu(view);
                    break;
                case R.id.shape1:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        reaver.start();
                        HelperMethods.playerSequence.add(1);
                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape2:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(2);
                        reaver.start();
                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape3:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(3);
                        reaver.start();

                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape4:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(4);
                        reaver.start();

                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape5:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(5);
                        reaver.start();

                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape6:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(6);
                        reaver.start();

                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape7:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(7);
                        reaver.start();

                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape8:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(8);
                        reaver.start();
                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape9:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(9);
                        reaver.start();

                    }
                    WinOrLossVerify();
                    Lives();
                    break;
                case R.id.shape10:
                    if (HelperMethods.playerSequence.size() < HelperMethods.computerSequence.size() && HelperMethods.canPlay) {
                        HelperMethods.playerSequence.add(10);
                        reaver.start();
                    }
                    WinOrLossVerify();
                    Lives();
                    break;
            }
        }

        //
        private void openPauseMenu(View view) {
            Intent intent = new Intent(view.getContext(), pause.class);
            startActivity(intent);
        }
        /*
        this method is invoked by the startgame button.
        It sets the canPlay boolean to false. Then it calculates the total delay between each
        red blink the buttons have ( because android buttons function separately).
        It randomly selects the buttons adding them to an arrayList, sets the shapes of those
        buttons that are selected.

        The buttons are then made visible or invisible based on whether they have been selected or not.
        Then the buttons are looped through and random selected to create a sequence of blinks
        and added to the arrayList in the java class containing the computer’s choices.
        Finally, the startGame button is set to as invisible.

         */
        private void startGame() {
            int choice;
            HelperMethods.canPlay = false;
            HelperMethods.totalDelay = HelperMethods.currentPlayer.getLevel()* 1500;
            ArrayList<Integer> Selectedbuttons = HelperMethods.SelectButtons(HelperMethods.currentPlayer.getLevel());
            Button startGame = (Button) findViewById(R.id.startGameButton);
            buttonsSelection(Selectedbuttons);
            buttonShapeSetter(Selectedbuttons);
            for (int x = 0; x < HelperMethods.currentPlayer.getLevel(); x++) {
                choice = HelperMethods.blinkingButtons(Selectedbuttons);
                buttonBlinker(choice, x);
                HelperMethods.computerSequence.add(choice);
            }
            startGame.setVisibility(View.INVISIBLE);
        }
        /*
        This invokes one of the methods in the HelperMethod class called winOrLoss() which
        verifies if the playerSequence and the computerSequence are identical,
        by assuming that the size are the same. This method is invoked each a button is clicked.
        It then resets all the variables, clearing and trimming the playersequence, computersequence,
        setting visbility of start game button to true and setting it as clickable and finally
        setting all of them as clickable and resetting them to default buttons.
         */
        private void WinOrLossVerify() {
            Button startGame = (Button) findViewById(R.id.startGameButton);
            if (HelperMethods.computerSequence.size() == HelperMethods.playerSequence.size()) {
                HelperMethods.winOrLoss();
                HelperMethods.computerSequence.clear();
                HelperMethods.computerSequence.trimToSize();
                HelperMethods.playerSequence.clear();
                HelperMethods.playerSequence.trimToSize();
                startGame.setVisibility(View.VISIBLE);
                startGame.setClickable(true);
                setAllVisibilities();
                setShapes();
            }
        }
        /*
        Inputs an arrayList of computer selected buttons that are being used in the game
        (before level 10 they are random and after that all buttons are present) and based on
        if they are randomly presented they will be set as visible or invisible.
        This makes it so that buttons out of sequence are not selected for the game.

         */
        private void buttonsSelection(ArrayList<Integer> Selectedbuttons) {
            Button shape1 = (Button) findViewById(R.id.shape1);
            Button shape2 = (Button) findViewById(R.id.shape2);
            Button shape3 = (Button) findViewById(R.id.shape3);
            Button shape4 = (Button) findViewById(R.id.shape4);
            Button shape5 = (Button) findViewById(R.id.shape5);
            Button shape6 = (Button) findViewById(R.id.shape6);
            Button shape7 = (Button) findViewById(R.id.shape7);
            Button shape8 = (Button) findViewById(R.id.shape8);
            Button shape9 = (Button) findViewById(R.id.shape9);
            Button shape10 = (Button) findViewById(R.id.shape10);

            if (!Selectedbuttons.contains(1)) {
                shape1.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(2)) {
                shape2.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(3)) {
                shape3.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(4)) {
                shape4.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(5)) {
                shape5.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(6)) {
                shape6.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(7)) {
                shape7.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(8)) {
                shape8.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(9)) {
                shape9.setVisibility(View.INVISIBLE);
            }
            if (!Selectedbuttons.contains(10)) {
                shape10.setVisibility(View.INVISIBLE);
            }
        }
        /*
        Loops through the array of computer selected buttons and sets their shape to one of the
        five shapes using an alternate method called shape shapeSetter(button,int)
        based on which shape has been randomly selected
         */
        private void buttonShapeSetter(ArrayList<Integer> selectedButtons) {
            Button shape1 = (Button) findViewById(R.id.shape1);
            Button shape2 = (Button) findViewById(R.id.shape2);
            Button shape3 = (Button) findViewById(R.id.shape3);
            Button shape4 = (Button) findViewById(R.id.shape4);
            Button shape5 = (Button) findViewById(R.id.shape5);
            Button shape6 = (Button) findViewById(R.id.shape6);
            Button shape7 = (Button) findViewById(R.id.shape7);
            Button shape8 = (Button) findViewById(R.id.shape8);
            Button shape9 = (Button) findViewById(R.id.shape9);
            Button shape10 = (Button) findViewById(R.id.shape10);
            int shapes;
            int specificButton;
            for (int x = 0; x < selectedButtons.size(); x++) {
                shapes = HelperMethods.RandomShapes();
                Drawable background;
                specificButton = selectedButtons.get(x);
                switch (specificButton) {
                    case 1:
                        shapeSetter(shape1, shapes);
                        break;
                    case 2:
                        shapeSetter(shape2, shapes);
                        break;
                    case 3:
                        shapeSetter(shape3, shapes);
                        break;
                    case 4:
                        shapeSetter(shape4, shapes);
                        break;
                    case 5:
                        shapeSetter(shape5, shapes);
                        break;
                    case 6:
                        shapeSetter(shape6, shapes);
                        break;
                    case 7:
                        shapeSetter(shape7, shapes);
                        break;
                    case 8:
                        shapeSetter(shape8, shapes);
                        break;
                    case 9:
                        shapeSetter(shape9, shapes);
                        break;
                    case 10:
                        shapeSetter(shape10, shapes);
                        break;
                }
            }
        }
        // Sets the button as a different shape based on the random integer inputted.
        private void shapeSetter(Button button, int shapes) {
            if (shapes == 1) {
                button.setBackgroundResource(R.drawable.ic_baseline_emoji_emotions_24);
            } else if (shapes == 2) {
                button.setBackgroundResource(R.drawable.ic_baseline_emoji_emotions_24);
            } else if (shapes == 3) {
                button.setBackgroundResource(R.drawable.ic_baseline_local_fire_department_24);
            } else if (shapes == 4) {
                button.setBackgroundResource(R.drawable.ic_baseline_pan_tool_24);
            } else {
                button.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
            }
        }
        /*
        This controls all the delays involved in the app, as each button has delays. However,
         since each button functions separately, the buttons are overlapped assuming the delays
         are wrong. So using both the button choice and the delay integer we calculate the
         timings needed for each button to glow so that the sequence is visible to the
         player.
         */
        private void buttonBlinker(int choice, int x) {
            Button shape = getButton(choice);
            int delay = x * 1500;
            timings(shape, delay);
            noise(delay);
            delayColor(shape, delay);
        }
        /*
        Sets a noise whenever the button glows. However, when the button is glowing, the sound is
         */
        private void noise(int x)
        {
            final MediaPlayer reaver=MediaPlayer.create(getApplicationContext(),R.raw.headshot);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reaver.start();
                }
            }, x);
        }
    /*
    The button is set to the color purple 1500*the index in the sequence + 1000 seconds later this
    gives the player 1 second for each button blinking
     */
        private void delayColor(Button button, int x) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.purple_500));
                }
            }, 1000 + x);
        }
        /*
         Sets the button to the color red after 1500*The index in the sequence seconds gives the
         illusion that it blinks and this is based on the difference in time between the red and
         the purple being 1 second.
         */
        private void timings(Button button, int x) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.red));
                }
            }, x);

        }
        /*
        Returns a button based on the int in the if statements if its one it returns the first
        button 2 second button etc etc. This is used to selected the randomized buttons
        effectively with looping through the length of the arrayList of computer selected buttons.
         */
        private Button getButton(int choice) {
            Button buttonChoice;
            if (choice == 1) {
                buttonChoice = (Button) findViewById(R.id.shape1);
            } else if (choice == 2) {
                buttonChoice = (Button) findViewById(R.id.shape2);
            } else if (choice == 3) {
                buttonChoice = (Button) findViewById(R.id.shape3);
            } else if (choice == 4) {
                buttonChoice = (Button) findViewById(R.id.shape4);
            } else if (choice == 5) {
                buttonChoice = (Button) findViewById(R.id.shape5);
            } else if (choice == 6) {
                buttonChoice = (Button) findViewById(R.id.shape6);
            } else if (choice == 7) {
                buttonChoice = (Button) findViewById(R.id.shape7);
            } else if (choice == 8) {
                buttonChoice = (Button) findViewById(R.id.shape8);
            } else if (choice == 9) {
                buttonChoice = (Button) findViewById(R.id.shape9);
            } else {
                buttonChoice = (Button) findViewById(R.id.shape10);
            }
            return buttonChoice;

        }
        /*
        Sets the visibilities of the buttons to visible; this is needed after they are set
        invisible after each level since the buttons are set invisible from level 1-10.
         */
        private void setAllVisibilities() {
            findViewById(R.id.shape1).setVisibility(View.VISIBLE);
            findViewById(R.id.shape2).setVisibility(View.VISIBLE);
            findViewById(R.id.shape3).setVisibility(View.VISIBLE);
            findViewById(R.id.shape4).setVisibility(View.VISIBLE);
            findViewById(R.id.shape5).setVisibility(View.VISIBLE);
            findViewById(R.id.shape6).setVisibility(View.VISIBLE);
            findViewById(R.id.shape7).setVisibility(View.VISIBLE);
            findViewById(R.id.shape8).setVisibility(View.VISIBLE);
            findViewById(R.id.shape9).setVisibility(View.VISIBLE);
            findViewById(R.id.shape10).setVisibility(View.VISIBLE);
        }
        /*
        Sets the shapes of the buttons back to the original shape because the button shapes are
        modified each level. (Mainly for appearence purposes)
         */
        private void setShapes() {
            findViewById(R.id.shape1).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape2).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape3).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape4).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape5).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape6).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape7).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape8).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape9).setBackgroundResource(android.R.drawable.btn_default);
            findViewById(R.id.shape10).setBackgroundResource(android.R.drawable.btn_default);

        }
        /* This sets the canPlay boolean variable to true after a specific delay of 1500*the length
        of the computer generated sequence. This allows the player to play after approximately
        3000 seconds.
         */
        private void ButtondelayClicks() {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    HelperMethods.canPlay = true;
                }
            }, HelperMethods.totalDelay);
        }
    };
}

