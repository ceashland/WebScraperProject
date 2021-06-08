package main.dictionaries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryReader {

	String DEFAULT_ALPHABET = "!abcdefghijklmnopqrstuvwxyz";
	int alphabetMode = -1;
	String filePath = "";
	String[] filePaths = null;
	
	public DictionaryReader(String filePath) {
		this.filePath = filePath;
	}
	
	public DictionaryReader(String[] filePaths) {
		this.filePaths = filePaths;
		
	}
	
	public String[][] outputDictionary() {
		String[][] output = null;
		char currentChar = DEFAULT_ALPHABET.charAt(0);
		if(alphabetMode == -1) {
		 output = new String[DEFAULT_ALPHABET.length()][];
		}
		File file = new File(filePath);
		ArrayList<String> ar = new ArrayList<String>();
		
		if(!filePath.isEmpty()) {
			try {
				Scanner scanner = new Scanner(file);
				//FileReader fr = new FileReader(file);
				
				while(scanner.hasNextLine()) {
					String line = scanner.nextLine();
					
					if(line.charAt(0) != currentChar ) {
						//for(int i = 0; i < DEFAULT_ALPHABET.length(); i++) {
							output[DEFAULT_ALPHABET.lastIndexOf(currentChar)] = ar.toArray(new String[ar.size()]);
							//}	
							ar.clear();
							currentChar = line.charAt(0);
							ar.add(line);
					}else {
					
					
					ar.add(line);
					}
				}
				
				if(!ar.isEmpty())
					output[DEFAULT_ALPHABET.lastIndexOf(ar.get(0).charAt(0))] = ar.toArray(new String[ar.size()]);
				
				scanner.close();
				
				for(int i = 0; i < output.length;i++) {
					char charIndex = ' ';
					if(output[i] != null) {
					charIndex = output[i][0].charAt(0);
					}
					if(output[i] != null)
					for(int ix = 0; ix < output[i].length; ix++) {
						System.out.println("Collection for [" + charIndex + "] at index " + ix + " = " + output[i][ix]);
					}
					
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}else if(filePaths == null){
			
		}
		
		return output;
	}
	
}
