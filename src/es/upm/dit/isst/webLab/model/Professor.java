package es.upm.dit.isst.webLab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Professor implements Serializable {

	@Id 
	private String email;
	
	private String password;
	private String name;
	
	@OneToMany(mappedBy="advisor", fetch = FetchType.EAGER)
	private List<TFG> advisedTFGs;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TFG> getAdvisedTFGs() {
		return advisedTFGs;
	}

	public void setAdvisedTFGs(List<TFG> advisedTFGs) {
		this.advisedTFGs = advisedTFGs;
	} 
	
	

}
