package com.example.ekarachinskaya.tehnopark;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class zayavRequest extends StringRequest {
    private static final String Zayav_REQUEST_URL = "http://localhost/lk/1CConnect/Java_1C/zayav_Java.php";
    private Map<String, String> params;

    public zayavRequest(String login, Response.Listener<String> listener) {
        super(Method.POST, Zayav_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
