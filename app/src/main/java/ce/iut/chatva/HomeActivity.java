package ce.iut.chatva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

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

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Delete Title Bar
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // Delete notification Bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);


        final EditText name = findViewById(R.id.profile_name);
        EditText adress = findViewById(R.id.profile_adress);
        EditText phone = findViewById(R.id.profile_phone);
        EditText mail = findViewById(R.id.profile_phone);


        Button validateButton = findViewById(R.id.update_button);

        validateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nameSaved = name.getText().toString().trim();
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
                pref.edit().putString("NAME", nameSaved).apply();
                String sname = pref.getString("NAME", "");
                name.setText(sname);
            }
        });
    }
}