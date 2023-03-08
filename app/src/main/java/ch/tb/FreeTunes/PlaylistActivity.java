package ch.tb.FreeTunes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class PlaylistActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);


        Button buttonBackToStart = (Button) findViewById(R.id.buttonBackStart);
        buttonBackToStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(PlaylistActivity.this, MainActivity.class));
            }
        });

        Button goTotracks = (Button) findViewById(R.id.buttonToTrack);
        goTotracks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(PlaylistActivity.this, TrackActivity.class));
            }
        });
    }

}