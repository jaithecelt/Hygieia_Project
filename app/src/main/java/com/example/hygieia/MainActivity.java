package com.example.hygieia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText heightText = findViewById(R.id.height);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);
                double heightM = height/39.37; //convert inches to meters
                final EditText weightText = findViewById(R.id.weight);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);
                double weightKg = weight/2.205; //convert lbs to kgs
                final EditText ageText = findViewById(R.id.age);
                String ageStr = ageText.getText().toString();
                double age = Double.parseDouble(ageStr);
                double BMI = (weightKg) / (heightM * heightM);
                DecimalFormat df = new DecimalFormat("#.#");
                double BMI_trimmed = Double.parseDouble(df.format(BMI));
                final TextView BMIResult = findViewById(R.id.result);
                BMIResult.setText(Double.toString(BMI_trimmed));
                String BMI_Cat;
                if (age > 20 && (BMI >=0 && BMI < 18.5)){
                    BMI_Cat = "Underweight";
                }
                else if (age > 20 && (BMI >=18.5 && BMI < 25)){
                    BMI_Cat = "Normal";
                }
                else if (age > 20 && (BMI >= 25 && BMI < 30)){
                    BMI_Cat = "Overweight";
                }
                else if (age > 20 && (BMI>=30 && BMI < 35)){
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                }
                else if (age > 20 && (BMI>= 35 && BMI < 40)){
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                }
                else if(age > 20 && (BMI>40)) {
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";
                }
                else if ((age <= 20 && age >=2) && (BMI < 18.5 && BMI >=0)){
                    BMI_Cat = "Underweight";
                }
                else if ((age <= 20 && age >=2) && (BMI <= 24.9 && BMI >=18.5)){
                    BMI_Cat = "Normal";
                }
                else if ((age <= 20 && age >=2) && (BMI < 29.9 && BMI >= 25)){
                    BMI_Cat = "Overweight";
                }
                else if ((age <= 20 && age >=2) && (BMI < 34.9 && BMI >= 30)){
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                }
                else if ((age <= 20 && age >=2) && (BMI < 40 && BMI >= 35)){
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                }
                else if ((age <= 20 && age >=2) && (BMI >= 40)){
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";
                }
                else{
                    BMI_Cat = "Enter valid information";
                }
                final TextView BMICategory = findViewById(R.id.bmiCat);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}