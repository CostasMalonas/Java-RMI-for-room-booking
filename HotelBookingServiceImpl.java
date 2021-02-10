import java.util.Arrays;

public class HotelBookingServiceImpl extends java.rmi.server.UnicastRemoteObject
implements HotelBookingService 
{
	public String rooms[] = new String[5];
	public int numOfRooms[] = new int[]{30, 45, 25, 10, 5};
	public String typeOfRooms[] = new String[]{"A", "B", "C", "D", "E"};
	public int price[] = new int[]{50, 70, 80, 120, 150};

	public HotelBookingServiceImpl() throws java.rmi.RemoteException
	{
		super();
	}

	//Implement of the method runProgramDirections to return
	//the directions about how to run the programm
	public String runProgramDirections()
		throws java.rmi.RemoteException
	{
		String msg = "Java HRClient \n Java HRClient list <hostname> \n java HRClient book <hostname> <type> <number> <name> \n java HRClinet quests <hostname> \n javaHRClient cancel <hostname> <type> <number> <name>\n ";
		return msg;
	}

	//Return list of available rooms
	
	public String[] returnListOfRooms()
		throws java.rmi.RemoteException
	{

		for (int i = 0; i < numOfRooms.length; i++)
		{
			rooms[i] = " "+ String.valueOf(numOfRooms[i]) + " Rooms of type " + String.valueOf(typeOfRooms[i]) + " with price " + String.valueOf(price[i]) + " a night";  			
		}
		
		return rooms;
	} 

	//Book rooms and return success or failure message along with the price of the rooms. Also ask the client if he wants to book fewer rooms than he wanted.
	public String[] bookRooms(String[] passArgs)
		throws java.rmi.RemoteException
	{
		String type = passArgs[2]; //Type of rooms client wants
		int wantedRooms = Integer.parseInt(passArgs[3]); //Number of rooms client wants to book
		String name = passArgs[4]; //Name of client
		int availableRooms; //How many rooms are available
		int index;
		int p; //price of room
		int cost; //cost client has to cover to pay for the rooms 
			
		index = Arrays.binarySearch(typeOfRooms, type); //Find the index in the array of types
		p = price[index]; //Find the price of the room that client wants
		
		//When the method is called the seecond time if in the fourth position of args array is "Yes" then client books the remainding rooms
		if(passArgs[4].equals("Yes"))
		{
			
			cost = numOfRooms[index] * price[index];
			String[] ret = {"Success", String.valueOf(cost)};
			numOfRooms[index] = 0;
			return ret;
		}
		//If there is not enough rooms we ask the client if he wants to book as many rooms as there are available
		if((wantedRooms > numOfRooms[index]) && (numOfRooms[index] > 0))
		{
			String[] ask = {"Do you want to book the available rooms??"};
			return ask;	
		
		}else if(numOfRooms[index] == 0) //No available rooms
		{
			String[] fail = {"Sorry no rooms available"};
			return fail;	
		}else
		{
			numOfRooms[index] -= wantedRooms;
			cost = wantedRooms * p;
			String[] success = {"Succesful booking of rooms", String.valueOf(cost)};
			return success; 
		}

			

	}
}		

























