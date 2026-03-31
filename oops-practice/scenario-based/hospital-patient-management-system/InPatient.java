// Creating a subclass which extends patient class(Payable) 
public class InPatient extends Patient implements IPayable {
    private int days;
    private double dailyCharge;

    // Creating a constructor using super keyword
    public InPatient(int id, String name, int age, Doctor doctor, int days, double dailyCharge) {
        super(id, name, age, doctor);
        this.days = days;
        this.dailyCharge = dailyCharge;
    }

    // Creating a method to calculate Bill
    public double calculateBill() {
        return days * dailyCharge;
    }

    // Creating a method to display information of the patient
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: InPatient, Bill: " + calculateBill());
    }
}

