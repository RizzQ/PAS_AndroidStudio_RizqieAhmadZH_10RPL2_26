package com.example.pas_androidstudio_rizqieahmadzh_10rpl2_26;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SiswaAdapter adapter;
    private ArrayList<Siswa> siswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);

        addData();

        adapter = new SiswaAdapter(siswaArrayList, new SiswaAdapter.Callback() {
            @Override
            public void onClick(int position) {
                Toast.makeText(com.example.pas_androidstudio_rizqieahmadzh_10rpl2_26.MainActivity.this, "click item " + position, Toast.LENGTH_SHORT).show();
                Intent move = new Intent(getApplicationContext(), DescriptionActivity.class);

                Siswa mymahasiswa = siswaArrayList.get(position);
                move.putExtra("nama", mymahasiswa.getNama());
                move.putExtra("jenjang", mymahasiswa.getjenjang());
                move.putExtra("hp", mymahasiswa.getnomor_hp());
                move.putExtra("email", mymahasiswa.getEmail());
                startActivity(move);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(com.example.pas_androidstudio_rizqieahmadzh_10rpl2_26.MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData() {
        siswaArrayList = new ArrayList<>();
        siswaArrayList.add(new Siswa(   "Rizqie Ahmad",     "SMK", "082748375839", "rizqieahmad@outlook.com"));
        siswaArrayList.add(new Siswa(   "Zakaria Hende",    "SMA", "028493847593", "zakariahende@gmail.com"));
        siswaArrayList.add(new Siswa(   "Ichik Ochak",      "SMP", "084581947643", "Ichik@hotmail.com"));
        Siswa ZakAhmad = new Siswa(     "Zakaria Ahmad",    "SMK", "083285493856", "zakariaahmad@yahoo.co.id");
        Siswa Doni = new Siswa(         "Doni Joko",        "SMA", "082038493583", "donijoko@outlook.co.id");
        Siswa Zaki = new Siswa(         "Zaki Ahmad",       "SMP", )
        siswaArrayList.add(ZakAhmad);
        siswaArrayList.add(Doni);
    }
}