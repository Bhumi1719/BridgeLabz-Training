import java.io.*;
import java.util.Scanner;

public class StudentDataStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path to store student data: ");
        String filePath = sc.nextLine();

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {

            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = sc.nextDouble();

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch(IOException e) {
            System.out.println("Error writing student data.");
            e.printStackTrace();
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch(IOException e) {
            System.out.println("Error reading student data.");
            e.printStackTrace();
        }
    }
}
