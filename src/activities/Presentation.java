package activities;

import chainoResp.ResourceChain;
import users.AbstractUser;

public class Presentation extends AbstractActivity{

	public Presentation(ResourceChain resource, AbstractUser user, String title,
			String description,	String participants, String support_material, 
			int sdate, int edate, int shour, int ehour) {
		
		super(resource, user, title, description, participants, support_material,
				"Apresentação", sdate, edate, shour, ehour);
		// TODO Auto-generated constructor stub
	}
	//RECEBA OS ATRIBUTOS E DEFINA-OS AQUI E NA SUPER
}
