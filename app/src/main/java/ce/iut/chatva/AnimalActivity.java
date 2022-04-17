package ce.iut.chatva;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AnimalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button add_button;

    DatabaseHelper myDB;
    ArrayList<String> animal_id, animal_name, animal_age, animal_espece, animal_sexe;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Delete Title Bar
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // Delete notification Bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animal);

        recyclerView = findViewById(R.id.animal_recycler_view);
        add_button = findViewById(R.id.update_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimalActivity.this, AddAnimal.class);
                startActivity(intent);
            }
        });


        myDB = new DatabaseHelper(AnimalActivity.this);
        animal_id = new ArrayList<>();
        animal_name = new ArrayList<>();
        animal_age = new ArrayList<>();
        animal_espece = new ArrayList<>();
        animal_sexe = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(AnimalActivity.this, this, animal_id, animal_name, animal_age, animal_espece, animal_sexe);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AnimalActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataAnimal();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Vous n'avez pas de chats", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                animal_id.add(cursor.getString(0));
                animal_name.add(cursor.getString(1));
                animal_age.add(cursor.getString(2));
                animal_espece.add(cursor.getString(3));
                animal_sexe.add(cursor.getString(4));
            }
        }
    }
}