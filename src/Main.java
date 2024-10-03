public class Main {
    public static void main(String[] args) {

        DataSet dataSet = new DataSet();

        char input = '1';

        switch (input) {
            case '1':
                performLinearRegression(dataSet);
                break;
            case '2':
                performPolynomialRegression(dataSet);
                break;
            case '3':
                performLeastSquaresRegression(dataSet);
                break;
            default:
                System.out.println("Selección Inválida");
        }
    }

    private static void performLinearRegression(DataSet dataSet) {
        LinearRegression linearRegression = new LinearRegression(dataSet);
        linearRegression.fit();
        System.out.println("Ecuación de Regresión Lineal: " + linearRegression.getEquation());
        makePredictions(linearRegression);
    }

    private static void performLeastSquaresRegression(DataSet dataSet) {
        LeastSquaresRegression leastSquaresRegression = new LeastSquaresRegression(dataSet);
        leastSquaresRegression.fit();
        System.out.println("Ecuación de Regresión de Mínimos Cuadrados: " + leastSquaresRegression.getEquation());
        makePredictions(leastSquaresRegression);
    }

    private static void performPolynomialRegression(DataSet dataSet) {
        PolynomialRegression polynomialRegression = new PolynomialRegression(dataSet);
        polynomialRegression.fit();
        System.out.println("Ecuación de Regresión Polinomial: " + polynomialRegression.getEquation());
        makePredictions(polynomialRegression);
    }


    private static void makePredictions(LinearRegression regression) {
        int[] testValues = {55, 60, 65, 125, 340,1200};
        for (int x : testValues) {
            System.out.printf("Predicción para publicidad=%d: %.2f%n", x, regression.predict(x)); // Mostramos la predicción
        }
    }

    private static void makePredictions(LeastSquaresRegression regression) {
        int[] testValues = {55, 60, 65, 125, 340,1200};
        for (int x : testValues) {
            System.out.printf("Predicción para publicidad=%d: %.2f%n", x, regression.predict(x)); // Mostramos la predicción
        }
    }

    private static void makePredictions(PolynomialRegression regression) {
        int[] testValues = {55, 60, 65, 125, 340,1200};
        for (int x : testValues) {
            System.out.printf("Predicción para publicidad=%d: %.2f%n", x, regression.predict(x)); // Mostramos la predicción
        }
    }
}