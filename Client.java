import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
  
public class Client 
{
    public static void main(String[] args)
    {
  	HotelBookingService s;
        try {
            // Create an remote object with the same name
            // Cast the lookup result to the interface
            s = (HotelBookingService)Naming.lookup("rmi://localhost/HotelBooking");
  
            // Call the method for the results
		if(args.length == 0)
		{	 
			System.out.println(s.runProgramDirections());
			//s.returnListOfRooms();
			//System.out.println(args[0] + args[1]);
		}
		else if((args[0].equals("list")) && (args[1].equals("Hotel")))
		{
			//hotelRooms room = new hotelRooms();
			for (int i = 0; i < s.returnListOfRooms().length; i++)
			{
				System.out.println(s.returnListOfRooms()[i]);
			}
		}
		else if(args[0].equals("book"))
		{

			String[] passArgs = new String[5];
			for(int i = 0; i < args.length; i++)
			{
				passArgs[i] = args[i];
			}
			String[] ask = {"Do you want to book the available rooms??"};
			//System.out.println(ask);
			String[] answer = s.bookRooms(passArgs);
			//System.out.println(answer[0]);
			String[] finalAnswer = new String[2];
			String respond;			

			if(answer.length == 1)
			{
				//System.out.println("HI");
				Scanner in = new Scanner(System.in);
				respond = in.nextLine();
				//System.out.println(respond);
				if(respond.equals("Yes"))
				{
					passArgs[4] = "Yes"; 
					/*for (int i = 0; i < passArgs.length; i++)
					{
						System.out.println(passArgs[i]);
					}*/
					finalAnswer = s.bookRooms(passArgs);
					for (int i = 0; i < finalAnswer.length; i++)
					{
						System.out.println(finalAnswer[i]);
					}
				}
				else
				{
					System.out.println("Bye");
					
				}
				
			}
			else
			{
				for (int i = 0; i < answer.length; i++)
				{
					System.out.println(answer[i]);
				}
			}


					
		}
		else
		{
		}	    



	}
	catch (Exception e) {
	   System.out.println("ERROR: " + e);
          }
    }
}
