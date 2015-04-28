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

public class cmd {
	public static void main(String[] args) {
		for (String s : args) {
			System.out.println(s);
		}
	}

}
