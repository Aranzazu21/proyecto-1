import jade.core.behaviours.OneShotBehaviour;

public class LinearRegressionAgent extends OneShotBehaviour {
    private LinearRegression simpleLinearRegression;

    public LinearRegressionAgent(LinearRegression simpleLinearRegression) {
        this.simpleLinearRegression = simpleLinearRegression;
    }

    @Override
    public void action() {
        simpleLinearRegression.fit();

        System.out.printf("BETA 0 (INTERCEPTO) = %.4f%n", simpleLinearRegression.getIntercept());
        System.out.printf("BETA 1 (PENDIENTE) = %.4f%n", simpleLinearRegression.getSlope());

        System.out.println("___________________________________");
        System.out.printf("CORRELACION (r) = %.4f%n", simpleLinearRegression.getCorrelation());

        System.out.println("_____________________________________________");


        System.out.printf("ERROR ESTANDAR BETA 0 (SE_B0) = %.4f%n", simpleLinearRegression.getSEIntercept(simpleLinearRegression.getSlope()));
        System.out.printf("ERROR ESTANDAR BETA 1 (SE_B1) = %.4f%n", simpleLinearRegression.getSESlope());

        System.out.println("___________________________________");
        System.out.println("\n");
        System.out.println("   (\\(\\ ");
        System.out.println("   ( 0.0)");
        System.out.println("   o_(\")(\")");
        System.out.println("\n_____________________________________________");

        System.out.println("REGRESION LINEAL SIMPLE:");
        System.out.println("___________________________________");

        System.out.println(simpleLinearRegression.getEquation());

        System.out.println("___________________________________");

        System.out.printf("%-25s %-15s%n", "PUBLICIDAD (X)", "PREDICCION (Y)");

        System.out.println("---------------------------------------------");

        double[] testValues = {55, 60, 65, 125, 340, 1200};

        for (double x : testValues) {
            double prediction = simpleLinearRegression.predict(x);
            System.out.printf("%-25.2f %-15.2f%n", x, prediction);
        }

        System.out.println("___________________________________");

        double r2 = simpleLinearRegression.calculateR2();

        System.out.printf("R^2 (COEFICIENTE DE DETERMINACION): %.4f%n", r2);
        System.out.printf("R^2 (PORCENTAJE): %.2f%%%n", r2 * 100);

        System.out.println("_____________________________________________");

        System.out.println("FINALIZACION");
    }
}