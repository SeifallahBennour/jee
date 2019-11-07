package implservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;
import entities.Winners;
import interfservices.WinnerServiceRemote;

@Stateless
@LocalBean
public class WinnerService implements WinnerServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;

	@Override
	public List<Winners> allwinners() {
		
		return em.createQuery("from Winners w").getResultList();
	}
	
	

}
