import java.rmi.Naming;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;

public class Server //extends UnicastRemoteObject implements HotelBookingService
{
	//constructor
	public Server()
	{
		try{
			HotelBookingService s = new HotelBookingServiceImpl(); //Create object reference to the interface
			Naming.rebind("rmi://localhost/HotelBooking", s);
		   }
		   catch (Exception e)
		   {
			System.out.println("ERROR: " + e);
		   }
	}

	public static void main(String[] atgs)
	{
		new Server();
	}

}
