package tesseract4j.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * The class <code>DosShellExecutor</code> represents a shell executor
 * that can execute DOS shell.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:07:09 PM 
 * @version 1.0
 */
public class DosShellExecutor extends AbstractShellExecutor{
	
	public File workDir = new File(System.getProperty("user.home"));
	
	/**
	 * @see tesseract4j.util.ShellExecutor#execute(java.lang.String)
	 */
	@Override
	public ShellExecuteResult execute(String cmd){
		if(cmd.startsWith("cd ")){
			String path = cmd.substring(3);
			System.out.println("path"+path);
			String fullPath = null;
			if(isAbsolutePath(path)){
				fullPath = path;
			}else{
				 fullPath = workDir.getAbsoluteFile()+FILE_SEPARATOR+path;
			}
			fullPath = simplifyPath(fullPath);
			System.out.println("Work Path:"+fullPath);
			File file = new File(fullPath);
			if(file.exists()&&file.isDirectory()){
				workDir = new File(fullPath);
				return new ShellExecuteResult().setCurrentWorkDir(workDir.getAbsolutePath()).setSuccess(true);
			}else{
				return new ShellExecuteResult().setCurrentWorkDir(workDir.getAbsolutePath()).setSuccess(false)
						.setErrorMessage("No such directory");
			}
		}
		try {
			
			Process ps = Runtime.getRuntime().exec(getConsoleProgram()+cmd,null, workDir);
			String resultMessage = loadStream(ps.getInputStream());
			String errorMessage = loadStream(ps.getErrorStream());
			ps.waitFor();
			int exitValue = ps.exitValue();
			return new ShellExecuteResult().setCurrentWorkDir(workDir.getAbsolutePath())
					.setErrorMessage(errorMessage).setResultMessage(resultMessage)
					.setSuccess(exitValue==0);
		
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
		return null;
	}
	
//	private static String getRootFile(){
//		switch (osName) {
//		case "Linux":
//			return "/";
//			
//		case "Windows 7":
//			return "C:\\";
//
//		default:
//			break;
//		}
//		return null;
//	}

	
	private static String getConsoleProgram(){
		switch (OS_NAME) {
		case "Linux":
//			return "/bin/sh -c ";
			return "";
			
		case "Windows 7":
			return "cmd.exe /c ";

		default:
			break;
		}
		return null;
	}
	
	
	static public void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DosShellExecutor shellExecutor = new DosShellExecutor();
		System.out.print(shellExecutor.getWorkDir().getAbsolutePath()+">");
		
		while(scanner.hasNext()){
			String cmd = scanner.nextLine();
			ShellExecuteResult result = shellExecutor.execute(cmd);
			if(result.isSuccess()){
				System.out.println(result.getResultMessage());
			}else{
				System.err.println(result.getErrorMessage());
			}
			System.out.print(result.getCurrentWorkDir()+">");
		}
	}

	// read an input-stream into a String
	static String loadStream(InputStream in) throws IOException {
//		in = new BufferedInputStream(in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,SYS_ENCODING));
		;
		StringBuffer buffer = new StringBuffer();
		String line = null;
		while( (line = reader.readLine()) != null ) {
			buffer.append(line+"\r");
		}
		return buffer.toString();
	}


	public void setWorkDir(File workDir) {
		this.workDir = workDir;
	}

	public File getWorkDir() {
		return workDir;
	}
	
	
	
	

} 