package mbeans;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import entities.Project;
import entities.Tache;
import entities.User;
import implservices.ProjectService;
import implservices.TacheService;
import implservices.UserService;

@ManagedBean
public class TacheBean 
{
	private int id;
	private String Nom;
	private Date DateDeb;
	private Date DateFin;
	private Date Date_fin_real;
	private Project project ;
	private int projectid;
	private int userid ;
	private int Difficulte ;
	private int enabled ;
	private int points ;
	
	
	private int max ;
	
	private String idprojmax ;
	
	private String idusmax ;
	
	private List<Tache> mymax ;

	
	
	
	
	
	

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getIdprojmax() {
		return idprojmax;
	}

	public void setIdprojmax(String idprojmax) {
		this.idprojmax = idprojmax;
	}

	public String getIdusmax() {
		return idusmax;
	}

	public void setIdusmax(String idusmax) {
		this.idusmax = idusmax;
	}

	public List<Tache> getMymax() {
		return mymax;
	}

	public void setMymax(List<Tache> mymax) {
		this.mymax = mymax;
	}

	public TacheService getTacheservice() {
		return tacheservice;
	}

	public void setTacheservice(TacheService tacheservice) {
		this.tacheservice = tacheservice;
	}

	public ProjectService getProjectservice() {
		return projectservice;
	}

	public void setProjectservice(ProjectService projectservice) {
		this.projectservice = projectservice;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getDifficulte() {
		return Difficulte;
	}

	public void setDifficulte(int difficulte) {
		Difficulte = difficulte;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	private int selectedtacheid ;
	
	private int selectedprojectid ;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSelectedtacheid() {
		return selectedtacheid;
	}

	public void setSelectedtacheid(int selectedtacheid) {
		this.selectedtacheid = selectedtacheid;
	}

	public int getSelectedprojectid() {
		return selectedprojectid;
	}

	public void setSelectedprojectid(int selectedprojectid) {
		this.selectedprojectid = selectedprojectid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	@EJB
	TacheService tacheservice ;
	
	@EJB
	ProjectService projectservice ;
	
	@EJB
	UserService userservice ;
	
	
	public String afftache(){
		String navigateTo ="/tasks?faces-redirect=true";
	    tacheservice.affecterTacheAProjet(id, selectedprojectid,userid);
		return navigateTo;
	}
	
	public String modifdatereal(int idv){
		String navigateTo="null";
	    tacheservice.updateTask(idv);
	  
        System.out.println("****** idddd"+idv);
		
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		 try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return navigateTo;
	}

	public int getdiff(int tacheid)
	{
		
		 int bar = Math.toIntExact(tacheservice.getdiff(tacheid,TimeUnit.DAYS));
		 
		 
		
		 
		 return bar ;
		
	}
	
	
	public List<Tache> toutetache() 
	{
		return tacheservice.toutetache();
	}
	
	
	
	public int getetat(int tacheid)
	{
		
		return tacheservice.getenabled(tacheid);
		
	}
	
	
	
	public void getAllTaches() {

		tacheservice.getAllTaches();
		
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		 try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
	}
	
	public void deletetache(int id) 
	{
	 tacheservice.deletetache(id);
	 
	 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	 try {
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	}
	
	public List<Project> getAllProjects() {
		return projectservice.getAllProject();
	}
	
	public List<User> getAllUsers() 
	{
		return userservice.getUsers();
		
	}
	
	public String ajouterTache()
	{
		String navigateTo="/tasks?faces-redirect=true";

		
		
		tacheservice.ajouterTache(new Tache( Nom,  DateDeb, DateFin, Date_fin_real,1));

		//navigateTo = "/login?faces-redirect=true";
	// navigateTo = "/pages/welcome?faces-redirect=true";
		return navigateTo;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Date getDateDeb() {
		return DateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		DateDeb = dateDeb;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public Date getDate_fin_real() {
		return Date_fin_real;
	}
	public void setDate_fin_real(Date date_fin_real) {
		Date_fin_real = date_fin_real;
	}
	
	

}
