package lab4;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;

public class ParallelBehaviourAgent extends Agent{
	
	protected void setup() {
		ParallelBehaviour pb = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
		MyBehaviour a = new MyBehaviour(1,3);
		MyBehaviour b = new MyBehaviour(2,10);
		MyBehaviour c = new MyBehaviour(3,2);
		MyBehaviour d = new MyBehaviour(4,6);
		
		pb.addSubBehaviour(a);
		pb.addSubBehaviour(b);
		pb.addSubBehaviour(c);
		pb.addSubBehaviour(d);
		
		addBehaviour(pb);
	}
	
	
	
	private class MyBehaviour extends Behaviour{
		private int id;
		private int cycles;
		private int currentCycle;
		
		MyBehaviour(int id, int cycles){
			this.id = id;
			this.cycles = cycles;
			this.currentCycle = 0;
		}

		@Override
		public void action() {
			System.out.print("Behaviour"+id+" executing cycle "+ ++currentCycle+"\n");
		
		}

		@Override
		public boolean done() {
			return (currentCycle==cycles);
		}
	}
	

}
