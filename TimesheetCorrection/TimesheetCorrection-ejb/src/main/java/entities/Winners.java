package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Winners
 *
 */
@Entity

public class Winners implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private int max;
	private String projname;
	private String winnername;
	private static final long serialVersionUID = 1L;

	public Winners() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public int getMax() {
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
	}   
	public String getProjname() {
		return this.projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}   
	public String getWinnername() {
		return this.winnername;
	}

	public void setWinnername(String winnername) {
		this.winnername = winnername;
	}
   
}
