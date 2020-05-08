package record.learn.netty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHttpServlet extends HttpServlet  {
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String param = request.getParameter("param");
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<HTML>");
	        out.println("<HEAD><TITLE>test</TITLE></HEAD>");
	        out.println("<BODY>");
	        out.println("GET method, param:" + param);
	        out.println("</BODY>");
	        out.println("</HTML>");
	        out.flush();
	        out.close();
	        response.setStatus(200);
	    }

	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<HTML>");
	        out.println("<HEAD><TITLE>test</TITLE></HEAD>");
	        out.println("<BODY>");
	        out.println("POST method");
	        out.println("</BODY>");
	        out.println("</HTML>");
	        out.flush();
	        out.close();
	        response.setStatus(200);
	    }
}
