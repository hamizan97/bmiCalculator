package com.hamizan.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button Calculate;
    private EditText Weight, Height;
    private TextView Answer;
    private Button Next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Next=findViewById(R.id.btnNext);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextpage();

            }



        });


        Calculate=findViewById(R.id.btnCalculate);
        Weight=findViewById(R.id.etWeight);
        Height=findViewById(R.id.etHeight);
        Answer=findViewById(R.id.tvAnswer);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getW=Weight.getText().toString();
                String getH=Height.getText().toString();

                float W=Float.parseFloat(getW);
                float H=Float.parseFloat(getH);

                float newH=H/100;
                float bmi=W/(newH*newH);

                if (bmi<18.4)
                {
                    Answer.setText(" Category: Underweight, Risk: Malnutrition ");
                }

                else if (bmi>18.5&&bmi<24.9)
                {
                    Answer.setText("Category: Normal Weight, Risk: Low ");
                }

                else if (bmi>25&&bmi<29.9)
                {
                    Answer.setText("Category: Overweight, Risk: Enhanced");
                }

                else if (bmi>30&&bmi<34.9)
                {
                    Answer.setText("Category: Moderately Obese, Risk: Medium");
                }

                else if (bmi>35&&bmi<39.9)
                {
                    Answer.setText("Category: Severely Obese, Risk: High");
                }

                else if (bmi>40)
                {
                    Answer.setText("Category: Very Severely Obese, Risk: Very High");
                }

                else
                {
                    Answer.setText("Error");
                }

            }
        });

        }
    public void openNextpage(){
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);

    }}
