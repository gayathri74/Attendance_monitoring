package com.example.attendance_monitoring.ui.login;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;


import com.example.attendance_monitoring.R;

public class WelcomeAdminActivity extends TabActivity {
    Button artistButton, songButton, videosButton;

    TabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_welcome);

        // Buttons referencing
        artistButton = (Button) findViewById(R.id.artist_id);
        songButton = (Button) findViewById(R.id.song_id);
        videosButton = (Button) findViewById(R.id.album_id);

        // getting TabHost
        tabHost = getTabHost();

        // Tab for Photos
        TabHost.TabSpec photospec = tabHost.newTabSpec("Photos");

        // setting indicator
        photospec.setIndicator("Photos");
        Intent photosIntent = new Intent(this, Tab1Activity.class);
        photospec.setContent(photosIntent);

        // Tab for Songs
        TabHost.TabSpec songspec = tabHost.newTabSpec("Songs");
        songspec.setIndicator("Songs");
        Intent songsIntent = new Intent(this, Tab2Activity.class);
        songspec.setContent(songsIntent);

        // Tab for Videos
        TabHost.TabSpec videospec = tabHost.newTabSpec("Videos");
        videospec.setIndicator("Videos");
        Intent videosIntent = new Intent(this, Tab3Activity.class);
        videospec.setContent(videosIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab

    }

    public void tabHandler(View target) {
        artistButton.setSelected(false);
        videosButton.setSelected(false);
        songButton.setSelected(false);
        if (target.getId() == R.id.artist_id) {
            tabHost.setCurrentTab(0);
            artistButton.setSelected(true);
        } else if (target.getId() == R.id.album_id) {
            tabHost.setCurrentTab(1);
            videosButton.setSelected(true);
        } else if (target.getId() == R.id.song_id) {
            tabHost.setCurrentTab(2);
            songButton.setSelected(true);
        }
    }

    ;
}
