package com.example.final_project.Tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.final_project.R;
import com.example.final_project.Tab.Fragments.AddEventFrag;
import com.example.final_project.Tab.Fragments.ChatFrag;
import com.example.final_project.Tab.Fragments.MainPageFrag;
import com.example.final_project.Tab.Fragments.ProfileFrag;
import com.example.final_project.Tab.Fragments.SearchPageFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TabLayoutController extends AppCompatActivity {

    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_controller);
        navigationView = findViewById(R.id.bottom_navigation);
        loadFragment(new MainPageFrag());
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        loadFragment(new MainPageFrag());
                        break;
                    case R.id.page_2:
                        loadFragment(new SearchPageFrag());
                        break;
                    case R.id.page_3:
                        loadFragment(new AddEventFrag());
                        break;
                    case R.id.page_4:
                        loadFragment(new ChatFrag());
                        break;
                    case R.id.page_5:
                        loadFragment(new ProfileFrag());
                        break;
                }
                return true;

            }
        });
    }



    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TabLayoutController.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
        //Toast.makeText(TabLayoutController.this,"There is no back action",Toast.LENGTH_LONG).show();
    }

}