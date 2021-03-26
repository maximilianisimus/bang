package com.example.bang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

    private void play(Context context, int resid){
        beforePlayerInit();
        mPlayer = MediaPlayer.create(context, resid);
        afterPlay();
    }

    public void shop(View view) {
        play(this, R.raw.shop);

    }

    public void gatling(View view) {
        play(this, R.raw.gatling);

    }

    public void indians(View view) {
        play(this, R.raw.indians);
    }

    public void bangbangbang(View view) {
        play(this, R.raw.bangbangbang);
    }

    public void duel(View view) {
        play(this, R.raw.duel);
    }

    public void looser(View view) {
        play(this, R.raw.looser);
    }

    public void badumtss(View view) {
        play(this, R.raw.badumtss);

    }

    public void eralash(View view) {
        play(this, R.raw.eralash);
    }

    public void directed(View view) {
        play(this, R.raw.directed_by_robert_b_weide_theme);
    }

    public void pause(View view) {
        mPlayer.pause();
    }

    public void stop(View view) {
        stopPlay();
    }

    private void beforePlayerInit() {
        if (mPlayer != null) {
//            stopPlay();
//            mPlayer.stop();
            mPlayer.stop();
            mPlayer.reset();
            mPlayer.release();
            mPlayer = null;
        }
    }

    private void afterPlay() {
        Log.d("function", "afterplay");
/*        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("event", "onCompletion");
                stopPlay();
            }
        });*/
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