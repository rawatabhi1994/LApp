package com.example.abhirawat.lapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.abhirawat.lapp.R;
import com.example.abhirawat.lapp.models.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAccountActivity extends AppCompatActivity {
    UserModel model;
    private static final String USERMODEL = "UserModel";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvNameValue)
    TextView tvNameValue;
    @BindView(R.id.tvMemberSinceValue)
    TextView tvMemberSinceValue;
    @BindView(R.id.tvUserTypeValue)
    TextView tvUserTypeValue;
    @BindView(R.id.tvEmailValue)
    TextView tvEmailValue;
    @BindView(R.id.tvPhoneValue)
    TextView tvPhoneValue;
    @BindView(R.id.tvPasswordChange)
    TextView tvPasswordChange;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        ButterKnife.bind(this);
       // Bundle bundle = getIntent().getExtras();
        //model = (UserModel) bundle.get(USERMODEL);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setViewData();
        msg = getResources().getString(R.string.change);
        tvPasswordChange.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString sp = new SpannableString(msg);
        sp.setSpan(new ChangePassword(), 0, msg.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvPasswordChange.setText(sp);

    }

    class ChangePassword extends ClickableSpan {

        @Override
        public void onClick(View view) {
        }
    }

    protected void setViewData() {
        tvNameValue.setText(model.getFname() + " " + model.getLname());
        String doj = model.getCreatedon();
        String fdoj = doj.substring(0, doj.indexOf('T'));
        tvMemberSinceValue.setText(fdoj);
        tvUserTypeValue.setText(model.getUserType());
        tvEmailValue.setText(model.getEmail());
        tvPhoneValue.setText(model.getMobile());
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
