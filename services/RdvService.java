package source.services;
import source.entities.Rdv;
import source.enums.Etat;
import source.enums.Specialite;
public class RdvService {
    private final int size = 1000;
    private int position;
    private final Rdv[] tabRdv = new Rdv[size];
    public Rdv[] getTabRdv(){
        return tabRdv;
    }
    public boolean saveRdv(Rdv rdv){
        if (position < size) {
            tabRdv[position++] = rdv;
            return true;
        }
        return false;
    }
    public void listRdvs(){
        for (Rdv rdv : tabRdv) {
            if (rdv != null) {
                System.out.println(rdv);
            }
        }
    }
    public void listRdvs(Etat etat){
        for (Rdv rdv : tabRdv) {
            if (rdv != null && rdv.getState() == etat) {
                System.out.println(rdv);
            }
        }
    }
    public void listRdvs(Specialite speciality){
        for (Rdv rdv : tabRdv) {
            if (rdv != null && rdv.getSpeciality() == speciality) {
                System.out.println(rdv);
            }
        }
    }
    public boolean treadRdv(Rdv rdv){
        if (rdv.getState() == Etat.ENCOURS){
            rdv.setState(Etat.VALIDE);
            return true;
        }
        return false;
    }
}