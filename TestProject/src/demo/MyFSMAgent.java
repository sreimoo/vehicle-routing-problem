package demo;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.FSMBehaviour;
public class MyFSMAgent extends Agent{
	private static final String STATE_A = "A";
	private static final String STATE_B = "B";
	private static final String STATE_C = "C";
	private static final String STATE_D = "D";
	private static final String STATE_E = "E";
	private static final String STATE_F = "F";
	protected void setup() {
		FSMBehaviour fsm = new FSMBehaviour(this) {
			public int onEnd() {
				System.out.println("FSM Behaviour Completed");
				myAgent.doDelete();
				return super.onEnd();
				
			}
		};
		fsm.registerFirstState(new NamePrinter(), STATE_A);
		fsm.registerState(new NamePrinter(), STATE_B);
		fsm.registerState(new RandomGenerator(3), STATE_C);
		fsm.registerState(new NamePrinter(), STATE_D);
		fsm.registerState(new RandomGenerator(4), STATE_E);
		fsm.registerLastState(new NamePrinter(), STATE_F);
		
		fsm.registerDefaultTransition(STATE_A,STATE_B);
		fsm.registerDefaultTransition(STATE_B,STATE_C);
		fsm.registerTransition(STATE_C,STATE_C,0);
		fsm.registerTransition(STATE_C,STATE_D,1);
		fsm.registerTransition(STATE_C,STATE_A,2);
		fsm.registerDefaultTransition(STATE_D, STATE_E);
		fsm.registerTransition(STATE_E,STATE_F,3);
		fsm.registerDefaultTransition(STATE_E, STATE_B);
		
		addBehaviour(fsm);
		
		
	}
	@SuppressWarnings("serial")
	private class NamePrinter extends OneShotBehaviour{
		public void action() {
			System.out.println("Executing beha" +getBehaviourName());
		}
	}
	@SuppressWarnings({ "unused", "serial" })
	private class RandomGenerator extends NamePrinter{
		private int maxExitValue;
		private int exitValue;
		
		private RandomGenerator (int max){
			super();
			maxExitValue = max;
			
		}
		public void action() {
			System.out.println("Executing Behaviour" + getBehaviourName());
			exitValue = (int) (Math.random()* maxExitValue);
			System.out.println("Exit Value is: " +exitValue);
		}
		public int onEnd() {
			return exitValue;
		}
	}
}
