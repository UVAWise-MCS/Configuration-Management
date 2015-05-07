package CommandLine;

/*
 *
 *	Joseph LaCava
 *	04/16/2015
 *	Interpreter Class
 *
 *
 * This file provides the functionality
 * for reading the commands from the 
 * console.
 *
 ******************************************/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Date;

import jsonParsing.ExamParser;

public class Interpreter{
	
	private static final String ERROR_TO_MANY_ARGS = "You seem to have too many arguments.";
	private static final String ERROR_TO_FEW_ARGS = "You seem to have too few arguments.";
	private static final String ERROR_INVALID_OPTION = "That seems to be an invalid option. Please try again or try the 'help' command.";
	private static final String ERROR_IO = "There was an unknown IO error.";
	private static final String ERROR_LOADING_FILES = "There was an error trying to load the files specified.";
	private static final String ERROR_FILE_NOT_FOUND = "There was a file issue. It is likly the file was not found or the path was invalid.";
	private static final String ERROR_NO_HELP = "There was a critical error in reading the built in help file.";
	
	public Interpreter(String args[]){
		if (args.length <= 0) {
			try {
				printHelp();
			} catch (IOException | NullPointerException e) {
				System.out.println(ERROR_NO_HELP+" - "+e.getMessage());
			}
		} else if (args.length > 4) {
			System.out.println(ERROR_TO_MANY_ARGS);
		} else {
			switch(args[0].toLowerCase()){
				case "1":
				case "load":
					if (args.length <= 2){ 
						System.out.println(ERROR_TO_FEW_ARGS);
					} else if (args.length == 3) {
						try {
							loadFiles(args[1],args[2],null);
						} catch (IOException e1) {
							System.out.println(ERROR_LOADING_FILES);
						}
					} else if (args.length == 4) {
						try {
							loadFiles(args[1],args[2],args[3]);
						} catch (IOException e1) {
							System.out.println(ERROR_LOADING_FILES);
						}
					} else {
						System.out.println(ERROR_TO_MANY_ARGS);
					}
					break;
				case "2":
				case "help":
					try {
						printHelp();
					} catch (IOException | NullPointerException e) {
						System.out.println(ERROR_NO_HELP+" - "+e.getMessage());
					}
					break;
				case "3":
				case "exit":
					System.exit(0);
					break;
				default:
					System.out.println(ERROR_INVALID_OPTION);
					try {
						System.in.read();
					} catch (IOException e) {
						System.out.println(ERROR_IO+" - "+e.getMessage());
					}
					break;
			}
		}
	}


	private void loadFiles(String questionsFileLoc, String attributesFileLoc, String saveLoc) throws IOException {
		String[] temp = new String[2];
		temp[0] = questionsFileLoc;
		temp[1] = attributesFileLoc;
		String questionJson = "",attributeJson = "";
		Date date= new java.util.Date();
		String fileEnd = File.separator+"output-"+date.getTime()+".txt";
		if (saveLoc == null) saveLoc = Paths.get(".").toAbsolutePath().normalize().toString()+fileEnd;
		File outPutFile = new File(saveLoc);
		
		for(int i=0; i<2;i++){
			FileReader file = null;
			try {
				file = new FileReader(temp[i]);
			} catch (FileNotFoundException | NullPointerException e) {
				System.out.println(ERROR_FILE_NOT_FOUND+" - "+e.getMessage());
				return;
			}
			BufferedReader br = new BufferedReader(file);
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
	
		        while (line != null) {
		            sb.append(line);
		            sb.append(System.lineSeparator());
		            line = br.readLine();
		        }
		        if (i==0) questionJson = sb.toString();
		        else attributeJson = sb.toString();
			} finally {
		        br.close();
		    }
		}
		
		try {
			File output = new File(outPutFile.getParent()+File.separator+
					outPutFile.getName().replaceAll("[^a-zA-Z0-9.-]", "_"));
			
			PrintWriter out = new PrintWriter(output.getPath());
			out.print(generateExam(questionJson,attributeJson));
			out.close();
			System.out.println("Exam saved to: "+output.getPath());
		} catch (FileNotFoundException|NullPointerException e) {
			System.out.println(ERROR_FILE_NOT_FOUND+" - "+e.getMessage());
		}
	}

	private String generateExam(String questionJson, String attributeJson) throws NullPointerException {
		ExamParser parser = new ExamParser(questionJson, attributeJson);
		return parser.parse().toString();
	}

	private void printHelp() throws IOException, NullPointerException {
		BufferedReader reader = null;
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("CommandLine/help");
		reader = new BufferedReader(new InputStreamReader(in));

		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		if (reader != null) {
			reader.close();
		}
		
	}

}
