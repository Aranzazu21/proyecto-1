import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class DataSetAgent extends Agent {
    private final DataSet[] dataSets;

    public DataSetAgent() {
        this.dataSets = new DataSet[] {
                new DataSet(),   // Conjunto de datos original

        };
    }

    @Override
    protected void setup() {
        System.out.println("AGENTE CONJUNTO DE DATOS LISTOS.");
        System.out.println("___________________________________");

        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();

        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                for (DataSet dataSet : dataSets) {
                    System.out.println("ENVIANDO CONJUNTOS DE DATOS PARA CLASIFICACION");

                    invokeRegressionAgents(dataSet);
                }
            }
        });

        addBehaviour(sequentialBehaviour);
    }

    private void invokeRegressionAgents(DataSet dataSet) {
        SequentialBehaviour regressionBehaviours = new SequentialBehaviour();


        regressionBehaviours.addSubBehaviour(new LinearRegressionAgent(new LinearRegression(dataSet)));
        regressionBehaviours.addSubBehaviour(new QuadraticAgent(new PolynomialRegression(dataSet, 2)));
        regressionBehaviours.addSubBehaviour(new CubicAgent(new PolynomialRegression(dataSet, 3)));

        addBehaviour(regressionBehaviours);
    }
}

