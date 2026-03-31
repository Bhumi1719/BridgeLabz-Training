public class OTP {
    public static void main(String[] args) {

        // Creating an integer array to store the generated otps
        int[] otps = new int[10];

        // Loop for generating otp 10 times
        for(int i=0; i<otps.length; i++) {
            otps[i] = otpGeneration(); // Calling the method to generate OTP
        }

        System.out.println("Generated OTPs are:");
        for(int otp : otps) {
            System.out.print(otp + " ");
        }

        System.out.println("\n\nAre all OTPs unique? " + areOTPsUnique(otps)); // Calling the method to chexk if otp are unique or not
    }

    // Method for generating a 6-digit OTP
    public static int otpGeneration() {
        int otp = (int) (Math.random() * 900000) + 100000; // 100000–999999
        return otp;
    }

    // Method for checking if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for(int i=0; i<otps.length; i++) {
            for(int j=i + 1; j<otps.length; j++) {
                if(otps[i] == otps[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
