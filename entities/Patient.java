package source.entities;
public class Patient {
    private String nom;
    private int phone;
    private String number;
    private static int counter;
    private final int size = 1000;
    private int position;
    private final Rdv[] tabRdv = new Rdv[size];
    public Patient(){number = String.format("PAT%04d", ++counter);}
    public String getNom(){return nom;}
    public int getPhone(){return phone;}
    public String getNumber(){return number;}
    public int getCounter(){return counter;}
    public Rdv[] getTabRdv(){return tabRdv;}
    public void setNom(String nom){this.nom = nom;}
    public void setPhone(int phone){this.phone = phone;}
    public void setNumber(String number){this.number = number;}
    @Override
    public String toString(){
        return STR."Patient \{number} : Nom = \{nom} Telephone = \{phone}\n";
    }
    public void addRdv(Rdv rdv){
        if (position < size){
            tabRdv[position++] = rdv;
        }
    }
}
