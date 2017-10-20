package arg.model;

public class Person {
	private String id;
	private String blood;
	private String height;
	private String weight;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Person(String id, String blood, String height, String weight) {
		super();
		this.id = id;
		this.blood = blood;
		this.height = height;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", blood=" + blood + ", height=" + height + ", weight=" + weight + "]";
	}
	
	public Person() {
		this("","","","");
	}
}
