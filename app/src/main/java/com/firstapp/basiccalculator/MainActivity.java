package com.firstapp.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1,num2;
        Spinner options;
        Button button;
        TextView result1;

        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        options =findViewById(R.id.options);
        button=findViewById(R.id.button);
        result1=findViewById(R.id.result1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double firstvalue=Double.parseDouble(num1.getText().toString());
                double secondvalue= Double.parseDouble((num2.getText().toString()));
                String operator=options.getSelectedItem().toString();

                double result=0;

                switch (operator){
                    case"+":
                        result=firstvalue+secondvalue;
                        break;
                    case"-":
                        result=firstvalue-secondvalue;
                        break;
                    case "*":
                        result=firstvalue*secondvalue;
                        break;
                    case"/":
                        if(secondvalue!= 0){
                            result=firstvalue/secondvalue;
                        }
                        else {
                            result1.setText("cannot divide by Zero");
                            return;
                        }
                        break;
                    default:
                        result1.setText("Please Select an operator");
                        return;
                }
                result1.setText(String.valueOf(result));
            }
        });

    }
}