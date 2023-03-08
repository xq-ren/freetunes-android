package ch.tb.FreeTunes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import ch.tb.Model.Playlist;
import ch.tb.Model.Track;

public class TrackActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private static final String CHANNEL_ID = "defaultChannel";
    private static final String CHANNEL_NAME = "Default Channel";

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        music = MediaPlayer.create(this, R.raw.deadonarrival);

        //sample
        Button playButton = findViewById(R.id.start);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
                music.start();
            }
        });

        this.notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        Button buttonBackToPlaylist = (Button) findViewById(R.id.buttonBackPlaylist);
        buttonBackToPlaylist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(TrackActivity.this, PlaylistActivity.class));
            }
        });
    }

    private void sendNotification() {
        Track track = new Track();
        track.setArtist("KUTE");
        track.setName("Dead On Arrival");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle(track.getName())
                .setContentText("By " + track.getArtist())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(0, builder.build());
    }
}