package lab4;

import java.util.Iterator;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent{
	protected void setup() {
		
		CyclicBehaviour messageListeningBehaviour = new CyclicBehaviour(this)
				{
					@Override
					public void action() {
						ACLMessage msg = receive();
						if(msg!=null) {
							System.out.println(getLocalName()+" : Received response"+ msg.getContent()+ " from "+ msg.getSender().getLocalName());
						}
						block();
						
					}
				
				};
				addBehaviour(messageListeningBehaviour);
				
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Ping");
		
		for(int i=1;i<=2;i++) {
			msg.addReceiver(new AID("a"+i,AID.ISLOCALNAME));
		}
		
		System.out.println(getLocalName()+": Sending message"+msg.getContent()+" to ");
		Iterator recievers = msg.getAllIntendedReceiver();
		while(recievers.hasNext()) {
			System.out.println(((AID)recievers.next()).getLocalName());
		}
			send(msg);
	}

}
