import classes;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
public static void main(String [] args)
{
	Scanner in = new Scanner(System.in);
	Person RA = new Person("test", "CS", 21, 0);
	Sort sort = new Sort();
	ArrayList<Resident> residents = new ArrayList<Resident>();

	while(true)
	{
		System.out.println("Please select your option: ");
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
			String name_in = in.next();

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
				int room_in = in.nextInt();

				char side_in = 'A';

				while(true)
				{
					System.out.printf("Side(A, B, C): ");
					side_in = in.next().charAt(0);
					
					if(side_in == 'A' || side_in == 'B' || side_in == 'C')
						break;
				}

				Resident res = new Resident(name_in, major_in, age_in, gender_in, room_in, side_in);
				residents.add(res);
				residents = sort.sort_res(residents);
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
