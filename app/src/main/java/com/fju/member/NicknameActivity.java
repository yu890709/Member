package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NicknameActivity extends AppCompatActivity {


    private SharedPreferences pref;
    private ImageView next;
    private EditText nickname;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        intent = new Intent(this, AgeActivity.class);
        pref = getSharedPreferences(getString(R.string.pref_member), MODE_PRIVATE);
        nickname = findViewById(R.id.nickname);
        next = findViewById(R.id.image_nickname);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_nickname = nickname.getText().toString();
                if (!string_nickname.equals("")) {
                    pref.edit()
                            .putString(getString(R.string.pref_nickname), string_nickname)
                            .commit();
                    setResult(RESULT_OK);
                    startActivityForResult(intent, 9);
                } else {
                    new AlertDialog.Builder(NicknameActivity.this)
                            .setTitle("錯誤")
                            .setMessage("請輸入暱稱")
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK){
            finish();
        }else{
            new AlertDialog.Builder(NicknameActivity.this)
                    .setTitle("錯誤")
                    .setMessage("請輸入年齡")
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
