package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String NomProject;
	private Date DateDeb;
	private Date DateFin;
	private String Description;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy = "project",fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List <Tache> taches ;
	
	
	
	

	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public Project(String nomProject, Date dateDeb, Date dateFin, String description) {
		super();
		NomProject = nomProject;
		DateDeb = dateDeb;
		DateFin = dateFin;
		Description = description;
	}
	public Project(int id, String nomProject, Date dateDeb, Date dateFin, String description) {
		super();
		Id = id;
		NomProject = nomProject;
		DateDeb = dateDeb;
		DateFin = dateFin;
		Description = description;
	}
	public Project() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getNomProject() {
		return this.NomProject;
	}

	public void setNomProject(String NomProject) {
		this.NomProject = NomProject;
	}   
	public Date getDateDeb() {
		return this.DateDeb;
	}

	public void setDateDeb(Date DateDeb) {
		this.DateDeb = DateDeb;
	}   
	public Date getDateFin() {
		return this.DateFin;
	}

	public void setDateFin(Date DateFin) {
		this.DateFin = DateFin;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
