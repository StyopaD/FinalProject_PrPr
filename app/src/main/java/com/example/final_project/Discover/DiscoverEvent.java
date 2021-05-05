package com.example.final_project.Discover;

import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.VideoView;

import java.nio.file.Path;

public class DiscoverEvent {
    private String event;
    private String path;
    private int color = 0;
   /* private VideoView videoView;
    private MediaPlayer mMediaPlayer;
    private int mCurrentVideoPosition;*/


    public DiscoverEvent(String event){
        this.event = event;
    }

    public String getEvent() {
        return event;
    }/*
    public int getCurrentVideoPosition() {
        return mCurrentVideoPosition;
    }
    public VideoView getVideoView() {
        return videoView;
    }

    public MediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }*/

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPath() {
        return path;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
