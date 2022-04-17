package ce.iut.chatva;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DoctorItem {

    private String doctor_name;
    private String doctor_adresse;
    private String doctor_tel;
    private String doctor_mail;

    public DoctorItem(String name, String age,String tel, String mail){
        this.doctor_name = name;
        this.doctor_adresse = age;
        this.doctor_tel = tel;
        this.doctor_mail = mail;
    }

    public String getDoctor_name() {return doctor_name;}
    public String getDoctor_adresse() {return doctor_adresse;}
    public String getDoctor_tel() {return doctor_tel;}
    public String getDoctor_mail() {return doctor_mail;}

}
