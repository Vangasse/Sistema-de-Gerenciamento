package state;

public class Confirmed implements ActivityState{

	public ActivityState toInProgress() {
		// TODO Auto-generated method stub
		return new InProgress();
	}

	public ActivityState toInProcessOfAllocation() {
		// TODO Auto-generated method stub
		return new InProcessOfAllocation();
	}

	public ActivityState toAllocated() {
		// TODO Auto-generated method stub
		return this;
	}

	public ActivityState toFinished() {
		// TODO Auto-generated method stub
		return this;
	}

	public ActivityState toConfirmed() {
		// TODO Auto-generated method stub
		return this;
	}

}
