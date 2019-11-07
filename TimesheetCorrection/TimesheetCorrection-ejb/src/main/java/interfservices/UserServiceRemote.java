package interfservices;

import java.util.List;

import javax.ejb.Remote;

import entities.Tache;
import entities.User;

@Remote
public interface UserServiceRemote 
{
	public void ajouterUser(User user);
	public User getLogin(String Login, String Mdp);
	public List<User> getUsers();
	public List<Tache> getTachesByUser(int id) ;
	public void  deleteuser(int id);
	public void Banniruser(int id);
	public void Allowuser(int id);
	public String getEtat(int id);
}
