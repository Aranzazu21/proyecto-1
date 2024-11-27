import java.util.Arrays;

public class GeneticAlgorithm {
    private Population population;
    private int generations;
    private double crossoverRate;
    private double mutationRate;

    public GeneticAlgorithm(int populationSize, int numGenes, int generations, double crossoverRate, double mutationRate) {
        this.population = new Population(populationSize, numGenes);
        this.generations = generations;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
    }

    public void run(DataSet dataSet) {
        for (int generation = 0; generation < generations; generation++) {
            population.evaluateFitness(dataSet);

            Population newPopulation = new Population(population.getIndividuals().length, population.getIndividuals()[0].getGenes().length);

            for (int i = 0; i < population.getIndividuals().length; i++) {
                Individual parent1 = population.selectParent();
                Individual parent2 = population.selectParent();

                Individual offspring;
                if (Math.random() < crossoverRate) {
                    offspring = population.crossover(parent1, parent2);
                } else {
                    offspring = parent1;
                }

                offspring.mutate(mutationRate);
                newPopulation.add(offspring);
            }

            population = newPopulation;

            if (bestFitness() >= 0.90) break;
        }

        reportBestSolution();
    }

    public double[] getBestSolution() {
        Individual bestIndividual = null;

        for (Individual individual : population.getIndividuals()) {
            if (bestIndividual == null || individual.getFitness() > bestIndividual.getFitness()) {
                bestIndividual = individual;
            }
        }

        return bestIndividual.getGenes();
    }

    private double bestFitness() {
        double bestFitnessValue = 0.0;

        for (Individual individual : population.getIndividuals()) {
            if (individual.getFitness() > bestFitnessValue) {
                bestFitnessValue = individual.getFitness();
            }
        }

        return bestFitnessValue;
    }

    private void reportBestSolution() {
        double[] bestGenes = getBestSolution();
        System.out.println("MEJOR SOLUCION ENCONTRADA: " + Arrays.toString(bestGenes));
    }
}