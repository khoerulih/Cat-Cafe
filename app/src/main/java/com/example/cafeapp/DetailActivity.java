package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESC = "extra_desc";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_THUMBNAIL = "extra_thumbnail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String description = getIntent().getStringExtra(EXTRA_DESC);
        String price = getIntent().getStringExtra(EXTRA_PRICE);
        int thumbnail = getIntent().getIntExtra(EXTRA_THUMBNAIL, 0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(name);

        TextView tvDetailName = findViewById(R.id.tv_detail_name);
        TextView tvDetailDesc = findViewById(R.id.tv_detail_description);
        TextView tvDetailPrice = findViewById(R.id.tv_detail_price);
        ImageView imageDetailThumbnail = findViewById(R.id.image_detail_thumbnail);

        tvDetailName.setText(name);
        tvDetailDesc.setText(description);
        tvDetailPrice.setText(price);

        Glide.with(this)
                .load(thumbnail)
                .into(imageDetailThumbnail);

    }
}