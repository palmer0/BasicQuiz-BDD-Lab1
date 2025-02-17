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

  private Button noButton, yesButton;
  private TextView answerField;

  private int currentAnswer;
  private boolean answerCheated;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);
    setTitle(R.string.cheat_screen_title);

    Log.d(TAG, "onCreate");

    //linkLayoutComponents();
    //initLayoutData();
    //initLayoutButtons();
  }


  private void initLayoutData() {
    Intent intent = getIntent();

    if ( intent != null) {
      currentAnswer = intent.getExtras().getInt(EXTRA_ANSWER);
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
    yesButton.setEnabled(false);
    noButton.setEnabled(false);
    answerCheated = true;
    updateLayoutContent();
  }

  private void updateLayoutContent() {

    if(currentAnswer == 0) {
      answerField.setText(R.string.false_text);
    } else {
      answerField.setText(R.string.true_text);

    }
  }

  private void onNoButtonClicked() {
    yesButton.setEnabled(false);
    noButton.setEnabled(false);

    returnCheatedStatus();
  }


}
