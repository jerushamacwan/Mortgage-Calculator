package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button findout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findout = (Button)findViewById(R.id.findout_btn);

        /*Setting the functionality of the button to let the user into the next activity*/
        findout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
    }

    public void openActivity2(){

        /*Lets the user into the next activity*/
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}