package com.example.pas_androidstudio_rizqieahmadzh_10rpl2_26;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {
    Bundle bundle;
    String name;
    String nim;
    String nohp;
    String email;
    TextView tvnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        tvnama = (TextView)findViewById(R.id.tvnama);
        bundle = getIntent().getExtras();
        if (bundle != null){
            name = bundle.getString("nama");
            nim = bundle.getString("nim");
            nohp = bundle.getString("hp");
            email = bundle.getString("email");
        }
        tvnama.setText("nama : "+name);
        //misa ada gambar, bisa pakai gambar asset, atau bisa dari internet
        // www.image.jpg -> Glide
    }
}