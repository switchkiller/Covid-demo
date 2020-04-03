package com.example.covid_demo.tweets;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class MyTwitterService extends IntentService {
    public static final String ACTION_LOAD = "com.example.covid_demo.tweets.action.LOAD_LIST";
    private final String END_POINT_URL = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=twitterapi&count=2";

    public MyTwitterService() {
        super("MyTwitterService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOAD.equals(action)) {
                try {
                    TwitterHelper.requestBearerToken(END_POINT_URL);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }




}
