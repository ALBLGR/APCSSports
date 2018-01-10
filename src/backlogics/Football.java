package backlogics;

public class Football extends Instrument {
	
	public Football(String id) {
		super("Football", id);
	}

        @Override
	public String getType(){
		return type;
	}
	
        @Override
	public int getHealth(){
		return health;
	}
	
        @Override
	public void modifyHealth(int num){
		health -= num;
	}
	
        @Override
	public String getId(){
		return id;
	}

}
