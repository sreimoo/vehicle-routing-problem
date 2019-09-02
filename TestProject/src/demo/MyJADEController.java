package demo;
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;
import jade.core.Agent;

public class MyJADEController {
public static void main(String[] args) throws StaleProxyException, InterruptedException{
	Runtime rt = Runtime.instance();
	System.out.println(MyJADEController.class.getName() + ": Launching the platform main container ...");
	Profile pMain = new ProfileImpl(null, 8888, null);
	pMain.setParameter(Profile.GUI, "true");
	ContainerController mainCtrl = rt.createMainContainer(pMain);
	Thread.sleep(10000);
	System.out.println(MyJADEController.class.getName() + ": Starting up counterAgent ...");
	AgentController agentCtrl = mainCtrl.createNewAgent("CounterAgent", MyCounterAgent.class.getName(), new Object[0]);
	agentCtrl.start();
	Thread.sleep(20000);
	
	try {
		System.out.println(MyJADEController.class.getName()+ ": Activating Counter");
		MyAgentInterface o2a = agentCtrl.getO2AInterface(MyAgentInterface.class);
		o2a.activateCounter();
		Thread.sleep(20000);
		System.out.println(MyJADEController.class.getName()+ ": Deactivating Counter");
		o2a.deactivateCounter();
	}
	catch (StaleProxyException e){
		e.printStackTrace();
	}
}
}
