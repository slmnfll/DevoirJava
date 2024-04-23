package source;
import source.entities.Patient;
import source.entities.Rdv;
import source.enums.Etat;
import source.enums.Specialite;
import java.util.Scanner;
public class RdvVue {
    public Rdv instanceRdv(Scanner scanner){
        Rdv rdv = new Rdv();
        scanner.nextLine();
        System.out.println("-> Date du rendez-vous :");
        rdv.setDate(scanner.nextLine());
        System.out.println("-> Heure du rendez-vous :");
        rdv.setTime(scanner.nextLine());
        System.out.println("-> Motif du rendez-vous :");
        rdv.setReason(scanner.next());
        rdv.setSpeciality(specialisation(scanner));
        return rdv;
    }
    public Specialite specialisation(Scanner scanner){
        int choice;
        do {
            System.out.println("-> Spécialité du rendez-vous :");
            System.out.println("1- Cardiologue");
            System.out.println("2- Ophtalmologue");
            System.out.println("3- Urologue");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3);
        return Specialite.values()[choice - 1];
    }
    public Etat state(Scanner scanner){
        int choice;
        do {
            System.out.println("-> État du rendez-vous :");
            System.out.println("1- Validé");
            System.out.println("2- En cours");
            System.out.println("3- Annulé");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3);
        return Etat.values()[choice - 1];
    }
    public Rdv findRdv(int id, Rdv[] tabRdv){
        for (Rdv rdv : tabRdv) {
            if (rdv != null && rdv.getId() == id) {
                return rdv;
            }
        }
        return null;
    }
    public int askId(Scanner scanner){
        System.out.println("-> ID du rendez-vous");
        return scanner.nextInt();
    }
}