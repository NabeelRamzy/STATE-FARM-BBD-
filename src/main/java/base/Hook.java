package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadProperties;
import static utils.IConstant.*;
public class Hook {
	
	BaseClass rootClass;
	ReadProperties readProperties = new ReadProperties();;
     
	@Before
	public void initBaseClass() {
	 rootClass = new BaseClass();
		rootClass.setUpDriver(readProperties.getProperty(BROWSER));
		
	}
	
	@After
	public void exitingDriven() {
		rootClass.tearUp();
	}
}
