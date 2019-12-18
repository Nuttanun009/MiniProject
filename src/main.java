import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select an option: \n"+
							"1 for CPU Testing\n"+
							"2 for Ram Testing\n"+
							"3 for Storage Testing\n"+
							"4 for all Testing\n"+
							"others for Exit\n");
		
		System.out.print("Your option: ");
		String option = sc.next();
		
		switch(option) {
		case "1" : CPU(); break;
		case "2" : RAM(); break;
		case "3" : Storage(); break;
		case "4" : CPU(); RAM(); Storage(); break;
					
		default : break;
		
		}

	}
//CPU tester
	static void CPU() {
		int row = 1000;
		int column = 1000;

		int a[][] = new int[row][column];
		int b[][] = new int[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				a[i][j] = (int) (Math.random() * 10);
				b[i][j] = (int) (Math.random() * 10);
			}
		}

		long start = System.currentTimeMillis();

		int val = 0;

		for (int row_a = 0; row_a < row; row_a++) {
			for (int column_b = 0; column_b < column; column_b++) {
				for (int k = 0; k < row; k++) {
					val += a[row_a][k] * b[k][column_b];
				}
				val = 0;
			}
		}

		long end = System.currentTimeMillis();
		double CPUTotle = (double) (end - start) / 1000d;
		System.out.format("Execution time is %.6f", CPUTotle);
		System.out.println(" seconds");

	}

	static void RAM() throws Exception {
		Vector v = new Vector();
		long start = System.currentTimeMillis();
		while (true) {
			try {
				byte b[] = new byte[2048576];
				v.add(b);
				Runtime rt = Runtime.getRuntime();
				System.out.println("free memory: " + rt.freeMemory());
			} catch (Exception e) {
				e.printStackTrace();
			} catch (OutOfMemoryError e) {
				break;
			}

//	      byte b[] = new byte[1073741824];

		}

		long end = System.currentTimeMillis();
		double RAMTotle = (double) (end - start) / 1000d;
		System.out.format("Execution time is %.6f", RAMTotle);
		System.out.println(" seconds");
	}

	static void Storage() throws Exception {
		// Accept a string
		String str = "File Handling in Java using " + " FileWriter and FileReader";

		// attach a file to FileWriter
		FileWriter fw = new FileWriter("output.txt");

		// read character wise from string and write
		// into FileWriter
		Random random = new Random();
		long startWrite = System.currentTimeMillis();
		for (int i = 0; i < 236955220; i++) {
			fw.write("02345790");
		}
		// close the file
		fw.close();
		long endWrite = System.currentTimeMillis();
		double writeTotle = (double) (endWrite - startWrite) / 1000d;
		System.out.format("Execution time writer is %.6f", writeTotle);
		System.out.println(" seconds");
		
		String text = "";
		long startRead = System.currentTimeMillis();
		try {
			text = new String(Files.readAllBytes(Paths.get("output.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
            e.printStackTrace();
        } 
		catch (OutOfMemoryError e) {
			
		}
		long endRead = System.currentTimeMillis();
		double readTotle = (double) (endRead - startRead) / 1000d;
		System.out.format("Execution time read is %.6f", readTotle);
		System.out.println(" seconds");


	}

}
