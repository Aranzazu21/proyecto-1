import jade.core.behaviours.OneShotBehaviour;

public class ProblemClassifierAgent extends OneShotBehaviour {
    private final DataSet dataSet;

    public ProblemClassifierAgent(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void action() {

        if (isRegressionProblem(dataSet)) {
            System.out.println("SE HA DETECTADO UN PROBLEMA DE REGRESION.");
            System.out.println(" \n");


            myAgent.addBehaviour(new LinearRegressionAgent(new LinearRegression(dataSet)));
            myAgent.addBehaviour(new PolynomialAgent(new PolynomialRegression(dataSet, 2))); // Cuadrática
            myAgent.addBehaviour(new PolynomialAgent(new PolynomialRegression(dataSet, 3))); // Cúbica

        } else if (isOptimizationProblem(dataSet)) {
            System.out.println("SE HA DETECTADO UN PROBLEMA DE OPTIMIZACION.");
            System.out.println("\n");


            myAgent.addBehaviour(new OptimizationAgent(dataSet));

        } else {
            System.out.println("SE DESCONOCE EL PROBLEMA.");
            System.out.println("\n");
        }
    }


    private boolean isRegressionProblem(DataSet dataSet) {
        return dataSet.getNumberOfVariables() == 2;
    }


    private boolean isOptimizationProblem(DataSet dataSet) {
        return dataSet.getNumberOfVariables() == 1;
    }
}
