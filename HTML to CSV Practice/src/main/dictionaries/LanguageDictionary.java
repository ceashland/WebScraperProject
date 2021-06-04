package main.dictionaries;

public class LanguageDictionary {
	
	public String DEFAULT_ALPHABET = "!abcdefghijklmnopqrstuvwxyz";
public String[][] dictonary;
public int[][] structureCode;
//boolean isNested = true;
//[] = section, [] = entry
public LanguageDictionary(String[][] dict) {
	this.dictonary = dict;
	
	this.structureCode = new int[DEFAULT_ALPHABET.length()][0];
	
	for(int i = 0; i < DEFAULT_ALPHABET.length(); i++) {
		if(dict[i] != null)
		this.structureCode[i] = new int[dict[i].length];
	}
	
	for(int i = 0; i < dict.length;i++) {
		char charIndex = ' ';
		if(dict[i] != null) {
		charIndex = dict[i][0].charAt(0);
		}
		if(dict[i] != null)
		for(int ix = 0; ix < dict[i].length; ix++) {
			if(dict[i][ix].contains(",")) {
				//this.DEFAULT_ALPHABET.index
				
				this.structureCode[i][ix] = Integer.parseInt((this.dictonary[i][ix].substring(this.dictonary[i][ix].length()-1)));
				this.dictonary[i][ix] = this.dictonary[i][ix].substring(0,(this.dictonary[i][ix].indexOf(',')));
			}else {
				this.structureCode[i][ix] = 1;
			}
			//System.out.println("Collection for [" + charIndex + "] at index " + ix + " = " + dict[i][ix]);
		}
		
	}
	
	outputDictionary(this);
}

public static void outputDictionary(LanguageDictionary dictionary) {
	
	int[][] dict = dictionary.structureCode;
	
	
	for(int i = 0; i < dictionary.dictonary.length; i++) {
	for(int ix = 0; ix < dict[i].length; ix++) {
		//if(dict[i][ix].contains(",")) {
			//this.DEFAULT_ALPHABET.index
			//this.structureCode[i][ix] = this.dictonary[i][ix].charAt(this.dictonary[i][ix].indexOf(",")+1);
		
		//System.out.println("Collection for [" + charIndex + "] at index " + ix + " = " + dict[i][ix]);
		System.out.println("entry " + dictionary.dictonary[i][ix] + " has structure code of: " + (dict[i][ix]));
		}
	}
}

public int findStructureCodeInDictonary(String word) {
	char sectionChar = word.toLowerCase().charAt(0);
	int sectionNum = -1;
	int sc = -1;
	for(int i = 0; i < DEFAULT_ALPHABET.length();i++) {
		if(DEFAULT_ALPHABET.charAt(i) == sectionChar) {
			sectionNum = i;
			break;
		}
	}
	
	if(sectionNum != -1)
	for(int i = 0; i < dictonary[sectionNum].length; i++) {
		if(dictonary[sectionNum][i].toLowerCase().equals(word)) {
			sc = structureCode[sectionNum][i];
			System.out.println("found it!");
		}
	}
	
	System.out.println("sc = " + sc);
	return sc;
}

public boolean isNested(int section, int index) {
	
	boolean result = false;
	
	return result;
}
}

