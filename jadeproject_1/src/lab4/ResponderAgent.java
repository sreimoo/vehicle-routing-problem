package lab4;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.*;

public class ResponderAgent extends Agent {
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			@Override
			public void action() {
				System.out.print(getLocalName()+": Waiting for a message");
				ACLMessage msg = receive();
				if(msg!=null) {
					System.out.println(getLocalName()+": Recieved message"+
					msg.getContent()+" from"+ msg.getSender().getLocalName());
					
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Pong");
					
					System.out.println(getLocalName()+": Sending response "+ reply.getContent()+" to "+msg.getAllReceiver().next());
					send(reply);
				}
					block();	
				}
			});			
		}
}

