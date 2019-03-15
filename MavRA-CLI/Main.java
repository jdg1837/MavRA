import classes.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main{
public static void main(String [] args)
{
	Scanner in = new Scanner(System.in);
	Person RA = new Person("test", "CS", 21, 0);
	ArrayList<Resident> residents = new ArrayList<Resident>();

	while(true)
	{
		System.out.print("\n0: exit\n1: Enter RA Info\n2: Add new Resident\n3: List Residents\n\nPlease select your option: ");
		int option = in.nextInt();

		if(option == -1)
		{
			System.out.printf("RA information:\n\tName: %s\n\tGender: %s\n\tAge: %s\n\tMajor: %s\n", RA.return_name(), RA.return_gender(), RA.return_age(), RA.return_major());
		}

		else if(option == 0)
			System.exit(0);

		else if(option == 1 || option == 2)
		{
			System.out.println("Please enter information: \n");
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

			System.out.printf("Age: ");
			int age_in = in.nextInt();

			System.out.printf("Major: ");
			String major_in = in.next();

			if(option == 1)
			{
				Person buffer = new Person(name_in, major_in, age_in, gender_in);
				RA = buffer;
			}

			else if(option == 2)
			{
				System.out.printf("Room number: ");
				String room_in = in.next();

				Resident res = new Resident(name_in, major_in, age_in, gender_in, room_in);
				residents.add(res);
				Collections.sort(residents, (res1, res2) -> res1.return_room().compareTo(res2.return_room()));
			}
		}

		else if(option == 3)
		{
			for(Resident r : residents)
				System.out.printf("%s: %s\n", r.return_room(), r.return_name());
		}
	}	

}
}
