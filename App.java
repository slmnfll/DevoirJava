package source;
import source.entities.Patient;
import source.entities.Rdv;
import source.services.PatientService;
import source.services.RdvService;
import java.util.Scanner;
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        PatientVue patientVue = new PatientVue();
        PatientService patientService = new PatientService();
        RdvVue rdvVue = new RdvVue();
        RdvService rdvService = new RdvService();
        do {
            switch (choice = menu()){
                case 1 -> {
                    if (patientService.savePatient(patientVue.instancePatient(scanner))) {
                        System.out.println("Le patient a bien été ajouté !");
                    } else {
                        System.out.println("Erreur ! Le patient ne peut être ajouté...");
                    }
                }
                case 2 -> patientService.listPatients(patientService.getTabPatient());
                case 3 -> {
                    Patient patient1 = patientService.findPatient(patientVue.askPhoneNumber(scanner), patientService.getTabPatient());
                    if ( patient1 == null){
                        System.out.println("Erreur ! Patient introuvable...");
                    } else {
                        Rdv rendezVous = rdvVue.instanceRdv(scanner);
                        if (rdvService.saveRdv(rendezVous)) {
                            System.out.println("Le rendez-vous a bien été enregistré !");
                            patient1.addRdv(rendezVous);
                            rendezVous.addPatient(patient1);
                        } else {
                            System.out.println("Erreur ! Le rendez-vous ne peut être enregistré...");
                        }
                    }
                }
                case 4 -> rdvService.listRdvs();
                case 5 -> rdvService.listRdvs(rdvVue.state(scanner));
                case 6 -> rdvService.listRdvs(rdvVue.specialisation(scanner));
                case 7 -> {
                    Patient patient1 = patientService.findPatient(patientVue.askPhoneNumber(scanner), patientService.getTabPatient());
                    if ( patient1 == null){
                        System.out.println("Erreur ! Patient introuvable...");
                    } else {
                        Rdv rendezVous1 = rdvVue.findRdv(rdvVue.askId(scanner), patient1.getTabRdv());
                        if (rendezVous1 == null) {
                            System.out.println("Erreur ! Rendez-vous introuvable...");
                        } else {
                            if (rdvService.treadRdv(patient1.getTabRdv()[rendezVous1.getId() - 1])) {
                                System.out.println("Rendez-vous validé !");
                            } else {
                                System.out.println("Erreur, le rendez-vous est soit annulé, soit déjà validé...");
                            }
                        }
                    }
                }
            }
        } while (choice != 8);

    }
    public static int menu() {
        System.out.println("1- Enregistrer un patient");
        System.out.println("2- Lister tous les patients");
        System.out.println("3- Enregistrer un rendez-vous");
        System.out.println("4- Lister tous les rendez-vous");
        System.out.println("5- Lister les rendez-vous par êtat");
        System.out.println("6- Lister les rendez-vous par spécialité");
        System.out.println("7- Traiter un rendez-vous");
        System.out.println("8- Quitter");
        return scanner.nextInt();
    }
}
