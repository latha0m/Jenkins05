package genericutility;

import java.time.LocalDateTime;
import org.openqa.selenium.WebDriver;

public class JavaUtility {
	
	/**
	 * This method is used to capture the system date and time
	 * @return
	 */

	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
	
}
