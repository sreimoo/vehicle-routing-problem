package jadeproject_1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class TWAgent extends Agent{
	TickerBehaviour t;
	WakerBehaviour w;
	
	protected void setup() {
		System.out.println("Agent "+ getLocalName()+"started");
		
		
		//repititive keeps executing on t amount of time difference	
		t = new TickerBehaviour(this, 1000) {
			protected void onTick() {
				System.out.print("Agent"+myAgent.getLocalName()+": tick =");
			}
		};
		
		
		//ends executes after t amount of time 
		w = new WakerBehaviour(this,2000) {
			protected void handleElapsedTimeout() {
				System.out.println("Agent"+ myAgent.getLocalName()+ ": It's wakeup-time...Bye");
			}
		};
		
		addBehaviour(t);
		
		addBehaviour(w);
	
	}

}
