//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            Thread agent, barista;
            Counter box;

            counter = new Counter(); // shared by producer and consumer

            // Create the producer and consumer threads, passing each thread
            // a reference to the shared BoundedBuffer object.
            agent = new Thread(new Agent(counter),"Agent");
            barista = new Thread(new Barista(counter),"Barista");
            agent.start();
            barista.start();

    }
}