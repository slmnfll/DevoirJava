package source.services;
import source.entities.Patient;
public class PatientService {
    private final int size = 1000;
    private int position;
    private final Patient[] tabPatient = new Patient[size];
    public Patient[] getTabPatient(){
        return tabPatient;
    }
    public boolean savePatient(Patient patient){
        if (position < size && findPatient(patient.getPhone(),tabPatient) == null) {
            tabPatient[position++] = patient;
            return true;
        }
        return false;
    }
    public Patient findPatient(int phone, Patient[] tabPatient){
        for (Patient patient : tabPatient) {
            if (patient != null && patient.getPhone() == phone) {
                return patient;
            }
        }
        return null;
    }
    public void listPatients(Patient[] tabPatient){
        for (Patient patient : tabPatient) {
            if (patient != null) {
                System.out.println(patient);
            }
        }
    }
}
