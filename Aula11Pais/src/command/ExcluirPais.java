package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class ExcluirPais implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulucao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		int id = -1;
		
		long populacao = 0;
		double area = 0;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		try {
			populacao = Long.parseLong(pPopulucao);
			area = Double.parseDouble(pArea);
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
		HttpSession session = request.getSession();
		ps.atualizar(pais);
		
		@SuppressWarnings("unchecked")
		ArrayList<Pais> lista = (ArrayList<Pais>) session .getAttribute("lista");
		
		int pos = busca(pais, lista);
		lista.remove(pos);
		lista.add(pos, pais);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("VisualizarPais.jsp");
		
		view.forward(request, response);
	}
	
	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pais.getId()) {
				return i;
			}
		}
		return -1;
	}

}
