import java.util.Random;

public class Individual {
    private double[] genes;
    private double fitness;

    public Individual(int numGenes) {
        genes = new double[numGenes];
        Random rand = new Random();
        for (int i = 0; i < numGenes; i++) {
            genes[i] = rand.nextDouble() * 10;
        }
    }

    public double[] getGenes() {
        return genes;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void mutate(double mutationRate) {
        Random rand = new Random();
        for (int i = 0; i < genes.length; i++) {
            if (rand.nextDouble() < mutationRate) {
                genes[i] += rand.nextGaussian();
            }
        }
    }
}