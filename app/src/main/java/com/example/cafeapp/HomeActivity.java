package com.example.cafeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rvMenu;
    private ArrayList<Food> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);

        rvMenu = findViewById(R.id.rv_menu);
        rvMenu.setHasFixedSize(true);

        list.addAll(FoodData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        CardFoodAdapter cardFoodAdapter = new CardFoodAdapter(list);
        rvMenu.setAdapter(cardFoodAdapter);

        cardFoodAdapter.setOnItemClickCallback(new CardFoodAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Food food) {
                String name = food.getName();
                String price = food.getPrice();
                String description = food.getDescription();
                int thumbnail = food.getThumbnail();
                Intent detailIntent = new Intent(HomeActivity.this, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_NAME, name);
                detailIntent.putExtra(DetailActivity.EXTRA_DESC, description);
                detailIntent.putExtra(DetailActivity.EXTRA_PRICE, price);
                detailIntent.putExtra(DetailActivity.EXTRA_THUMBNAIL, thumbnail);
                startActivity(detailIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setAction(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setAction(int selectedAction) {
        if (selectedAction == R.id.btn_logout) {
            Toast.makeText(getApplicationContext(), "Logout Berhasil", Toast.LENGTH_SHORT).show();
            Intent loginIntent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }

}