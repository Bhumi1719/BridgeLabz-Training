import java.util.HashMap;

public class Calculator {
    private HashMap<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int factorial(int n) {
        // Checking cache first
        if(cache.containsKey(n)) {
            System.out.println("Returning cached result for " + n);
            return cache.get(n);
        }

        System.out.println("Computing factorial for " + n);

        int result = 1;

        for(int i=1; i<=n; i++) {
            result *= i;
        }

        cache.put(n, result); // Storing in cache
        return result;
    }
}
