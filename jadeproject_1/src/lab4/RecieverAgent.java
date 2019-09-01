package lab4;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class RecieverAgent extends Agent {
	
	protected void setup(){
		 CyclicBehaviour msgReceivingBehaviour = (new CyclicBehaviour(this){
			 	
			 public void action() {
		 
				 System.out.println(getLocalName() + ": Waiting for message");
		
				 ACLMessage msg= receive();
		
				 if (msg!=null) {
		
					 System.out.println(getLocalName()+ ": Received response " +
							 msg.getContent() + " from " + msg.getSender().getLocalName());
		}
		// Continue listening
		// block();
		// This line gets printed since the blocking effect is achieved only after
		//the action() method returns
		
				 System.out.println(getLocalName() + ": This line is printed");}
		}
		);
		
		 addBehaviour(msgReceivingBehaviour);
		}
		

}
