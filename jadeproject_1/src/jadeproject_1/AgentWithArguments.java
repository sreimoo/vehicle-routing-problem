package jadeproject_1;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;


public class AgentWithArguments extends Agent{	
	protected void setup() {
		System.out.println(getLocalName()+"I have been created");
		addBehaviour(new MyMultiStepBehaviour());
		System.out.print(getLocalName()+ ":I have added my behaviours");
	}


private class MyMultiStepBehaviour extends Behaviour{
	private int step = 1;
	
	MyMultiStepBehaviour(){
		System.out.print(getBehaviourName()+":I have been created");
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return step==5;
	}
	public int onEnd(){
		System.out.println(this.getBehaviourName()+": I have finished executing");
		return super.onEnd();
	}
}
}