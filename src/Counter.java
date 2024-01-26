import java.util.ArrayList;
import java.util.List;
public class Counter {
    private List<String> ingredients = new ArrayList<>();

    public synchronized void put(String ingredient) throw InterruptedException{
        while (!ingredients.isEmpty()) {
            wait();
        }
        ingredients.add(ingredient);
        notifyAll();
    }

    public synchronized List<String> get() throws InterruptedException {
        while (ingredients.isEmpty()) {
            wait();
        }
        return new ArrayList<>(ingredients);
    }

    public synchronized void clear() {
        ingredients.clear();
        notifyAll();
    }

}
