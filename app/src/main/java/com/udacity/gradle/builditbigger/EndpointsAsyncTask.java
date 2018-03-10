package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.jokedisplaylib.JokeDisplayActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Denis on 04/03/2018.
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private static final String JOKE_TEXT = "JOKE_TEXT";
    private static MyApi myApiService = null;
    private Context mContext;

    @Override
    protected String doInBackground(Context... contexts) {

        // options for running against local devappserver
        // - 10.0.2.2 is localhost's IP address in Android emulator
        // - turn off compression when running against local devappserver

        mContext = contexts[0];

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String jokeToDisplay) {

        //if the joke string starts with failed to connect, then the connnection with server was unsuccessful
        if(jokeToDisplay.toLowerCase().startsWith("failed to connect")) {
            Toast.makeText(mContext, mContext.getString(R.string.server_unreachable), Toast.LENGTH_LONG).show();

            //hide the Progress Bar
            View rootView = ((Activity) mContext).getWindow().getDecorView().findViewById(android.R.id.content);
            ProgressBar progressBar = rootView.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.INVISIBLE);
        } else {
            super.onPostExecute(jokeToDisplay);
            Intent intent = new Intent(mContext, JokeDisplayActivity.class);
            intent.putExtra(JOKE_TEXT, jokeToDisplay);
            mContext.startActivity(intent);
        }
    }
}
