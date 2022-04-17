package ce.iut.chatva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Delete Title Bar
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // Delete notification Bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Bottom nav
        BottomNavigationView btnNav = findViewById(R.id.bottomNavigation);
        btnNav.setOnNavigationItemSelectedListener(navListener);
    }

    // Listener Nav Bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {

                        case R.id.item2:
                            openProfilActivity();
                            break;

                        case R.id.item3:
                            openActivityAnimal();
                            break;

                        case R.id.item4:
                            openActivityDoctor();
                            break;
                    }
                    return true;

                }
            };
    public void openProfilActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openActivityAnimal(){
        Intent intent = new Intent(this, AnimalActivity.class);
        startActivity(intent);
    }
    public void openActivityDoctor(){
        Intent intent = new Intent(this, DoctorActivity.class);
        startActivity(intent);
    }
}