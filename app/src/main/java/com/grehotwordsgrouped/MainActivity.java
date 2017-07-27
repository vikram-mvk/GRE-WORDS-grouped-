package com.grehotwordsgrouped;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClick(View v) {
            Uri uri = Uri.parse("mailto:mail2me.mvk@gmail.com");

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

    public void test(View view) {
        Intent intent = new Intent(this, noun.class);
        intent.putExtra("a",5);
        startActivity(intent);}
    public void startpadj(View view) {
        Intent intent = new Intent(this, noun.class);
        intent.putExtra("a",3);
        startActivity(intent);}
    public void startnadj(View view) {
        Intent intent = new Intent(this, noun.class);
        intent.putExtra("a",4);
        startActivity(intent);}
    public void startverb(View view) {
        Intent intent = new Intent(this, noun.class);
        intent.putExtra("a",2);
        startActivity(intent);}

    public void startnoun(View view) {
        Intent intent = new Intent(this, noun.class);
        intent.putExtra("a",1);
        startActivity(intent);}
}


