package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisesService {
	
	PaisDAO dao;
	
	public PaisesService() {
		dao = new PaisDAO();
	}
	
	public ArrayList<Pais> listarPaises(){
		return dao.listarPais();
	}
	
	public ArrayList<Pais> listarPais(String chave) throws IOException{
		return dao.listar(chave);
	}

}
