package ch.tb.FreeTunes;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import ch.tb.Model.TokenRequest;

public class PlaylistActivity extends AppCompatActivity {
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

        /*RequestQueue queue = Volley.newRequestQueue(getBaseContext());
        TokenRequest tokenRequest = new TokenRequest(Request.Method.POST,
                "https://accounts.spotify.com/authorize?", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "onResponse: " + response);
                if (!response.isEmpty()) {
                    Log.i(TAG, "onResponse: " + response);
                } else {
                    Log.i(TAG, "response is empty");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onErrorResponse:token request " + error.getMessage());
            }
        });
        queue.add(tokenRequest);*/
    }
}