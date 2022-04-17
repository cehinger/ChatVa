package ce.iut.chatva;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ProfilItem {

    private String profil_name;
    private String profil_adresse;
    private String profil_tel;
    private String profil_mail;

    public ProfilItem(String name, String adresse,String tel, String mail){
        this.profil_name = name;
        this.profil_adresse = adresse;
        this.profil_tel = tel;
        this.profil_mail = mail;
    }

    public String getProfil_name() {return profil_name;}
    public String getProfil_adresse() {return profil_adresse;}
    public String getProfil_tel() {return profil_tel;}
    public String getProfil_mail() {return profil_mail;}

}
