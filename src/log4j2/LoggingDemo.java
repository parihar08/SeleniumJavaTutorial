package log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {
	
	private static final Logger log = LogManager.getLogger(LoggingDemo.class.getName());

	public static void main(String[] args) {
		log.trace("Trace message logged");
		log.debug("Debug message logged");
		log.info("Info message logged");
		log.error("Error message logged");
		log.fatal("Fatal message logged");
	}

}
