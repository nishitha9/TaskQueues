package taskCreation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try
		{
		
	
		String email_id=request.getParameter("emailid");
		if(email_id==null) throw new Exception("Invalid email id");
		Queue queue=QueueFactory.getQueue("email-subscription");
		queue.add(TaskOptions.Builder.withUrl("/SignupServlet").param("emailid", email_id));
		out.println("Emailid Registered Successfully");
	//	queue.deleteTask("/SignupServlet"); 
	//	queue.purge(); -> to delete all tasks frm the queue.
		//delete queue from xml file and cloud console.
	
		Queue queue1=QueueFactory.getDefaultQueue();
		queue1.add(TaskOptions.Builder.withUrl("/getMethod"));
		
	
	}catch(Exception e)
		{
			out.println(e.getMessage());
		}


}
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request,response);
	} 
	
}
