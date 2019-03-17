import classes.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
	public static void main(String [] args)
	{
		Person RA = new Person("test", "CS", 0);
		ArrayList<Resident> residents = new ArrayList<Resident>();
		ArrayList<Goal> conflicts = new ArrayList<Goal>();
		ArrayList<Goal> archived_conflicts = new ArrayList<Goal>();
		ArrayList<Task> tasks = new ArrayList<Task>();

		while(true)
		{
			Scanner in = new Scanner(System.in);
			System.out.print("\n0: exit\n1: Manage People\n2: Manage Conflicts\n\nPlease select your option: ");
			int option = in.nextInt();

			if(option == 0)
			{
				in.close();
				System.exit(0);
			}

			else if(option == 1)
			{
				managePeople(in, RA, residents);
			}

			else if(option == 2)
			{
				manageConflicts(in, RA, residents, conflicts, archived_conflicts);
			}
		}
	}

	static public void managePeople(Scanner in, Person RA, ArrayList<Resident> residents)
	{
		while(true)
		{
			System.out.print("\n-1: exit\n0: Return\n1: Enter RA Info\n2: Add new Resident\n3: List Residents\n\nPlease select your option: ");
			int option = in.nextInt();

			if(option == -1)
			{
				in.close();
				System.exit(0);					
			}

			else if(option == 0)
			{
				return;
			}

			else if(option == 1 || option == 2)
			{
				System.out.println("Please enter information:");
				in.nextLine();

				System.out.printf("Name: ");
				String name_in = in.nextLine();

				int gender_in = 0;
				boolean gender_good = false;
				while(!gender_good)
				{
					gender_good = true;
					System.out.printf("Gender(m,f,n): ");
					char gender_buff = in.next().charAt(0);
					switch(gender_buff)
					{
						case 'm': gender_in = 0; break;
						case 'f': gender_in = 1; break;
						case 'n': gender_in = 2; break;
						default: gender_good = false; break;
					}
				}

				System.out.printf("Major: ");
				String major_in = in.next();

				if(option == 1)
				{
					Person buffer = new Person(name_in, major_in, gender_in);
					RA = buffer;
				}

				else if(option == 2)
				{
					System.out.printf("Room number: ");
					String room_in = in.next();

					Resident res = new Resident(name_in, major_in, gender_in, room_in);
					residents.add(res);
					Collections.sort(residents, (res1, res2) -> res1.getRoom().compareTo(res2.getRoom()));
				}
			}

			else if(option == 3)
			{
				for(Resident r : residents)
					System.out.printf("%s: %s\n", r.getRoom(), r.getName());
			}

		}	
	}

	static public void manageConflicts(Scanner in, Person RA, ArrayList<Resident> residents, ArrayList<Goal> conflicts, ArrayList<Goal> archived_conflicts)
	{
		while(true)
		{
			System.out.print("\n-1: exit\n0: Return\n1: List Ongoing Conflicts\n2: Expand Conflict\n3: Edit Conflict\n4: Add Conflict\n5: Show Archived Conflicts\n\nPlease select your option: ");
			int option = in.nextInt();

			if(option == -1)
			{
				in.close();
				System.exit(0);					
			}

			else if(option == 0)
			{
				return;
			}

			else if(option == 1)
			{
				int i = -1;
				for(Goal c : conflicts)
					System.out.printf("%d) %s: %s\n", ++i, c.getLocation(), c.getTitle());
			}

			else if(option == 2)
			{
				int pos = in.nextInt();
				System.out.printf("%s\n", conflicts.get(pos).toString());
			}

			else if(option == 4)
			{
				in.nextLine();
				System.out.printf("Enter title: ");
				String title_in = in.nextLine();

				System.out.printf("Enter location: ");
				String location_in = in.nextLine();

				System.out.printf("How severe is it? (1-5): ");
				int severity_in = in.nextInt();

				Conflict new_conflict = new Conflict(title_in, location_in, severity_in);

				int j = 0;
				for(Resident r : residents)
					System.out.printf("%d) %s: %s\n", j++, r.getRoom(), r.getName());
				
				System.out.printf("Who are the people involved? Add residents by number, insert -1 to stop: ");
				while(true)
				{
					int pos = in.nextInt();
					if(pos == -1)
						break;
					else
						new_conflict.addPeopleInvolved(residents.get(pos));
				}

				System.out.println("Enter description: ");
				String buffer = in.nextLine();
				new_conflict.setDescription(buffer);

				conflicts.add(new_conflict);
			}
		}
	}
}
