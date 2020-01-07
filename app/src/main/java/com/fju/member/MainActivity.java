package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private Intent intent;
    private String gender;
    private String age;
    private String nickname;
    private TextView text_nickname;
    private TextView text_age;
    private TextView text_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences(getString(R.string.pref_member),MODE_PRIVATE);
        intent = new Intent(this,NicknameActivity.class);
        findViews();
        nickname = pref.getString(getString(R.string.pref_nickname),"");
        age = pref.getString(getString(R.string.pref_age),"");
        gender = pref.getString(getString(R.string.pref_gender),"");
        if(nickname.equals("")||age.equals("")||gender.equals("")){
            startActivityForResult(intent,10);
        }else{
            text_nickname.setText(pref.getString(getString(R.string.pref_nickname),""));
            text_age.setText(pref.getString(getString(R.string.pref_age),""));
            text_gender.setText(pref.getString(getString(R.string.pref_gender),""));
        }
    }

    private void findViews() {
        text_nickname = findViewById(R.id.show_nickname);
        text_age = findViewById(R.id.show_age);
        text_gender = findViewById(R.id.show_gender);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK){
            text_nickname.setText(pref.getString(getString(R.string.pref_nickname),""));
            text_age.setText(pref.getString(getString(R.string.pref_age),""));
            text_gender.setText(pref.getString(getString(R.string.pref_gender),""));
        }else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("錯誤")
                    .setMessage("請輸入暱稱")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivityForResult(intent,10);
                        }
                    })
                    .show();
        }
    }
}
