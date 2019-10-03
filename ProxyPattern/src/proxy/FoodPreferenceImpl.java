package proxy;

public class FoodPreferenceImpl implements FoodPreference{
	
	String name;
	String cuisinePreference;
	int spiceLevel;
	int levelCount = 0;

	
	public String getName() {
		return name;
	}

	
	public String getCuisinePreference() {
		return cuisinePreference;
	}

	
	public int getSpiceLevel() {
		return spiceLevel;
	}

	
	public void setName(String name) {
		this.name = name;	
	}

	
	public void setCuisinePreference(String cuisinePreference) {
		this.cuisinePreference = cuisinePreference;
	}

	
	public void setSpiceLevel(int spiceLevel) {
		this.spiceLevel = spiceLevel;		
	}

}