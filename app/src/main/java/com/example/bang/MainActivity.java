package com.example.bang;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button playButton, pauseButton, stopButton,
            shopButton,
            gatlingButton,  indiansButton,
            bangbangbangButton, duelButton, looserButton,
            badumtssButton, eralashButton, directedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        shopButton = (Button) findViewById(R.id.shopButton);
        gatlingButton = (Button) findViewById(R.id.gatlingButton);
        indiansButton = (Button) findViewById(R.id.indiansButton);
        bangbangbangButton = (Button) findViewById(R.id.bangbangbangButton);
        duelButton = (Button) findViewById(R.id.duelButton);
        looserButton = (Button) findViewById(R.id.looserButton);
        badumtssButton = (Button) findViewById(R.id.badumtssButton);
        eralashButton = (Button) findViewById(R.id.eralashButton);
        directedButton = (Button) findViewById(R.id.directedButton);

        Log.d("1", "2");

    }

    private void stopPlay() {
        Log.d("stop", "play");

        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
        } catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void shop(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.shop);
        afterPlay();
    }

    public void gatling(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.gatling);
        afterPlay();
    }

    public void indians(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.indians);
        afterPlay();
    }

    public void bangbangbang(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.bangbangbang);
        afterPlay();
    }

    public void duel(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.duel);
        afterPlay();
    }

    public void looser(View view) {
        Log.d("function", "looser");
        mPlayer = MediaPlayer.create(this, R.raw.looser);
        afterPlay();
    }

    public void badumtss(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.badumtss);
        afterPlay();
    }

    public void eralash(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.eralash);
        afterPlay();
    }

    public void directed(View view) {
        mPlayer = MediaPlayer.create(this, R.raw.directed_by_robert_b_weide_theme);
        afterPlay();
    }

    public void pause(View view) {
        mPlayer.pause();
    }

    public void stop(View view) {
        stopPlay();
    }

    private void afterPlay() {
        Log.d("function", "afterplay");
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("event", "onCompletion");
                stopPlay();
            }
        });
        mPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}