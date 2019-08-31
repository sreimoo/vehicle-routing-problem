package jadeproject_1;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

@SuppressWarnings({ "unused", "serial" })
public class GBOSAgent extends Agent{
	protected void setup() {
		System.out.println(getLocalName()+": I have been created");
		
		//Add a cyclic Behavior
		addBehaviour(new MyCyclicBehaviour());
		
		addBehaviour(new MyOneShotBehaviour());
		
		addBehaviour(new MyMultiStepBehaviour());
		
		System.out.println(getLocalName() + ": I have added my behaviours");
		
	}
	
	protected void takeDown() {
		System.out.println(getLocalName()+": Preparing to die");
	}

private class MyCyclicBehaviour extends CyclicBehaviour{

	MyCyclicBehaviour(){
		System.out.println(getLocalName()+": I have been created");
			
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println(getBehaviourName()+": Cycling");
		
	}
}

	
///One Shot Behaviour Implementation
@SuppressWarnings({ "unused" })
private class MyOneShotBehaviour extends OneShotBehaviour{
	
	@SuppressWarnings("unused")
	 MyOneShotBehaviour(){
		 	System.out.println(getBehaviourName()+": I have been created");
	}
	
	 @Override
	 public void action() {
		 System.out.println(getBehaviourName()+": I will be executed only once");
	 }
}

		//Multi Step Behaviour Implementation
private class MyMultiStepBehaviour extends Behaviour{
	private int step = 1;
	
	@SuppressWarnings("unused")
	MyMultiStepBehaviour(){
		System.out.println(getBehaviourName()+": I have been created");
	}
	
	@Override
	public void action() {
		
		switch(step) {
		
		case 1:
			System.out.println(getBehaviourName()+": Operation 1");
			break;
		case 2:
			System.out.println(getBehaviourName()+": Operation 2");
			break;
		case 3:
			System.out.println(getBehaviourName()+": Operation 3");
			break;
		case 4:
			System.out.println(getBehaviourName()+": Operation 4");
			break;
		
		}
		step++;
		
	}

	@Override
	public boolean done() {
		
		return step ==5;
	}
	
	public int onEnd() {
		System.out.println(this.getBehaviourName() + ": I have finished executing");
		System.out.println(this.getBehaviourName()+": Terminating agent");
		myAgent.doDelete();
		return super.onEnd();
		}
	
	
}

}
