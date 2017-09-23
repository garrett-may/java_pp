package javapp.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public interface Object {
		
	public static byte deepCopy(byte t) {
		return t;
	}
	
	public static int deepCopy(int t) {
		return t;
	}
	
	public static char deepCopy(char t) {
		return t;
	}
	
	public static float deepCopy(float t) {
		return t;
	}
	
	public static double deepCopy(double t) {
		return t;
	}
	
	public static short deepCopy(short t) {
		return t;
	}
	
	public static long deepCopy(long t) {
		return t;
	}
	
	public static boolean deepCopy(boolean t) {
		return t;
	}
	
	public static String deepCopy(String t) {
		StringBuilder builder = new StringBuilder("");
		for(char c : t.toCharArray()) {
			builder.append(c);
		}
		return builder.toString();
	}
	
	public static byte[] deepCopy(byte[] t) {
		byte[] newT = new byte[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
		
	public static int[] deepCopy(int[] t) {
		int[] newT = new int[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static char[] deepCopy(char[] t) {
		char[] newT = new char[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static float[] deepCopy(float[] t) {
		float[] newT = new float[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static double[] deepCopy(double[] t) {
		double[] newT = new double[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static short[] deepCopy(short[] t) {
		short[] newT = new short[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static long[] deepCopy(long[] t) {
		long[] newT = new long[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static boolean[] deepCopy(boolean[] t) {
		boolean[] newT = new boolean[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	public static String[] deepCopy(String[] t) {
		String[] newT = new String[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = deepCopy(t[i]);
		}
		return newT;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] deepCopy(Object[] t) {
		T[] newT = (T[]) new java.lang.Object[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = (T) deepCopy(t[i]);
		}
		return newT;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T deepCopy(T t) {
		try{
			Class<T> clazz = (Class<T>) t.getClass();
			if(clazz.isArray()){
				Class<?> componentType = clazz.getComponentType();
				if(componentType == byte.class)						return (T) deepCopy((byte[]) t);
				else if(componentType == int.class)					return (T) deepCopy((int[]) t);
				else if(componentType == char.class)				return (T) deepCopy((char[]) t);
				else if(componentType == float.class)				return (T) deepCopy((float[]) t);
				else if(componentType == double.class)				return (T) deepCopy((double[]) t);
				else if(componentType == short.class)				return (T) deepCopy((short[]) t);
				else if(componentType == long.class)				return (T) deepCopy((long[]) t);
				else if(componentType == boolean.class)				return (T) deepCopy((boolean[]) t);
				else if(componentType == String.class)				return (T) deepCopy((String[]) t);
				else												return (T) deepCopy((Object[]) t);
			}
			T newT = null;
			for(Constructor<?> ctor : clazz.getConstructors()){
				Class<?>[] parameterTypes = ctor.getParameterTypes();
				java.lang.Object[] nulls = new java.lang.Object[parameterTypes.length];
				for(int i = 0; i < nulls.length; i++){
					Class<?> parameterType = parameterTypes[i];
					if(parameterType == byte.class)						nulls[i] = 0;
					else if(parameterType == int.class)					nulls[i] = 0;
					else if(parameterType == char.class)				nulls[i] = '\0';
					else if(parameterType == float.class)				nulls[i] = 0.0f;
					else if(parameterType == double.class)				nulls[i] = 0.0;
					else if(parameterType == short.class)				nulls[i] = 0;
					else if(parameterType == long.class)				nulls[i] = 0L;
					else if(parameterType == boolean.class)				nulls[i] = false;	
					else if(parameterType == String.class)				nulls[i] = "";
					else if(parameterType.isArray()){
						Class<?> componentType = parameterType.getComponentType();
						Object[] objectArray = (Object[]) t;
						if(componentType == byte.class)						nulls[i] = new byte[objectArray.length];
						else if(componentType == int.class)					nulls[i] = new int[objectArray.length];
						else if(componentType == char.class)				nulls[i] = new char[objectArray.length];
						else if(componentType == float.class)				nulls[i] = new float[objectArray.length];
						else if(componentType == double.class)				nulls[i] = new double[objectArray.length];
						else if(componentType == short.class)				nulls[i] = new short[objectArray.length];
						else if(componentType == long.class)				nulls[i] = new long[objectArray.length];
						else if(componentType == boolean.class)				nulls[i] = new boolean[objectArray.length];
						else if(componentType == String.class)				nulls[i] = new String[objectArray.length];
						else												nulls[i] = new Object[objectArray.length];
					}
					else												nulls[i] = null;
				}			
				newT = (T) ctor.newInstance(nulls);
				if(newT != null) break;
			}			
			for(Field field : clazz.getDeclaredFields()){
				field.setAccessible(true);
				Class<?> fieldType = field.getType();
				System.out.println(fieldType);
				if(fieldType == byte.class)						field.set(newT, deepCopy((byte) field.get(t)));
				else if(fieldType == int.class)					field.set(newT, deepCopy((int) field.get(t)));
				else if(fieldType == char.class)				field.set(newT, deepCopy((char) field.get(t)));
				else if(fieldType == float.class)				field.set(newT, deepCopy((float) field.get(t)));
				else if(fieldType == double.class)				field.set(newT, deepCopy((double) field.get(t)));
				else if(fieldType == short.class)				field.set(newT, deepCopy((short) field.get(t)));
				else if(fieldType == long.class)				field.set(newT, deepCopy((long) field.get(t)));
				else if(fieldType == boolean.class)				field.set(newT, deepCopy((boolean) field.get(t)));
				else if(fieldType == String.class)				field.set(newT, deepCopy((String) field.get(t)));
				else if(fieldType.isArray()){	
					field.set(newT, deepCopy(fieldType.cast(field.get(t))));
				}
				else											field.set(newT, deepCopy(field.get(t)));
					
				field.setAccessible(false);
			}			
			return newT;
		} catch(InstantiationException 
				| IllegalAccessException 
				| IllegalArgumentException
				| InvocationTargetException exception){
			exception.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public default <T extends Object> T copy(){
		return (T) deepCopy(this);
	}
	
}
