package state;

public interface ActivityState {
	ActivityState toInProgress();
	
	ActivityState toInProcessOfAllocation();
	
	ActivityState toAllocated();
	
	ActivityState toFinished();
	
	ActivityState toConfirmed();
}
