package com.mariam.registeration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyApplications extends AppCompatActivity {
    private TabLayout tabLayout;
    private ListView listView;

    // App class declaration
    public class App {
        private String name;
        private String category;
        private int iconResId;
        private int Rejected;

        public App(String name, String category, int iconResId, int Rejected) {
            this.name = name;
            this.category = category;
            this.iconResId = iconResId;
            this.Rejected = Rejected;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public int getIconResId() {
            return iconResId;
        }
        public int getRejected() {
            return Rejected;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications);

        // Find the TabLayout by its ID
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                if (position == 0) {
                    // My Requests tab selected
                    Intent intent = new Intent(MyApplications.this, MainActivity.class);

                    // Apply custom transition animations
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(MyApplications.this,
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

        TabLayout.Tab myApplicationsTab = tabLayout.getTabAt(1);
        if (myApplicationsTab != null) {
            myApplicationsTab.select();
        }

        // Create a sample list of apps (replace with your actual data)
        List<App> appsList = new ArrayList<>();
        appsList.add(new App("Pet Care", "Walk my dog for 20 mins", R.drawable.person, R.drawable.rejected));
        appsList.add(new App("Installation", "Change 4 lightbulbs", R.drawable.person, R.drawable.pending));
        appsList.add(new App("Installation", "Mow my Lawn", R.drawable.person, R.drawable.accepted));

        // Initialize the ListView
        listView = findViewById(R.id.listView);

        // Create and set the adapter
        ArrayAdapter<App> adapter = new ArrayAdapter<App>(this, R.layout.apps_list_item, R.id.title, appsList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ViewHolder viewHolder;

                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    viewHolder.iconImageView = view.findViewById(R.id.userImage);
                    viewHolder.nameTextView = view.findViewById(R.id.title);
                    viewHolder.categoryTextView = view.findViewById(R.id.desc);
                    viewHolder.rejectedIconImageView = view.findViewById(R.id.rejectedIcon);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }

                App app = getItem(position);

                if (app != null) {
                    viewHolder.iconImageView.setImageResource(app.getIconResId());
                    viewHolder.nameTextView.setText(app.getName());
                    viewHolder.categoryTextView.setText(app.getCategory());
                    viewHolder.rejectedIconImageView.setImageResource(app.getRejected());

                    // Set rejectedIcon visibility based on the value of Rejected
                    if (app.getRejected() == R.drawable.rejected) {
                        viewHolder.rejectedIconImageView.setVisibility(View.VISIBLE);
                    } else {
                        viewHolder.rejectedIconImageView.setVisibility(View.VISIBLE);
                    }
                }

                return view;
            }

        };

        listView.setAdapter(adapter);
    }

    private static class ViewHolder {
        ImageView iconImageView;
        TextView nameTextView;
        TextView categoryTextView;
        ImageView rejectedIconImageView;
    }
}


