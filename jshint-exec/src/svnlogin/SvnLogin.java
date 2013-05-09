package svnlogin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svnUtil.svnManager;
import svnlogin.RunCheck;
import fileUtil.fileManager;

/**
 * Servlet implementation class SvnLogin
 */
public class SvnLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvnLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		String URL = request.getParameter("url").trim();
		String username = request.getParameter("username").trim();
		String passwd = request.getParameter("password").trim();
		String filename ="";
		svnManager SVNMan = new svnManager();
		RunCheck run = new RunCheck();
		fileManager fileRead = new fileManager();
		
		// ִ��SVN���
		try {
			filename = SVNMan.doCo(URL, username, passwd, sessionId);
		} catch (Exception e) {
			run.delFile(filename);
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "svn��¼ʧ�ܣ������û��������룡");
			return;
		}
		// ִ�м��
		try {
			run.doCheck(filename,username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ��ȡ���
		String reName = "D:\\result_"+username+".json";
		ArrayList<String> reList = fileRead.readFileByLines(reName,URL);
		
		
		request.setAttribute("result", reList);
		
		// ת����ҳ��
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
