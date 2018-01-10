package backlogics;

public class Basketball extends Instrument {
	
	public Basketball(String id) {
		super("Basketball", id);
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
