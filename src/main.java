
import java.util.Vector;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;


public class main {
	static double cpuScore;
	static double ramScore;
	static double storageWriteScoreTotal;
	static double storageReadScoreTotal;
	static double storageScoreTotal;
	public static String option;
	static String text;
	public static void main(String[] args) throws Exception {
		System.out.println("-----------------------------------------");
		do{		
			Scanner sc = new Scanner(System.in);
			System.out.println("Please select an option: \n"+
					"1 for CPU Testing\n"+
					"2 for Ram Testing\n"+
					"3 for Storage Testing\n"+
					"4 for all Testing\n"+
					"e for Exit\n");

			System.out.print("Your option: ");
			option = sc.next();
				switch(option) {
				case "1" : CPU(); break;
				case "2" : RAM(); break;
				case "3" : Storage(); break;
				case "4" : System.out.println("\n******************************************");
						   CPU(); RAM(); Storage(); Total(); 
						   System.out.println("******************************************"); break;	
				case "e" : break;
				default : System.out.println("//Please enter your option number again.//"); break;
			}
			System.out.println("\n------------------------------------------");
		}while(!option.equals("e")) ;
		System.out.println("|                  Exit                  |");
		System.out.println("------------------------------------------");
	}
	//CPU performance
	public static void CPU() {
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
	   double CPUTotleTime = (double) (end - start) / 1000d;
	   System.out.format("CPUExecution time is %.6f", CPUTotleTime);
	   System.out.println(" seconds");
	   
	   //Scoring
	   cpuScore = 50*100/CPUTotleTime;
	   System.out.println("Your cpu score is: " + (int)cpuScore);
	   
	   
	  }
	  
	 //ram performance
	 public static void RAM() throws Exception {
	   Vector v = new Vector();
	   long start = System.currentTimeMillis();
	   while (true) {
	    try {
	     byte b[] = new byte[2048576];
	     v.add(b);

	    } catch (Exception e) {
	     e.printStackTrace();
	    } catch (OutOfMemoryError e) {
	     break;
	    }



	   }

	   long end = System.currentTimeMillis();
	   double RAMTotleTime = (double) (end - start) / 1000d;
	   System.out.format("RamExecution time is %.6f", RAMTotleTime);
	   System.out.println(" seconds");
	   
	   //Scoring
	   ramScore = 50*100/RAMTotleTime;
	   System.out.println("Your ram score is: " + (int)ramScore);
	   
	   
	  }
	  
	  // w/r storage performance
	  public static void Storage() throws Exception {
	   

	   // Writing performance
	   FileWriter fw = new FileWriter("output.txt");

	   // write 5 GB of text file
	   long startWrite = System.currentTimeMillis();
	   for (int i = 0; i < 236955220; i++) {
	    fw.write("0123457901234567890123");
	   }
	   // close the file
	   fw.close();
	   
	   long endWrite = System.currentTimeMillis();
	   double writeTotleTime = (double) (endWrite - startWrite) / 1000d;
	   System.out.format("Execution time writing is %.6f", writeTotleTime);
	   System.out.println(" seconds");
	   
	   //Scoring
	   storageWriteScoreTotal = 50*100/writeTotleTime;
	   System.out.println("Your StorageWritting score is: " + (int)storageWriteScoreTotal);
	   
	   //reading performance
	   text = "";
	   long startRead = System.currentTimeMillis();
	   StringBuilder contentBuilder = new StringBuilder();
	   try(Stream<String> stream = Files.lines( Paths.get("output.txt"), StandardCharsets.UTF_8)) {
	    stream.forEach(s -> contentBuilder.append(s).append("\n"));

	    
	   } catch (IOException e) {
	    
	   }
	   catch (Exception e) {
	             
	         } 
	   catch (OutOfMemoryError e) {
	    
	   }
	   long endRead = System.currentTimeMillis();
	   double readTotleTime = (double) (endRead - startRead) / 1000d;
	   System.out.format("Execution time reading is %.6f", readTotleTime);
	   System.out.println(" seconds");
	   
	   //Scoring
	   storageReadScoreTotal = 50*100/readTotleTime;
	   System.out.println("Your StorageReading score is: " + (int)storageReadScoreTotal);
	   
	   //delete text file
	   File file = new File("output.txt"); 
	   file.delete();

	 }
	  	  
	  // Total score
	  public static void Total() {
		double Total = cpuScore + ramScore + storageWriteScoreTotal + storageReadScoreTotal;
		System.out.println();
		System.out.printf("Total: %.2f" , Total);
		System.out.println();
	 }

}
