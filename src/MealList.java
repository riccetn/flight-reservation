import java.util.ArrayList;
import java.util.List;

public class MealList {
	private List<Meal> economyMenu = new ArrayList<>();
	private List<Meal> vipMenu = new ArrayList<>();	
	
	
	public MealList(){
		economyMenu.add(new Meal(1, "normal beef", 200));
		economyMenu.add(new Meal(2, "normal vegetable", 100));
		economyMenu.add(new Meal(3, "normal sashimi", 180));
		economyMenu.add(new Meal(4, "normal shushi", 150));

		vipMenu.add(new Meal(1, "Kobe beef", 2000));
		vipMenu.add(new Meal(2, "Garden vegetable", 500));
		vipMenu.add(new Meal(3, "Kaiseki sashimi", 1800));
		vipMenu.add(new Meal(4, "Koukyu shushi", 1500));		
		
	}
	
// to finish 	
	public void printMenu(FareClass fareClass) {
		if (fareClass==FareClass.First){
		for(Meal meal : vipMenu) {
			System.out.println(meal);
		}} else {for(Meal meal : economyMenu) {
			System.out.println(meal);
		}
			
		}
	}
	
	
}
