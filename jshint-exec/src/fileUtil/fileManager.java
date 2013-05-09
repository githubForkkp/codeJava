package fileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class fileManager {
	
	static ArrayList<String> list = new ArrayList<String>();
	// 读文件
	 public ArrayList<String> readFileByLines(String fileName,String URL) {
		 	list.clear();
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        String url = URL.substring(5);
	        
	        try {
	        	InputStreamReader read = new InputStreamReader (new FileInputStream(file),"UTF-8");
	            reader = new BufferedReader(read);
	            String tempString = null;
	            int line = 1;
	          
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                //System.out.println("line " + line + ": " + tempString);
	            	if(tempString.indexOf("\\")!= -1){
	            		int index1 = tempString.indexOf("\\");
	            		int index2 = tempString.indexOf("\\",index1 + 1);
	            		list.add(url + tempString.substring(index2));
		            	line++;
	            	}else{
	            		list.add(tempString);
	            		line++;
	            	}
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e) {
	                }
	            }
	        }
			return list;
	    }

}
