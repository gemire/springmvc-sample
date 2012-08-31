package struts.example.util;

/**
 *
 * @author Srikanth Shenoy
 * @version $Revision:   $ $Date:   $
 */
public class ServiceLocator 
{
	private static ServiceLocator instance = new ServiceLocator();

	//private 	
	private ServiceLocator() 
	{ 
	}
	
	public static ServiceLocator getInstance()
	{
		return instance;
	}
	
	
}