import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputationInterface extends Remote {
		int add(int a,int b) throws RemoteException;
		int[] sort(int[] array) throws RemoteException;
}
