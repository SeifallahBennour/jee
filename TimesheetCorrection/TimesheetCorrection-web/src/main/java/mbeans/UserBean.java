package mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Tache;
import entities.User;
import implservices.UserService;

@ManagedBean
@SessionScoped
public class UserBean
{
	private int Id;
	private String Nom;
	private String Role;
	private String Prenom;
	private String Login;
	private String Mdp;
	private int Bonus;
	private User user;
	private String etat ;
	private boolean loggedIn ;
	
	private List<Tache> taches ;
	
	public User getUser() {
		return user;
	}

	public String getEtat(int id) 
	{
		
		return userservice.getEtat(id) ;	
				}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	@EJB
	UserService userservice ;
	
	
	
	public List<Tache> getTachesbyuser(int id)
	{
		System.out.println("MyuseruserId =" + id);
		taches = userservice.getTachesByUser(id) ;
		
		return taches ;
		
	}
	
	public String addUser()
	{
		String navigateTo="null";

		
		userservice.ajouterUser(new User(Nom, "Member", Prenom, Login, Mdp, 0,1));

		navigateTo = "/login?faces-redirect=true";
		return navigateTo;
	}
	
	
	
	public String addAdmin()
	{
		String navigateTo="null";

		
		userservice.ajouterUser(new User(Nom, "Admin", Prenom, Login, Mdp, 0,1));

		navigateTo = "/users?faces-redirect=true";
		return navigateTo;
	}
	
	
	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
		}

	
	
	
	public String doLogin(){
		String navigateTo="null";
		user=userservice.getLogin(Login, Mdp);
	    if (user !=null)
	    {
	    	
	    	Id=user.getId();
	    	loggedIn=true;
	    	
	    	
	    	
	    
		if (user.getRole().equals("Member") && (user.getEnabled()==1)){
			navigateTo="/mytasks?faces-redirect=true";
		}
		
		if (user.getRole().equals("Admin")){
			navigateTo="/tasks?faces-redirect=true";
		}
	    	
	    }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
	return navigateTo;
	}
	
	
	public List<User> getUsers()
	{
	return userservice.getUsers();
		
	}
	
	
	
	public void deleteuser(int id)
	{
	
		userservice.deleteuser(id);
	}
	
	
	
	public void Banniruser(int id)
	{
	
		userservice.Banniruser(id);
	}
	
	
	public void AllowUser(int id)
	{
	
		userservice.Allowuser(id);
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getMdp() {
		return Mdp;
	}

	public void setMdp(String mdp) {
		Mdp = mdp;
	}

	public int getBonus() {
		return Bonus;
	}

	public void setBonus(int bonus) {
		Bonus = bonus;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	
}
