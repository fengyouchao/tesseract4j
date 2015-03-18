package tesseract4j.util;

/**
 * 
 * The interface <code>CommandExecutor</code> represents a command
 * executor.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:07:03 PM 
 * @version 1.0
 */
public interface CommandExecutor {
	
	boolean canHandle(String cmd);
	
	ShellExecuteResult execute(String cmd);

}
