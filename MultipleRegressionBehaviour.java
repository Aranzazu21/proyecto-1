import jade.core.behaviours.OneShotBehaviour;

public class MultipleRegressionBehaviour extends OneShotBehaviour {
    private final DataSet dataSet;

    public MultipleRegressionBehaviour(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void action() {
        System.out.println("\n");
        System.out.println("   (\\(\\ ");
        System.out.println("   ( *.*)");
        System.out.println("   o_(\")(\")");
        System.out.println("\n_____________________________________________");
        System.out.println("INICIANDO REGRESION MULTIPLE...");
        System.out.println("___________________________________");


        MultipleLinearRegression regression = new MultipleLinearRegression(dataSet);
        regression.fit();

        System.out.println("Ecuación de Regresión Múltiple:");
        System.out.println(regression.getEquation());

        // Encabezado para las predicciones
        System.out.printf("%-25s %-15s %-15s%n", "PUBLICIDAD (X)", "AÑO (Y)", "PREDICCION (Z)");
        System.out.println("---------------------------------------------");


        double[] advertisingValues = {55, 60, 65, 125, 340, 1200};
        int year = 2021;

        for (double advertising : advertisingValues) {
            double prediction = regression.predict(advertising, year);
            System.out.printf("%-25.2f %-15d %-15.2f%n", advertising, year, prediction);
        }

        double r2 = regression.calculateR2();

        System.out.printf("R^2 (COEFICIENTE DE DETERMINACION): %.4f%n", r2);
        System.out.printf("R^2 (PORCENTAJE): %.2f%%%n", r2 * 100);

        System.out.println("FINALIZACION");
        System.out.println("_____________________________________________");

    }
}