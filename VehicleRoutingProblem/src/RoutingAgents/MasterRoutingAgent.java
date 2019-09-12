package RoutingAgents;

import java.util.ArrayList;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.lang.acl.ACLMessage;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;

@SuppressWarnings("serial")
public class MasterRoutingAgent extends Agent{
	int agentCount = 0;
	RoutingWorld world = new RoutingWorld(); 
	ArrayList<Node> locations = new ArrayList<Node>();
	
	protected void setup() {
		world.BuildWorld();
		AMSAgentDescription [] agents = null;        
		try {             
			SearchConstraints c = new SearchConstraints();             
			c.setMaxResults ((long) -1);   
				agents = AMSService.search( this, new AMSAgentDescription(), c );   
				}   
				catch (Exception e) {             
				System.out.println( "Problem searching AMS: " + e );             
				e.printStackTrace();   
				}      
			AID da1 = getAID("DeliveryAgent1");
			AID da2 = getAID("DeliveryAgent2");
			AID da3 = getAID("DeliveryAgent3");
			
			for (int i=0; i<agents.length;i++)   {    
				AID agentID = agents[i].getName(); 
				if(agentID.equals(da1) || agentID.equals(da2) || agentID.equals(da3)) {
					agentCount ++;
				}
				//agentCount ++;
				System.out.println(     
						( agentID.equals(da1) || agentID.equals(da2) || agentID.equals(da3) ? "*** " : "    ")        
						+ i + ": " + agentID.getName());
				}
			if(agentCount > 0) {
				System.out.println("We have " + agentCount + " Delivery Agents");
			}
			
			CyclicBehaviour msgReceivingBehaviour =  (new CyclicBehaviour(this)    {  
			public void action() {       
				System.out.println(getLocalName() + ": Waiting for Capacity Constraints");  
				for(int i = 0; i < agentCount; i++) {	
				ACLMessage msg= receive();     
				if (msg!=null) {      
					// Print out message content      
					System.out.println(getLocalName()+ ": Received Capacity Constraints: " + msg.getContent() 
					+ " from " + msg.getSender().getLocalName());      
					}  
				}
				// Continue listening //    
				block();  
				locations = world.TellMeLocations();
				for(Node a : locations) {
					System.out.println(a.parcels);
				}
				// This line gets printed since the blocking effect is achieved only after the action() method returns     
				//System.out.println(getLocalName() + ": This line is printed");
				}
			} );
			
			addBehaviour(msgReceivingBehaviour);
	}
	
}
