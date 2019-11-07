package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.print.DocFlavor.STRING;

/**
 * Entity implementation class for Entity: Tache
 *
 */
@Entity

public class Tache implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nom;
	private Date DateDeb;
	private Date DateFin;
	private Date Date_fin_real;
	private int enabled ;
	private int points ;
	@Transient
	private int max ;
	@Transient
	private String idprojmax ;
	@Transient
	private String idusmax ;
	private String daysleft;
	
	







	private static final long serialVersionUID = 1L;
	
	
	
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	
	public int getpoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points=points;
	}
	
	

	public Tache(String nom, Date dateDeb, Date dateFin, Date date_fin_real,int enabled) {
		super();
		Nom = nom;
		DateDeb = dateDeb;
		DateFin = dateFin;
	
		Date_fin_real = date_fin_real;
		this.enabled =enabled ;
	}

	


	



	@ManyToOne
     private Project project ;
	
	@ManyToOne
    private User user ;
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Tache(String nom, Date dateDeb, Date dateFin, Date date_fin_real) {
		super();
		Nom = nom;
		DateDeb = dateDeb;
		DateFin = dateFin;
		Date_fin_real = date_fin_real;
	}
	
	

	public Tache(int max, String idprojmax, String idusmax) {
		super();
		this.max = max;
		this.idprojmax = idprojmax;
		this.idusmax = idusmax;
	}
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
	public int getPoints() {
		return points;
	}
	public Tache() {
		super();
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
	public Date getDate_fin_real() {
		return this.Date_fin_real;
	}

	public void setDate_fin_real(Date Date_fin_real) {
		this.Date_fin_real = Date_fin_real;
	}
	public String getDaysleft() {
		return daysleft;
	}
	public void setDaysleft(String daysleft) {
		this.daysleft = daysleft;
	}
   
}
