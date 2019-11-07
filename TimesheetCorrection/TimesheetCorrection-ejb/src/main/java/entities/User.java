package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nom;
	private String Role;
	private String Prenom;
	private String Login;
	private String Mdp;
	@Column(nullable = true)
	private int Bonus;
	
	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	private int enabled ;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy = "user",fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List <Tache> taches ;
	
	

	public List<Tache> getTaches() {
		return taches;
	}


	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}


	public User() {
		super();
	}   
	
	
	public User(String nom, String role, String prenom, String login, String mdp, int bonus,int enabled) {
		
		Nom = nom;
		Role = role;
		Prenom = prenom;
		Login = login;
		Mdp = mdp;
		Bonus = bonus;
		this.enabled =enabled;
	}


	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}   
	public String getPrenom() {
		return this.Prenom;
	}

	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}   
	public String getLogin() {
		return this.Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}   
	public String getMdp() {
		return this.Mdp;
	}

	public void setMdp(String Mdp) {
		this.Mdp = Mdp;
	}   
	public int getBonus() {
		return this.Bonus;
	}

	public void setBonus(int Bonus) {
		this.Bonus = Bonus;
	}
   
}
