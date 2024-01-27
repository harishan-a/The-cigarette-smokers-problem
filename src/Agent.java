import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class represents an Agent who puts random ingredients on the counter.
 */
public class Agent implements Runnable {
    private final Counter counter;
    private final List<String> ingredients;
    private final Random random;

    /**
     * Constructor for the Agent class.
     *
     * @param counter The counter on which the agent puts ingredients.
     */
    public Agent(Counter counter) {
        this.counter = counter;
        this.ingredients = Arrays.asList("Coffee Beans", "Water", "Sugar");
        this.random = new Random();
    }

    /**
     * The run method which is executed when the thread for this class is started.
     * The agent puts random ingredients on the counter 20 times.
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            // Generate two different random indices
            int index1 = getRandomIndex();
            int index2 = getRandomIndex();
            while (index1 == index2) {
                index2 = getRandomIndex();
            }

            // Get the ingredients at the generated indices
            List<String> randomIngredients = Arrays.asList(ingredients.get(index1), ingredients.get(index2));

            try {
                // Put the ingredients on the counter and print a message
                counter.put(randomIngredients);
                System.out.printf("Order #%d%nAgent puts %s & %s on counter%n", i + 1, randomIngredients.get(0), randomIngredients.get(1));

                // Sleep for a second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // If the thread is interrupted, stop its execution
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /**
     * Generates a random index within the range of the ingredients list.
     *
     * @return A random index.
     */
    private int getRandomIndex() {
        return random.nextInt(ingredients.size());
    }
}