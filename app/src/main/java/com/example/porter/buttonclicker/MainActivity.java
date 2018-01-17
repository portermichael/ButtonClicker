package com.example.porter.buttonclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView myMessage;
    private int numTimesClicked = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.button);
        myMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener myButtonsOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result;
                    numTimesClicked = numTimesClicked + 1;
                    result = "Button Count is equal to " + numTimesClicked + " press";
                    if(numTimesClicked != 1) {
                        result += "es";
                    }
                    myMessage.setText(result);
                    Toast toastMessage = Toast.makeText(getBaseContext(), "Main button Increments our Count", Toast.LENGTH_LONG);
                    toastMessage.show();
                }
        };


        myButton.setOnClickListener(myButtonsOnClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String result;
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "Resets Count to Zero", Toast.LENGTH_LONG);
            toastMessage.show();
            numTimesClicked = 0;
            result = "Button Count is equal to " + numTimesClicked + " presses";
            myMessage.setText(result);
            return true;
        } else if (id == R.id.action_settings_2) {
            Toast toastMessage = Toast.makeText(this, "Multiplies Count By 10", Toast.LENGTH_SHORT);
            toastMessage.show();
            numTimesClicked = numTimesClicked * 10;
            result = "Button Count is equal to " + numTimesClicked + " press";
            if(numTimesClicked != 1) {
                result += "s";
            }
            myMessage.setText(result);
            return true;
        } else if (id == R.id.action_settings_3) {
            Toast toastMessage = Toast.makeText(this, "Squares Count", Toast.LENGTH_LONG);
            toastMessage.show();
            numTimesClicked = numTimesClicked * numTimesClicked;
            result = "Button Count is equal to " + numTimesClicked + " press";
            if(numTimesClicked != 1) {
                result += "s";
            }
            myMessage.setText(result);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
