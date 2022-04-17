package ce.iut.chatva;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class UpdateAnimal extends AppCompatActivity {

    EditText name_input, age_input, espece_input;
    Button update_button, delete_button;
    Switch switch_sexe;

    String id, name, age, espece, sexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_animal);


        name_input = findViewById(R.id.name_input2);
        age_input = findViewById(R.id.age_input2);
        espece_input = findViewById(R.id.espece_input2);
        switch_sexe = findViewById(R.id.switch_sexe);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        // Appel de la fonction en premier
        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();

        // Changer titre de la barre apres getAndSetIntentData()
        if(ab != null){
            ab.setTitle(name);
        }



        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switch_sexe.isChecked()){
                    sexe = "Femelle";
                }
                else{
                    sexe = "Male";
                }
                // Et seulement après création objet db + appel fonction updateData()
                DatabaseHelper myDB = new DatabaseHelper(UpdateAnimal.this);
                myDB.updateDataAnimal(id, name_input.getText().toString(), age_input.getText().toString(), espece_input.getText().toString(), sexe);
                finish();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("nom") &&
                getIntent().hasExtra("age") &&
                getIntent().hasExtra("espece") &&
                getIntent().hasExtra("sexe")){
            // Get data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("nom");
            age = getIntent().getStringExtra("age");
            espece = getIntent().getStringExtra("espece");
            sexe = getIntent().getStringExtra("sexe");

            // Set Intent data
            name_input.setText(name);
            age_input.setText(age);
            espece_input.setText(espece);
        }else{
            Toast.makeText(this, "Pas de données", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Supprimer " + name + " ?");
        builder.setMessage("Êtes vous sur de vouloir supprimer " + name + " de vos chats?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(UpdateAnimal.this);
                myDB.deleteOneRowAnimal(id);
                finish();
            }
        });
        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}