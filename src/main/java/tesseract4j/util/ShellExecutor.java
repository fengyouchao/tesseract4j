package tesseract4j.util;

import java.io.File;

/**
 * 
 * The interface <code>ShellExecutor</code> define a shell executor.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:06:41 PM 
 * @version 1.0
 */
public interface ShellExecutor {

	public final static String FILE_SEPARATOR = System.getProperty("file.separator");

	/**
	 * OS default encoding.
	 */
	public final static String SYS_ENCODING = System.getProperty("sun.jnu.encoding");

	/**
	 * OS name.
	 */
	public final static String OS_NAME = System.getProperty("os.name");

	/**
	 * User who execute this application
	 */
	public final static String USERNAME = System.getProperty("user.name");

	/**
	 * OS version
	 */
	public final static String OS_VERSION = System.getProperty("os.version");

	/**
	 * Execute a shell program.
	 * 
	 * @param cmd	command
	 * @return		the result of the execution.
	 */
	public ShellExecuteResult execute(String cmd);
	
	public void setWorkDir(File workDir);

}