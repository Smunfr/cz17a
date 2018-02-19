package com.example.cz17a.quizclient.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cz17a.quizclient.Src.Quizzes;
import com.example.cz17a.quizclient.R;

public class LobbyActivity extends AppCompatActivity {
    public static Quizzes quizzes;
    int quizId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizId = getIntent().getExtras().getInt("quizId",1);
        setContentView(R.layout.activity_lobby);
        Button skipLogin = findViewById(R.id.skipButton);
        skipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGame();
            }
        });
    }
    public void goToGame(){
        Intent intent = new Intent(this,  GameActivity.class);
        GameActivity.quizzes = quizzes;
        intent.putExtra("quizId", quizId);
        startActivity(intent);
    }
}