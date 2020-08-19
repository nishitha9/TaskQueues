package taskCreation;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.urlfetch.*;
import com.google.appengine.api.urlfetch.URLFetchServicePb.URLFetchResponse.Header;


@WebServlet("/urlFetch")
public class UrlFetch extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		URL url =new URL("https://www.google.co.in/");
	//URLFetchService.fetch(url);
		
		URLFetchService urlService= URLFetchServiceFactory.getURLFetchService();
		HTTPResponse Httpresponse =urlService.fetch(url);
		byte[] b=Httpresponse.getContent();
		/*for(byte i:b)
		{
		response.getWriter().println(b[i]);
		} */
		
		response.getWriter().println(b[89]);
		
		URL url_final=Httpresponse.getFinalUrl();
		System.out.println(url_final);
		
		List<HTTPHeader> header=Httpresponse.getHeaders();
		System.out.println(header);
	}
	


}
