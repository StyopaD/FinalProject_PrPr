package com.example.final_project.Discover;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.final_project.MainPage.MainActivity;
import com.example.final_project.R;
import com.example.final_project.Tab.TabLayoutController;

import java.util.ArrayList;
import java.util.Date;

public class DiscoverActivity extends AppCompatActivity {

    private static final int maxNumItems = 5;
    private int numItemsSelected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        DiscoverLab discoverLab = DiscoverLab.getInstance(this);
        ArrayList<DiscoverEvent> discovers = discoverLab.getDiscoverList();

        DiscoverAdapter adapter = new DiscoverAdapter(discovers);
        recyclerView.setAdapter(adapter);
    }

    private class DiscoverHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private DiscoverEvent discover;
        private TextView textView;
        private ImageView imageView;
        //private VideoView videoView;
        //private MediaPlayer mMediaPlayer;
        //private int mCurrentVideoPosition;


        public DiscoverHolder(LayoutInflater layoutInflater, @NonNull ViewGroup parent) {
            super(layoutInflater.inflate(R.layout.list_discover_item, parent, false));
            itemView.setOnClickListener(this);

            textView = itemView.findViewById(R.id.titleDiscover);
            imageView = itemView.findViewById(R.id.imageDiscover);
            //videoView = itemView.findViewById(R.id.videoDiscover);

        }

        public void bind(DiscoverEvent discover){
            this.discover = discover;
            textView.setText(this.discover.getEvent());
            imageView.setImageResource(getDrawable(this.discover.getEvent()));
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(discover.getColor());
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            imageView.setColorFilter(filter);

        }

        @Override
        public void onClick(View view) {

            ColorMatrix matrix = new ColorMatrix();

            if(discover.getColor()==0){
                discover.setColor(1);
                matrix.setSaturation(1);
                numItemsSelected++;
            }else{
                discover.setColor(0);
                matrix.setSaturation(0);
                numItemsSelected--;
            }
            if(numItemsSelected == maxNumItems){
                new AlertDialog.Builder(DiscoverActivity.this)
                        .setMessage("Are those your "+ maxNumItems+ " preferences?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(DiscoverActivity.this, TabLayoutController.class));
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                discover.setColor(0);
                                matrix.setSaturation(0);
                                numItemsSelected--;
                                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                                imageView.setColorFilter(filter);
                            }
                        })
                        .show();
            }
            //matrix.setSaturation(1);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            imageView.setColorFilter(filter);

        }

/*
        @Override
        public void onClick(View view) {
            if (!videoView.isPlaying()) {
                videoView.resume();
            }else {
                videoView.pause();
            }
        }*/
    }

    private class DiscoverAdapter extends RecyclerView.Adapter<DiscoverHolder>{
        private ArrayList<DiscoverEvent> discovers;

        public DiscoverAdapter(ArrayList<DiscoverEvent> discovers){
            this.discovers = discovers;
        }

        @NonNull
        @Override
        public DiscoverHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new DiscoverHolder(layoutInflater,parent);

        }
        @Override
        public void onBindViewHolder(@NonNull DiscoverHolder holder, int position) {
            DiscoverEvent discoverEvent = discovers.get(position);
            holder.bind(discoverEvent);
        }

        @Override
        public int getItemCount() {
            return discovers.size();
        }

    }

    private int getDrawable(String event){
        int image = R.drawable.home_icon_foreground;
        switch (event){
            case "CINEMA":
                image = R.drawable.cinema;
                break;
            case "ART":
                image = R.drawable.art;
                break;
            case "BASKETBALL":
                image = R.drawable.basketball;
                break;
            case "BEACH":
                image = R.drawable.beach;
                break;
            case "CONCERT":
                image = R.drawable.concert;
                break;
            //case "COOKING":
            //  image = R.drawable.cooking;
             //   break;
            case "CYCLING":
                image = R.drawable.cycling;
                break;
            case "DINER":
                image = R.drawable.diner;
                break;
            case "PARTY":
                image = R.drawable.party;
                break;
            case "GYM":
                image = R.drawable.gym;
                break;
            case "HIKING":
                image = R.drawable.hiking;
                break;
            case "STAND-UP":
                image = R.drawable.standup;
                break;
            case "KAYAK":
                image = R.drawable.kayak;
                break;
            case "MARTIAL ART":
                image = R.drawable.fighting;
                break;
            case "MUSIC":
                image = R.drawable.music;
                break;
            case "PICNIC":
                image = R.drawable.picnic;
                break;
            case "READING":
                image = R.drawable.reading;
                break;
            case "RUNNING":
                image = R.drawable.running;
                break;
            case "SHOPPING":
                image = R.drawable.shopping;
                break;
            case "SOCIALIZE":
                image = R.drawable.socialize;
                break;
            case "TOURISM":
                image = R.drawable.tourism2;
                break;

        }
        return image;
    }

}