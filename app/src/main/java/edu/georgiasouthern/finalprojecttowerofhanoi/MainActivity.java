package edu.georgiasouthern.finalprojecttowerofhanoi;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText numberOfDiscsEditText;
    Button solveButton, resetButton;
    HanoiGameDrawing hanoiGameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hanoiGameView = new HanoiGameDrawing(this);;
        setContentView(R.layout.activity_main);

        numberOfDiscsEditText = findViewById(R.id.numberOfDiscsEditText);
        solveButton = findViewById(R.id.solveButton);
        // hanoiGameView = findViewById(R.id.hanoiGameView);
    }

    // event handler when the user clicks the reset button
    public void onResetClicked(View view){
        // retrieve how many discs the user wants
        // Remember that numberOfDiscsEditText.getText() gets the text entered in the edit text field
        // getText() returns an Editable object
        // use .toString() to convert the editable object into a String
        // .trim() to remove spaces
        String discCountString = numberOfDiscsEditText.getText().toString().trim();
        int n = Integer.parseInt(discCountString);
    }



}