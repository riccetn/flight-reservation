public class Meal {
	private String meal;
	private int price;
	private int mealID;
	
	
	
	public Meal(int mealID, String meal, int price ) {
		super();
		this.meal = meal;
		this.price = price;
		this.mealID = mealID;
	}
	
	
	
	

	@Override
	public String toString(){
		return mealID + " " + meal + "......" +" SEK " + price;  
	}

	
	
}
