package activities;

import chainoResp.ResourceChain;
import users.AbstractUser;

public class LaboratoryClass extends AbstractActivity{
	//RECEBA OS ATRIBUTOS E DEFINA-OS AQUI E NA SUPER
	public LaboratoryClass(ResourceChain resource, AbstractUser user, String title,
			String description,	String participants, String support_material,
			int sdate, int edate, int shour, int ehour){
		
		super(resource, user, title, description, participants, support_material,
				"Laboratório", sdate, edate, shour, ehour);
	}

}
