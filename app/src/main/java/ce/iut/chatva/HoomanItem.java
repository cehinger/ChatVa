package ce.iut.chatva;

public class HoomanItem {

    private String name;
    private String adress;
    private String phone;
    private String mail;
    private int id = 1;

    public HoomanItem(String name, String adress, String phone, String mail, int n){
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.id = n+1;
    }

    public String getHoomanName(){return name;}
    public String getHoomanAdress(){return adress;}
    public String getHoomanPhone(){return phone;}
    public String getHoomanMail(){return mail;}

    public void setHoomanName(String setname){this.name = setname;}
    public void setHoomanAdress(String setadress){this.adress = setadress;}
    public void setHoomanPhone(String setphone){this.phone = setphone;}
    public void setHoomanMail(String setmail){this.mail = setmail;}

    @Override
    public String toString() {
        return id +" "+ name;
    }
}
