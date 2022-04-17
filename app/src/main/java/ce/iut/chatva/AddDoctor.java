package ce.iut.chatva;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddDoctor extends AppCompatActivity {

    EditText name_input, adresse_input, tel_input,mail_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        name_input = findViewById(R.id.name_input);
        adresse_input = findViewById(R.id.adresse_input);
        tel_input = findViewById(R.id.tel_input);
        mail_input = findViewById(R.id.mail_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(AddDoctor.this);
                myDB.addDoctor(name_input.getText().toString(), adresse_input.getText().toString(), tel_input.getText().toString(), mail_input.getText().toString());
                finish();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
}