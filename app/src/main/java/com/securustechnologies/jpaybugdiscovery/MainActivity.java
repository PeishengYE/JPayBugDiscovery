package com.securustechnologies.jpaybugdiscovery;

import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnErrorListener{

    private static VideoView videoView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        videoView = (VideoView) findViewById(R.id.videoView);


        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.p240);

//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.p360);

//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.p480);
//
//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.p720);

        videoView.setVisibility(View.VISIBLE);
        videoView.setVideoURI(uri);
//            String videoPath = Environment.getExternalStorageDirectory()
//                    + File.separator + "/vidoe_2.mp4";
//
//            Log.d(TAG, "Video Path: " + videoPath);

//            videoView.setVideoPath(videoPath);
        videoView.seekTo(0);
        videoView.setOnErrorListener(this);
        videoView.start();

        Log.d(TAG, "Uri: " + uri.toString());


//        MediaController mediaController = new MediaController(this);
////        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }

    public boolean onError(final MediaPlayer mp, final int what, final int extra) {
        Log.e(TAG, "Media player error " + what + "/" + extra);
        switch (what) {
            case MediaPlayer.MEDIA_ERROR_UNKNOWN:
                Log.e(TAG, "Media player error: MEDIA_ERROR_UNKNOWN ");
                return true;
            case MediaPlayer.MEDIA_ERROR_IO:
                Log.e(TAG, "Media player error: MEDIA_ERROR_IO ");
                return true;
            default:
                Log.e(TAG, "Media player error: not known for me");

        }
        return true;
    }

}
