import java.util.ArrayList;
import java.util.List;

public class MealList {
	private List<Meal> economyMenu = new ArrayList<>();
	private List<Meal> vipMenu = new ArrayList<>();
	
	
	private Meal meal1= new Meal("normal beef", 200);
	private Meal meal2= new Meal("normal vegetable", 100);
	private Meal meal3= new Meal("normal sashimi", 180);
	private Meal meal4= new Meal("normal shushi", 150);

	
	private Meal meal5= new Meal("Kobe beef", 2000);
	private Meal meal6= new Meal("Garden vegetable", 500);
	private Meal meal7= new Meal("Kaiseki sashimi", 1800);
	private Meal meal8= new Meal("Koukyu shushi", 1500);

	
	public MealList(){
		economyMenu.add(meal1);
		economyMenu.add(meal2);
		economyMenu.add(meal3);
		economyMenu.add(meal4);

		vipMenu.add(meal5);
		vipMenu.add(meal6);
		vipMenu.add(meal7);
		vipMenu.add(meal8);

		
		
	}
	
	

}
