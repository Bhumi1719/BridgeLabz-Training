import java.util.*;

public class OnlineClassroomApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AttendanceService service = new AttendanceService();

        while(true) {
            System.out.println("\nOnline Classroom Attendance Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Remove Attendance");
            System.out.println("4. Display Session Attendance");
            System.out.println("5. Display All Sessions");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            try {
                switch(choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String studentId = sc.nextLine();

                        service.addStudent(studentId);
                        break;

                    case 2:
                        System.out.print("Enter Session ID: ");
                        String sessionId = sc.nextLine();
                        System.out.print("Enter Student ID: ");
                        String sId = sc.nextLine();

                        service.markAttendance(sessionId, sId);
                        break;

                    case 3:
                        System.out.print("Enter Session ID: ");
                        String removeSession = sc.nextLine();
                        System.out.print("Enter Student ID: ");
                        String removeStudent = sc.nextLine();

                        service.removeAttendance(removeSession, removeStudent);
                        break;

                    case 4:
                        System.out.print("Enter Session ID: ");
                        String displaySession = sc.nextLine();

                        service.displayAttendance(displaySession);
                        break;

                    case 5:
                        service.displayAllSessions();
                        break;

                    case 6:
                        System.out.println("Exited");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (DuplicateAttendanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}