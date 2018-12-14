package mybank.antandbuffalo.com.mybank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView trResult, sl1Result, sl2Result, nsResult;
    EditText srInput, prInput;
    double srVal = 0.0, prVal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        srInput = findViewById(R.id.srVal);
        prInput = findViewById(R.id.prVal);

        trResult = findViewById(R.id.trResult);

        sl1Result = findViewById(R.id.sl1Result);

        sl2Result = findViewById(R.id.sl2Result);

        nsResult = findViewById(R.id.nsResult);

        srInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculate();
            }
        });

        prInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculate();
            }
        });

        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void calculate() {
        try {
            srVal = Double.parseDouble(srInput.getText().toString());
            prVal = Double.parseDouble(prInput.getText().toString());
        }
        catch (NumberFormatException e) {
            Log.e("Parse", e.toString());
        }


        trResult.setText("TR: " + calculateTR(srVal));

        sl1Result.setText("SL1: " + calculateSL1(srVal));

        sl2Result.setText("SL2: " + calculateSL2(srVal));

        nsResult.setText("NS: " + calculateNS(srVal, prVal));
    }


    public double calculateTR(double srValue) {
        double tr = (srValue * 0.003) + srValue;
        return tr;
    }

    public double calculateSL1(double srValue) {
        double sl1 = srValue - (0.003 * srValue);
        return sl1;
    }

    public double calculateSL2(double srValue) {
        double sl2 = srValue - (0.01 * srValue);
        return sl2;
    }

    public double calculateNS(double srValue, double prValue) {
        return Math.floor(prValue / srValue);
    }
}
