package com.tunahan.catchtheinsect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView timeText;
TextView scoreText;
int score;
ImageView imageView;
ImageView imageView2;
ImageView imageView3;
ImageView imageView4;
ImageView imageView5;
ImageView imageView6;
ImageView imageView7;
ImageView imageView8;
ImageView imageView9;
ImageView[] imageArray;
Handler handler;
Runnable runnable;
Button button;
Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        button = findViewById(R.id.button);
        button2= findViewById(R.id.button2);
        button2.setEnabled(false);
        score=0;
        imageView =findViewById(R.id.imageView);
        imageView2 =findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        imageView4 =findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 =findViewById(R.id.imageView7);
        imageView8 =findViewById(R.id.imageView8);
        imageView9 =findViewById(R.id.imageView9);
        imageArray = new ImageView[] {imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
    for (ImageView image : imageArray){
        image.setVisibility(View.INVISIBLE);
    }
    }

    public void start(View view){
        button.setEnabled(false);
        button2.setEnabled(true);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,500);
            }
        };
        handler.post(runnable);
        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {

                timeText.setText("Time : "+ l/1000);
            }

            @Override
            public void onFinish() {

                button2.setEnabled(true);
                timeText.setText("Time Off!");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
            }
        }.start();

    }

    public void score(View view){
     score++;
     scoreText.setText("Score : "+score);

    }
    public void restart(View view){

        Intent intent = getIntent();
        finish();
        startActivity(intent);



    }
}