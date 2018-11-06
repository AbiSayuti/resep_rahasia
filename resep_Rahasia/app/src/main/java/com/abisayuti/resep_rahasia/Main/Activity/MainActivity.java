package com.abisayuti.resep_rahasia.Main.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.abisayuti.resep_rahasia.Main.adapter.MainAdapter;
import com.abisayuti.resep_rahasia.Main.Activity.model.RecipesItem;
import com.abisayuti.resep_rahasia.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.RCV)
    RecyclerView RCV;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter();
        onAttachView();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSucces(List<RecipesItem> data) {

        RCV.setLayoutManager(new LinearLayoutManager(this));
        RCV.setAdapter(new MainAdapter(MainActivity.this, data));
    }

    @Override
    public void onAttachView() {
        //  TODO 1. minta data ke presenter
        mainPresenter.onAttach(this);
        mainPresenter.getData();
    }

    @Override
    public void onDettachView() {

    }
}
