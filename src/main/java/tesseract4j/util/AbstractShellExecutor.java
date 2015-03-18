package tesseract4j.util;

import java.io.File;

/**
 * 
 * The class <code>AbstractShellExcutor</code> is a abstract shell executor.
 * 
 * @author Youchao Feng
 * @date  Mar 5, 2015 2:06:49 PM 
 * @version 1.0
 */
public abstract class AbstractShellExecutor implements ShellExecutor{
	
	private CommandExecutor commandExecutor;
	
	
	public static void main(String[] args){
		File[] rootFiles = File.listRoots();
		for (int i = 0; i < rootFiles.length; i++){
			System.out.println(rootFiles[i].getAbsolutePath());
		}
	}
	
	public char getFileSeparator(){
		if(isUnixOrLinux(OS_NAME)){
			return '/';
		}else{
			return '\\';
		}
	}
	
	protected boolean isAbsolutePath(String path){
		File[] rootFiles = File.listRoots();
		for (int i = 0; i < rootFiles.length; i++){
			if(path.startsWith(rootFiles[i].getAbsolutePath())){
				return true;
			}
		}
		return false;
	}
	
	
	protected  String simplifyPath(String path){
		if(path.contains("..")){
			for(int i=0;i<path.length();i++){
				char ch = path.charAt(i);
				if(ch=='.'&&i+1<path.length()&&path.charAt(i+1)=='.'){
					int count = 0;
					for(int j=i-1;j>0;j--){
						if(path.charAt(j)==getFileSeparator()){
							count++;
						}
						if(count==2){
							path = path.substring(0,j)+path.substring(i+2);
							path = simplifyPath(path);
							break;
						}
					}
				}
			}
		}
		return path;
	}
	
	protected boolean isUnixOrLinux(String osName) {
	  return osName.equals("Linux") || osName.equals("Mac OS X");
	}

	public CommandExecutor getCommandExecutor() {
		return commandExecutor;
	}

	public void setCommandExecutor(CommandExecutor commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

}
