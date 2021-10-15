package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {
    /*Variable creation*/
        private EditText mortgageAmt;
        private EditText interestRate;
        private EditText loanTerm;
        private TextView monthlyPayment;
        private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /*Assigning variables to the ids in the xml layout*/
        mortgageAmt = (EditText)findViewById(R.id.et_PrinAmt);
        interestRate = (EditText)findViewById(R.id.et_IntRate);
        loanTerm = (EditText)findViewById(R.id.et_term);
        monthlyPayment = (TextView) findViewById(R.id.tv_result);
        calc = (Button)findViewById(R.id.calc_btn);

        /*Setting the functionality of the button to display the result when the user clicks it*/
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Converting the string input into double and int datatypes and assigning it to new variables*/
                double morAmt = Double.parseDouble(mortgageAmt.getText().toString());
                double intRate = Double.parseDouble(interestRate.getText().toString());
                int loanTermInMonths = Integer.parseInt(loanTerm.getText().toString());

                /*Monthly payment calculation*/
                double monthlyInterestRate = intRate/(12*100.00);
                double monthwisePayment = (monthlyInterestRate*morAmt)/1-Math.pow((1+monthlyInterestRate), -loanTermInMonths);

                /*Rounding the value to two decimal places*/
                DecimalFormat formatter = new DecimalFormat("#.##");


                String monthlyPaymentStr = formatter.format(monthwisePayment);
                monthlyPayment.setText("Monthly Payment (CAD): " + (monthlyPaymentStr));

            }

        });

    }
}