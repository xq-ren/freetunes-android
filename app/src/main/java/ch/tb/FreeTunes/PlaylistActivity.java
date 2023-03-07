package ch.tb.FreeTunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ch.tb.Model.Playlist;

public class PlaylistActivity extends AppCompatActivity {

    private static final String SPOTIFY_PLAYLIST_API = "https://api.spotify.com/v1/users/i3dyjo2q5t75gg1d11rd7fqth/playlists";
    private static final String ACCESS_TOKEN = "BQBoLFKs71L77b3FsA-4JQlNWx7TUjGuJDIPRllStzBaJ6LfiSegSYDuShCGUVuulsfP8q_o8FycjgHTpd1lzzFWCuvyDy_Ptxeh_UqU30l9bGqAFShmiU1Mr0quEpALQ-ev6VHpincpVK1C8vXCccPGEu_4_2w9v5I7PxR6ZaFtTVwKD898Oixi8mTOyeAcuXirBCNWWg";
    public static final String CHARSET_NAME = "UTF-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        try {
            getPlaylist();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        Button buttonBackToStart = (Button) findViewById(R.id.buttonBackStart);
        buttonBackToStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(PlaylistActivity.this, MainActivity.class));
            }
        });
    }

    public List<Playlist> getPlaylist() throws JSONException {
        List<Playlist> playlists = new ArrayList<>();

        String renPlaylist = SPOTIFY_PLAYLIST_API;
        JSONObject playObj = new JSONObject(renPlaylist);
        JSONArray playArr = new JSONArray(playObj);

        for (int i = 0; i < playArr.length(); i++) {
            Playlist play = new Playlist();

            JSONObject test = playArr.getJSONObject(i);

            JSONObject items = test.getJSONObject("items");

            String name = items.getString("name");

            JSONObject tracks = test.getJSONObject("aircraft");

            String total = tracks.getString("total");

            play.setName(name);
            play.setTotalTracks(total);

            playlists.add(play);
        }
        return playlists;

    }
}