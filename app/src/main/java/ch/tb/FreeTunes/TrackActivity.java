package ch.tb.FreeTunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        Button buttonBackToPlaylist = (Button) findViewById(R.id.buttonBackPlaylist);
        buttonBackToPlaylist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(TrackActivity.this, PlaylistActivity.class));
            }
        });
    }
}