import jade.core.behaviours.OneShotBehaviour;

public class OptimizationAgent extends OneShotBehaviour {
    private final DataSet dataSet;

    public OptimizationAgent(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void action() {
        System.out.println("INICIANDO OPTIMIZACION...");

        double learningRate = 0.01;
        double[] parameters = initializeParameters(dataSet);

        double[] optimizedParams = optimize(parameters, learningRate);

        System.out.println("OPTIMIZACION DE PARAMETROS: ");
        for (double param : optimizedParams) {
            System.out.printf("%.4f ", param);
        }

        System.out.println("\n OPTIMISACION COMPLETA.");
    }

    private double[] initializeParameters(DataSet dataSet) {
        return new double[dataSet.getNumberOfVariables()];
    }

    private double[] optimize(double[] parameters, double learningRate) {
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] -= learningRate * Math.random();
        }

        return parameters;
    }
}