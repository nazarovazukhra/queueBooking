import jdbc.DatabaseManager;
import model.Appointment;
import model.Patient;
import model.TimeLine;

import java.time.LocalDateTime;

import java.util.Scanner;

import static jdbc.DatabaseManager.timeLine;
import static jdbc.DatabaseManager.timeLineList;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Continue -> 1   Exit -> 0");
        int want = scanner.nextInt();
        while (want == 1) {
            guideLine();
            System.out.println("Choose option ");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1: {
                    patientMethod();
                    break;
                }
                case 2: {
                    doctorMethod();
                    break;
                }
                default: {
                    System.out.println("Choose right option");
                }
            }


            System.out.println("Continue -> 1   Exit -> 0");
            want = scanner.nextInt();
        }


    }

    private static void doctorMethod() {
        //code
    }

    public static void patientMethod() {
        System.out.println("1.Make an appointment");
        System.out.println("2.Show my appointment");
        Scanner scanner2 = new Scanner(System.in);
        int patientOp = scanner2.nextInt();
        switch (patientOp) {
            case 1: {
                // make an apt
                makeAnAppointment();
                break;
            }
            case 2: {
                //show my apt
                break;
            }
            default: {
                System.out.println("Choose right option");
            }
        }

    }

    public static void makeAnAppointment() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Firstname  : ");
        String firstname = scanner3.next();
        System.out.print("Lastname  : ");
        String lastname = scanner3.next();
        System.out.print("Phone  : ");
        String phone = scanner3.next();
        System.out.print("Address  : ");
        String address = scanner3.next();
        Patient patient = new Patient(firstname, lastname, phone, address);
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.enterPatientInfo(patient);
        databaseManager.showDoctors(); //-----> get doctor's name there
        System.out.print("Choose doctor  : ");
        Scanner scanner4 = new Scanner(System.in);
        int doctor = scanner4.nextInt();
        databaseManager.showTimeLine(doctor);
        System.out.print("Choose time  : ");
        int choosenTime = scanner4.nextInt();

        int patieId = databaseManager.getPatientId(firstname, lastname); // patientId
        String doc = databaseManager.infoGettingFromDoctors(doctor);
        int docId = databaseManager.getDoctorId(doc);
        System.out.println("Doctor id : " + docId);
        int timeLineId = databaseManager.getTimeLineId(choosenTime);
        System.out.println("TimiLine id : " + timeLineId);
        LocalDateTime localDateTime = LocalDateTime.now();
        Appointment appointment = new Appointment(patieId, docId, localDateTime, timeLineList);
        System.out.println(appointment.getPatientId());
        System.out.println(appointment.getDoctorId());
        System.out.println(appointment.getCreatedAt());
        for (int i = 0; i < timeLineList.size(); i++) {
            if (timeLineList.get(i).getId() == choosenTime) {
                System.out.println(timeLineList.get(i).getStartTime());
                System.out.println(timeLineList.get(i).getEndTime());
                System.out.println(timeLineList.get(i).getStatus());
                System.out.println(timeLineList.get(i).getDate());
            }
        }
    }


    public static void guideLine() {
        System.out.println("1.Patient");
        System.out.println("2.Doctor");
    }
}
