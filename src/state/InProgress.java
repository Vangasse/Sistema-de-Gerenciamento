package state;

public class InProgress implements ActivityState{

	public ActivityState toInProgress() {
		// TODO Auto-generated method stub
		return this;
	}

	public ActivityState toInProcessOfAllocation() {
		// TODO Auto-generated method stub
		return this;
	}

	public ActivityState toAllocated() {
		// TODO Auto-generated method stub
		return this;
	}

	public ActivityState toFinished() {
		// TODO Auto-generated method stub
		return new Finished();
	}

	public ActivityState toConfirmed() {
		// TODO Auto-generated method stub
		return this;
	}

}
