package br.com.ifpb.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MostraEmpresaServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramID = request.getParameter("id");
		Integer id = Integer.valueOf(paramID);
		
		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaPeloId(id);
		
		System.out.println("Nome: " + emp.getNome());
		
		request.setAttribute("empresa", emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

}
