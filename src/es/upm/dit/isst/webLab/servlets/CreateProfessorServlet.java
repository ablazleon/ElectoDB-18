package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.webLab.dao.ProfessorDAO;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.model.Professor;

@WebServlet("/CreateProfessorServlet")
public class CreateProfessorServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Recoger datos
		String name = req.getParameter( "name" );
		String password = req.getParameter( "password" );
		String email = req.getParameter( "email" );
		
		// Apply logic
		Professor professor = new Professor();
		professor.setName( name );
		professor.setEmail( email );
		professor.setPassword( new Sha256Hash( password ).toString() );
		
		// Persistir los datos modificados
		ProfessorDAO pdao = ProfessorDAOImplementation.getInstance();
		pdao.createProfessor( professor );
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	}
}
