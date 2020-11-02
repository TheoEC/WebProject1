package br.com.ifpb.gerenciador.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class alteraEmpresa
 */
@WebServlet("/alteraEmpresa")
public class alteraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alteraEmpresa() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando...");
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Date dataAbertura = null;
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (Exception e) {
		throw new ServletException(e);
		}
		System.out.println(id);
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listaEmpresas");
		
	}

}
