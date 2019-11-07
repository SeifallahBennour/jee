package implservices;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.print.attribute.standard.DateTimeAtCompleted;

import entities.Project;
import entities.Tache;
import entities.User;
import entities.Winners;
import interfservices.TacheServiceRemote;

@Stateless
@LocalBean
public class TacheService implements TacheServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;
	
	private String name ;
	private int max ;


	@Override
	public void ajouterTache(Tache tache) {
		
		em.persist(tache);
	

	}
	
	public List<Tache> toutetache()
	{
		return em.createQuery("from Tache").getResultList();
	}
	
	
	public void  deletetache(int id)
	{
		em.remove(em.find(Tache.class, id));
	}
	
	
	public List<Tache> getAllTaches()
	{
		List<Tache> taches =  em.createQuery("from Tache").getResultList();
		
		
		
		String nom="" ;
		
		String nomuser="";
		
		List<Tache> mymax = new ArrayList<>();
		Winners w = new Winners();
		
		
		
		
		for(Tache p : taches)
		{
			
			
			
			if(p.getpoints()>max) 
				
			{
				
				System.out.println("name"+name);
				nom = p.getProject().getNomProject();
				nomuser =p.getUser().getNom()+p.getUser().getPrenom();
				max=p.getPoints();
				name = p.getProject().getNomProject();
				
					
				
				
			}
			
		
			
		
		} //
			
		
		
		w.setMax(max);
		 w.setProjname(nom);
		w.setWinnername(nomuser);
		
		em.merge(w);
		
		
		
	 
	System.out.println("nom stocké :"+name);
		
		
		
		return em.createQuery("from Tache").getResultList();
	}
	
	public long getLeft(Tache t,TimeUnit timeUnit)
	{
		
		
		
			
				Date tawa = new Date();
			
				Long diffInMillies = t.getDateFin().getTime()-tawa.getTime();
		        

			        return  timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
			}
	
			public long getdiff(int tacheid,TimeUnit timeUnit)
			{
				Tache tache= em.find(Tache.class, tacheid);
				
				
					if(Objects.isNull(tache.getDate_fin_real()))
					{
						return 0 ;
						
					}
					
					
					else 
					{
						Long diffInMillies = tache.getDateFin().getTime() - tache.getDate_fin_real().getTime();
				        
						
					       int a = (int) timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
							System.out.println("****diff****"+a);
							tache.setPoints(a);

					        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
					} 
		
		
	}
	
	
	
	
	public void affecterTacheAProjet(int tacheid, int projectid,int userid)
	{
		Tache tacheManagedEntity = em.find(Tache.class, tacheid);
		Project projectManagedEntity = em.find(Project.class, projectid);
		User userManagedEntity = em.find(User.class, userid);
		tacheManagedEntity.setUser(userManagedEntity);
		tacheManagedEntity.setProject(projectManagedEntity);
	}


	@Override
	public void updateTask(int idval) 
	{
		Tache tache = em.find(Tache.class, idval) ;
		if(tache.getEnabled() == 1)
		{
		tache.setDate_fin_real(new Date());
		tache.setEnabled(0);
		}
		
		
		
	
	}
	
	@Override
	public int getenabled(int idtache) 
	{
		Tache tache = em.find(Tache.class, idtache) ;
		int val = tache.getEnabled() ;
		
		return val ;
		
	
	}
	


}
