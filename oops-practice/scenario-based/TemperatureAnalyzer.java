class TemperatureAnalyzer {
    public static void main(String[] args) {
        // Creating a 2D array to store the temperature(7 days * 24 hours)
        float[][] temperatures = new float[7][24];

        // Storing the values in the temperatures array
        for(int i=0; i<7; i++) {
            for(int j=0; j<24; j++) {
                temperatures[i][j] = 20 + (float)(Math.random() * 15);
            }
        }

        analyzeTemperature(temperatures); // Calling the method to analyze the temperature directly as print statement is inside the method itself
    }

    // Creating method to analyze temperatures
    public static void analyzeTemperature(float[][] temperatures) {
        int HOTTEST_DAY = 0; // Variable to store the index of the hottest day
        int COLDEST_DAY = 0; // Variable to store the index of the coldest day
        float MAX_TEMP = temperatures[0][0]; // Initializing maximum tempertaure with first value of the array
        float MIN_TEMP = temperatures[0][0]; // Initializing minimum temperature with first value of the array

        // Creating an array to store the average temperature each day
        float[] averageTemp = new float[7];

        // Loop to find the hottest and coldest days and average per day
        for(int i=0; i<7; i++) {
            float SUM = 0; // Variable to store the sum of temperatures
            for(int j=0; j<24; j++) {
                float CURRENT = temperatures[i][j]; // Storing the value from temp array to the current variable
                SUM += CURRENT; // Adding each day temperature in the sum variable

                // Condition to check for hottest temperature
                if(CURRENT > MAX_TEMP) {
                    MAX_TEMP = CURRENT;
                    HOTTEST_DAY = i;
                }

                // Condition to check for coldest temperature
                if(CURRENT < MIN_TEMP) {
                    MIN_TEMP = CURRENT;
                    COLDEST_DAY = i;
                }
            }

            averageTemp[i] = SUM / 24;
        }

        System.out.println("Hottest Day is: \nDay " + (HOTTEST_DAY + 1) + " -> " + String.format("%.2f", MAX_TEMP) + "°C");
        System.out.println("\nColdest Day: \nDay " + (COLDEST_DAY + 1) + " -> " + String.format("%.2f", MIN_TEMP) + "°C");

        System.out.println("\nAverage Temperature per Day is:");
        for(int i=0; i<7; i++) {
            System.out.println("Day " + (i + 1) + " : " + String.format("%.2f", averageTemp[i]) + "°C");
        }
    }
}
