package tesseract4j.util;

/**
 * 
 * The class <code>ShellExecuteResult</code> represents shell
 * executed result.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:07:22 PM 
 * @version 1.0
 */
public class ShellExecuteResult {
	
	/**
	 * Current work space.
	 * 
	 * @see #setCurrentWorkDir(String)
	 * @see #getCurrentWorkDir()
	 */
	private String currentWorkDir;
	
	/**
	 * Output message.
	 * 
	 * @see #setResultMessage(String)
	 * @see #getResultMessage()
	 */
	private String resultMessage;
	
	/**
	 * Error message.
	 * 
	 * @see #setErrorMessage(String)
	 * @see #getErrorMessage()
	 */
	private String errorMessage;
	
	/**
	 * success flag.
	 * 
	 * @see #setSuccess(boolean)
	 * @see #isSuccess()
	 */
	private boolean success;
	
	/**
	 * Return <code>true</code> if command execute successfully.
	 * 
	 * @return <code>true</code> if command execute successfully.
	 */
	public boolean isSuccess() {
		return success;
	}

	public ShellExecuteResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getCurrentWorkDir() {
		return currentWorkDir;
	}

	public ShellExecuteResult setCurrentWorkDir(String currentWorkDir) {
		this.currentWorkDir = currentWorkDir;
		return this;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public ShellExecuteResult setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public ShellExecuteResult setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
}
