package javapp.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public interface Object {
	
	@SuppressWarnings("unchecked")
	public default <T extends Object> T copy(){
		try{
			Class<T> clazz = (Class<T>) getClass();
			T t = null;
			for(Constructor<?> ctor : clazz.getConstructors()){
				Class<?>[] parameterTypes = ctor.getParameterTypes();
				java.lang.Object[] nulls = new java.lang.Object[parameterTypes.length];
				for(int i = 0; i < nulls.length; i++){
					Class<?> parameterType = parameterTypes[i];
					if(parameterType == byte.class)				nulls[i] = 0;
					else if(parameterType == int.class)			nulls[i] = 0;
					else if(parameterType == char.class)		nulls[i] = '\0';
					else if(parameterType == float.class)		nulls[i] = 0.0f;
					else if(parameterType == double.class)		nulls[i] = 0.0;
					else if(parameterType == short.class)		nulls[i] = 0;
					else if(parameterType == long.class)		nulls[i] = 0L;
					else if(parameterType == boolean.class)		nulls[i] = false;					
					else										nulls[i] = null;
				}			
				t = (T) ctor.newInstance(nulls);
				if(t != null) break;
			}			
			for(Field field : clazz.getFields()){
				field.set(t, field.get(this));
			}			
			return t;
		} catch(InstantiationException 
				| IllegalAccessException 
				| IllegalArgumentException
				| InvocationTargetException exception){
			exception.printStackTrace();
			return null;
		}
	}
	
}
