import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Counter where ingredients can be put and taken.
 */
public class Counter {
    private final List<String> ingredients;

    /**
     * Constructor for the Counter class.
     */
    public Counter() {
        this.ingredients = new ArrayList<>();
    }

    /**
     * Puts a list of ingredients on the counter.
     *
     * @param newIngredients The ingredients to be put on the counter.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public synchronized void put(List<String> newIngredients) throws InterruptedException {
        while (!this.ingredients.isEmpty()) {
            wait();
        }
        this.ingredients.addAll(newIngredients);
        notifyAll();
    }

    /**
     * Gets the ingredients from the counter.
     *
     * @return A list of ingredients currently on the counter.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public synchronized List<String> get() throws InterruptedException {
        while (ingredients.isEmpty()) {
            wait();
        }
        return new ArrayList<>(ingredients);
    }

    /**
     * Clears the counter.
     */
    public synchronized void clear() {
        ingredients.clear();
        notifyAll();
    }
}