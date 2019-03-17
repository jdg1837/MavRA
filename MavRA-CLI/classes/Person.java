package classes;

public class Person
{ 
	public String[] Gender = {"male", "female", "non-binary/unespecified"};
	
	private String name;
	private String major;
	private int age;
	private int gender;

	public Person(String name_in, String major_in, int gender_in)
	{
		name = name_in;
		major = major_in;
		gender = gender_in;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getMajor() 
	{
		return major;
	}

	public void setMajor(String major) 
	{
		this.major = major;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getGender() 
	{
		return Gender[gender];
	}

	public void setGender(int gender) 
	{
		this.gender = gender;
	}
}