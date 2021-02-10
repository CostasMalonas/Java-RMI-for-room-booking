
public interface HotelBookingService extends java.rmi.Remote
{
	public String runProgramDirections() throws java.rmi.RemoteException;
	public String[] returnListOfRooms() throws java.rmi.RemoteException;
	public String[] bookRooms(String[] passArgs) throws java.rmi.RemoteException;
}
