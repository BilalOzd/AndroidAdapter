package com.zahidgurbuz.week07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.zahidgurbuz.week07.adapters.HairModelAdapter;
import com.zahidgurbuz.week07.services.HairModelService;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_UI();

    }

    private void init_UI() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        HairModelAdapter adapter = new HairModelAdapter(HairModelService.getItems(), this);
        rv.setAdapter(adapter);
    }
}