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

public class UpdateDoctor extends AppCompatActivity {

    EditText name_input, adresse_input, tel_input, mail_input;
    Button update_button, delete_button;

    String id, name, adresse, tel, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_doctor);


        name_input = findViewById(R.id.name_input2);
        adresse_input = findViewById(R.id.adresse_input2);
        tel_input = findViewById(R.id.tel_input2);
        mail_input = findViewById(R.id.mail_input2);
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
                // Et seulement après création objet db + appel fonction updateData()
                DatabaseHelper myDB = new DatabaseHelper(UpdateDoctor.this);
                myDB.updateDataDoctor(id, name_input.getText().toString(), adresse_input.getText().toString(), tel_input.getText().toString(), mail_input.getText().toString());
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
                getIntent().hasExtra("adresse") &&
                getIntent().hasExtra("tel") &&
                getIntent().hasExtra("mail")){
            // Get data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("nom");
            adresse = getIntent().getStringExtra("adresse");
            tel = getIntent().getStringExtra("tel");
            mail = getIntent().getStringExtra("mail");

            // Set Intent data
            name_input.setText(name);
            adresse_input.setText(adresse);
            tel_input.setText(tel);
            mail_input.setText(mail);
        }else{
            Toast.makeText(this, "Pas de données", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Supprimer " + name + " ?");
        builder.setMessage("Êtes vous sur de vouloir supprimer " + name + " de vos vétérinaires?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(UpdateDoctor.this);
                myDB.deleteOneRowDoctor(id);
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