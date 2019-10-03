package proxy;

public interface FoodPreference {
	String getName();
	String getCuisinePreference();
	int getSpiceLevel();
 
    void setName(String name);
    void setCuisinePreference(String cuisine);
    void setSpiceLevel(int level); 
}