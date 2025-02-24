package es.ulpgc.eite.da.basicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

  public static final String TAG = "Quiz.CheatActivity";


  public final static String EXTRA_ANSWER = "EXTRA_ANSWER";
  public final static String EXTRA_CHEATED = "EXTRA_CHEATED";
  public final static String KEY_ANSWER = "KEY_ANSWER";
  public final static String KEY_CHEATED = "KEY_CHEATED";

  private Button noButton, yesButton;
  private TextView answerField;

  private int currentAnswer;
  private boolean answerCheated;
  //private boolean buttonsDisabled;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);
    setTitle(R.string.cheat_screen_title);
    Log.d(TAG, "onCreate");

    linkLayoutComponents();
    initLayoutData(); // ---

    /*

    if(savedInstanceState != null) {
      currentAnswer = savedInstanceState.getInt("CURRENT_ANSWER");
      answerCheated = savedInstanceState.getBoolean("VER_RESPUESTA");
    }

    if(answerCheated) {
      yesButton.setEnabled(false);
      noButton.setEnabled(false);
      answerField.setText(currentAnswer == 0 // 0 o 1
          ? R.string.false_text // "False"
          : R.string.true_text // "True"
      );
    }
    */

    if(savedInstanceState == null) {
      initLayoutData();

    } else {

      currentAnswer = savedInstanceState.getInt(KEY_ANSWER);
      answerCheated = savedInstanceState.getBoolean(KEY_CHEATED);

      if(answerCheated) {
        //updateLayoutContent();
        onYesButtonClicked();
      }
    }


    initLayoutButtons();
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d(TAG, "onSaveInstanceState");

    /*
    //outState.putBoolean("BTN_PRESSED", buttonsDisabled);
    outState.putInt("CURRENT_ANSWER", currentAnswer); // 0 o 1
    outState.putBoolean("VER_RESPUESTA", answerCheated);

    */

    outState.putInt(KEY_ANSWER, currentAnswer);
    outState.putBoolean(KEY_CHEATED, answerCheated);
  }

  private void initLayoutData() {
    Intent intent = getIntent();

    if ( intent != null) {
      currentAnswer = intent.getExtras().getInt(EXTRA_ANSWER); // 0 o 1
    }
  }

  private void initLayoutButtons() {

    noButton.setOnClickListener(v -> onNoButtonClicked());
    yesButton.setOnClickListener(v -> onYesButtonClicked());
  }

  private void linkLayoutComponents() {
    noButton = findViewById(R.id.noButton);
    yesButton = findViewById(R.id.yesButton);

    answerField = findViewById(R.id.answerField);
  }


  private void returnCheatedStatus() {
    Log.d(TAG, "returnCheatedStatus");

    //Log.d(TAG, "answerCheated: " + answerCheated);

    Intent intent = new Intent();
    intent.putExtra(EXTRA_CHEATED, answerCheated);
    setResult(RESULT_OK, intent);

    finish();

  }

  @SuppressWarnings("ALL")
  @Override
  public void onBackPressed() {
    //super.onBackPressed();
    Log.d(TAG, "onBackPressed");

    returnCheatedStatus();
  }


  private void onYesButtonClicked() {
    Log.d(TAG, "onYesButtonClicked");

    yesButton.setEnabled(false);
    noButton.setEnabled(false);
    answerCheated = true;
    updateLayoutContent();

    //buttonsDisabled=true;
  }

  private void updateLayoutContent() {
    Log.d(TAG, "updateLayoutContent");


    if(currentAnswer == 0) {
      answerField.setText(R.string.false_text);
    } else {
      answerField.setText(R.string.true_text);

    }
  }

  private void onNoButtonClicked() {
    Log.d(TAG, "onNoButtonClicked");

    //buttonsEnabled=false;

    yesButton.setEnabled(false);
    noButton.setEnabled(false);

    returnCheatedStatus();
  }


}
