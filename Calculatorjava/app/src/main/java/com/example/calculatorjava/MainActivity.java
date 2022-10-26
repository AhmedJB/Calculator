package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    private Button btPlus, btDiv, btMult, btMinus, btDot;
    private Button btClear, btCe, btErase, btResult;
    private EditText screen;
    private  boolean operator, hasdot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Numbers
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);

        // Math Operations
        btPlus = findViewById(R.id.btplus);
        btMinus = findViewById(R.id.btminus);
        btDiv = findViewById(R.id.btdiv);
        btMult = findViewById(R.id.btmult);

        // Other Operations
        btResult = findViewById(R.id.btresult);
        btDot = findViewById(R.id.btdot);
        btClear = findViewById(R.id.btclear);
        btCe = findViewById(R.id.btCE);
        btErase = findViewById(R.id.btErase);

        // Screen
        screen = findViewById(R.id.screen);
        screen.setFocusable(false);
    }

    // add numbers to screen
    public void add0(View v) {

        operator = false;
        if(screen.getText().toString().compareToIgnoreCase("Infinity") == 0 ||
                (screen.getText().length() == 1 && screen.getText().charAt(0) == '0'))
            screen.setText("");
        screen.setText(screen.getText() + "0");
        movecarot();
    }

    public void add1(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0') ||
                screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "1");
        movecarot();
    }

    public void add2(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "2");
        movecarot();
    }

    public void add3(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "3");
        movecarot();
    }

    public void add4(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "4");
        movecarot();
    }

    public void add5(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "5");
        movecarot();
    }

    public void add6(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "6");
        movecarot();
    }

    public void add7(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "7");
        movecarot();
    }

    public void add8(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "8");
        movecarot();
    }

    public void add9(View v) {
        operator = false;
        if((screen.getText().length() == 1 && screen.getText().charAt(0) == '0')
                || screen.getText().toString().compareToIgnoreCase("Infinity") == 0)
            screen.setText("");
        screen.setText(screen.getText() + "9");
        movecarot();
    }

    public void dot(View v) {
        if(!hasdot && !operator
                && !TextUtils.isEmpty(screen.getText().toString())
                && screen.getText().toString().compareToIgnoreCase("Infinity") != 0) {
            screen.setText(screen.getText()+".");
            hasdot = true;
            movecarot();
        }
    }

    // action buttons

    public String getLastDigitedNumber() {
        String expression = "";
        int i = 0;
        for(i = screen.getText().length() - 1; i >= 0; i--) {
            if(screen.getText().charAt(i) != ' ') {
                expression+=screen.getText().charAt(i);
            } else {
                break;
            }
        }
        screen.setText(screen.getText().subSequence(0, i + 1));
        String finalres = "";
        for(i = expression.length() - 1; i >= 0; i--)
            finalres+=expression.charAt(i);
        return finalres;
    }

    public void clear(View v) {
        screen.setText("");
        hasdot = operator = false;
        movecarot();
    }

    public void ce(View v) {
        if(!TextUtils.isEmpty(screen.getText().toString()) && !operator) {
            getLastDigitedNumber();
            hasdot = false;
            operator = true;
            movecarot();
        }
    }

    public void erase(View v) {
        char lastChar = ' ';
        if(!TextUtils.isEmpty(screen.getText().toString())) {
            if(screen.getText().toString().compareToIgnoreCase("Infinity") == 0) {
                screen.setText("");
            } else {
                if (operator) {
                    screen.setText(screen.getText().subSequence(0, screen.getText().length() - 3));
                    operator = false;
                } else {
                    lastChar = screen.getText().charAt(screen.getText().length() - 1);
                    screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));
                }
                if (screen.getText().length() > 0) {
                    char currentLastOne = screen.getText().charAt(screen.getText().length() - 1);
                    if (currentLastOne == '.') {
                        screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));
                        hasdot = false;
                    } else if (currentLastOne == ' ') {
                        operator = true;
                    } else if (currentLastOne == '-') {
                        screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));
                    }
                }
            }

            if(lastChar == '.')
                hasdot = false;
            movecarot();
        }
    }

    // operations logic
    public void sum(View v) {
        if(!TextUtils.isEmpty(screen.getText().toString()) && screen.getText().toString().compareToIgnoreCase("Infinity") != 0) {
            if(operator) {
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 3));
            }
            screen.setText(screen.getText().toString() + " + ");
            operator = true;
            hasdot = false;
            movecarot();
        }
    }

    public void sub(View v) {
        if(!TextUtils.isEmpty(screen.getText().toString()) && screen.getText().toString().compareToIgnoreCase("Infinity") != 0) {
            if(operator) {
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 3));
            }
            screen.setText(screen.getText() + " - ");
            operator = true;
            hasdot = false;
            movecarot();
        }
    }

    public void div(View v) {
        if(!TextUtils.isEmpty(screen.getText().toString()) && screen.getText().toString().compareToIgnoreCase("Infinity") != 0) {
            if(operator) {
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 3));
            }
            screen.setText(screen.getText() + " / ");
            operator = true;
            hasdot = false;
            movecarot();
        }
    }

    public void mult(View v) {
        if(!TextUtils.isEmpty(screen.getText().toString()) && screen.getText().toString().compareToIgnoreCase("Infinity") != 0) {
            if(operator) {
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 3));
            }

            screen.setText(screen.getText().toString() + " * ");
            operator = true;
            hasdot = false;
            movecarot();
        }
    }

    public void result(View v) {
        if(!TextUtils.isEmpty(screen.getText().toString())
                && !operator && screen.getText().toString().compareToIgnoreCase("Infinity") != 0) {
            List<Double> number = new ArrayList<Double>();
            List<Character> operators = new ArrayList<Character>();

            String expression = screen.getText().toString();
            String value = "";
            expression+=" ";
            for(int i = 0; i < expression.length(); i++) {
                if((expression.charAt(i) != ' ' && !isAnOperatorSign(expression.charAt(i))) ||
                        (isAnOperatorSign(expression.charAt(i)) && expression.charAt(i + 1) != ' ')) {
                    value += expression.charAt(i);
                } else {
                    if(value != "") {
                        number.add(Double.parseDouble(value));
                        value = "";
                    } else {
                        if(isAnOperatorSign(expression.charAt(i))) {
                            operators.add((expression.charAt(i)));
                        }
                    }
                }
            }
            if(operators.size() > 0) {
                String resp = calculation(number, operators).toString();
                hasdot = doesItHasADot(resp);
                if(resp.charAt(resp.length() - 1) == '0' && resp.charAt(resp.length() - 2) == '.') {
                    resp = resp.substring(0, resp.length() - 2);
                    hasdot = false;
                }
                // update screen
                screen.setText(resp);
                operator = false;
                movecarot();
            }
        }

    }


    // helper functions
    public Double calculation(List<Double>number, List<Character>op) {
        Double resp = 0.0;
        while(number.size() > 1) {
            int i;
            boolean found = false;
            for (i = 0; i < op.size(); i++) {
                if(op.get(i) == '/' || op.get(i) == '*') {
                    found = true;
                    break;
                }
            }
            if(!found) {
                i = 0;
            }
            resp = doMath(number.get(i), number.get(i + 1), op.get(i));
            number.set(i + 1, resp);
            number.remove(i);
            op.remove(i);
        }
        return resp;
    }

    public boolean doesItHasADot(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    // execute math operations
    public double doMath(Double n1, double n2, char op) {
        double r = 0;
        switch(op) {
            case '+':
                r = n1 + n2;
                break;
            case '-':
                r = n1 - n2;
                break;
            case '/':
                r = n1 / n2;
                break;
            case '*':
                r = n1 * n2;
                break;
        }
        return r;
    }
    //  check if it's an operator
    public boolean isAnOperatorSign(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*');
    }

    // move the  cursor
    public void movecarot() {
        screen.setSelection(screen.getText().length());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        // itents goes here
        MenuItem item1 = menu.findItem(R.id.item1);
        Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
        item1.setIntent(intent1);
        MenuItem item2 = menu.findItem(R.id.item2);
        Intent intent2 = new Intent(MainActivity.this, Scientific.class);
        item2.setIntent(intent2);





        return true;

    }

}