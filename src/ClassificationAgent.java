import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class ClassificationAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("___________________________________");
        System.out.println("AGENTE DE CLASIFICACION LISTO :)");
        System.out.println("___________________________________");

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                DataSet dataSet = new DataSet();


                GeneticAlgorithm ga = new GeneticAlgorithm(100, 3, 50, 0.95, 0.01);
                ga.run(dataSet);


                double[] bestParameters = ga.getBestSolution();


                LinearRegression geneticLinearRegression = new LinearRegression(dataSet);
                geneticLinearRegression.fitWithParameters(bestParameters);
                double geneticRSquared = geneticLinearRegression.calculateR2();


                System.out.printf("R^2 con algoritmo genético: %.4f%n", geneticRSquared);


                String analysisType = classifyData(dataSet, geneticRSquared);
                System.out.println("___________________________________");
                System.out.println("CLASIFICACION DEL PROBLEMA :O " + analysisType);
                System.out.println("___________________________________");
            }
        });
    }

    private String classifyData(DataSet dataSet, double geneticRSquared) {
        DataPoint[] dataPoints = dataSet.getDataPoints();
        System.out.println("___________________________________");

        if (dataPoints.length < 2) {
            return "NO CUENTAS CON LOS DATOS SUFICIENTES :(";
        }

        LinearRegression linearRegression = new LinearRegression(dataSet);
        linearRegression.fit();
        double rSquaredLinear = linearRegression.calculateR2();

        PolynomialRegression quadraticRegression = new PolynomialRegression(dataSet, 2);
        quadraticRegression.fit();
        double rSquaredQuadratic = quadraticRegression.calculateR2();

        PolynomialRegression cubicRegression = new PolynomialRegression(dataSet, 3);
        cubicRegression.fit();
        double rSquaredCubic = cubicRegression.calculateR2();

        MultipleLinearRegression multipleRegression = new MultipleLinearRegression(dataSet);
        multipleRegression.fit();
        double rSquaredMultiple = multipleRegression.calculateR2();

        System.out.println("___________________________________");
        System.out.printf("R^2 LINEAL: %.4f, R^2 CUADRÁTICA: %.4f, R^2 CÚBICA: %.4f, R^2 MULTIPLE: %.4f%n",
                rSquaredLinear, rSquaredQuadratic, rSquaredCubic, rSquaredMultiple);
        System.out.println("___________________________________");


        String bestModel;

        if (geneticRSquared > Math.max(rSquaredLinear, Math.max(rSquaredQuadratic, rSquaredCubic))) {
            bestModel = "( REGRESION MULTIVARIABLE )";
            System.out.printf("El MODELO CON ALGORITMO GENETICO ES MEJOR: R^2 = %.4f%n", geneticRSquared);
        } else if (rSquaredCubic > Math.max(rSquaredLinear, rSquaredQuadratic)) {
            bestModel = "( REGRESION CÚBICA )";
            System.out.printf("EL MODELO CUBICO ES MEJOR: R^2 = %.4f%n", rSquaredCubic);
        } else if (rSquaredQuadratic > rSquaredLinear) {
            bestModel = "( REGRESION CUADRÁTICA )";
            System.out.printf("EL MODELO CUADRATICO ES MEJOR: R^2 = %.4f%n", rSquaredQuadratic);
        } else {
            bestModel = "( REGRESION LINEAL )";
            System.out.printf("EL MODELO LINEAL ES MEJOR: R^2 = %.4f%n", rSquaredLinear);
        }

        return bestModel;
    }
}