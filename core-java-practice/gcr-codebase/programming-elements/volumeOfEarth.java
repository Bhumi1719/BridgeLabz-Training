public class volumeOfEarth {
    public static void main(String[] args) {
        double radius = 6378; // Radius in km

        // Calculate the volume of the Earth in cubic km
        double volInKm = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        // Calculate the volume in cubic miles
        double volInMiles = volInKm * 0.239;

        System.out.println("The volume of the Earth in cubic kilometers is " + volInKm + " and cubic miles is " + volInMiles);
    }
}