import java.util.List;

/**
 * This class represents a Barista who takes ingredients from the counter and brews coffee.
 */
public class Barista implements Runnable {
    private final Counter counter;
    private final List<String> ingredientsNeeded;

    /**
     * Constructor for the Barista class.
     *
     * @param counter The counter from which the barista takes ingredients.
     * @param ingredientsNeeded The ingredients needed by the barista to brew coffee.
     */
    public Barista(Counter counter, List<String> ingredientsNeeded) {
        this.counter = counter;
        this.ingredientsNeeded = ingredientsNeeded;
    }

    /**
     * The run method which is executed when the thread for this class is started.
     * The barista continuously checks the counter for the needed ingredients and brews coffee if they are available.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Get the ingredients from the counter
                List<String> ingredientsCounter = counter.get();

                // If the counter contains all the needed ingredients, brew coffee
                if (ingredientsCounter.containsAll(ingredientsNeeded)) {
                    System.out.printf("%s takes %s & %s from the counter%n", Thread.currentThread().getName(), ingredientsNeeded.get(0), ingredientsNeeded.get(ingredientsNeeded.size() - 1));
                    System.out.printf("%s brews coffee%n\n", Thread.currentThread().getName());
                    counter.clear();
                }

                // Sleep for a second and a half
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                // If the thread is interrupted, stop its execution
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}