package com.example.dinesh.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView downloadImg;

    //https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png
    //https://images-na.ssl-images-amazon.com/images/I/51fuV-tnKZL.jpg
    public void downloadImage(View view){

        ImageDownloader task = new ImageDownloader();
        Bitmap myimage ;
        try {
            myimage = task.execute("//https://images-na.ssl-images-amazon.com/images/I/51fuV-tnKZL.jpg").get();
            downloadImg.setImageBitmap(myimage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadImg = (ImageView) findViewById(R.id.imageview);
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{


        @Override
        protected Bitmap doInBackground(String... urls) {

            try {

                URL url = new URL(urls[0]);
                HttpURLConnection Connection = (HttpURLConnection) url.openConnection();
                Connection.connect();
                InputStream inputstream = Connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputstream);
                 return myBitmap;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
