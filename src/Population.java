import java.util.Random;
public class Population {
    private Individual[] individuals;

    public Population(int populationSize, int numGenes) {
        individuals = new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            individuals[i] = new Individual(numGenes);
        }
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void evaluateFitness(DataSet dataSet) {
        for (Individual individual : individuals) {
            double fitnessValue = calculateFitness(individual, dataSet);
            individual.setFitness(fitnessValue);
        }
    }

    private double calculateFitness(Individual individual, DataSet dataSet) {
        double totalError = 0.0;
        for (DataPoint point : dataSet.getDataPoints()) {
            double predicted = predict(individual.getGenes(), point);
            totalError += Math.pow(predicted - point.getSales(), 2);
        }

        double rSquared = 1 - (totalError / dataSet.getTotalSumOfSquares());
        return rSquared;
    }

    private double predict(double[] genes, DataPoint point) {

        if (genes.length < 2) {
            throw new IllegalArgumentException("NO HAY SUFICIENTES GENES PARA HACER PREDICCIONES .");
        }
        return genes[0] + genes[1] * point.getAdvertising();
    }

    public Individual selectParent() {
        Random rand = new Random();
        return individuals[rand.nextInt(individuals.length)];
    }

    public Individual crossover(Individual parent1, Individual parent2) {
        double[] childGenes = new double[parent1.getGenes().length];
        Random rand = new Random();

        int crossoverPoint = rand.nextInt(parent1.getGenes().length);

        for (int i = 0; i < childGenes.length; i++) {
            if (i < crossoverPoint) {
                childGenes[i] = parent1.getGenes()[i];
            } else {
                childGenes[i] = parent2.getGenes()[i];
            }
        }

        Individual child = new Individual(childGenes.length);
        System.arraycopy(childGenes, 0, child.getGenes(), 0, childGenes.length);

        return child;
    }

    public void add(Individual individual) {
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i] == null) {
                individuals[i] = individual;
                return;
            }
        }

        int worstIndex = 0;
        for (int i = 1; i < individuals.length; i++) {
            if (individuals[i].getFitness() < individuals[worstIndex].getFitness()) {
                worstIndex = i;
            }
        }

        individuals[worstIndex] = individual;
    }
}