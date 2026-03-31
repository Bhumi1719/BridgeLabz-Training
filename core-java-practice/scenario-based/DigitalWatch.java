public class DigitalWatch {
    public static void main(String[] args) {

        System.out.println("Watch starts!");

        // This loop is for displaying hour(0 to 23 for 24-hr format)
        for(int hour=0; hour<24; hour++) {
            // This loop is for displaying minutes(0 to 59)
            for(int minute=0; minute< 60; minute++) {
                String hourHand; // For storing hour hand time
                String minuteHand; // For storing minute hand time

                // Formatting hours
                if(hour < 10) {
                    hourHand = "0" + hour;
                } else {
                    hourHand = "" + hour;
                }

                // Formatting minutes
                if (minute < 10) {
                    minuteHand = "0" + minute;
                } else {
                    minuteHand = "" + minute;
                }

                // Displaying in HH:MM format
                System.out.println(hourHand + ":" + minuteHand);

                // Stopping simulation at 13:00, condition given
                if(hour == 13 && minute == 0) {
                    System.out.println("Power cut!");
                    break; // For breaking the minute loop
                }
            }

            // Terminating the hour loop also for 13:00
            if(hour == 13) {
                break;
            }
        }
    }
}
