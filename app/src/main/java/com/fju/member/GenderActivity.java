package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class GenderActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private ImageView next;
    private String string_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        string_gender = "";
        pref = getSharedPreferences(getString(R.string.pref_member),MODE_PRIVATE);
        next= findViewById(R.id.image_gender);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!string_gender.equals("")){
                    pref.edit()
                            .putString(getString(R.string.pref_gender),string_gender)
                            .commit();
                    setResult(RESULT_OK);
                    finish();
                }else{
                    new AlertDialog.Builder(GenderActivity.this)
                            .setTitle("錯誤")
                            .setMessage("請選擇性別")
                            .setPositiveButton("OK",null)
                            .show();
                }
            }
        });
        RadioGroup rg=findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.man:
                        Log.d("Gender", "onCheckedChanged: 男");
                        string_gender="男";
                        break;
                    case R.id.woman:
                        Log.d("Gender", "onCheckedChanged: 女");
                        string_gender="女";
                        break;
                }
            }
        });
    }
}
