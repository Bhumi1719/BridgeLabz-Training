// Creating a subclass OutPatient which extends the class Patient(Payable)
public class OutPatient extends Patient implements IPayable {
    private double consultationFee;

    // Creating a constructor using super keyword
    public OutPatient(int id, String name, int age, Doctor doctor, double consultationFee) {
        super(id, name, age, doctor);
        this.consultationFee = consultationFee;
    }

    // Creating a method to calculate Bill
    public double calculateBill() {
        return consultationFee;
    }

    // Creating a method to display the information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: OutPatient, Bill: " + calculateBill());
    }
}
