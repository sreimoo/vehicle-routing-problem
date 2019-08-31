package jadeproject_1;

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;

import jade.wrapper.*;
public class MyJADEController {
	
	public static void main(String[] args) throws StaleProxyException, InterruptedException {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.instance();
		
		System.out.println(MyJADEController.class.getName()+": Launching the platform Main Container...");
		Profile pMain = new ProfileImpl(null,8888,null);
		pMain.setParameter(Profile.GUI, "true");
		ContainerController mainCtrl = rt.createMainContainer(pMain);
		
		Thread.sleep(10000);
		
		System.out.println(MyJADEController.class.getName()+ ": Starting up a ConterAgent...");
		AgentController agentCtrl = mainCtrl.createNewAgent("CounterAgent", MyCounterAgent.class.getName(),new Object[0] );
		agentCtrl.start();
		
		Thread.sleep(20000);
		
		try {
			System.out.print(MyJADEController.class.getName()+": Activating counter");
			MyAgentinterface o2a = agentCtrl.getO2AInterface(MyAgentinterface.class);
			o2a.activateCounter();
			
			Thread.sleep(20000);
			
			System.out.println(MyJADEController.class.getName()+": Deactivating counter");
			o2a.deactivateCounter();
		}
		catch(StaleProxyException e){
			e.printStackTrace();
		}
		
		
		

	}

}
