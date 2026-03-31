import java.util.Date;

public class EnergyUsage {

    private Date date;
    private double value;

    public EnergyUsage(Date date, double value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}
