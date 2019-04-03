package es.upm.dit.isst.webLab.dao;

import java.util.List;
import es.upm.dit.isst.webLab.model.TFG;

public interface TFGDAO {

	public void createTFG( TFG tfg );

	public TFG readTFG( String email );

	public void updateTFG( TFG tfg );

	public void deleteTFG( TFG tfg );
    
	public List<TFG> readAllTFG();
	
}
