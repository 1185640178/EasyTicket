

import java.io.IOException;
import java.util.Enumeration;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkProcess
 */
@WebServlet("/WorkProcess")
public class WorkProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
	}
	
	 private void downloadFileByOutputStream(HttpServletResponse response)
	            throws FileNotFoundException, IOException {
	        //1.��ȡҪ���ص��ļ��ľ���·��
	        String realPath = this.getServletContext().getRealPath("1.zip");
	        //2.��ȡҪ���ص��ļ���
	        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
	        //3.����content-disposition��Ӧͷ��������������ص���ʽ���ļ�
	        response.setHeader("content-disposition", "attachment;filename="+fileName);
	        //4.��ȡҪ���ص��ļ�������
	        InputStream in = new FileInputStream(realPath);
	        int len = 0;
	        //5.�������ݻ�����
	        byte[] buffer = new byte[1024];
	        //6.ͨ��response�����ȡOutputStream��
	        OutputStream out = response.getOutputStream();
	        //7.��FileInputStream��д�뵽buffer������
	        while ((len = in.read(buffer)) > 0) {
	        //8.ʹ��OutputStream��������������������ͻ��������
	            out.write(buffer,0,len);
	        }
	        in.close();
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
