import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class ComputationServer extends UnicastRemoteObject implements ComputationInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ComputationServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final int PORT_NUMBER = 8080;

	public static void main(String args[]) {

		try {
			Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
			registry.bind("computation", new ComputationServer());

			System.err.println("Server is Up and Running.....");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int[] sort(int[] array) throws RemoteException {
		// TODO Auto-generated method stub
		Arrays.sort(array);
		return array;
	}

}
