package com.example.abhirawat.lapp.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.abhirawat.lapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JoinNowActivity extends AppCompatActivity {
    String msg = "";
    @BindView(R.id.tViewTermsAndConditions)
    TextView tViewTermsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_now);
        ButterKnife.bind(this);
        msg = getResources().getString(R.string.by_clicking_join_now_you_agree_to_our_terms_and_policy);
        tViewTermsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(msg);
        int start = msg.indexOf(getString(R.string.learn_more));
        if(start>=0)
        {
            spannableString.setSpan(new JoinNowActivity.urlClickSpan(),start,start+getString(R.string.learn_more).length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tViewTermsAndConditions.setText(spannableString);
    }
    private class urlClickSpan extends ClickableSpan
    {

        @Override
        public void onClick(View view) {
            String webUrl = "https://www.google.com/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
            startActivity(intent);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(Color.GREEN);
        }
    }
}
