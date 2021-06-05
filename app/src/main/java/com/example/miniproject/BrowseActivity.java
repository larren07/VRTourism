package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;

import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;

public class BrowseActivity extends AppCompatActivity {


    Button back;
    Button vid1,vid2,vid3,vid4,vid5,vid6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        back = findViewById(R.id.back1);
        back.setOnClickListener(v->{
            Intent intent = new Intent(BrowseActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        });

        vid1 = findViewById(R.id.button1);
        vid1.setOnClickListener(v->{


            Intent intent1 = new Intent(BrowseActivity.this,VideoActivity.class);
            intent1.putExtra("keyUrl","https://firebasestorage.googleapis.com/v0/b/miniproject-10641.appspot.com/o/%F0%9F%8C%8D%20360%C2%B0%20Gateway%20Of%20India%20_%20Bombay%2C%20India%20%F0%9F%87%AE%F0%9F%87%B3%E3%80%90GoPro%20VR%20Travel%20_%20360%20Video%E3%80%91.mp4?alt=media&token=eb7c6f91-6e02-4cc3-adcb-feddeb71368a");
            startActivity(intent1);
            finish();
        });

        vid2 = findViewById(R.id.button3);
        vid2.setOnClickListener(v->{
            Intent intent2 = new Intent(BrowseActivity.this,VideoActivity.class);
            intent2.putExtra("keyUrl","https://firebasestorage.googleapis.com/v0/b/miniproject-10641.appspot.com/o/%F0%9F%8C%8D%20360%C2%B0%20The%20Golden%20Temple%20_%20Amritsar%2C%20India%20%F0%9F%87%AE%F0%9F%87%B3%E3%80%90GoPro%20VR%20Travel%20_%20360%20Video%E3%80%91.mp4?alt=media&token=6b5039aa-3d78-4524-bae8-6e62bded6615");
            startActivity(intent2);
            finish();
        });

        vid3 = findViewById(R.id.button4);
        vid3.setOnClickListener(v->{
            Intent intent3 = new Intent(BrowseActivity.this, VideoActivity.class);
            intent3.putExtra("keyUrl","https://firebasestorage.googleapis.com/v0/b/miniproject-10641.appspot.com/o/Jaipur%20Hawa%20Mahal%20360%C2%B0%20VR%20Video%20Tour%2C%20Hawa%20Mahal%20Virtual%20Reality%20Tour%20_%20Hawa%20Mahal%20360%C2%B0%20Video%20Tour.mp4?alt=media&token=8d095c97-9d18-4ed2-abb2-af46bd962c0e");
            startActivity(intent3);
            finish();
        });

        vid4= findViewById(R.id.button5);
        vid4.setOnClickListener(v->{
            Intent intent4 = new Intent(BrowseActivity.this,VideoActivity.class);
            intent4.putExtra("keyUrl","https://firebasestorage.googleapis.com/v0/b/miniproject-10641.appspot.com/o/%F0%9F%8C%8D%20360%C2%B0%20Royal%20Lake%20_%20Udaipur%2C%20India%20%F0%9F%87%AE%F0%9F%87%B3%E3%80%90GoPro%20VR%20Travel%20_%20360%20Video%E3%80%91.mp4?alt=media&token=e5677790-cd32-4763-a4d8-91ecc63dda0d");
            startActivity(intent4);
            finish();
        });

        vid5 = findViewById(R.id.button2);
        vid5.setOnClickListener(v->{
            Intent intent5 = new Intent(BrowseActivity.this,VideoActivity.class);
            intent5.putExtra("keyUrl","https://firebasestorage.googleapis.com/v0/b/miniproject-10641.appspot.com/o/%F0%9F%87%AE%F0%9F%87%B3%20360%C2%B0%20Inside%20Mysore%20Palace%20_%20Mysore%2C%20India.mp4?alt=media&token=2b481c31-6540-4af7-bd66-9c863c166a8d");
            startActivity(intent5);
            finish();
        });

        vid6 = findViewById(R.id.button6);
        vid6.setOnClickListener(v -> {
            Intent intent6 = new Intent(BrowseActivity.this,VideoActivity.class);
            intent6.putExtra("keyUrl","https://firebasestorage.googleapis.com/v0/b/miniproject-10641.appspot.com/o/%F0%9F%8F%9B%EF%B8%8F%20UNESCO%20World%20Heritage%20Sites%20_%20Episode%207_%20The%20Great%20Wall%20Of%20China%20%F0%9F%87%A8%F0%9F%87%B3%E3%80%90360%20Video%E3%80%91.mp4?alt=media&token=87268f26-7640-45ad-92a6-433e8ad290f6");
            startActivity(intent6);
            finish();
        });






    }
}

