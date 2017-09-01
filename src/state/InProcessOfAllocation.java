package state;

public class InProcessOfAllocation implements ActivityState{

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
		return new Allocated();
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
