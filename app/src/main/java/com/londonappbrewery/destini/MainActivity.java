package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    QuestionAnswer mQuestionAnswer;
    TextView mQuestionTextView;
    Button mTopButton, mBottomButton;
    int mQuestionIndex;
    enum  answerType{
        TOP,
        BOTTOM
    }
    QuestionAnswer[] mQuestionAnswerBank = {
            new QuestionAnswer(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new QuestionAnswer(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new QuestionAnswer(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new QuestionAnswer(R.string.T4_End),
            new QuestionAnswer(R.string.T5_End),
            new QuestionAnswer(R.string.T6_End)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            mQuestionIndex = savedInstanceState.getInt("CurrentQuestion");
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mQuestionTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mQuestionAnswer = mQuestionAnswerBank[mQuestionIndex];

        mQuestionTextView.setText(mQuestionAnswer.getQuestion());
        mTopButton.setText(mQuestionAnswer.getTopAnswer());
        mBottomButton.setText(mQuestionAnswer.getBottomAnswer());

        setStory();


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionAnswer.isEnd()) {
                    mQuestionAnswer = mQuestionAnswerBank[0];
                }
                else{
                    UpdateQuestion(answerType.TOP);
                }
                UpdateDisplay();
            }
        });
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckForCloseAction();
                UpdateQuestion(answerType.BOTTOM);
                UpdateDisplay();
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }
    private void setStory(){
        mQuestionAnswerBank[0].setTopNext(2);
        mQuestionAnswerBank[0].setBottomNext(1);

        mQuestionAnswerBank[1].setTopNext(2);
        mQuestionAnswerBank[1].setBottomNext(3);

        mQuestionAnswerBank[2].setTopNext(5);
        mQuestionAnswerBank[2].setBottomNext(4);
    }

    private void UpdateQuestion(answerType choice){
        if(choice == answerType.TOP){
            mQuestionIndex = mQuestionAnswer.getTopNext();
        }else if(choice ==answerType.BOTTOM){
            mQuestionIndex = mQuestionAnswer.getBottomNext();
        }
        mQuestionAnswer = mQuestionAnswerBank[mQuestionIndex];
    }

    private void UpdateDisplay(){
        mQuestionTextView.setText(mQuestionAnswer.getQuestion());
        if(!mQuestionAnswer.isEnd()){
            mTopButton.setText(mQuestionAnswer.getTopAnswer());
            mBottomButton.setText(mQuestionAnswer.getBottomAnswer());
        }
        else{
            mTopButton.setText(R.string.Retry);
            //mTopButton.setVisibility(View.INVISIBLE);
            mBottomButton.setText(R.string.CloseApp);
        }
    }

    private void CheckForCloseAction(){

        if(mQuestionAnswer.isEnd()){
            finish();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentQuestion",mQuestionIndex);
    }
}
