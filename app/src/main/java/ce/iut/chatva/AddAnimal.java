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

public class AddAnimal extends AppCompatActivity {

    EditText name_input, age_input, espece_input;
    Switch switch_sexe;
    String sexe;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        name_input = findViewById(R.id.name_input);
        age_input = findViewById(R.id.age_input);
        espece_input = findViewById(R.id.espece_input);
        switch_sexe = findViewById(R.id.switch_sexe);
        add_button = findViewById(R.id.add_button);

        if(switch_sexe.isChecked()){
            String sexe = "Femelle";
        }
        else{
            String sexe = "Male";
        }

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switch_sexe.isChecked()){
                    sexe = "Femelle";
                }
                else{
                    sexe = "Male";
                }
                DatabaseHelper myDB = new DatabaseHelper(AddAnimal.this);
                myDB.addAnimal(name_input.getText().toString(), Integer.valueOf(age_input.getText().toString().trim()), espece_input.getText().toString(), sexe);
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