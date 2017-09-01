import state.*;


public abstract class AbstractActivity {
	AbstractResource resource = null;
	AbstractUser user = null;
	
	String title = "";
	String description = "";
	String participants = "";
	String support_material = "";
	String type = "";
	
	int sdate = 0;
	int edate = 0;
	int shour = 0;
	int ehour = 0;
	ActivityState state = new InProcessOfAllocation();
	
	public AbstractActivity(){
		
	}
	
	abstract void updateStatus();
	
}
