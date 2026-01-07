public class Ride {
	User user;
	Driver driver;
	double distance;
	double fare;
	public String status;
	
	Ride(User user, Driver driver, double distance, double fare) {
		this.user = user;
		this.driver = driver;
		this.distance = distance;
		this.fare = fare;
		this.status = status;
	}
}
