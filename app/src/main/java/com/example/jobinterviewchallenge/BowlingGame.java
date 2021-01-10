package com.example.jobinterviewchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

public class BowlingGame extends AppCompatActivity {

    EditText enterScore;
    Button btnSubmitScore, btnNextFrame, showResults;
    TextView welcomeMessage, frameCount, draggingName, textViewCounter, outputValue, gameEndMessage, countTextView, equal10;

    String playerOnePass;

    int ballCounter = 0;
    int frameCounter = 1;
    int num = 0;
    int pinsLeftColor, enterScoreValue, endFirstValue, endSecondValue, endThirdValue, finalValue, getfinalVal, countFinalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Creating BowlingSystem Object
        final BowlingSystem bowlingSystem = new BowlingSystem();

        //color text
        pinsLeftColor = Color.rgb(255, 115, 115);

        // Welcoming message
        welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);

        //Placing welcoming message on TextView
        welcomeMessage.setText(bowlingSystem.welcomeMessage());

        //Entering score
        enterScore = (EditText) (findViewById(R.id.enterScore));

        //Submitting score
        btnSubmitScore = (Button) (findViewById(R.id.btnSubmitScore));

        // Placing frame count
        frameCount = (TextView) findViewById(R.id.frameCount);
        frameCount.setText("\n--- Frame " + Integer.toString(frameCounter) + " starts now! ---");

        //Name from MainActivity
        draggingName = (TextView) findViewById(R.id.draggingName);

        textViewCounter = (TextView) findViewById(R.id.textViewCounter);

        //Passing name to this activity
        playerOnePass = getIntent().getExtras().getString("valueOne");
        draggingName.setText(playerOnePass);

        textViewCounter.setText("! Enter your score for ball 1:");

        outputValue = (TextView) findViewById(R.id.outputValue);

        //start count for 0
        countTextView = (TextView) findViewById(R.id.countTextView);

        btnNextFrame = (Button) findViewById(R.id.btnNextFrame);
        btnNextFrame.setVisibility(View.GONE);

        //end game message
        gameEndMessage = (TextView) findViewById(R.id.gameEndMessage);

        //show results net page
        showResults = (Button) findViewById(R.id.MainPage);

        equal10 = (TextView) findViewById(R.id.equal10);


        //onClick submitting score
        btnSubmitScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //show total value
                outputValue.setVisibility((View.VISIBLE));


                if (TextUtils.isEmpty(enterScore.getText())) {

                    enterScore.setError("Enter your score!");

                    //hide textView
                    outputValue.setVisibility((View.GONE));

                } else if (Integer.parseInt(enterScore.getText().toString()) < 0 || Integer.parseInt(enterScore.getText().toString()) > 10) {

                    enterScore.setError("Opps! there are only 10 pins. Try another number");

                    //hide textView
                    outputValue.setVisibility((View.GONE));

                } else {

                    ballCounter++;
                    frameCounter++;

                    //getting the score value entered
                    enterScoreValue = Integer.parseInt(enterScore.getText().toString());


                    if (ballCounter == 1) {

                        //adding 1 to score counter
                        ballCounter++;

                        //getting the value of the first ball
                        endFirstValue = bowlingSystem.getScores(enterScoreValue);

                        equal10.setText(enterScore.getText().toString());

                        //using switch to determine leftover pins
                        switch (enterScoreValue) {
                            case 0:
                            case 10:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("Enter Score");
                                enterScore.setHintTextColor(Color.rgb(128, 128, 128));
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 10)});
                                break;
                            case 1:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("9 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 9)});
                                break;
                            case 2:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("8 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 8)});
                                break;
                            case 3:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("7 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 7)});
                                break;
                            case 4:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("6 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 6)});
                                break;
                            case 5:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("5 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 5)});
                                break;
                            case 6:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("4 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 4)});
                                break;
                            case 7:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("3 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 3)});
                                break;
                            case 8:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("2 pins left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 2)});
                                break;
                            case 9:
                                enterScore.getText().clear();
                                enterScore.setHint("");
                                enterScore.setHint("1 pin left to input");
                                enterScore.setHintTextColor(pinsLeftColor);
                                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax(0, 1)});
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + enterScoreValue);
                        }

                        //getting the final value of both balls
                        finalValue = endFirstValue;

                        //setting final value
                        bowlingSystem.setfinalValueResults(finalValue);

                        //start count for 0
                        countFinalValue = Integer.parseInt(countTextView.getText().toString());

                        //updating final value
                        bowlingSystem.updateFinalValueResults(countFinalValue);

                        //getting the final value from update
                        getfinalVal = bowlingSystem.getfinalValueResults();

                        //checking on frame 10 of ball 2
                        if (frameCounter == 11 && endFirstValue != 10 && textViewCounter.getText().toString().equals("! Enter your score for ball: 2")) {

                            int non10Frame11Value = getfinalVal;
                            outputValue.setText("Total is: " + non10Frame11Value);
                            outputValue.setVisibility(View.VISIBLE);
                            textViewCounter.setVisibility(View.GONE);
                            frameCount.setVisibility(View.GONE);
                            draggingName.setVisibility(View.GONE);
                            enterScore.setVisibility(View.GONE);
                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);


                        }

                        //checking if 0
                        if (endFirstValue == 0) {

                            //show first value
                            showToast("You missed!" + "\nBall 1 score is " + endFirstValue);

                            //printing out 2nd ball
                            textViewCounter.setText("! Enter your score for ball " + ballCounter + ":");

                            //setting score counter back to 1
                            ballCounter--;

                            //hide textView
                            outputValue.setVisibility((View.GONE));

                            equal10.setText(enterScore.getText().toString());

                            //checking if 10
                        } else if (endFirstValue == 10) {

                            //show first value
                            showToast("Ball 1 score is " + endFirstValue);

                            if (frameCounter == 11) {

                                num++;
                                int num1 = 0;
                                bowlingSystem.set2(num1);
                                bowlingSystem.update2(num);


                            } else

                                ballCounter = 0;

                            //getting the final value of both balls
                            finalValue = endFirstValue;

                            //setting final value
                            bowlingSystem.setfinalValueResults(finalValue);

                            //start count for 0
                            countFinalValue = Integer.parseInt(countTextView.getText().toString());

                            //updating final value
                            bowlingSystem.updateFinalValueResults(countFinalValue);

                            //getting the final value from update
                            getfinalVal = bowlingSystem.getfinalValueResults();

                            //printing out the total value
                            outputValue.setText("Got a Strike! " + "\nTotal is: " + getfinalVal);

                            //setting it to have output of getfinalVal so that when
                            //button is clicked, it takes the set text to add with
                            // the new finalValue.
                            countTextView.setText(String.valueOf(getfinalVal));

                            //operating visible/invisible buttons
                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);

                            //clear text
                            enterScore.getText().clear();

                            //hide enter score editText
                            enterScore.setVisibility(View.GONE);

                        } else {


                            //printing out 2nd ball
                            textViewCounter.setText("! Enter your score for ball " + ballCounter + ":");

                            //setting score counter back to 1
                            ballCounter--;

                            //hide textView
                            outputValue.setVisibility((View.GONE));


                        }

                    } else if (ballCounter == 2) {

                        //setting the frame back by -1
                        frameCounter--;

                        //getting the second ball value
                        endSecondValue = bowlingSystem.getScores(enterScoreValue);

                        //show second value
                        showToast("Ball 2 score is " + endSecondValue);

                        //checking if 10
                        if (endSecondValue == 10) {

                            if (frameCounter == 11) {
                                frameCounter = 12;
                            }

                            showToast("Ball 2 score is " + endSecondValue);

                            //getting the final value of both balls
                            finalValue = endSecondValue;

                            //setting final value
                            bowlingSystem.setfinalValueResults(finalValue);

                            //start count for 0
                            int countFinalValue = Integer.parseInt(countTextView.getText().toString());

                            //updating final value
                            bowlingSystem.updateFinalValueResults(countFinalValue);

                            //getting the final value from update
                            int getfinalVal = bowlingSystem.getfinalValueResults();

                            //printing out the total value
                            outputValue.setText("Got a Strike! " + "\nTotal is: " + getfinalVal);

                            //setting it to have output of getfinalVal so that when
                            //button is clicked, it takes the set text to add with
                            // the new finalValue.
                            countTextView.setText(String.valueOf(getfinalVal));

                            //operating visible/invisible buttons
                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);

                            //clear text
                            enterScore.getText().clear();

                            //hide enter score editText
                            enterScore.setVisibility(View.GONE);

                        } else {

                            //checking if 0
                            if (endSecondValue == 0) {

                                //show first value
                                showToast("You missed!" + "\nBall 2 score is " + endSecondValue);

                                //getting the final value of both balls
                                finalValue = endFirstValue + endSecondValue;

                                //setting final value
                                bowlingSystem.setfinalValueResults(finalValue);

                                //start count for 0
                                int countFinalValue = Integer.parseInt(countTextView.getText().toString());

                                //updating final value
                                bowlingSystem.updateFinalValueResults(countFinalValue);

                                //getting the final value from update
                                int getfinalVal = bowlingSystem.getfinalValueResults();

                                //getting the Ball 1 Value
                                // int valueBall1 = Integer.parseInt(equal10.getText().toString());

                                //printing out the total value
                                outputValue.setText("You missed!" + "\nTotal is: " + getfinalVal);

                                //setting it to have output of getfinalVal so that when
                                //button is clicked, it takes the set text to add with
                                // the new finalValue.
                                countTextView.setText(String.valueOf(getfinalVal));

                            } else {

                                //getting the final value of both balls
                                finalValue = endFirstValue + endSecondValue;

                                //setting final value
                                bowlingSystem.setfinalValueResults(finalValue);

                                //start count for 0
                                int countFinalValue = Integer.parseInt(countTextView.getText().toString());

                                //updating final value
                                bowlingSystem.updateFinalValueResults(countFinalValue);

                                //getting the final value from update
                                int getfinalVal = bowlingSystem.getfinalValueResults();

                                //getting the Ball 1 Value
                                String i = equal10.getText().toString();
                                //valueBall1 = Integer.parseInt(i);
                                //showToast(String.valueOf(bowlingSystem.spareValue(endFirstValue, endSecondValue) ));

                                //checking if spare
                                if (bowlingSystem.spareValue(endFirstValue, endSecondValue) == 10) {
                                    outputValue.setText("Got a spare! " + "\nTotal is: " + getfinalVal);
                                } else

                                    //printing out the total value
                                    outputValue.setText("Total is: " + getfinalVal);

                                //setting it to have output of getfinalVal so that when
                                //button is clicked, it takes the set text to add with
                                // the new finalValue.
                                countTextView.setText(String.valueOf(getfinalVal));

                            }

                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);
                            enterScore.getText().clear();
                            enterScore.setVisibility(View.GONE);
                        }

                    } else if (ballCounter == 3) {


                        //setting the frame back by -1
                        frameCounter = 12;

                        //getting the second ball value
                        endThirdValue = bowlingSystem.getScores(enterScoreValue);

                        //show second value
                        showToast("Ball 3 score is " + endThirdValue);
                        //getting the final value of both balls
                        finalValue = endThirdValue;

                        //setting final value
                        bowlingSystem.setfinalValueResults(finalValue);

                        //start count for 0
                        countFinalValue = Integer.parseInt(countTextView.getText().toString());

                        //updating final value
                        bowlingSystem.updateFinalValueResults(countFinalValue);

                        //getting the final value from update
                        getfinalVal = bowlingSystem.getfinalValueResults();

                        //checking on frame 10 of ball 2
                        if (frameCounter == 12 && endThirdValue != 10 || endThirdValue == 0 && textViewCounter.getText().toString().equals("! Enter your score for ball: 2")) {

                            int non10Frame11Value = endThirdValue;
                            outputValue.setText("Total is: " + non10Frame11Value);
                            outputValue.setVisibility(View.VISIBLE);
                            textViewCounter.setVisibility(View.GONE);
                            frameCount.setVisibility(View.GONE);
                            draggingName.setVisibility(View.GONE);
                            enterScore.setVisibility(View.GONE);
                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);


                        }

                        //checking if 0
                        if (endThirdValue == 10) {

                            frameCounter = 12;

                            //getting the final value of both balls
                            finalValue = endThirdValue;

                            //setting final value
                            bowlingSystem.setfinalValueResults(finalValue);

                            //start count for 0
                            int countFinalValue = Integer.parseInt(countTextView.getText().toString());

                            //updating final value
                            bowlingSystem.updateFinalValueResults(countFinalValue);

                            //getting the final value from update
                            int getfinalVal = bowlingSystem.getfinalValueResults();


                            //printing out the total value
                            outputValue.setText("Got a Strike! " + "\nTotal is: " + getfinalVal);

                            //setting it to have output of getfinalVal so that when
                            //button is clicked, it takes the set text to add with
                            // the new finalValue.
                            countTextView.setText(String.valueOf(getfinalVal));

                            //operating visible/invisible buttons
                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);

                            //clear text
                            enterScore.getText().clear();

                            //hide enter score editText
                            enterScore.setVisibility(View.GONE);

                        } else if (endThirdValue == 0) {

                            //show first value
                            showToast("You missed!" + "\nBall 3 score is " + endThirdValue);

                            //getting the final value of both balls
                            finalValue = endFirstValue + endSecondValue + endThirdValue;

                            //setting final value
                            bowlingSystem.setfinalValueResults(finalValue);

                            //start count for 0
                            int countFinalValue = Integer.parseInt(countTextView.getText().toString());

                            //updating final value
                            bowlingSystem.updateFinalValueResults(countFinalValue);

                            //getting the final value from update
                            int getfinalVal = bowlingSystem.getfinalValueResults();

                            //getting the Ball 1 Value
                            int valueBall1 = Integer.parseInt(equal10.getText().toString());

                            //printing out the total value
                            outputValue.setText("You missed!" + "\nTotal is: " + getfinalVal);

                            //setting it to have output of getfinalVal so that when
                            //button is clicked, it takes the set text to add with
                            // the new finalValue.
                            countTextView.setText(String.valueOf(getfinalVal));

                            //operating visible/invisible buttons
                            btnSubmitScore.setVisibility(View.GONE);
                            btnNextFrame.setVisibility(View.VISIBLE);

                            //clear text
                            enterScore.getText().clear();

                            //hide enter score editText
                            enterScore.setVisibility(View.GONE);


                        } else {

                            //getting the final value of both balls
                            finalValue = endSecondValue + endThirdValue;

                            //setting final value
                            bowlingSystem.setfinalValueResults(finalValue);

                            //start count for 0
                            int countFinalValue = Integer.parseInt(countTextView.getText().toString());

                            //updating final value
                            bowlingSystem.updateFinalValueResults(countFinalValue);

                            //getting the final value from update
                            int getfinalVal = bowlingSystem.getfinalValueResults();

                            //getting the Ball 1 Value
                            int valueBall1 = Integer.parseInt(equal10.getText().toString());

                            //checking if spare
                            if (bowlingSystem.spareValue(valueBall1, enterScoreValue) == 10) {

                                outputValue.setText("Got a spare! " + "\nTotal is: " + getfinalVal);

                            } else

                                //printing out the total value
                                outputValue.setText("Total is: " + getfinalVal);

                            //setting it to have output of getfinalVal so that when
                            //button is clicked, it takes the set text to add with
                            // the new finalValue.
                            countTextView.setText(String.valueOf(getfinalVal));


                        }

                    }

                }
            }
        });


        //onClick next frame
        btnNextFrame.setOnClickListener(v ->
        {

            if (frameCounter == 11 && bowlingSystem.get2() == 1 && endFirstValue == 10) {

                //operating visible/invisible buttons
                btnSubmitScore.setVisibility(View.VISIBLE);
                btnNextFrame.setVisibility(View.GONE);

                //hide total value
                outputValue.setVisibility((View.GONE));

                frameCounter = 10;

                //printing out the reset frame
                frameCount.setText("\n--- Frame " + frameCounter + " starts now! ---");

                //setting the score counter back to ballCounter =0;
                ballCounter = 0;

                //Showing scoreCounter is back to 1
                textViewCounter.setText("! Enter your score for ball: 2");

                //reset the pins
                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax("0", "999")});

                //show enter score editText
                enterScore.setVisibility(View.VISIBLE);

                //hidden clear text
                enterScore.setHint("Enter Score");

                //setting hint color back to deaf
                enterScore.setHintTextColor(Color.rgb(128, 128, 128));
                outputValue.setVisibility(View.GONE);


            } else if (frameCounter == 11 && bowlingSystem.get2() == 2) {

                //operating visible/invisible buttons
                btnSubmitScore.setVisibility(View.VISIBLE);
                btnNextFrame.setVisibility(View.GONE);

                //hide total value
                outputValue.setVisibility((View.GONE));

                frameCounter = 10;

                //printing out the reset frame
                frameCount.setText("\n--- Frame " + frameCounter + " starts now! ---");

                //setting the score counter back to ballCounter = 2;
                ballCounter = 2;

                //Showing scoreCounter is back to 1
                textViewCounter.setText("! You get an extra go for having 2 strikes! \nEnter your score for ball: 3");

                //reset the pins
                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax("0", "999")});

                //show enter score editText
                enterScore.setVisibility(View.VISIBLE);

                //hidden clear text
                enterScore.setHint("Enter Score");

                //setting hint color back to deaf
                enterScore.setHintTextColor(Color.rgb(128, 128, 128));
                outputValue.setVisibility(View.GONE);


            } else if (frameCounter == 11 && endFirstValue != 10 && endSecondValue != 10 ||
                    frameCounter == 12 && endThirdValue >= 0) {

                //hide all, leaving just the button and TextView only
                enterScore.setVisibility(View.GONE);
                btnSubmitScore.setVisibility(View.GONE);
                btnNextFrame.setVisibility(View.GONE);
                welcomeMessage.setVisibility(View.GONE);
                frameCount.setVisibility(View.GONE);
                draggingName.setVisibility(View.GONE);
                textViewCounter.setVisibility(View.GONE);

                //show total
                outputValue.setVisibility(View.VISIBLE);

                //end game message
                gameEndMessage.setVisibility(View.VISIBLE);
                gameEndMessage.setText("You finished the game! \nThanks for playing.");

                //showing button to go to next page
                showResults.setVisibility(View.VISIBLE);

                // onClick third page
                showResults.setOnClickListener(v1 -> {

                    //going back to main page page
                    startActivity(new Intent(BowlingGame.this, MainPage.class));

                });

            } else {


                //operating visible/invisible buttons
                btnSubmitScore.setVisibility(View.VISIBLE);
                btnNextFrame.setVisibility(View.GONE);

                //hide total value
                outputValue.setVisibility((View.GONE));

                //printing out the reset frame
                frameCount.setText("\n--- Frame " + frameCounter + " starts now! ---");

                //setting the score counter back to 1
                ballCounter = 0;

                //Showing scoreCounter is back to 1
                textViewCounter.setText("! Enter your score for ball 1:");

                //reset the pins
                enterScore.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9999")});

                //show enter score editText
                enterScore.setVisibility(View.VISIBLE);

                //hidden clear text
                enterScore.setHint("Enter Score");

                //setting hint color back to deaf
                enterScore.setHintTextColor(Color.rgb(128, 128, 128));

            }


        });

    }


    public void showToast(String text) {
        Toast.makeText(BowlingGame.this, text, Toast.LENGTH_LONG).show();
    }


}

