package processing;

public class Timer {

	private static long initTime;
	private static long finalTime;
	private static long totalTime;
	
	public static void initTime()
	{
		initTime = System.currentTimeMillis();
	}
	public static void finalTime()
	{
		finalTime = System.currentTimeMillis();
	}
	public static long total()
	{
		return totalTime = finalTime - initTime;
	}
	
	public static void restart()
	{
		initTime = finalTime = totalTime = 0;
	}
	
	public static String result()
	{
		return "Finish in "+ total() +" ms";
	}
}
