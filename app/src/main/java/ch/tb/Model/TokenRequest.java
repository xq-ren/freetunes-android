package ch.tb.Model;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import android.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class TokenRequest extends StringRequest {
//code from thetechhoster.com

    private static final String CLIENT_ID = "41665843c0d145fbb376403a4a372ede";
    private static final String CLIENT_SECRET = "c5502616ba304186a4c880cfd073e2c5";

    public TokenRequest(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        Map<String,String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credentials");
        return params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError{
        Map<String,String> headers = new HashMap<String, String>();
        String auth = "Basic "
                + Base64.encodeToString((CLIENT_ID
                        + ":" + CLIENT_SECRET).getBytes(),
                Base64.NO_WRAP);
        headers.put("Authorization", auth);
        return headers;
    }

}
