package proxy;

import java.lang.reflect.*;

public class OwnerProxy implements InvocationHandler{
	
	FoodPreference preference;
	
	public OwnerProxy(FoodPreference preference) {
		this.preference = preference;
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(preference, args);
   			} else if (method.getName().equals("setCuisinePreference")) {
				return method.invoke(preference, args);
			} else if (method.getName().startsWith("set")) {
				return method.invoke(preference, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}