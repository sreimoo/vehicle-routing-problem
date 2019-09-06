package RoutingAgents;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


public class MainClass {

	public static void main(String[] args) throws StaleProxyException, InterruptedException{
		// TODO Auto-generated method stub
		Runtime rt = Runtime.instance();
		
		System.out.println(MainClass.class.getName()+ " Launching the main platform");
		
		Profile pMain = new ProfileImpl(null,8888,null);
		pMain.setParameter(Profile.GUI, "true");
		ContainerController mainCtrl = rt.createMainContainer(pMain);
		
		System.out.println("Main class has been initiated");
		
		//create an agent
		AgentController agentCtrl = mainCtrl.createNewAgent("Master Routing Agent", MasterRoutingAgent.class.getName(),new Object[0]);
		//start agent
		agentCtrl.start();
		
	
		
		
		
	}

}
