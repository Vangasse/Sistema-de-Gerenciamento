package chainoResp;

import java.util.ArrayList;

import activities.AbstractActivity;

public abstract class ResourceChain {
	protected ResourceChain next;
	protected int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ResourceChain(int id) {
		next = null;
		this.id = id;
	}
	
	public void setNext(ResourceChain last) {
		if(this.next == null) {
			this.next = last;
		}
		else {
			this.next.setNext(last);
		}
	}

	public ArrayList<AbstractActivity> schedule(ArrayList<AbstractActivity> activities, AbstractActivity activity) throws Exception{
		
		boolean collision = false;
		
		for(int i = 0;i < activities.size(); i++) {
			if(this.id == activities.get(i).getResource().getId()) {
				if(activities.get(i).getSdate() <= activity.getSdate() && activities.get(i).getEdate() >= activity.getSdate()) {
					//VERIFICAR SITUAÇÃO COM HORARIOS DE EVENTOS DE MULTIPLOS DIAS
					if(activities.get(i).getShour() <= activity.getShour() && activities.get(i).getEhour() >= activity.getShour()) {
						collision = true;
						if(next == null) throw new Exception("Não há salas disponíveis para o horário.");
						next.schedule(activities, activity);
						break;
					}
				}
				else if(activities.get(i).getSdate() <= activity.getEdate() && activities.get(i).getEdate() >= activity.getEdate()) {
					//VERIFICAR SITUAÇÃO COM HORARIOS DE EVENTOS DE MULTIPLOS DIAS
					if(activities.get(i).getShour() <= activity.getEhour() && activities.get(i).getEhour() >= activity.getEhour()) {
						collision = true;
						if(next == null) throw new Exception("Não há salas disponíveis para o horário.");
						next.schedule(activities, activity);
						break;
					}
				}
			}
		}
		if(!(collision)) {
			activity.setResource(this);
			activities.add(activity);
		}
		return activities;
	}
	public abstract String getType();
}
