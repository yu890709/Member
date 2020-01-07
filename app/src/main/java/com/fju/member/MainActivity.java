package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private SharedPreferences pref;
    private Intent intent;
    private String gender;
    private String age;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("Member",MODE_PRIVATE);
        intent = new Intent(this,NicknameActivity.class);
        nickname = pref.getString("nickname","");
        age = pref.getString("age","");
        gender = pref.getString("gender","");
        if(nickname.equals("")||age.equals("")||gender.equals("")){
            startActivityForResult(intent,10);
        }else{

        }
    }
}
