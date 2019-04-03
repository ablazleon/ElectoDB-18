package es.upm.dit.isst.webLab.dao;

import java.util.List;
import es.upm.dit.isst.webLab.model.Professor;

public interface ProfessorDAO {
	
	public void createProfessor(Professor professor);
	
	public Professor readProfessor(String email);
	
	public void updateProfessor(Professor professor);
	
	public void deleteProfessor(Professor professor);
	
	public List<Professor> readAllProfessor();
}
