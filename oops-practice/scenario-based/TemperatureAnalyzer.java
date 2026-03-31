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
        int hottestDay = 0; // Variable to store the index of the hottest day
        int coldestDay = 0; // Variable to store the index of the coldest day
        float maxTemp = temperatures[0][0]; // Initializing maximum tempertaure with first value of the array
        float minTemp = temperatures[0][0]; // Initializing minimum temperature with first value of the array

        // Creating an array to store the average temperature each day
        float[] averageTemp = new float[7];

        // Loop to find the hottest and coldest days and average per day
        for(int i=0; i<7; i++) {
            float sum = 0; // Variable to store the sum of temperatures
            for(int j=0; j<24; j++) {
                float current = temperatures[i][j]; // Storing the value from temp array to the current variable
                sum += current; // Adding each day temperature in the sum variable

                // Condition to check for hottest temperature
                if(current > maxTemp) {
                    maxTemp = current;
                    hottestDay = i;
                }

                // Condition to check for coldest temperature
                if(current < minTemp) {
                    minTemp = current;
                    coldestDay = i;
                }
            }

            averageTemp[i] = sum / 24;
        }

        System.out.println("Hottest Day is: \nDay " + (hottestDay + 1) + " -> " + String.format("%.2f", maxTemp) + "°C");
        System.out.println("\nColdest Day: \nDay " + (coldestDay + 1) + " -> " + String.format("%.2f", minTemp) + "°C");
        System.out.println("\nAverage Temperature per Day is:");
        for(int i=0; i<7; i++) {
            System.out.println("Day " + (i + 1) + " : " + String.format("%.2f", averageTemp[i]) + "°C");
        }
    }
}
