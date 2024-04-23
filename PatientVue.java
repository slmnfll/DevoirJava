package source;
import source.entities.Patient;
import java.util.Scanner;

public class PatientVue {
    public Patient instancePatient(Scanner scanner){
        Patient patient = new Patient();
        scanner.nextLine();
        System.out.println("-> Nom du patient :");
        patient.setNom(scanner.nextLine());
        System.out.println("Numéro de téléphone client :");
        patient.setPhone(scanner.nextInt());
        return patient;
    }
    public int askPhoneNumber(Scanner scanner){
        System.out.println("-> Numéro de téléphone du patient");
        return scanner.nextInt();
    }
}