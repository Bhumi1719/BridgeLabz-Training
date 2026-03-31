import java.util.*;

public class Program {

    public void RegisterCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    public Map<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for(CreatorStats creator : records) {
            int count = 0;

            for(double likes : creator.WeeklyLikes) {
                if(likes >= likeThreshold) {
                    count++;
                }
            }

            if(count > 0) {
                result.put(creator.CreatorName, count);
            }
        }
        return result;
    }

    public double CalculateAverageLikes() {
        double totalLikes = 0;
        int totalWeeks = 0;

        for(CreatorStats creator : CreatorStats.EngagementBoard) {
            for(double likes : creator.WeeklyLikes) {
                totalLikes += likes;
                totalWeeks++;
            }
        }

        if(totalWeeks == 0) {
            return 0;
        }
        return totalLikes / totalWeeks;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        boolean running = true;

        while(running) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Enter your choice:");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    CreatorStats creator = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    creator.CreatorName = sc.nextLine();

                    creator.WeeklyLikes = new double[4];

                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for(int i=0; i<4; i++) {
                        creator.WeeklyLikes[i] = Double.parseDouble(sc.nextLine());
                    }

                    program.RegisterCreator(creator);
                    System.out.println("Creator registered successfully");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = Double.parseDouble(sc.nextLine());

                    Map<String, Integer> result = program.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                    if(result.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for(Map.Entry<String, Integer> entry : result.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    double average = program.CalculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + average);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}
