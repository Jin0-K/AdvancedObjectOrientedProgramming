import java.util.Date;

public class FileInfo {
	private String name;
	private String type;
	private int size;
	private Date modifiedDate;
	
	//Constructor
	public FileInfo(String name, String type, int size, Date modified) {
		this.name = name;
		this.type = type;
		this.size = size;
		this.modifiedDate = modified;
	}
	
	//Methods
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getSize() {
		return size;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public String toString() {
		return "Name: " + name + "\n"
				+ "Type: " + type + "\n"
				+ "Size: " + size + "\n"
				+ "Modified Date: " + modifiedDate + "\n";
	}
}