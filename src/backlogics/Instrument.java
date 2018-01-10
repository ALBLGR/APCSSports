package backlogics;

public class Instrument {

	protected String type;	//e.g. basketball
	protected int health;		// the degree of integrity of the instrument
	protected String id;		//barcode ID
	
	Instrument(String type, String id){
		this.type = type;
		this.health = 100;	//initially new insts are 100 health
		this.id = id;
	}

	public String getType(){
		return type;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void modifyHealth(int num){
		health -= num;
	}
	
	public String getId(){
		return id;
	}
        
        @Override
        public String toString(){
            return "Instrument type" + type + "ID "+ id + "Health "+ health;
        }
}
