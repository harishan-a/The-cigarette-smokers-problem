import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Agent implements Runnable{
    Counter counter;
    List<String> ingredients;
    Random random;

    public Agent(Counter counter){
        this.counter = counter;
        this.ingredients = Arrays.asList("Coffee Beans", "Water", "Sugar");
        this.random = new Random();
    }

    public void run(){
        for(int = 0; i < 21; i++){
            int index1 = random.nextInt(ingredients.size());
            int index2 = random.nextInt(ingredients.size());

            while(index1 == index2) {
                index2 = random.nextInt(ingredients.size());
            }

            String randomIngredient1 = ingredients.get(index1);
            String randomIngredient2 = ingredients.get(index2);


            try{
                counter.put(randomIngredient1);
                System.out.println("Agent put " + randomIngredient1 + " on the counter");

                counter.put(randomIngredient2);
                System.out.println("Agent put " + randomIngredient2 + " on the counter");

                Thread.sleep(1000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }


        }
    }
}
