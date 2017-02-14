package com.example.parkjinkyu.mission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mission02Activity extends AppCompatActivity {

    public static final int MAX_LENGTH = 80;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission02);

        EditText editText = (EditText) findViewById(R.id.editText);
//        editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(MAX_LENGTH)});
        editText.setFilters(new InputFilter[] {new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                int keep = Mission02Activity.MAX_LENGTH - (dest.toString().getBytes().length - (dend - dstart));
                if (keep <= 0) {
                    return "";
                } else if (keep >= end - start) {
                    return null; // keep original
                } else {
                    keep += start;
                    if (Character.isHighSurrogate(source.charAt(keep - 1))) {
                        --keep;
                        if (keep == start) {
                            return "";
                        }
                    }
                    return source.subSequence(start, keep);
                }
            }
        }});

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    EditText editText = (EditText) findViewById(R.id.editText);
                    TextView textView = (TextView) findViewById(R.id.textView1);

                    if(editText.getText().toString().getBytes("utf-8").length > 80) {
//                        Toast.makeText(getApplicationContext(), "onTextChanged : " + s, Toast.LENGTH_SHORT);
                    }

                    textView.setText(editText.getText().toString().getBytes("utf-8").length + " / 80 바이트");
                } catch (Exception e) {
                    Log.e("Mission_02 >>> ","afterTextChanged", e);
                }
            }
        };

        editText.addTextChangedListener(textWatcher);
    }

    public void onButton1Clicked(View v) {
        EditText edittext = (EditText) findViewById(R.id.editText);
        Toast.makeText(getApplicationContext(), edittext.getText(), Toast.LENGTH_LONG).show();
    }

    public void onButton2Clicked(View v) {
        finish();
    }
}
