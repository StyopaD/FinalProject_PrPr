package com.example.final_project.MainPage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.final_project.Discover.DiscoverActivity;
import com.example.final_project.R;
import com.example.final_project.Tab.TabLayoutController;
import com.example.final_project.io.ApiAdapter;
import com.example.final_project.io.response.UserResponse;

import java.nio.file.Path;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button RegisterButton;
    private Button LogInButton;
    private VideoView videoBG;
    private MediaPlayer mMediaPlayer;
    private int mCurrentVideoPosition;

    public static Intent newIntent(Context packageContext) {
        Intent intent2 = new Intent(packageContext, MainActivity.class);
        return intent2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RegisterButton = (Button) findViewById(R.id.register_button);
        RegisterButton.setOnClickListener(this);

        LogInButton = (Button) findViewById(R.id.login_button);
        LogInButton.setOnClickListener(this);
        videoBG = (VideoView) findViewById(R.id.videoView);


        UserResponse userResponse = new UserResponse("josep", "josep", "josep@josep.com", "josepjosep", "fhhiu");
        ApiAdapter.getApiService().postCreateUser(userResponse).enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    try {
                        //Toast.makeText(getApplicationContext(), "User " + response.body().getName() + " created", Toast.LENGTH_SHORT).show();
                        new AlertDialog.Builder(MainActivity.this)
                                .setMessage("Are you sure you want to exit?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        MainActivity.this.finish();
                                    }
                                })
                                .setNegativeButton("No", null)
                                .show();
                        System.out.println("hola soy julio quieres tema");
                    } catch (Exception e) {
                        System.out.println("HOLA SOY UN PUTO ERROR:" + e);
                    }
                }
                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    System.out.println("hooooooola");
                }
            });

        // Build your video Uri
        int hai = R.drawable.logo_vividly;
        int hola = R.raw.video_background;
        System.out.println("android.resource://" // First start with this,
                + getPackageName() // then retrieve your package name,
                + "/" // add a slash,
                + R.raw.marshall);
        Uri uri = Uri.parse("android.resource://" // First start with this,
                + getPackageName() // then retrieve your package name,
                + "/" // add a slash,
                + hola); // and then finally add your video resource. Make sure it is stored
        // in the raw folder.;
        System.out.println(hola);
        // Set the new Uri to our VideoView
        videoBG.setVideoURI(uri);
        // Start the VideoView
        videoBG.start();

        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });
    }

    /*================================ Important Section! ================================
    We must override onPause(), onResume(), and onDestroy() to properly handle our
    VideoView.
     */

    @Override
    protected void onPause() {
        super.onPause();
        // Capture the current video position and pause the video.
        mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Restart the video when resuming the Activity
        videoBG.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // When the Activity is destroyed, release our MediaPlayer and set it to null.
        mMediaPlayer.release();
        mMediaPlayer = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                new RegisterControl(MainActivity.this,
                        (LinearLayout)findViewById(R.id.bottomSheetContainer));

                break;
            case R.id.login_button:
                // Intent intent = AddCrimeActivity.newIntent(MainActivity.this, "title");
                //startActivityForResult(new Intent(MainActivity.this, LogIn.class), 0);
                new LoginControl(MainActivity.this,
                        (LinearLayout)findViewById(R.id.bottomSheetContainerLogin));
                break;
        }
    }


}