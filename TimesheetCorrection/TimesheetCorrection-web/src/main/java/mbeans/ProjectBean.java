package mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Project;
import entities.Tache;
import implservices.ProjectService;

@ManagedBean
public class ProjectBean {

	private int Id;
	private String NomProject;
	private Date DateDeb;
	private Date DateFin;
	private String Description;
	private List <Project> projects ;
	
	private List <Tache> taches ;
	
	
	
	
	
	public List<Tache> getTaches() {
		return taches;
	}


	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}


	public ProjectService getProjectservice() {
		return projectservice;
	}


	public void setProjectservice(ProjectService projectservice) {
		this.projectservice = projectservice;
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@EJB
	ProjectService projectservice;
	
	public String ajouterproject(){
		
		String navigateTo="/allprojects?faces-redirect=true";
	
		
		projectservice.ajouterproject(new Project(NomProject, DateDeb, DateFin, Description));

		
		return navigateTo;
	}
	
	
	public List<Project> affprojects(){
			
		
		projects =projectservice.getAllProject() ;
		
		return projects ;

		
	
	}
	
	
	public List<Tache> Tachebyproject(int id)
	{
			
		
		taches =projectservice.Tachebyproject(id) ;
		
		return taches ;

		
	
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNomProject() {
		return NomProject;
	}
	public void setNomProject(String nomProject) {
		NomProject = nomProject;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	
}
