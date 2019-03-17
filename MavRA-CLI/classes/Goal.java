package classes;
import java.util.ArrayList;

public class Goal extends Task
{
    private String location;
	private ArrayList<Person> people_involved = new ArrayList<Person>();

    public Goal(String title_in, String location_in)
    { 
        super(title_in);
        location = location_in;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public ArrayList<Person> getPeopleInvolved() 
    {
        return people_involved;
    }

    public void addPeopleInvolved(Person person) 
    {
        this.people_involved.add(person);
    }

    public void removePeopleInvolved(int entry) 
    {
        this.people_involved.remove(entry);
    }
}