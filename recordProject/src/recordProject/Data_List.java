package recordProject;
import java.io.Serializable;

public class Data_List implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String currentDate;
	private String Type;
	private String Name;
	private String NameType;
	private double Price;
	public void setNo(String currentDate) {this.currentDate = currentDate;}
	public void setType(String Type) {this.Type = Type;}
	public void setName(String Name) {this.Name = Name;}
	public void setNameType(String NameType) {this.NameType = NameType;}
	public void setPrice(double d) {this.Price = d;}
	public String toString() {return String.format("%s	%s	%s	%s	$%g", currentDate , Type , Name , NameType , Price);}
}