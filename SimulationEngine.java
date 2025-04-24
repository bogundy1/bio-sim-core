import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Organism {
    int energy;

    Organism(int energy) {
        this.energy = energy;
    }

    void update() {
        energy -= new Random().nextInt(5);
    }

    boolean isAlive() {
        return energy > 0;
    }
}

public class SimulationEngine {
    public static void main(String[] args) {
        List<Organism> population = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            population.add(new Organism(100));
        }

        for (int step = 0; step < 20; step++) {
            System.out.println("Step " + step);
            population.removeIf(o -> !o.isAlive());
            population.forEach(Organism::update);
            System.out.println("Population size: " + population.size());
        }
    }
}
