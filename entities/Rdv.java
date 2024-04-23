package source.entities;
import source.enums.Etat;
import source.enums.Specialite;
public class Rdv {
    private int id;
    private static int nbrRdv;
    private String date;
    private String time;
    private String reason;
    private Patient patient;
    private Etat state;
    private Specialite speciality;
    public Rdv(){
        id = ++nbrRdv;
        state = Etat.ENCOURS;
    }
    public int getId(){return id;}
    public int getNbrRdv(){return nbrRdv;}
    public String getDate(){return date;}
    public String getTime(){return time;}
    public String getReason(){return reason;}
    public Patient getPatient(){return patient;}
    public Etat getState(){return state;}
    public Specialite getSpeciality(){return speciality;}
    public void setId(int id){this.id = id;}
    public void setDate(String date){this.date = date;}
    public void setTime(String time){this.time = time;}
    public void setReason(String reason){this.reason = reason;}
    public void addPatient(Patient patient){this.patient = patient;}
    public void setState(Etat state){this.state = state;}
    public void setSpeciality(Specialite speciality){this.speciality = speciality;}
    @Override
    public String toString(){
        return STR."Rdv \{id} : \nDate = \{date} \nHeure = \{time} \nMotif = \{reason} \nSpecialisation = \{speciality} \nÉtat = \{state}";
    }
}