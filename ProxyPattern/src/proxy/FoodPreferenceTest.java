package proxy;

import java.lang.reflect.*;
import java.util.*;

public class FoodPreferenceTest {
	
HashMap<String, FoodPreference> foodDB = new HashMap<String, FoodPreference>();
 	
	public static void main(String[] args) {
		FoodPreferenceTest test = new FoodPreferenceTest();
		test.infoFromDB();
	}
 
	public FoodPreferenceTest() {
		initializeDatabase();
	}

	public void infoFromDB() {
		FoodPreference preference = getNameFromDB("Priyanka Chopra"); 
		FoodPreference ownerProxy = getOwnerProxy(preference);
		System.out.println("Cusotmer name is " + ownerProxy.getName());
		ownerProxy.setCuisinePreference("Indian Food");
		System.out.println("Cuisine Preference set from owner proxy " + ownerProxy.getCuisinePreference());
		try {
			ownerProxy.setSpiceLevel(4);
			System.out.println("Spice level set from owner proxy " + ownerProxy.getSpiceLevel());
		} catch (Exception e) {
			System.out.println("Can't set spice level from owner proxy");
		}
	
		preference = getNameFromDB("Nick Jonas"); 
		FoodPreference nonOwnerProxy = getNonOwnerProxy(preference);
		System.out.println("Customer Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setCuisinePreference("Sushi");
			System.out.println("Cuisine Preference set from non owner proxy " + nonOwnerProxy.getCuisinePreference());
		} catch (Exception e) {
			System.out.println("Can't set cuisine from non owner proxy");
		}
		nonOwnerProxy.setSpiceLevel(8);
		System.out.println("Spice level set from non owner proxy " + nonOwnerProxy.getSpiceLevel());
	}

	FoodPreference getOwnerProxy(FoodPreference preference) {
 		
        return (FoodPreference) Proxy.newProxyInstance( 
            	preference.getClass().getClassLoader(),
            	preference.getClass().getInterfaces(),
                new OwnerProxy(preference));
	}

	FoodPreference getNonOwnerProxy(FoodPreference preference) {
		
        return (FoodPreference) Proxy.newProxyInstance(
            	preference.getClass().getClassLoader(),
            	preference.getClass().getInterfaces(),
                new NonOwnerProxy(preference));
	}

	FoodPreference getNameFromDB(String name) {
		return (FoodPreference)foodDB.get(name);
	}

	void initializeDatabase() {
		FoodPreference cust1 = new FoodPreferenceImpl();
		cust1.setName("Priyanka Chopra");
		cust1.setCuisinePreference("Indian Food");
		cust1.setSpiceLevel(4);
		foodDB.put(cust1.getName(), cust1);

		FoodPreference cust2 = new FoodPreferenceImpl();
		cust2.setName("Nick Jonas");
		cust2.setCuisinePreference("Sushi");
		cust2.setSpiceLevel(8);
		foodDB.put(cust2.getName(), cust2);
	}

}
