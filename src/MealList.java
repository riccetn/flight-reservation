import java.util.ArrayList;
import java.util.List;

public class MealList {
	private List<Meal> economyMenu = new ArrayList<>();
	private List<Meal> vipMenu = new ArrayList<>();	

	public MealList(){
		economyMenu.add(new Meal(1, "Normal beef", 200));
		economyMenu.add(new Meal(2, "Normal vegetable", 100));
		economyMenu.add(new Meal(3, "Normal sashimi", 180));
		economyMenu.add(new Meal(4, "Normal shushi", 150));
		economyMenu.add(new Meal(5, "No thanks", 0));

		vipMenu.add(new Meal(1, "Kobe beef", 2000));
		vipMenu.add(new Meal(2, "Garden vegetable", 500));
		vipMenu.add(new Meal(3, "Kaiseki sashimi", 1800));
		vipMenu.add(new Meal(4, "Koukyu shushi", 1500));		
		vipMenu.add(new Meal(5, "No thanks", 0));		
	}

	public void printMenu(FareClass fareClass) {
		if (fareClass == FareClass.First) {
			for (Meal meal : vipMenu) {
				System.out.println(meal);
			}
		} else {
			for (Meal meal : economyMenu) {
				System.out.println(meal);
			}

		}
	}

	public Meal getMeal(FareClass fareClass, int id) throws NoSuchMealException {
		switch(fareClass) {
			case First:
				if(id < 1 || id > vipMenu.size())
					throw new NoSuchMealException();
				return vipMenu.get(id-1);
			case Economy:
				if(id < 1 || id > economyMenu.size())
					throw new NoSuchMealException();
				return economyMenu.get(id-1);
			default:
				throw new AssertionError();
		}
	}
}
