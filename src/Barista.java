public class Barista implements Runnable{
    Counter counter;
    String ingredient;
    String ingredientBarista1;
    String ingredientBarista2;
    String ingredientBarista3;

    public Barista(Counter counter) {
        this.counter = counter;
        this.ingredientBarista1 = "Coffee Beans";
        this.ingredientBarista2 = "Water";
        this.ingredientBarista3 = "Sugar";
    }

    public void run(){
        while (true) {

            try {
                List <String> ingredientsCounter = counter.get();

                if(!ingredientsCounter.contains(ingredientBarista1)) {
                    System.out.println("Barista 1 takes Water & Sugar from the counter");
                    counter.clear();
                } else if (!ingredientsCounter.contains(ingredientBarista2)) {
                    System.out.println("Barista 2 takes Coffee Beans & Sugar from the counter");
                    counter.clear();
                } else if (!ingredientsCounter.contains(ingredientBarista3)) {
                    System.out.println("Barista 3 takes Coffee Beans & Water from the counter");
                    counter.clear();
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;

            }


        }

    }

}
