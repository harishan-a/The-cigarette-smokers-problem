//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            Thread agent, barista1, barista2, barista3;
            Counter counter;

            counter = new Counter(); // Box


            agent = new Thread(new Agent(counter),"Agent"); //Producer
            barista1 = new Thread(new Barista(counter),"Barista1"); //Consumer
            barista2 = new Thread(new Barista(counter),"Barista2"); //Consumer
            barista3 = new Thread(new Barista(counter),"Barista3"); //Consumer

            agent.start();
            barista1.start();
            barista2.start();
            barista3.start();

    }
}