package tesseract4j.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * The class <code>BashShellExecutor</code> represents a shell executor that
 * can execute bash shell.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:06:56 PM 
 * @version 1.0
 */
public class BashShellExecutor extends AbstractShellExecutor{

	private File workDir = new File(System.getProperty("user.home"));

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
//		if(getCommandExecutor().canHandle(cmd)){
//			return getCommandExecutor().execute(cmd);
//		}
		try {

			//						Process ps = Runtime.getRuntime().exec(getConsoleProgram()+cmd,null, workDir);

			List<String> cmds = new ArrayList<String>();
			cmds.add("sh");
			cmds.add("-c");
			cmds.add(cmd);
			//			cmds.add(System.getProperty("user.home"));
			ProcessBuilder pBuilder =new ProcessBuilder(cmds).directory(workDir);
			Process ps = pBuilder.start();
			//			Process ps = Runtime.getRuntime()
			String resultMessage = loadStream(ps.getInputStream());
			String errorMessage = loadStream(ps.getErrorStream());
			ps.waitFor();
			int exitValue = ps.exitValue();
			return new ShellExecuteResult().setCurrentWorkDir(workDir.getAbsolutePath())
					.setErrorMessage(errorMessage).setResultMessage(resultMessage)
					.setSuccess(exitValue == 0);

		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	static public void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		BashShellExecutor shellExecutor = new BashShellExecutor();
		System.out.print(ShellExecutor.USERNAME+"-"+shellExecutor.getWorkDir().getAbsolutePath()+"$:");

		while(scanner.hasNext()){
			String cmd = scanner.nextLine();
			ShellExecuteResult result = shellExecutor.execute(cmd);
			if(result.isSuccess()){
				System.out.println(result.getResultMessage());
			}else{
				System.err.println(result.getErrorMessage());
			}
			System.out.print(ShellExecutor.USERNAME+"-"+shellExecutor.getWorkDir().getAbsolutePath()+"$:");
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
			buffer.append(line+"\n");
		}
		return buffer.toString();
	}

	public File getWorkDir() {
		return workDir;
	}

	public void setWorkDir(File workDir) {
		this.workDir = workDir;
	}




} 