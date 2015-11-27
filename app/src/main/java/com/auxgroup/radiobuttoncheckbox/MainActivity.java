package com.auxgroup.radiobuttoncheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private RadioGroup radioGroup;
    private Button btn_rb;

    private CheckBox cb_one,cb_two,cb_three;
    private Button btn_cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                Toast.makeText(MainActivity.this, "你选择了" + rb.getText(), Toast.LENGTH_SHORT).show();

                btn_rb = (Button) findViewById(R.id.btnpost);
                btn_rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < radioGroup.getChildCount(); i++) {
                            RadioButton rb2 = (RadioButton) radioGroup.getChildAt(i);
                            if (rb2.isChecked()) {
                                Toast.makeText(MainActivity.this, "选择了" + rb2.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            }

                        }

                    }
                });
            }
        });
        cb_one= (CheckBox) findViewById(R.id.cb_one);
        cb_two= (CheckBox) findViewById(R.id.cb_two);
        cb_three= (CheckBox) findViewById(R.id.cb_three);
        btn_cb= (Button) findViewById(R.id.btn_cb);
        cb_one.setOnCheckedChangeListener(this);
        cb_two.setOnCheckedChangeListener(this);
        cb_three.setOnCheckedChangeListener(this);
        btn_cb.setOnClickListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked()) {
            Toast.makeText(this,buttonView.getText().toString(),Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onClick(View v) {
        String choose="";
        if (cb_one.isChecked()) {
            choose+=cb_one.getText().toString();

        }
        if (cb_two.isChecked()) {
            choose+=cb_two.getText().toString();

        }
        if (cb_three.isChecked()) {
            choose+=cb_three.getText().toString();

        }
Toast.makeText(this,choose,Toast.LENGTH_SHORT).show();

    }
}
