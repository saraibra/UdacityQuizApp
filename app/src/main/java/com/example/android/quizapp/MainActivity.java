package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button submitButton;
    private EditText answerEditText;
    private RadioGroup answer1_RadioGroup, answer2_RadioGroup, answer3_RadioGroup;
    private TextView result1, result2, result3, result4, result5;
    private CheckBox checkBox_A, checkBox_B, checkBox_C, checkBox_D;
    private TextView resultTextView;
    int result = 0;
    String averageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit_Button);
        answerEditText = (EditText) findViewById(R.id.answer5_EditText);
        answer1_RadioGroup = (RadioGroup) findViewById(R.id.answer1_RadioGroup);
        answer2_RadioGroup = (RadioGroup) findViewById(R.id.answer2_RadioGroup);
        answer3_RadioGroup = (RadioGroup) findViewById(R.id.answer3_RadioGroup);
        result1 = (TextView) findViewById(R.id.answer_1);
        result2 = (TextView) findViewById(R.id.answer_2);
        result3 = (TextView) findViewById(R.id.answer_3);
        result4 = (TextView) findViewById(R.id.answer_4);
        result5 = (TextView) findViewById(R.id.answer_5);
        resultTextView = (TextView) findViewById(R.id.result_TextView);
        checkBox_A = (CheckBox) findViewById(R.id.a_checkBox);
        checkBox_B = (CheckBox) findViewById(R.id.b_checkBox);
        checkBox_C = (CheckBox) findViewById(R.id.c_checkBox);
        checkBox_D = (CheckBox) findViewById(R.id.d_checkBox);
        answer1_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.answer1C_Button) {
                    result1.setText(R.string.true1);
                    result1.setTextColor(getResources().getColor(R.color.colorPrimary));
                    result++;
                } else {
                    result1.setText(R.string.false1);
                    result1.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }
        });

        answer2_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.answer2D_Button) {
                    result2.setText(R.string.true1);
                    result2.setTextColor(getResources().getColor(R.color.colorPrimary));

                    result++;
                } else {
                    result2.setText(R.string.false1);
                    result2.setTextColor(getResources().getColor(R.color.colorAccent));

                }
            }
        });

        answer3_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.answer3C_Button) {
                    result3.setTextColor(getResources().getColor(R.color.colorPrimary));

                    result3.setText(R.string.true1);
                    result++;

                } else {
                    result3.setTextColor(getResources().getColor(R.color.colorAccent));

                    result3.setText(R.string.false1);

                }
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAnswers();


            }
        });


    }

    private void submitAnswers() {

        if (checkBox_A.isChecked() && checkBox_B.isChecked() && checkBox_C.isChecked()) {
            result4.setTextColor(getResources().getColor(R.color.colorPrimary));

            result4.setText(R.string.true1);
            result++;
        } else {
            result4.setTextColor(getResources().getColor(R.color.colorAccent));

            result4.setText(R.string.false1);

        }
        String answer = answerEditText.getText().toString();
        if (answer.equals(getString(R.string.q5_answer))) {
            result5.setTextColor(getResources().getColor(R.color.colorPrimary));

            result5.setText(R.string.true1);
            result++;

        } else {
            result5.setTextColor(getResources().getColor(R.color.colorAccent));

            result5.setText(R.string.false1);


        }


        result1.setVisibility(View.VISIBLE);
        result2.setVisibility(View.VISIBLE);
        result3.setVisibility(View.VISIBLE);
        result4.setVisibility(View.VISIBLE);
        result5.setVisibility(View.VISIBLE);

        resultTextView.setText(getResources().getString(R.string.result) + " : " + result);
        if (result > 3) {
            Toast.makeText(getApplicationContext(), "You passed the exam", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "You didn't pass the exam try again", Toast.LENGTH_LONG).show();

        }

    }

}
