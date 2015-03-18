package tesseract4j.util;

/**
 * 
 * The class <code>ShellExecutors</code> is a factory to create 
 * {@link ShellExecutor} instance.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:07:30 PM 
 * @version 1.0
 */
public abstract class ShellExecutors {
	
	/**
	 * Get a default {@link ShellExecutor} instance.
	 * <p>
	 * In windows, it will be {@link DosShellExecutor}</br>
	 * In Linux or Mac OS X, it will be {@link BashShellExecutor}
	 * </p>
	 * @return {@link ShellExecutor} instance.
	 */
	public static ShellExecutor newDefaultShellExecutor(){
		String osName = ShellExecutor.OS_NAME;
		if(osName.equals("Linux") || osName.equals("Mac OS X")){
			return new BashShellExecutor();
		}
		else if(osName.startsWith("Windows")){
			return new DosShellExecutor();
		}
		else{
			throw new RuntimeException("Sytem dose not supported");
		}
	}
}
