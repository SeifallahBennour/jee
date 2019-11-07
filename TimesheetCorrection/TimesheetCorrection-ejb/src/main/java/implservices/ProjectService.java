package implservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Project;
import entities.Tache;
import entities.User;
import interfservices.ProjectServiceRemote;

@Stateless
@LocalBean
public class ProjectService implements ProjectServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em;
	@Override
	public void ajouterproject(Project Project) {
		// TODO Auto-generated method stub
		em.persist(Project);
	}
	@Override
	public void supprimerproject(int Id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Project.class,Id));
	}
	
	@Override
	public List<Project> getAllProject(){
	return em.createQuery("from Project").getResultList();
	}
	@Override
	public List<Tache> Tachebyproject(int id) 
	{
		Project project = em.find(Project.class, id) ;
		
		return project.getTaches();
		
		
	}
	


}
