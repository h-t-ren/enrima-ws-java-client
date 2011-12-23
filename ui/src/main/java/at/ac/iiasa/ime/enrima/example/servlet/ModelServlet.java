package at.ac.iiasa.ime.enrima.example.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.ac.iiasa.ime.enrima.example.client.ModelClient;
import at.ac.iiasa.ime.enrima.example.client.jaxws.Model;

public class ModelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ModelClient modelClient= new ModelClient();;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int idModel = getIntegerValue(request,"id");
		Model model = modelClient.getById(idModel);
		request.setAttribute("model", model);
		RequestDispatcher dispatcher = request.getRequestDispatcher("model.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String saveAction=request.getParameter("_save");
		if(saveAction!=null)
		{
			int idModel = getIntegerValue(request,"idModel");
			Model model = modelClient.getById(idModel);
			model.setName(request.getParameter("name"));
			model.setVersion(request.getParameter("version"));
			model.setDescription(request.getParameter("description"));
			modelClient.save(model);
		}
		response.sendRedirect("modelList");
	}

	@Override
	public String getServletInfo() {
		return "Model";
	}
	
	private int getIntegerValue(HttpServletRequest request,String paraName)
	{
		String s_value = request.getParameter(paraName);
		return Integer.parseInt(s_value);
	}
}
