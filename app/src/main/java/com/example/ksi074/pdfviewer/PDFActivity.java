package com.example.ksi074.pdfviewer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PDFActivity extends AppCompatActivity {
    StringBuffer response = new StringBuffer();
    PDFView pdfView;
    Object x = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pdf);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        TextView toolbar_title_pdf = (TextView) findViewById(R.id.toolbar_title_pdf);
        ImageButton btnClose = (ImageButton) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Bundle extras = getIntent().getExtras();
        String location = "";
        String title = "";
        if (extras != null) {
            location = extras.getString("location");
            title = extras.getString("title");
        }

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/DBOzoneX-Medium.ttf");
        toolbar_title_pdf.setTypeface(custom_font);
        toolbar_title_pdf.setText(title);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        Log.d("Files", "location: " + location);
        File directory = new File(location);
        pdfView.fromFile(directory).load();

    }


}



