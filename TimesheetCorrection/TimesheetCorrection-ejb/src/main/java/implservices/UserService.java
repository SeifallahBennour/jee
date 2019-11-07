package implservices;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Tache;
import entities.User;
import interfservices.UserServiceRemote;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote {
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;
	
	private int id ;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public void ajouterUser(User user) 
	{

		em.persist(user);
	}
	
	
	
	public void dologout(User user) 
	{

		user.setId(0);
	}
	
	
	public List<Tache> getTachesByUser(int id) 
	{
		User user = em.find(User.class, id);
		for (Tache t : user.getTaches()) {
			TacheService ts = new TacheService();
			if((Math.toIntExact(ts.getLeft(t, TimeUnit.DAYS)))<=0) {
				t.setDaysleft("No days left");
			}else {
			String s = String.valueOf(Math.toIntExact(ts.getLeft(t, TimeUnit.DAYS)));
			t.setDaysleft("You have "+s+" days left");
		}}
		return user.getTaches() ;
	}
	
	public User getLogin(String Login, String Mdp) {
		TypedQuery<User> query= em.createQuery("Select e from User e " + "where e.Login=:Login and "+"e.Mdp=:Mdp", User.class);
		query.setParameter("Login", Login);
		query.setParameter("Mdp", Mdp);
		User user = null;
		try{
			user = query.getSingleResult();
			id = user.getId();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}
		return user;
	}
	
	
	public void  deleteuser(int id)
	{
		em.remove(em.find(User.class, id));
	}

	
	public void Banniruser(int id)
	{
	User usr =	em.find(User.class, id) ;
		
	usr.setEnabled(0);
	}
	
	public void Allowuser(int id)
	{
	User usr =	em.find(User.class, id) ;
		
	usr.setEnabled(1);
	}
	
	
	public String getEtat(int id)
	{
	User usr =	em.find(User.class, id) ;
		
	if(usr.getEnabled() ==0)
	{
		return "Bloqué";
	}
	
	if(usr.getEnabled() ==1)
	{
		return "Autorisé";
	}
	
	return "" ;
	
	}
	

	
	public List<User> getUsers()
	{
		return em.createQuery("from User").getResultList();
	}
	

}
