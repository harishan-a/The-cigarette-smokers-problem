import java.util.Arrays;

/**
 * This class represents the main entry point of the application.
 * It creates an agent and three baristas, and starts their threads.
 */
public class Main {
    /**
     * The main method which is executed when the application is started.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Create a counter
        Counter counter = new Counter();

        // Create an agent and three baristas, each with a different pair of ingredients they need
        Thread agent = new Thread(new Agent(counter), "Agent");
        Thread barista1 = new Thread(new Barista(counter, Arrays.asList("Water", "Sugar")), "Barista 1");
        Thread barista2 = new Thread(new Barista(counter, Arrays.asList("Coffee Beans", "Sugar")), "Barista 2");
        Thread barista3 = new Thread(new Barista(counter, Arrays.asList("Coffee Beans", "Water")), "Barista 3");

        // Start the threads
        agent.start();
        barista1.start();
        barista2.start();
        barista3.start();

        try {
            // Wait for the agent to finish
            agent.join();
        } catch (InterruptedException e) {
            // If the main thread is interrupted, stop its execution
            Thread.currentThread().interrupt();
            return;
        }

        // Stop the barista threads
        barista1.interrupt();
        barista2.interrupt();
        barista3.interrupt();
    }
}