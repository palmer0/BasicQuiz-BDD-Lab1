package es.ulpgc.eite.da.basicquiz;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    public static final String TAG = "Quiz.QuestionActivity";

    public static final int CHEAT_REQUEST = 1;

    private Button falseButton, trueButton, cheatButton, nextButton;
    private TextView questionField, resultField;

    private String[] questionsArray;
    private int questionIndex = 0;
    private int[] answersArray;
    private boolean nextButtonEnabled;
    //private boolean trueButtonPressed;

    private String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setTitle(R.string.question_screen_title);

        initLayoutData();
        linkLayoutComponents();
        updateLayoutContent();
        initLayoutButtons();
    }

    private void initLayoutButtons() {

        trueButton.setOnClickListener(v -> onTrueButtonClicked());
        falseButton.setOnClickListener(v -> onFalseButtonClicked());
        nextButton.setOnClickListener(v -> onNextButtonClicked());
        cheatButton.setOnClickListener(v -> onCheatButtonClicked());



        /*
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // metodo (o codio) a ejecutar cuando se haga clic en TRUE
                onTrueButtonClicked();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // metodo (o codio) a ejecutar cuando se haga clic en FALSE
                onFalseButtonClicked();
            }
        });
        */

    }


    private void initLayoutData() {
        questionsArray = getResources().getStringArray(R.array.questions_array);
        answersArray = getResources().getIntArray(R.array.answers_array);
    }

    private void linkLayoutComponents() {
        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);
        cheatButton = findViewById(R.id.cheatButton);
        nextButton = findViewById(R.id.nextButton);

        questionField = findViewById(R.id.questionField);
        resultField = findViewById(R.id.resultField);
    }

    /*
    private void updateLayoutContent() {
        questionField.setText(questionsArray[questionIndex]);

        if (trueButtonPressed) {
            if (answersArray[questionIndex] == 1) {
                resultField.setText(R.string.correct_text);
            } else {
                resultField.setText(R.string.incorrect_text);
            }

        } else {

            if (!nextButtonEnabled) {
                resultField.setText(R.string.empty_text);
            } else {
                if (answersArray[questionIndex] == 0) {
                    resultField.setText(R.string.correct_text);
                } else {
                    resultField.setText(R.string.incorrect_text);
                }
            }
        }

        nextButton.setEnabled(nextButtonEnabled);
        cheatButton.setEnabled(!nextButtonEnabled);
        falseButton.setEnabled(!nextButtonEnabled);
        trueButton.setEnabled(!nextButtonEnabled);
    }


    private void onTrueButtonClicked() {

        if (answersArray[questionIndex] == 1) {
            resultField.setText(R.string.correct_text);
        } else {
            resultField.setText(R.string.incorrect_text);
        }

        nextButtonEnabled = true;
        trueButtonPressed = true;
        updateLayoutContent();
    }

    private void onFalseButtonClicked() {

        if (answersArray[questionIndex] == 0) {
            resultField.setText(R.string.correct_text);
        } else {
            resultField.setText(R.string.incorrect_text);
        }

        nextButtonEnabled = true;
        trueButtonPressed = false;
        updateLayoutContent();
    }
    */

    private void updateLayoutContent() {
        questionField.setText(questionsArray[questionIndex]);

        if (!nextButtonEnabled) {
            resultText = getString(R.string.empty_text);
        }

        resultField.setText(resultText);

        nextButton.setEnabled(nextButtonEnabled);
        cheatButton.setEnabled(!nextButtonEnabled);
        falseButton.setEnabled(!nextButtonEnabled);
        trueButton.setEnabled(!nextButtonEnabled);
    }

    private void onTrueButtonClicked() {

        if (answersArray[questionIndex] == 1) {
            resultText =  getString(R.string.correct_text);
        } else {
            resultText = getString(R.string.incorrect_text);
        }

        nextButtonEnabled = true;
        updateLayoutContent();
    }

    private void onFalseButtonClicked() {

        if (answersArray[questionIndex] == 0) {
            resultText = getString(R.string.correct_text);
        } else {
            resultText = getString(R.string.incorrect_text);
        }

        nextButtonEnabled = true;
        updateLayoutContent();
    }

    @SuppressWarnings("ALL")
    private void onCheatButtonClicked() {


        Intent intent = new Intent(this, CheatActivity.class);
        // para pasar datos de una pantalla a otra
        // debo hacerlo usando "clave, valor"
        // clave: , valor: respuesta a pregunta actual
        //intent.putExtra(EXTRA_ANSWER, answersArray[questionIndex]);
        intent.putExtra(CheatActivity.EXTRA_ANSWER, answersArray[questionIndex]);
        //intent.putExtra("INDICE",  questionIndex);
        //intent.putExtra("RESPUESTA",  answersArray[questionIndex]);
        //intent.putExtra("PREEGUNTA",  questionsArray[questionIndex]);
        startActivity(intent);
        //startActivityForResult(intent, CHEAT_REQUEST);


    }

    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        Log.d(TAG, "onActivityResult");

        if (requestCode == CHEAT_REQUEST && resultCode == RESULT_OK && intent != null) {

            boolean answerCheated = intent.getBooleanExtra(
                CheatActivity.EXTRA_CHEATED, false
            );

            //Log.d(TAG, "answerCheated: " + answerCheated);

            if (answerCheated) {
                nextButtonEnabled = true;
                onNextButtonClicked();
            }

        }

    }
    */

    private void onNextButtonClicked() {
        Log.d(TAG, "onNextButtonClicked");

        nextButtonEnabled = false;
        questionIndex++;

        checkQuizCompletion();

        if (questionIndex < questionsArray.length) {
            //trueButtonPressed = false;
            updateLayoutContent();
        }

    }

    private void checkQuizCompletion() {

        if (questionIndex == questionsArray.length) {
            questionIndex = 0;
        }

    }
}
