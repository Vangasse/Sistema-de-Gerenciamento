package activities;
import state.*;
import users.AbstractUser;
import chainoResp.*;


public abstract class AbstractActivity {
	ResourceChain resource;
	
	public ResourceChain getResource() {
		return resource;
	}

	public void setResource(ResourceChain resource) {
		this.resource = resource;
	}

	AbstractUser user = null;
	
	public AbstractUser getUser() {
		return user;
	}

	public void setUser(AbstractUser user) {
		this.user = user;
	}

	String title = "";
	String description = "";
	String participants = "";
	String support_material = "";
	String type = "";
	
	int sdate = 0;
	int edate = 0;
	int shour = 0;
	int ehour = 0;
	
	public int getSdate() {
		return sdate;
	}

	public void setSdate(int sdate) {
		this.sdate = sdate;
	}

	public int getEdate() {
		return edate;
	}

	public void setEdate(int edate) {
		this.edate = edate;
	}

	public int getShour() {
		return shour;
	}

	public void setShour(int shour) {
		this.shour = shour;
	}

	public int getEhour() {
		return ehour;
	}

	public void setEhour(int ehour) {
		this.ehour = ehour;
	}

	ActivityState state = new InProcessOfAllocation();
	
	public AbstractActivity(ResourceChain resource, AbstractUser user, String title, String description,
			String participants, String support_material, String type, int sdate, int edate,
			int shour, int ehour){
		
		this.resource = resource;
		this.user = user;
		
		this.title = title;
		this.description = description;
		this.participants = participants;
		this.support_material = support_material;
		this.type = type;
		
		this.sdate = sdate;
		this.edate = edate;
		this.shour = shour;
		this.ehour = ehour;
	}
	
	public void updateStatus() {};
	public String toString() {
		return "";
	};
}
