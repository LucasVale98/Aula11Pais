package command;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command{

	public String pPopulucao;
	public String pArea;

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		pPopulucao = request.getParameter("populacao");
		pArea = request.getParameter("Area");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		Pais pais = new Pais();
		pais.setId(id);
		pais.setNome(pNome);
		pais.getPopulacao();
		pais.getArea();
		
		PaisService ps = new PaisService();
		RequestDispatcher view = null;
		
		pais = ps.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");
		
		view.forward(request, response);
		
	}

}
