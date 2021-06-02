package com.example.a131_manifestfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView textViewTimeline, textViewCountChars;
    EditText editTextTweet, editTextUsername;
    Twitter twitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextTweet = (EditText) findViewById(R.id.editTextTweet);
        editTextTweet.addTextChangedListener(new MyTextWatcher());
        textViewCountChars =(TextView) findViewById(R.id.textViewCountChars);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        textViewTimeline = (TextView) findViewById(R.id.textViewTimeline);
        textViewTimeline.setMovementMethod(new ScrollingMovementMethod());

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey("0000")
                .setOAuthConsumerSecret("1111")
                .setOAuthAccessToken("2222-3333")
                .setOAuthAccessTokenSecret("4444");
        TwitterFactory factory = new TwitterFactory(builder.build());
        twitter = factory.getInstance();

    }
    // Button click listener
    public void onTweetButtonClick(View v){
        new MyAsyncTaskTweet().execute(editTextTweet.getText().toString());
    }
    public void onTimelineButtonClick(View v){
        new MyAsyncTaskTimeline().execute(editTextUsername.getText().toString());
    }
    //Count character in the Tweet field
    class MyTextWatcher implements TextWatcher {
        @Override
        public void afterTextChanged(Editable s){
            textViewCountChars.setText("" + editTextTweet.getText().length());
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after){

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count){

        }
    }
    //The AsyncTask classes
    public class MyAsyncTaskTweet extends AsyncTask<String, Void , String> {
        @Override
        protected String doInBackground(String... tweet){
            String result = "";
            try{
                twitter.updateStatus(tweet[0]);
                result = getResources().getString(R.string.success);
            }catch(TwitterException twitterException){
                Log.d(TAG, "Errrrr");
                result = getResources().getString(R.string.twitter_failure);
            }catch(Exception e){
                result = getResources().getString(R.string.genertal_failure);
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result){
            editTextTweet.setHint(result);
            editTextTweet.setText("");
        }
    }


    public class MyAsyncTaskTimeline extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... username){
            String result = new String("");
            List<twitter4j.Status> statuses = null;
            try{
                statuses = twitter.getUserTimeline(username[0]);
            }catch (TwitterException twitterException){
                result = getResources().getString(R.string.twitter_failure);
            }catch (Exception e){
                result = getResources().getString(R.string.genertal_failure);
            }
            for(twitter4j.Status status : statuses){
                result += status.getText();
                result +="\n";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result){
            editTextUsername.setText("");
            textViewTimeline.setText(result);
        }
    }


}