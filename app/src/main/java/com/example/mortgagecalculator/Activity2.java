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
        private EditText mortgageAmt;
        private EditText interestRate;
        private EditText loanTerm;
        private TextView monthlyPayment;
        private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mortgageAmt = (EditText)findViewById(R.id.et_PrinAmt);
        interestRate = (EditText)findViewById(R.id.et_IntRate);
        loanTerm = (EditText)findViewById(R.id.et_term);
        monthlyPayment = (TextView) findViewById(R.id.tv_result);
        calc = (Button)findViewById(R.id.calc_btn);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double morAmt = Double.parseDouble(mortgageAmt.getText().toString());
                double intRate = Double.parseDouble(interestRate.getText().toString());
                int loanTermInMonths = Integer.parseInt(loanTerm.getText().toString());

                double monthlyInterestRate = intRate/(12*100.00);
                double monthwisePayment = (monthlyInterestRate*morAmt)/1-Math.pow((1+monthlyInterestRate), -loanTermInMonths);

                DecimalFormat formatter = new DecimalFormat("#.##");
                String monthlyPaymentStr = formatter.format(monthwisePayment);
                monthlyPayment.setText("Monthly Payment (CAD): " + (monthlyPaymentStr));

            }

        });

    }
}