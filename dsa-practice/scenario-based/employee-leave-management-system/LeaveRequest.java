public class LeaveRequest {
    int employeeId;
    int days;
    String status; 
    public LeaveRequest(int employeeId, int days) {
        this.employeeId = employeeId;
        this.days = days;
        this.status = "Pending";
    }
}

