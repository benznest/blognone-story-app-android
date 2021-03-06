package com.panuwatjan.blognonestory.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import com.panuwatjan.blognonestory.MyConstants;
import com.panuwatjan.blognonestory.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashScreenActivity extends AppCompatActivity {

    private int nodeId = -1;
    private String tag;
    private String jobSlug;
    private String companySlug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        Intent intent = getIntent();
        if (intent != null) {
            nodeId = intent.getIntExtra(MyConstants.KEY_NODE_ID, -1);
            Log.d("BENZNEST LOG", "SplashScreenActivity nodeId = " + nodeId);
        }

        Uri uri = getIntent().getData();
        if (uri != null) {
            String path = uri.toString();
//            MyUtils.log("URI = " + path);

            if (path.contains("/node/")) {
                // Example : https://blognonde.com/topic/node?x=...
                // Topic ID = 36936146
                String[] str = path.split("/");
                String topic = str[str.length - 1];
                String[] str2 = topic.split("\\?");
                nodeId = Integer.parseInt(str2[0]);
//                MyUtils.log("TOPIC ID = " + topicId);

                navigateToMainActivity();
            } else if (path.contains("/topics/")) {
                // Example : https://blognonde.com/topics/Google_Drive?x=...
                // TAG = Google_Drive
                String[] str = path.split("/");
                String topic = str[str.length - 1];
                String[] str2 = topic.split("\\?");
                tag = str2[0];


                navigateToMainActivity();
            } else if (path.contains("/company/") && !path.contains("/job/")) {
                // company case
                String str = path.replace("//", "");
                String[] str2 = str.split("/");
                companySlug = str2[2];

                navigateToMainActivity();
            } else if (path.contains("/company/") && path.contains("/job/")) {
                // Job case
                String str = path.replace("//", "");
                String[] str2 = str.split("/");
                companySlug = str2[2];
                jobSlug = str2[4];

                navigateToMainActivity();
            } else {
                navigateToMainActivity();
            }
        } else {
            navigateToMainActivity();
        }
    }


    private void navigateToMainActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                intent.putExtra(MyConstants.KEY_NODE_ID, nodeId);
                intent.putExtra(MyConstants.KEY_NODE_TAG, tag);
                intent.putExtra(MyConstants.KEY_JOB_SLUG, jobSlug);
                intent.putExtra(MyConstants.KEY_COMPANY_SLUG, companySlug);
                startActivity(intent);
                finish();
            }
        }, 500);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
