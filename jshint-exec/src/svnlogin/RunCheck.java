package svnlogin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;  
import svnUtil.svnManager;


public class RunCheck {
	
	public void doCheck(String filename,String name) throws IOException{
		// 实例化svnManager
		svnManager svnMan = new svnManager();
		String Filename = filename.substring(3);
		String rname = name;
	try{
		
	Process p = null;
	p = Runtime.getRuntime().exec("cmd /c jshint D:\\"+Filename+" > d:\\result_" + rname + ".json");
	
	String ls_1;
	BufferedReader reader = new BufferedReader(new 
			InputStreamReader(p.getInputStream()));
	   while((ls_1 = reader.readLine()) != null)
	   { 
	    System.out.println(ls_1); 
	   }
	
	reader.close();
	p.destroy();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	finally{
		// 删除svn目录
		delFile(Filename);
	}
	}
	public void delFile(String Filename) throws IOException{
				// 删除文件夹方法
		try{
				String Str = "cmd /c rd/s/q D:\\"+Filename;
			    Runtime.getRuntime().exec(Str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
