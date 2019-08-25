package RoutingAgents;

import jade.core.Agent;

@SuppressWarnings("serial")
public class MasterRoutingAgent extends Agent{
	protected void setup() {
		Object[] args = getArguments();
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
