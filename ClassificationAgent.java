import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class ClassificationAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("___________________________________");
        System.out.println("AGENTE DE CLASIFICACACION LISTO:)");
        System.out.println("___________________________________");

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                DataSet dataSet = new DataSet();


                String analysisType = classifyData(dataSet);
                System.out.println("___________________________________");
                System.out.println("CLASIFICACION DEL PROBLEMA :O " + analysisType);
                System.out.println("___________________________________");
            }
        });
    }

    private String classifyData(DataSet dataSet) {
        DataPoint[] dataPoints = dataSet.getDataPoints();
        System.out.println("___________________________________");
        if (dataPoints.length < 2) {
            return "NO CUENTAS CON LOS DATOS SUFICIENTES :(.";
        }


        LinearRegression linearRegression = new LinearRegression(dataSet);
        linearRegression.fit();

        PolynomialRegression quadraticRegression = new PolynomialRegression(dataSet, 2);
        quadraticRegression.fit();

        PolynomialRegression cubicRegression = new PolynomialRegression(dataSet, 3);
        cubicRegression.fit();


        double rSquaredLinear = linearRegression.calculateR2();
        double rSquaredQuadratic = quadraticRegression.calculateR2();
        double rSquaredCubic = cubicRegression.calculateR2();
        System.out.println("___________________________________");
        System.out.printf("R^2 LINEAL: %.4f, R^2 CUADRATICA: %.4f, R^2 CUBICA: %.4f%n",
                rSquaredLinear, rSquaredQuadratic, rSquaredCubic);
        System.out.println("___________________________________");

        if (rSquaredCubic > rSquaredQuadratic && rSquaredCubic > rSquaredLinear && rSquaredCubic > 0.5) {
            return "( REGRESION CUBICA )";
        } else if (rSquaredQuadratic > rSquaredLinear && rSquaredQuadratic > 0.5) {
            return "( REGRESION CUADRATICA )";
        } else if (rSquaredLinear > 0.5) {
            return "( REGRESION LINEAL )";
        } else {
            return "( NO SE A PODICO CLASIFICAR (NOTA ESTO PUEDE SUCEDER POR UN MAL ACOMODO DE NUESTROS DATOS).)";
        }
    }
}
