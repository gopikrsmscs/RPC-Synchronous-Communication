import java.rmi.Naming;
import java.util.Scanner;



public class ComputationClient {
	public static void main(String args[]) {
		try {

			System.out.println("****************** Client is Running*********************");
			ComputationInterface stub = (ComputationInterface) Naming.lookup("rmi://localhost:8080/computation");
			String operation = args[0];

			if (operation.equals("ADD")) {
				System.out.println("************** Performing Addition Operation. **************");
				int a  = Integer.parseInt(args[1]);
				int b = Integer.parseInt(args[2]);
				int result = stub.add(a, b);
		
				System.out.println("The Result for the Addition is :"+ result);

			} else if (operation.equals("SORT")) {
				int numberOfElements = Integer.parseInt(args[1]);
				System.out.println("************** Performing Sort Operation. **************");
				System.out.println("Enter " + numberOfElements+ " elements to Sort.");
				Scanner sc = new Scanner(System.in);
				int arr[] = new int[numberOfElements];
				for(int i=0;i<numberOfElements ;i++) {
					arr[i] = sc.nextInt();
				}
				int sortedArray[] = stub.sort(arr);
				System.out.print("The Sorted Array is :");
				for(int i=0;i<numberOfElements;i++) {
					System.out.print(" "+sortedArray[i]+" ");
				}
			} 

		} catch (Exception e) {
			System.err.println("File Client Exception : " + e.toString());
			e.printStackTrace();
		}
	}
}
