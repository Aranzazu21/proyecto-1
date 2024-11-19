
import jade.core.behaviours.OneShotBehaviour;
import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class NewAgent extends Agent {

    @Override
    protected void setup(){
        printInitializationMessage();

        SequentialBehaviour sequentialBehaviour= new SequentialBehaviour();

        sequentialBehaviour.addSubBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                try{
                    AgentContainer container= getContainerController();

                    AgentController classificationAgent= container.createNewAgent("ClassificationAgent", "ClassificationAgent", null);
                    classificationAgent.start();

                    AgentController dataSetAgent= container.createNewAgent("DataSetAgent", "DataSetAgent", null);
                    dataSetAgent.start();


                }catch(StaleProxyException e){
                    e.printStackTrace();
                }
            }
        });

        addBehaviour(sequentialBehaviour);
    }

    private void printInitializationMessage(){
        System.out.println(" /|_/|   /|_/|   /|_/|   /|_/| ");
        System.out.println("( o.o ) ( o.o ) ( o.o ) ( o.o )");
        System.out.println(" > ^ <   > ^ <   > ^ <   > ^ <  ");
        System.out.println("___________________________________");
        System.out.println("INICIALIZACION DE NEWAGENT");
        System.out.println("___________________________________");
    }
}