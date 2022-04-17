package ce.iut.chatva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private static String LOG_TAG = "UIElementsPracticeLog";
    private EditText nameet;
    private EditText adresset;
    private EditText phoneet;
    private EditText mailet;

    private TextView nametv;
    private TextView adresstv;
    private TextView phonetv;
    private TextView mailtv;

    private View view;

    List<HoomanItem> hoomanItems = new ArrayList<>();

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Delete Title Bar
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // Delete notification Bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor);

        // Spinner
        spinner = (Spinner) findViewById(R.id.spinner_choice);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hoomanItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
/*
        // Edit Text

        // TextView
        nametv = (TextView) findViewById(R.id.doctor_name_tv);
        adresstv = (TextView) findViewById(R.id.doctor_adress_tv);
        phonetv = (TextView) findViewById(R.id.doctor_phone_tv);
        mailtv = (TextView) findViewById(R.id.doctor_mail_tv);


 */

        HoomanItem hoomanItem1 = new HoomanItem("nom", "adresse", "tel", "e-miel", hoomanItems.size());
        hoomanItems.add(hoomanItem1);

        HoomanItem hoomanItem2 = new HoomanItem("Prout", "adresse", "tel", "e-miel", hoomanItems.size());
        hoomanItems.add(hoomanItem2);

        hoomanItem1.setHoomanName("Billy");
        hoomanItem1.setHoomanAdress("2 xxxxx xxx xxxx, 21000 Dijon");
        hoomanItem1.setHoomanPhone("0618283444");
        hoomanItem1.setHoomanMail("billytheveterinaire@gmail.com");

    }

    public void newDoctor(View view){

        nameet = (EditText) findViewById(R.id.doctor_name);
        adresset = (EditText) findViewById(R.id.doctor_adress);
        phoneet = (EditText) findViewById(R.id.doctor_phone);
        mailet = (EditText) findViewById(R.id.doctor_mail);


        if(nameet.getText().toString().isEmpty() || adresset.getText().toString().isEmpty() || phoneet.getText().toString().isEmpty() || mailet.getText().toString().isEmpty()) {
            Toast.makeText(this,"Vous devez remplir tous les champs", Toast.LENGTH_LONG ).show();
        }
        else {
            HoomanItem newHooman = new HoomanItem(nameet.getText().toString(), adresset.getText().toString(), phoneet.getText().toString(), mailet.getText().toString(), hoomanItems.size());
            hoomanItems.add(newHooman);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(LOG_TAG, "In saved instance state");

        nameet = (EditText) findViewById(R.id.doctor_name);
        adresset = (EditText) findViewById(R.id.doctor_adress);
        phoneet = (EditText) findViewById(R.id.doctor_phone);
        mailet = (EditText) findViewById(R.id.doctor_mail);

        CharSequence writtenDataName = nameet.getText();
        CharSequence writtenDataAdress = adresset.getText();
        CharSequence writtenDataPhone = phoneet.getText();
        CharSequence writtenDataMail = mailet.getText();


            outState.putCharSequence("SavedDataName", writtenDataName);
            outState.putCharSequence("SavedDataAdress", writtenDataAdress);
            outState.putCharSequence("SavedDataPhone", writtenDataPhone);
            outState.putCharSequence("SavedDataMail", writtenDataMail);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(LOG_TAG, "In restore instance state");

        CharSequence storedDataName = savedInstanceState.getCharSequence("SavedDataName");
        CharSequence storedDataAdress = savedInstanceState.getCharSequence("SavedDataAdress");
        CharSequence storedDataPhone = savedInstanceState.getCharSequence("SavedDataPhone");
        CharSequence storedDataMail = savedInstanceState.getCharSequence("SavedDataMail");
        nameet = (EditText) findViewById(R.id.doctor_name);
        adresset = (EditText) findViewById(R.id.doctor_adress);
        phoneet = (EditText) findViewById(R.id.doctor_phone);
        mailet = (EditText) findViewById(R.id.doctor_mail);

        nameet.setText(storedDataName);
        adresset.setText(storedDataAdress);
        phoneet.setText(storedDataPhone);
        mailet.setText(storedDataMail);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        Toast.makeText(this,"test", Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}