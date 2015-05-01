package CommandLine;

/*
 *
 *	Joseph LaCava
 *	04/16/2015
 *	Commandline Class
 *
 *
 * This file provides the functionality
 * for reading the commands from the 
 * console.
 *
 ******************************************/

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class cmd{
	File exam = null;
	File examAttr = null;
	Desktop curDesk = null;
	static String option = null;

	public static void main(String[] args) throws IOException{

		while (option != "3" || option.toLowerCase() != "exit"){
			System.out.println("Please select an option from" +
					"on of the following:");
			option = new String (printMenu());

			if (option == "1" || option.toLowerCase() == "load file"){
				grabFile();
			}
			else if (option == "2" || option.toLowerCase() == "help"){
				File help = new File("help.md");
				FileInputStream fis = new FileInputStream(help);
				byte[] data = new byte[(int) help.length()];
				fis.read(data);
				fis.close();

				String str = new String(data, "UTF-8");
				System.out.print(str);
			}

		}
		System.exit(0);
	}

	public static String printMenu(){

		Scanner in = new Scanner(System.in);
		String read = new String();

		System.out.println("1. Load File");
		System.out.println("2. Help");
		System.out.println("3. Exit");

		return read = in.nextLine();

	}

	private static String grabFile() throws FileNotFoundException, IOException{

		Scanner in = new Scanner(System.in);
		File file = new File(in.nextLine());

		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
		}
		return null;


	}

}
