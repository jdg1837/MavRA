package classes;
import java.util.ArrayList;

public class Resident extends Person
{
	private String room;
	private ArrayList<String> info;
	private ArrayList<String> concerns;

    public Resident(String name_in, String major_in, int age_in, int gender_in, String room_in)
    { 
        super(name_in, major_in, age_in, gender_in); 
        room = room_in;
		info = new ArrayList<String>();
		concerns = new ArrayList<String>();
    } 

	public String return_room()
	{
		return room;
	}

	public ArrayList<String> return_info()
	{
		return info;
	}

	public ArrayList<String> return_concerns()
	{
		return concerns;
	}

	public void add_content(int list, String content)
	{
		switch(list)
		{
			case 0: info.add(content);
			case 1: concerns.add(content);
		}
	}

	public void edit_content(int list, int pos, String content)
	{
		if(pos < 0)
			System.out.printf("Position must be a postive integer\n");

		switch(list)
		{
			case 0: 
				if(pos >= info.size())
					System.out.printf("Value is out of range. Possible values: 0-%d", info.size()-1);
				else				
					info.add(pos, content);
			
			case 1: 
				if(pos >= concerns.size())
					System.out.printf("Value is out of range. Possible values: 0-%d", concerns.size()-1);
				else				
					concerns.add(pos, content);
		}
	}

	public void remove_content(int list, int pos)
	{
		if(pos < 0)
			System.out.printf("Position must be a positive integer\n");

		switch(list)
		{
			case 0: 
				if(pos >= info.size())
					System.out.printf("Value is out of range. Possible values: 0-%d", info.size()-1);
				else				
					info.remove(pos);
			
			case 1: 
				if(pos >= concerns.size())
					System.out.printf("Value is out of range. Possible values: 0-%d", concerns.size()-1);
				else				
					concerns.remove(pos);
		}
	}

}
