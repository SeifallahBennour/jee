package interfservices;

import java.util.List;
import java.util.concurrent.TimeUnit;

import entities.Tache;
import entities.User;
import entities.Winners;

public interface TacheServiceRemote {
	
  public void ajouterTache(Tache tache);
  
  public void affecterTacheAProjet(int tacheid, int projectid,int userid) ;
  
  public List<Tache> getAllTaches();
  
  public void updateTask(int idval) ;
  
  public long getdiff(int tacheid,TimeUnit timeUnit);
  public int getenabled(int idtache) ;
  public List<Tache> toutetache();


}
