package ce.iut.chatva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "ChatVaLibrary.db";
    private static final int DATABASE_VERSION = 1;

    // Table pour les chats
    private static final String TABLE_NAME = "animals";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_ESPECE = "espece";
    private static final String COLUMN_SEXE = "sexe";

    // Table pour les vétérinaires
    private static final String TABLE_NAME_DOCTOR = "doctor";
    private static final String COLUMN_ID_DOCTOR = "_idDoctor";
    private static final String COLUMN_NAME_DOCTOR = "nameDoctor";
    private static final String COLUMN_ADRESSE_DOCTOR = "adresseDoctor";
    private static final String COLUMN_TEL_DOCTOR = "telDoctor";
    private static final String COLUMN_MAIL_DOCTOR = "mailDoctor";

    // Table pour les profils
    private static final String TABLE_NAME_PROFIL = "profil";
    private static final String COLUMN_ID_PROFIL = "_idProfil";
    private static final String COLUMN_NAME_PROFIL = "name_Profil";
    private static final String COLUMN_ADRESSE_PROFIL = "adresseProfil";
    private static final String COLUMN_TEL_PROFIL = "telProfil";
    private static final String COLUMN_MAIL_PROFIL = "mailProfil";


    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Création query animal
        String queryAnimal = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_AGE + " INTEGER, "
                + COLUMN_ESPECE + " TEXT, " + COLUMN_SEXE + " TEXT);";

        // Création query doctor
        String queryDoctor = "CREATE TABLE " + TABLE_NAME_DOCTOR + " (" + COLUMN_ID_DOCTOR + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME_DOCTOR + " TEXT, " + COLUMN_ADRESSE_DOCTOR + " TEXT, "
                + COLUMN_TEL_DOCTOR + " TEXT, " + COLUMN_MAIL_DOCTOR + " TEXT);";

        //Création query profil
        String queryProfil = "CREATE TABLE " + TABLE_NAME_PROFIL + " (" + COLUMN_ID_PROFIL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME_PROFIL + " TEXT, " + COLUMN_ADRESSE_PROFIL + " TEXT, "
                + COLUMN_TEL_PROFIL + " TEXT, " + COLUMN_MAIL_PROFIL + " TEXT);";

        // Création Table Animal
        db.execSQL(queryAnimal);
        // Création Table Doctor
        db.execSQL(queryDoctor);
        // Création Table Profil
        db.execSQL(queryProfil);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DOCTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PROFIL);
        onCreate(db);
    }

    void addAnimal(String name, int age, String espece, String sexe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_AGE,age);
        cv.put(COLUMN_ESPECE,espece);
        cv.put(COLUMN_SEXE,sexe);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "L'ajout de votre chat a échoué.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Votre chat a été ajouté.", Toast.LENGTH_SHORT).show();
        }
    }

    void addDoctor(String name, String adresse, String tel, String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME_DOCTOR, name);
        cv.put(COLUMN_ADRESSE_DOCTOR, adresse);
        cv.put(COLUMN_TEL_DOCTOR, tel);
        cv.put(COLUMN_MAIL_DOCTOR,mail);

        long result = db.insert(TABLE_NAME_DOCTOR,null,cv);
        if(result == -1){
            Toast.makeText(context, "L'ajout de votre vétérinaire a échoué.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Votre vétérinaire a été ajouté.", Toast.LENGTH_SHORT).show();
        }
    }

    void addProfil(String name, String adresse, String tel, String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME_PROFIL,name);
        cv.put(COLUMN_ADRESSE_PROFIL, adresse);
        cv.put(COLUMN_TEL_PROFIL, tel);
        cv.put(COLUMN_MAIL_PROFIL, mail);

        long result = db.insert(TABLE_NAME_PROFIL, null, cv);
        if(result == -1){
            Toast.makeText(context, "L'ajout de votre profil a échoué.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Votre profil a été ajouté.", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllDataAnimal(){
        String query = "Select * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    Cursor readAllDataDoctor(){
        String query = "Select * FROM "+TABLE_NAME_DOCTOR;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    Cursor readAllDataProfil(){
        String query = "Select * FROM "+TABLE_NAME_PROFIL;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    void updateDataAnimal(String row_id, String name, String age, String espece, String sexe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_ESPECE, espece);
        cv.put(COLUMN_SEXE, sexe);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Echec de la mise à jour des informations de votre chat.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Les informations du chat ont étés mises à jours!", Toast.LENGTH_SHORT).show();
        }
    }

    void updateDataDoctor(String row_id, String name, String adresse, String tel, String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME_DOCTOR, name);
        cv.put(COLUMN_ADRESSE_DOCTOR, adresse);
        cv.put(COLUMN_TEL_DOCTOR, tel);
        cv.put(COLUMN_MAIL_DOCTOR,mail);

        long result = db.update(TABLE_NAME_DOCTOR, cv, "_idDoctor=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Echec de la mise à jour des informations de votre vétérinaire.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Les informations de votre vétérinaire ont étés mises à jour!", Toast.LENGTH_SHORT).show();
        }
    }

    void updateDataProfil(String row_id, String name, String adresse, String tel, String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME_PROFIL, name);
        cv.put(COLUMN_ADRESSE_PROFIL, adresse);
        cv.put(COLUMN_TEL_PROFIL, tel);
        cv.put(COLUMN_MAIL_PROFIL, mail);

        long result = db.update(TABLE_NAME_PROFIL, cv, "_idProfil=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Echec de la mise à jour des informations devotre profil.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Les informations de votre profil ont étés mises à jour!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRowAnimal(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[] {row_id});
        if(result == -1){
            Toast.makeText(context, "Impossible de supprimer le chat.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Chat supprimé.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRowDoctor(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_DOCTOR, "_idDoctor=?", new String[] {row_id});
        if(result == -1){
            Toast.makeText(context, "Impossible de supprimer le vétérinaire.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Vétérinaire supprimé.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRowProfil(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_PROFIL, "_idProfil=?", new String[] {row_id});
        if(result == -1){
            Toast.makeText(context, "Impossible de supprimer le profil.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Profil supprimé.", Toast.LENGTH_SHORT).show();
        }
    }
}
