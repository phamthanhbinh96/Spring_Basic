package springjdbc.model;

public class Student {
	//ID, Name, BirthOfDate, Gender.
	int ID;
	String name;
	String Gender; 
	String BirthOfDate;
	
	public Student(int ID, String name, String Gender, String BirthOfDate) {
        this.ID = ID;
        this.name = name;
        this.Gender = Gender;
        this.BirthOfDate = BirthOfDate;
    }
	
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getBirthOfDate() {
        return BirthOfDate;
    }

    public void setBirthOfDate(String BirthOfDate) {
        this.BirthOfDate = BirthOfDate;
    }
	
    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", name=" + name + ", Gender=" + Gender + ", BirthOfDate=" + BirthOfDate + '}';
    }


}
