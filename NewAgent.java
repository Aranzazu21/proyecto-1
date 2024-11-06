import jade.core.Agent;

public class NewAgent extends Agent {

    @Override
    protected void setup() {

        printInitializationMessage();


        DataSet dataSet = new DataSet();


        addBehaviour(new ProblemClassifierAgent(dataSet));
    }

    private void printInitializationMessage() {
        System.out.println("___________________________________");
        System.out.println("INICIALIZACION");
        System.out.println("___________________________________");
    }
}
