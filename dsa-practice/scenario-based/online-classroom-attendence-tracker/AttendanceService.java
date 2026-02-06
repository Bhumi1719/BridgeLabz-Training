import java.util.*;

public class AttendanceService {

    private Set<String> students = new HashSet<>();
    private Map<String, Set<String>> attendanceMap = new HashMap<>();

    // Method to add Student
    public void addStudent(String studentId) {
        if(students.add(studentId)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student already exists.");
        }
    }

    // Method to mark Attendance
    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {

        if(!students.contains(studentId)) {
            System.out.println("Student not registered!");
            return;
        }

        attendanceMap.putIfAbsent(sessionId, new HashSet<>());
        Set<String> sessionAttendance = attendanceMap.get(sessionId);

        if(!sessionAttendance.add(studentId)) {
            throw new DuplicateAttendanceException("Attendance already marked for this session!");
        }

        System.out.println("Attendance marked successfully.");
    }

    // Method to remove Attendance
    public void removeAttendance(String sessionId, String studentId) {

        if(!attendanceMap.containsKey(sessionId)) {
            System.out.println("Session not found.");
            return;
        }

        Set<String> sessionAttendance = attendanceMap.get(sessionId);

        if(sessionAttendance.remove(studentId)) {
            System.out.println("Attendance removed.");
        } else {
            System.out.println("Student was not marked present.");
        }
    }

    // Method to display Attendance
    public void displayAttendance(String sessionId) {

        if(!attendanceMap.containsKey(sessionId)) {
            System.out.println("Session not found.");
            return;
        }

        Set<String> sessionAttendance = attendanceMap.get(sessionId);

        if(sessionAttendance.isEmpty()) {
            System.out.println("No students attended this session.");
            return;
        }

        System.out.println("Students present in Session " + sessionId + ":");
        for(String id : sessionAttendance) {
            System.out.println(id);
        }
    }

    // Method to display All Sessions
    public void displayAllSessions() {

        if(attendanceMap.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }

        for(String sessionId : attendanceMap.keySet()) {
            System.out.println("\nSession: " + sessionId);
            displayAttendance(sessionId);
        }
    }
}