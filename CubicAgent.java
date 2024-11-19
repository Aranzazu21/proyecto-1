import jade.core.behaviours.OneShotBehaviour;

public class CubicAgent extends OneShotBehaviour {
    private PolynomialRegression polynomial;

    public CubicAgent(PolynomialRegression polynomial) {
        this.polynomial = polynomial;
    }

    @Override
    public void action() {
        polynomial.fit();
        System.out.println("\n");
        System.out.println("   (\\(\\ ");
        System.out.println("   ( *.*)");
        System.out.println("   o_(\")(\")");
        System.out.println("\n_____________________________________________");
        System.out.println("CUBIC POLYNOMIAL REGRESSION:");
        System.out.println("___________________________________");
        System.out.println(polynomial.getEquation());

        System.out.printf("%-25s %-15s%n", "PUBLICIDAD (X)", "PREDICCION (Y)");
        System.out.println("---------------------------------------------");

        double[] testValues = {55, 60, 65, 125, 340, 1200};

        for (double x : testValues) {
            double prediction = polynomial.predict(x);
            System.out.printf("%-25.2f %-15.2f%n", x, prediction);
        }

        double r2 = polynomial.calculateR2();
        System.out.printf("R^2 (COEFICIENTE DE DETERMINACION): %.4f%n", r2);
        System.out.printf("R^2 (PORCENTAJE): %.2f%%%n", r2 * 100);

        System.out.println("FINALIZACION");
        System.out.println("_____________________________________________");
    }
}