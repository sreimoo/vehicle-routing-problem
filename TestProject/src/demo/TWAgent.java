package demo;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.core.behaviours.TickerBehaviour; 
public class TWAgent extends Agent{
TickerBehaviour t;
WakerBehaviour w;
protected void setup() {
	System.out.println("Agent " + getLocalName()+ " Started");
	t = new TickerBehaviour(this,1000) {
		protected void onTick() {
			System.out.println("Agent " + myAgent.getLocalName() + ":tick = " + getTickCount());
			
		}
	};
	w = new WakerBehaviour(this, 20000) {
		protected void handleElapsedTimeout() {
			System.out.println("Agent" + myAgent.getLocalName() + ": It's wakeup time");
			removeBehaviour(t);
		}
	};
	addBehaviour(t);
	addBehaviour(w);
}

}
