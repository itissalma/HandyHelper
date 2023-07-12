package com.mariam.registeration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

class CustomItem {
    private String title;
    private String description;

    public CustomItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title; // or any other desired format
    }
}


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<CustomItem> itemList;
    private ArrayAdapter<CustomItem> adapter;
    private TabLayout tabLayout;
    private FloatingActionButton fabCreatePost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        listView = findViewById(R.id.listView);
        tabLayout = findViewById(R.id.tabLayout);

        // Initialize the itemList
        itemList = new ArrayList<>();

        itemList.add(new CustomItem("Husky Dog Walking", "Description 1"));
        itemList.add(new CustomItem("Water My Plants", "Description 2"));
        itemList.add(new CustomItem("Wash my Cat", "Description 2"));
        itemList.add(new CustomItem("Mow my lawn", "Description 2"));
        itemList.add(new CustomItem("Install my furniture", "Description 2"));


        adapter = new ArrayAdapter<>(this, R.layout.requests_list_item, R.id.titleText, itemList);

        listView.setAdapter(adapter);

        fabCreatePost = findViewById(R.id.fabCreatePost);

        // Set a click listener for the FloatingActionButton
        fabCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostService.class);
                startActivity(intent);
            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                if (position == 1) {
                    // My Applications tab selected
                    Intent intent = new Intent(MainActivity.this, MyApplications.class);

                    // Apply custom transition animations
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(MainActivity.this,
                            android.R.anim.fade_in, android.R.anim.fade_out);
                    startActivity(intent, options.toBundle());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Do nothing
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Do nothing
            }
        });
    }
}
