package ce.iut.chatva;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class AnimalItem {

    private String animal_name;
    private String animal_age;
    private String animal_espece;
    private String animal_sexe;

    public AnimalItem(String name, String age, String espece, String sexe){
        this.animal_name = name;
        this.animal_age = age;
        this.animal_espece = espece;
        this.animal_sexe = sexe;
    }

    public String getAnimal_name() {return animal_name;}
    public String getAnimal_age() {return animal_age;}
    public String getAnimal_espece() {return animal_espece;}
    public String getAnimal_sexe() {return animal_sexe;}

}
