package mbeans;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Tache;
import entities.Winners;
import implservices.ProjectService;
import implservices.WinnerService;

@ManagedBean
public class WinnersBean 
{
	private int Id;
	private int max;
	private String projname;
	private String winnername;
	private List <Winners> winners ;
	
	@EJB
	WinnerService winnerservice ;
	
	public Winners allwinners() 
	{
		
		
		return winnerservice.allwinners().get(0);
		
	}
	

	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public String getWinnername() {
		return winnername;
	}
	public void setWinnername(String winnername) {
		this.winnername = winnername;
	}
	public List<Winners> getWinners() {
		return winners;
	}
	public void setWinners(List<Winners> winners) {
		this.winners = winners;
	}
	
	
	

}
