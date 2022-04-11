package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String operator;
    String oldNumber;
    Boolean isNew = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    editText=findViewById(R.id.editText);
    }

    public void clickNumber(View view) {
        if(isNew)
            editText.setText("");
        isNew = false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.btn1: number = number+"1";
            break;
            case R.id.btn2: number = number+"2";
                break;
            case R.id.btn3: number = number+"3";
                break;
            case R.id.btn4: number = number+"4";
                break;
            case R.id.btn5: number = number+"5";
                break;
            case R.id.btn6: number = number+"6";
                break;
            case R.id.btn7: number = number+"7";
                break;
            case R.id.btn8: number = number+"8";
                break;
            case R.id.btn9: number = number+"9";
                break;
            case R.id.btnZero: number = number+"0";
                break;
            case R.id.btnDot:
                if(dotIsPresent(number)) {

                }else {
                    number = number + ".";
                }
                break;
            case R.id.btnPlusMinus:
               if(minusIsPresent(number)) {
                   number = number.substring(1);
               }else {
                   number = "-" + number;
               }
                break;
        }
        editText.setText(number);
    }

    public boolean minusIsPresent(String number) {
if(number.charAt(0) == '-'){
    return true;
}else {
    return false;
}
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.btnPlus: operator = "+";
                break;
            case R.id.btnMinus: operator = "-";
                break;
            case R.id.btnDivide: operator = "/";
                break;
            case R.id.btnMultiply: operator = "*";
                break;
        }
    }

    public void clickResult(View view) {
        String newNumber = editText.getText().toString();
        Double res = 0.0;
        switch (operator){
            case "+": res =Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-": res =Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "/": res =Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
            case "*": res =Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
        }
        editText.setText(res+"");
    }

    public void clickAC(View view) {
        editText.setText("0");
        isNew = true;
    }

    public boolean dotIsPresent (String number) {
        if (number.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }
}