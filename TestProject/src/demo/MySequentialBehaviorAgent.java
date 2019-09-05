package demo;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SequentialBehaviour;
@SuppressWarnings("serial")
public class MySequentialBehaviorAgent extends Agent{
	protected void setup() {
		System.out.println(getLocalName() + ": I have been created just now");
		SequentialBehaviour sb = new SequentialBehaviour();
		MyBehaviour a = new MyBehaviour (1,3);
		MyBehaviour b = new MyBehaviour (2,10);
		MyBehaviour c = new MyBehaviour (3,2);
		
		sb.addSubBehaviour(a);
		sb.addSubBehaviour(b);
		sb.addSubBehaviour(c);
		
		this.addBehaviour(sb);
	}
	private class MyBehaviour extends Behaviour{
		private int id;
		private int cycles;
		private int currentCycle;
		
		MyBehaviour(int id, int cycles) {
			this.id = id;
			this.cycles = cycles;
			this.currentCycle = 0;
		}
		public void action() {
			System.out.println("Behavior " + id + " executing cyclec" + ++currentCycle);
		}
		public boolean done() {
			return (cycles == currentCycle);
		}
	}

}
