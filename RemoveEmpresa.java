package br.com.ifpb.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/removeEmpresa")
public class RemoveEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveEmpresa() {
        
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID);
		
		System.out.println("Empresa de ID = '" + id + "' sendo removida...");
		Banco banco = new Banco();
		banco.remove(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
