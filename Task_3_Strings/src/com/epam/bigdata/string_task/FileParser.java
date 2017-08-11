package com.epam.bigdata.string_task;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
		
	public String parsingFromFile(String path) {
		String inputText = "";
		try
		{
			File file = new File (path);
			
			if(file.exists())
			{
				try(Scanner scanner = new Scanner(file)){
					
					while (scanner.hasNext()) {						
						inputText += scanner.nextLine();
						
					}					
				}
			}		
			
			else{
				throw new FileNotFoundException("File not found");
			}
		}		
		catch (FileNotFoundException ex)
		{
			System.out.print(ex.getMessage());
			System.exit(0);
		}
		return inputText;	
	}
}
