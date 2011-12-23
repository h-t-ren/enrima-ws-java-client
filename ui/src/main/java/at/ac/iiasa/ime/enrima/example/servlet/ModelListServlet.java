package at.ac.iiasa.ime.enrima.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.ac.iiasa.ime.enrima.example.client.ModelClient;
import at.ac.iiasa.ime.enrima.example.client.jaxws.Model;


public class ModelListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ModelClient modelClient;


    protected void processRequest(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        modelClient = new ModelClient();
        List<Model> modelList = modelClient.getAll();
        request.setAttribute("modelList", modelList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("modelList.jsp");
        dispatcher.forward(request, response);
      
    }

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Model list";
    }
}
