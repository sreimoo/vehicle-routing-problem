package demo;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour; 
public class MyCounterAgent extends Agent implements MyAgentInterface {
private TickerBehaviour counter;
public void myCounterAgent() {
	registerO2AInterface(MyAgentInterface.class, this);
}
protected void setup() {
	System.out.println(getLocalName()+": I have been created");
}
public void activateCounter() {
	System.out.println(getLocalName() + ": I have been asked to start counting");
	counter = new TickerBehaviour(this, 1000) {
		private static final long serialVersionUID = 1L;
		public void onStart() {
			super.onStart();
			System.out.println(getLocalName() + ": Start Counting");
		}
		protected void onTick() {
			System.out.println(getLocalName()+": Counter -" + getTickCount());
		}
		public int onEnd() {
			System.out.println(getLocalName() + ": Stop Counting");
			return super.onEnd();
		}
		
	};
	addBehaviour(counter);
}

public void deactivateCounter() {
	System.out.println(getLocalName()+ ": I have been asked to stop counting");
	counter.stop();
}
}
