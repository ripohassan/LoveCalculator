package com.example.ripo.lovecal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etFname,etSname;
    private Button btnCalculate;
    private TextView tvResult;
    private ImageView imvLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFname = findViewById(R.id.et_fname);
        etSname = findViewById(R.id.et_sname);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        imvLove = findViewById(R.id.imv_love);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);*/

                if (!etFname.getText().toString().equals("")
                        &&!etSname.getText().toString().equals("")){
                    String fname = etFname.getText().toString();
                    String sname = etSname.getText().toString();

                    Calendar c = Calendar.getInstance();
                    String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    String month = String.valueOf(c.get(Calendar.MONTH));
                    String year = String.valueOf(c.get(Calendar.YEAR));

                    String result = fname+ sname + day + month + year;
                    result = result.toLowerCase();
                    result = result.trim();

                    int seed = result.hashCode();

                    Random r = new Random(seed);


                    tvResult.setText((r.nextInt(100) + 1) +"%");
                    imvLove.setVisibility(View.VISIBLE);


                }


            }
        });
    }
}
