package classes;

public class Person
{ 
	public String[] Gender = {"male", "female", "non-binary/unespecified"};
	
	private String name;
	private String major;
	private int age;
	private int gender;

	public Person(String name_in, String major_in, int age_in, int gender_in)
	{
		name = name_in;
		major = major_in;
		age = age_in;
		gender = gender_in;
	}

	public String return_name()
	{
		return name;
	}
	public String return_major()
	{
		return major;
	}
	public String return_age()
	{
		return Integer.toString(age);
	}
	public String return_gender()
	{
		return Gender[gender];
	}
} 
