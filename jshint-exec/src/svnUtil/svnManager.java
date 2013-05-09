package svnUtil;

import java.io.File; 
import org.tmatesoft.svn.core.SVNDepth; 
import org.tmatesoft.svn.core.SVNException; 
import org.tmatesoft.svn.core.SVNURL; 
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl; 
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions; 
import org.tmatesoft.svn.core.wc.ISVNOptions; 
import org.tmatesoft.svn.core.wc.SVNClientManager; 
import org.tmatesoft.svn.core.wc.SVNRevision; 
import org.tmatesoft.svn.core.wc.SVNUpdateClient; 
import org.tmatesoft.svn.core.wc.SVNWCUtil;


public class svnManager {
	

	// 声明SVN客户端管理类
	private static SVNClientManager ourClientManager;
	private static svnManager svnInstance;
	

	// 返回一个文件目录名
	public String doCo(String Url,String name,String passwd,String sessionId) throws SVNException{
		
		synchronized(svnManager.class){
		// 初始化SVN协议
		SVNRepositoryFactoryImpl.setup();
		
		SVNURL repositoryURL = null;
		String url = Url;
		//String url ="http://svn.test.taobao.net/repos/test-svnrepos/autotest/base/mall/shopping-guide/projects/malldetail_v2.0/AutomanShare";
		try { 
			repositoryURL = SVNURL.parseURIEncoded(url);
			} 
		catch (SVNException e) {    
		}
		String Name = name;
		String pass = passwd;
		String Id = sessionId;
		ISVNOptions options = SVNWCUtil.createDefaultOptions(true);
		
		//实例化客户端管理类   
		ourClientManager = SVNClientManager.newInstance( (DefaultSVNOptions) options, Name, pass);
		
		File localDir = new File("D:/new_" + Id.substring(0, 10));
		if (localDir.exists()) {
			System.out.println("the destination directory '"+ localDir.getAbsolutePath() + "' already exists!");
			}         
		localDir.mkdirs();
		// 
		SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
		updateClient.setIgnoreExternals(false);
		// 执行co
		long workingVersion= updateClient.doCheckout(repositoryURL, localDir, SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY,false);
		System.out.println("已将svn版本号为："+workingVersion+" check out 到目录："+ localDir +" 中");
		return localDir.toString();
		

		}
	}
	
}
