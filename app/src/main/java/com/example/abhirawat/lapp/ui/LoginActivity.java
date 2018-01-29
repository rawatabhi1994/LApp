package com.example.abhirawat.lapp.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abhirawat.lapp.R;
import com.example.abhirawat.lapp.models.UserModel;
import com.google.gson.Gson;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.userName)
    AutoCompleteTextView tvUserNaME;
    @BindView(R.id.password)
    EditText edPassword;
    @BindView(R.id.sign_in_button)
    Button sign_in_button;
    String userName, password;
    private static final String url = "https://lovewar.herokuapp.com/webapi/user/login";
    StringRequest request;
    JSONObject jsonObject;
    String requestBody;
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    private static final String USERMODEL = "UserModel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Gson gson = new Gson();
                    UserModel model = gson.fromJson(response, UserModel.class);
                    if (model.getSuccess().equalsIgnoreCase("true")) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra(USERMODEL, model);
                        startActivity(intent);
                    } else {
                        Log.d("ELSE", "eLSE");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "failed not connected ", Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return requestBody.getBytes();
            }

            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

        };

    }

    @OnClick(R.id.sign_in_button)
    public void postRequest() {
        if (TextUtils.isEmpty(tvUserNaME.getText().toString()) || TextUtils.isEmpty(edPassword.getText().toString())) {
            Toast.makeText(this, "Please Enter Credentials", Toast.LENGTH_LONG).show();
        } else {
            userName = tvUserNaME.getText().toString();
            password = edPassword.getText().toString();
            try {
                jsonObject = new JSONObject();
                jsonObject.put(USER_NAME, userName);
                jsonObject.put(PASSWORD, password);
                requestBody = jsonObject.toString();

            } catch (Exception e) {
            }
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        }
    }
}

