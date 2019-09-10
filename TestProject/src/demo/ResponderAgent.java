package demo;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;
public class ResponderAgent extends Agent{

	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				System.out.println(getLocalName() + ": Waiting for message");
				ACLMessage msg = receive();
				if(msg !=null) {
					System.out.println(getLocalName() + ": Received message " + msg.getContent() + " from " + msg.getSender().getLocalName());
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Pong");
					System.out.println(getLocalName() + ": Sending response" + reply.getContent() + " to " + msg.getAllReceiver().next());
					send(reply);
				}
				//block();
			}
		});
	}
}
