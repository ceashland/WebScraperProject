package main;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import architexture.Tag;
import gfx.frame.Frame;
import main.dictionaries.DictionaryReader;
import main.dictionaries.LanguageDictionary;

import java.net.MalformedURLException;
public class Main {

	public static void main(String[] args) throws IOException{
		boolean testing = true;
		if(testing == true) {
			System.out.println("width/3 = " + (500/3) + "| height/3 = " + (300/3) );
			Frame frame = new Frame("Tested", 500,300);
		}else{
		DictionaryReader dr = new DictionaryReader("./dictionary/htmlDictonary.txt");
		String[][] htmlDict = dr.outputDictionary();
		LanguageDictionary ld = new LanguageDictionary(htmlDict);
		
		//for(int i = 0; i < htmlDict.length; i++) {
			//System.out.println(htmlDict[i]);
		//}
		
		//I just got rid of a line that has a weird class to look for. Crazy right?!
		
		
		//Code comes accross a "<" without the quotes and the tag type is totally different
		boolean isEncapsulatingTag = false;
		
		//Code comes accross a ">" without quotes
		boolean isOpeningTag = false;
		
		// code comes accross "<" without the quotes
 		boolean isReadingTag = false;
 		
		// code comes accross a ="<value>" while isReadingTag is true;
		boolean isReadingAttribute = false;
		
		String tagType = "";
		String tagValue = "";
		ArrayList<String> attributeName;
		ArrayList<String> attributeValue;
		
		
		
		int tabCount = 0;
		int tabMarker = 0;
		String site = "https://www.google.com";//https://www.indeed.com/viewjob?cmp=El-Hogar-Community-Services&t=Administrative+Assistant&jk=42310489837d1188&sjdu=QwrRXKrqZ3CNX5W-O9jEvcD9A2--9riq-7sA7JLcQXPJQ06vzH2zhtCREOgeKB3-epCFhUgtF4h1LQPStbU7lnDyNyfdhx64XG2UkQVjfbg&tk=1eukkars3nq1a800&adid=5945611&ad=-6NYlbfkN0C-JuSQS1CacF0HjptwGahH1uXHgeSf5TGulbWbZELbsJVzoQnxNJyNAWyshxqCr_5WjN2EtSmRj667BOVA6SKtpmYbfPUbLZXI5uWxDVGoCp6T91hQxg5G_KcTLhkPElbxmpq_wOjgB7NFds3EO752v6fwgXUdvTf-aYTRqQkm9RpiB_ftyDD3cDTsLzv0g_s1ufIVOsvdXS3N9hQgx1R1v24Pk8xCi54224OqAC9atp_uOlxGLmgKyPJibjAIJphUw7I-jhXD--Q4jw6J7-gFHadLYIYJ7jZ4fuNun_ZAzBuvSOv4vhkXJ9yKH1oN5W6WIEiKeRkn3pGNuMTz-msw&pub=4a1b367933fd867b19b072952f68dceb&vjs=3";
		StringBuilder buffer;// = new StringBuilder();
		try{
			URL url = new URL(site);
			BufferedReader readr =  
		              new BufferedReader(new InputStreamReader(url.openStream())); 
		  
		            // Enter filename in which you want to download 
		            //BufferedWriter writer =  
		             // new BufferedWriter(new FileWriter("Download.html")); 
		              
		            // read each line from stream till end 
		            String line; 
		            int lineNumber = 0;
		            String website = "";
		            while ((line = readr.readLine()) != null) { 
		            	
		            	//if(lineNumber > 0)
		            	website += line;
		            	
		            	//System.out.println(line);
		            	//lineNumber++;
		            	/*
		            	 * You're looking for
		            	 * <div id="jobDescriptionText" class="jobsearch-jobDescriptionText">
		            	 */
		            	//buffer = new StringBuilder(line);
		            	//for(int i =0; i < buffer.length();i++) {
		            		/*
		            		 * 
		            		 
		            		//if
		            		//readr.
		            		if(buffer.charAt(i) == '<') {
		            			if(!isReadingTag)
		            			isReadingTag = true;
		            			
		            			if(i+1 < buffer.length())
		            				if(buffer.charAt(i+1) == '/' && isReadingTag) {
		            					buffer.insert(i, '\n');
		            					i+=2;
		            					String tempTab = "";
		            					for(int tabIndex = 0; tabIndex < tabCount; tabIndex++) {
		            						tempTab = tempTab+'\t';
		            					}
		            					
		            				}else {
		            					//isOpeningTag = true;
		            					
		            					if(isEncapsulatingTag == true) {
		            					tabCount++;	
		            					}else {
		            					isEncapsulatingTag = true;
		            					}
		            				}
		            			//buffer.insert(i, '\n');//line.
		            		}else {
		            			if(buffer.charAt(i) == '>' & (isReadingTag)) {
		            				isEncapsulatingTag = true;
	            					buffer.insert(i+1, '\n');
	            					i+=2;
		            			}
		            		}
		            	}
		            	*/
		            	
		            	
		            	//System.out.println(line);
		            	//for(int i = 0; i < line.length(); i++) {
		            		
		            		
		            		
		            	//}
		            	/*
		            	if(line.startsWith("<") && line.endsWith(">"))
		            		if(containsMultipleTags(line) == true)
		            	
		            	if(line.contains("<") & line.contains(">")){
		            		System.out.println("Probably a tag, lineNumber = " + lineNumber);
		            	
		            		
		            	if(line.contains("=") && line.contains("\"")){
		            		int quoteCount = 0; 
		            		boolean attributeReading = false;
		            		boolean attributeNameReading = false;
		            		String tempString = "";
		            		ArrayList<String> tempTag = new ArrayList<String>();
		            		ArrayList<String> tempTagName = new ArrayList<String>();
		            		for(int i = 0; i < line.length();i++){
		            		if(line.charAt(i) == ' ' && attributeNameReading == false ){
		            			attributeNameReading = true;
		            			i = i+1;
		            			tempString = tempString + line.charAt(i);
		            		}else if(!(line.charAt(i) == '=') && attributeNameReading == true){
		            			tempString = tempString + line.charAt(i);
		            		}else if(attributeNameReading == true){
		            			tempTagName.add(tempString);
		            			tempString = "";
		            			attributeNameReading = false;
		            		}
		            		
		            		if(line.charAt(i) == '='){
		            			if(line.charAt(i+1) == '"'){
		            				attributeReading = true;
		            				i = i+2;
		            				tempString = tempString + line.charAt(i);
		            			}
		            			
		            		}else if(line.charAt(i) == '"' && attributeReading){
		            			tempTag.add(tempString);
		            			attributeReading = false;
		            			tempString = "";
		            			//quoteCount++;
		            		}else if(attributeReading == true){
		            			tempString = tempString + line.charAt(i);
		            		}
		            	}
		            		
		            		for(int i = 0; i < tempTag.size(); i++){
		            			System.out.println(tempTagName.get(i) + " = "+tempTag.get(i));
		            		}
		            		tempTag.clear();
		            	}
		            	
		            	
		            		
		            		
		            	
		            	}else{
		            		System.out.println("Probably a value, lineNumber = " + lineNumber);
		            	}
		            	*/
		            	lineNumber++;
		            	
		            	
		            	//writer.write(line + '\n'); 
		            } 
		  
		            readr.close(); 
		            //writer.close(); 
		            
		            System.out.println(website);
		            System.out.println("Successfully Downloaded."); 
		            
		            readWebsite(website,ld);
		        } 
		  
	//	}
		        // Exceptions 
		        catch (MalformedURLException mue) { 
		            System.out.println("Malformed URL Exception raised"); 
		        } 
		        catch (IOException ie) { 
		            System.out.println("IOException raised"); 
		       // } 
		    } 
		  
		
	}
	
}
	
	public static void findTag(String line) {
		
		//Does this line start with a < and end with a >
		if(line.startsWith("<") && line.endsWith(">")) {
			
		
		
			//Yes
				//How many tags are on the line
				switch(countTags(line)) {
				
				case -1:
					//Line is incomplete
					break;
				case 1:
					//There's only one tag, it's chill
					break;
				default:
					//Multiple tags
					break;
				
				}
				
			
		}
			//No
		else {
				//Does this line start with a < and NOT end with a '>'
					//Yes
						//How many opening < and closing > 
		
		
		}
		
	}
	public static Tag[] readMultipleTags(String line) {
		Tag[] tagArry = new Tag[0];
		ArrayList<Tag> tempCol = new ArrayList<Tag>();
		ArrayList<String> tagNameList = new ArrayList<String>();
		ArrayList<String> tagAttributeNameList = new ArrayList<String>();
		ArrayList<String> tagAttributeValueList = new ArrayList<String>();
		Tag activeParent = null;
		
		
		String tagsName = "";
		boolean readingTagName = false;
		
		String attributesName = "";
		boolean readingAttributeName = false;
		
		String attributeValue = "";
		boolean readingAttributeValue = false;
		byte quoteCount = 0;
		
		String tagValue = "";
		boolean readingValue = false;
		
		int activeTag = -1;
		
		for(int i = 0; i < line.length(); i++) {
			
			/*if(readingValue == true & readingTagName == false) {
				if(line.charAt(i) != '<') {
					tagValue = tagValue + line.charAt(i);
				}else if(line.charAt(i) == '<'){
					//time to submit!
					//Tag(String type, String value, String[] attributeName, String[] attributeValue)
					//if(!tagsName.trim().isBlank())
					System.out.println("Adding from beggining");
					tempCol.add(new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()])));
					tagAttributeNameList.clear();
					tagAttributeValueList.clear();
					tagsName = "";
					attributeValue = "";
					tagValue = "";
					//attributeName = "";
					readingAttributeName = false;
					readingAttributeValue = false;
					readingTagName = false;
					readingValue = false;
					//if(i+1 < line.length())
					//i++;
				}
					
			}else*/
			if(line.charAt(i) == '<' ) {
				readingTagName = true;
				readingValue = false;
				 i++;
			}/*else if(line.charAt(i) == '>') {
				readingValue = true;
				
			}*/
			
			if(readingTagName == true) {
				if(line.charAt(i) == ' '  ) {
					readingTagName = false;
					
					//tagNameList.add(tagsName);
					//tagsName = "";
					
					readingAttributeName = true;
					
					//System.out.println("Testing readingName");
				}else if(line.charAt(i) != '>'){
					tagsName = tagsName + line.charAt(i);
				}else {
					readingTagName = false;
					//Tag(String type, String value, String[] attributeName, String[] attributeValue)
					//System.out.println("Dead drop add");
					//if(i >= line.length())
					if(!tagsName.isBlank()) {
						System.out.println("Adding");
					tempCol.add(new Tag(tagsName, tagValue, null,null));
					activeParent = findParent(tagsName);
					//tagValue = "";
					//readingValue = false;
					//tagsName = "";
					if(activeParent != null) {
						System.out.println("found parent");
						activeParent.addChild(Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1));
						Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).setParent(activeParent);
						System.out.println("Tag = "+ Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).type + " Parent = "+ Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).parent.type);
					}else {
						activeParent = Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1);
					}
					}
					
					
					tagValue = "";
					readingValue = true;
					tagsName = "";
					
				}
			}
			
			if(readingAttributeName == true) {
				if(line.charAt(i) == '=') {
					
					readingAttributeName = false;
					tagAttributeNameList.add(attributesName.trim());
					attributesName = "";
					readingAttributeValue = true;
					//System.out.println("I read this stuffs");
					
				}else {
					attributesName = attributesName + line.charAt(i);
				}
			}else if(readingAttributeName == false && readingTagName == false && readingAttributeValue == false && line.charAt(i) == ' ') {
				readingAttributeName = true;
			}
			
			if(readingAttributeValue == true) {
				if(quoteCount == 0) {
					quoteCount += 1;
					
					i++;
					
				}else if(quoteCount == 1) {
					
					if(line.charAt(i) == '"') {
						
						readingAttributeValue = false;
						quoteCount = 0;
						tagAttributeValueList.add(attributeValue);
						attributeValue = "";
						
					}else {
						attributeValue = attributeValue + line.charAt(i);
						
					}
				}
			}
			
			if(i < line.length()) {
				
				//System.out.println("Never gonna get here");
				//time to submit!
				//Tag(String type, String value, String[] attributeName, String[] attributeValue)
				
				//if(!tagsName.trim().isBlank())
				//System.out.println("I found an ending!");
				if(i == line.length()-1 || (i+1 < line.length()-1 && line.charAt(i+1) == '<')) {
					//System.out.println("Adding from end");
					if(!tagsName.isBlank()) {
						System.out.println("Added tag properly");
				tempCol.add(new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()])));
				activeParent = findParent(tagsName);
				if(activeParent != null) {
					System.out.println("found parent 2");
					activeParent.addChild(tempCol.get(tempCol.size()-1));
					tempCol.get(tempCol.size()-1).setParent(activeParent);
				}
					}
					tagAttributeNameList.clear();
				tagAttributeValueList.clear();
				tagsName = "";
				attributeValue = "";
				tagValue = "";
				readingValue = false;
				//attributeName = "";
				readingAttributeName = false;
				readingAttributeValue = false;
				readingTagName = false;
				}
				if( i != line.length()-1) {
				readingValue = true;
				//System.out.println("Gonna start looking for value");
				}
				//if(i+1 < line.length())
				//i++;
			}
			
			if(readingValue == true) {
				if(line.charAt(i) != '<' & line.charAt(i) != '>') {
					tagValue = tagValue + line.charAt(i);
				}else if(line.charAt(i) == '<'){
					//System.out.println("Adding from end (Not line end tho)");
					//if(!tagsName.isBlank())
					tempCol.add(new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()])));
					activeParent = findParent(tagsName);
					if(activeParent != null) {
						System.out.println("found parent 3");
						activeParent.addChild(tempCol.get(tempCol.size()-1));
						tempCol.get(tempCol.size()-1).setParent(activeParent);
					}
					readingValue = false;
					tagAttributeNameList.clear();
					tagAttributeValueList.clear();
					tagsName = "";
					attributeValue = "";
					tagValue = "";
					//attributeName = "";
					readingAttributeName = false;
					readingAttributeValue = false;
					//readingTagName = true;
				}
			}
			
				
			
			
		}
		
		for(int i = 0; i < tagAttributeValueList.size(); i++) {
			System.out.println(tagAttributeValueList.get(i));	
		}
		
		/*
		//submit
		tagName = new String[tagNameList.size()];
		for(int i = 0; i < tagNameList.size(); i++) {
			tagName[i] = tagNameList.get(i);
			Array.set(tagName, i, tagNameList.get(i));
		}
		//tagName = tagNameList.toArray(tagName);
		
		tagAttributeName = new String[tagNameList.size()];
		for(int i = 0; i < tagAttributeValueList.size(); i++) {
			tagAttributeName[i] = tagAttributeNameList.get(i);
		}
		//tagAttributeName = tagAttributeNameList.toArray(tagAttributeName);
		
		tagAttributeValue = new String[tagAttributeValueList.size()];
		for(int i = 0; i < tagAttributeValueList.size(); i++) {
			tagAttributeValue[i] = tagAttributeValueList.get(i);
		}
		*/
		tagArry = new Tag[tempCol.size()];
		tagArry = tempCol.toArray(tagArry);
		
		return tagArry;
		//tagAttributeValue.
		//tagAttributeValue = tagAttributeValueList.toArray(tagAttributeValue);
		
	}
	public static Tag activeParent = null;
	public static Tag readTag(String line) {
		Tag tag = null;
		ArrayList<Tag> tempCol = new ArrayList<Tag>();
		ArrayList<String> tagNameList = new ArrayList<String>();
		ArrayList<String> tagAttributeNameList = new ArrayList<String>();
		ArrayList<String> tagAttributeValueList = new ArrayList<String>();
		//Tag activeParent = null;
		
		
		String tagsName = "";
		boolean readingTagName = false;
		
		String attributesName = "";
		boolean readingAttributeName = false;
		
		String attributeValue = "";
		boolean readingAttributeValue = false;
		byte quoteCount = 0;
		
		String tagValue = "";
		boolean readingValue = false;
		
		int activeTag = -1;
		
		for(int i = 0; i < line.length(); i++) {
			
			/*if(readingValue == true & readingTagName == false) {
				if(line.charAt(i) != '<') {
					tagValue = tagValue + line.charAt(i);
				}else if(line.charAt(i) == '<'){
					//time to submit!
					//Tag(String type, String value, String[] attributeName, String[] attributeValue)
					//if(!tagsName.trim().isBlank())
					System.out.println("Adding from beggining");
					tempCol.add(new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()])));
					tagAttributeNameList.clear();
					tagAttributeValueList.clear();
					tagsName = "";
					attributeValue = "";
					tagValue = "";
					//attributeName = "";
					readingAttributeName = false;
					readingAttributeValue = false;
					readingTagName = false;
					readingValue = false;
					//if(i+1 < line.length())
					//i++;
				}
					
			}else*/
			if(line.charAt(i) == '<' ) {
				readingTagName = true;
				readingValue = false;
				 i++;
			}/*else if(line.charAt(i) == '>') {
				readingValue = true;
				
			}*/
			
			if(readingTagName == true && readingValue == false) {
				if(line.charAt(i) == ' '  ) {
					readingTagName = false;
					
					//tagNameList.add(tagsName);
					//tagsName = "";
					
					readingAttributeName = true;
				}else if(line.charAt(i) != '>' ){
					tagsName = tagsName + line.charAt(i);
				}else if (readingValue == false) {
					readingTagName = false;
					//Tag(String type, String value, String[] attributeName, String[] attributeValue)
					//System.out.println("Dead drop add");
					
					if(!tagsName.isBlank()) {
					tag = new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()]));
					activeParent = findParent(tagsName);
					if(activeParent != null) {
						activeParent.addChild(tag);
						tag.setParent(activeParent);
						break;
					}
					}
					
					tagValue = "";
					readingValue = false;
					tagsName = "";
					
				}
			}
			//
			
			/*
			if(readingAttributeName == true && readingValue == false) {
				if(line.charAt(i) == '=') {
					
					readingAttributeName = false;
					tagAttributeNameList.add(attributesName);
					attributesName = "";
					readingAttributeValue = true;
					
				}else {
					attributesName = attributesName + line.charAt(i);
				}
			}
			
			if(readingAttributeValue == true  && readingValue == false) {
				if(quoteCount == 0) {
					quoteCount += 1;
					
					i++;
					
				}else if(quoteCount == 1) {
					
					if(line.charAt(i) == '"') {
						
						readingAttributeValue = false;
						quoteCount = 0;
						tagAttributeValueList.add(attributeValue);
						attributeValue = "";
						
					}else {
						attributeValue = attributeValue + line.charAt(i);
						
					}
				}
			}
			*/
			
			if(readingAttributeName == true) {
				if(line.charAt(i) == '=') {
					
					readingAttributeName = false;
					tagAttributeNameList.add(attributesName.trim());
					attributesName = "";
					readingAttributeValue = true;
					//System.out.println("I read this stuffs");
					
				}else {
					attributesName = attributesName + line.charAt(i);
				}
			}else if(readingAttributeName == false && readingTagName == false && readingAttributeValue == false && line.charAt(i) == ' ') {
				readingAttributeName = true;
			}
			
			if(readingAttributeValue == true) {
				if(quoteCount == 0) {
					quoteCount += 1;
					
					i++;
					
				}else if(quoteCount == 1) {
					
					if(line.charAt(i) == '"') {
						
						readingAttributeValue = false;
						quoteCount = 0;
						tagAttributeValueList.add(attributeValue);
						attributeValue = "";
						
					}else {
						attributeValue = attributeValue + line.charAt(i);
						
					}
				}
			}
			
			//
			
			
			
			
			
			
			if(line.charAt(i) == '>') {
				//time to submit!
				//Tag(String type, String value, String[] attributeName, String[] attributeValue)
				
				//if(!tagsName.trim().isBlank())
				//System.out.println("I found an ending!");
				if(i == line.length()-1 || (i+1 < line.length()-1 && line.charAt(i+1) == '<')) {
					//System.out.println("Adding from end");
					
					if(tagAttributeNameList.size() != tagAttributeValueList.size()) {
						String revision = line.replaceFirst(tagsName, "");
						revision = revision.replaceFirst("<", "");
						if(tagsName.contains("/"))
							revision.replaceFirst("/", "");
						revision = revision.replace(">", "");//.replaceFirst("/", "");
						//System.out.println("Revision = "+revision);
						ArrayList<String>[] correctedAr = Tag.correctAttributes(revision.trim());
						tagAttributeNameList =correctedAr[0];
						tagAttributeValueList = correctedAr[1];
					}
					
					if(!tagsName.isBlank())
				tag = new Tag(tagsName, tagValue.trim(), tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()]));
				
					
					
					tagAttributeNameList.clear();
				tagAttributeValueList.clear();
				activeParent = findParent(tagsName);
				
				if(activeParent != null) {
					activeParent.addChild(tag);
					tag.setParent(activeParent);
					
				}
				
				
				tagsName = "";
				attributeValue = "";
				tagValue = "";
				readingValue = false;
				//attributeName = "";
				readingAttributeName = false;
				readingAttributeValue = false;
				readingTagName = false;
				}
				if( i != line.length()-1) {
				//readingValue = true;
				//System.out.println("Gonna start looking for value");
				}
				//if(i+1 < line.length())
				//i++;
			}
		
		
	}
		return tag;
	}
	
	
	
	public static boolean containsMultipleTags(String line) {
		boolean result = false;
		
		int openCount = 0;
		int closeCount = 0;
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '>' )
				closeCount++;
			else if(line.charAt(i) == '<')
				openCount++;
		}
		
		if(openCount/closeCount == 1)
		result = true;
		
		
		return result;
	}
	
	
	public static int countTags(String line) {
		int tagCount = -1;
		int openCount = 0;
		int closeCount = 0;
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '>' )
				closeCount++;
			else if(line.charAt(i) == '<')
				openCount++;
		}
		
		
		if((float)openCount/(float)closeCount == 1.0)
			tagCount = openCount;
		
		
		
		return tagCount;
	}
	
	
	
	public static Tag findParent(String tagType) {
		
		//Tag activeParent = null;
		boolean foundClose = false;
		
		if(Tag.tempTagCollection != null && !Tag.tempTagCollection.isEmpty()&& Tag.tempTagCollection.size() > 1) {
		if(tagType.contains("/")) {
			//Will close the parentTag
			
			boolean foundParent = false;
			Tag recentParent = null;
			for(int i = Tag.tempTagCollection.size()-2; i >= 0; i-- ) {
				
				if(recentParent == null && Tag.tempTagCollection.get(i).isOpen == true) {
					recentParent = Tag.tempTagCollection.get(i); 
				}
				
				if(foundClose == false & Tag.tempTagCollection.get(i).type.equalsIgnoreCase(tagType.replace("/", ""))) {
					System.out.println("Case = " + tagType.replace("/", ""));
					//Tag.tempTagCollection.get(i).setOpen(false);
					//activeParent = Tag.tempTagCollection.get(i);
					foundClose = true;
					//foundParent = true;
				}
				if(foundClose == true & Tag.tempTagCollection.get(i).isOpen & Tag.tempTagCollection.get(i).type.equalsIgnoreCase(tagType.replace("/", ""))){
					if(Tag.tempTagCollection != null && !Tag.tempTagCollection.isEmpty() && Tag.tempTagCollection.size() > 1) {
					activeParent = Tag.tempTagCollection.get(i).getParent();
					Tag.tempTagCollection.get(i).setOpen(false);
					foundParent = true;
					}
				}
			}
			
			if(foundParent == false) {
				System.out.println("Case = " + tagType.replace("/", "") + " new parent should = " + recentParent.type);
				activeParent = recentParent;//Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).set
			}
			
		}else {
			//Will add to the parentTag
			
			
			if(Tag.tempTagCollection != null & !Tag.tempTagCollection.isEmpty()) {
				
				if(Tag.tempTagCollection.size()-2 <= 0 && Tag.tempTagCollection.size() > 0 & Tag.tempTagCollection.get(0).isOpen == true) {
					
					activeParent = Tag.tempTagCollection.get(0);
					System.out.println("Checking for entry");
				}else {
					System.out.println("Checking for entry 2");
			for(int i = Tag.tempTagCollection.size()-2; i > 0; i-- ) {
				if(Tag.tempTagCollection.get(i).isOpen == true) {
					activeParent = Tag.tempTagCollection.get(i);
					break;
				}
			}
			}
			}else{
				//if(activeParent != null)
				//Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).setParent(activeParent);
				
				//activeParent = Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1);
				}
			}
		}
		if(activeParent != null)
		System.out.println("Active parent = "+  activeParent.toString());
		return activeParent;
	}
	
	public static void readWebsite(String str, LanguageDictionary ld) {
		
		//Step 1 break up website into a collection of chunks
		ArrayList<String> chunks = new ArrayList<String>();
		Tag recentOpen = null;
		boolean isSpecialTag = false;
		String current = "";
		Tag currentTag = null;
		
		String buffer = "";
		
		
		//This will be set to true if '<' character is found and will run a while
		boolean readingTag = false;
		
		//Is true if readingTagName == false and encounters '<' | is false if readingTagName == true and encounters '>'
		boolean readingTagName = false;
		
		boolean readingTagAttributes = false;
		
		boolean readingTagAttributesName = false;
		
		//Is true immediately after readingTagName is set to false | Is false if readingTagValue == true and encounters '<'
		//boolean readingTagValue = false;
		
		System.out.println("Reading site");
		System.out.println("Site is this big: "+str.length());
		for(int i = 0; i < str.length(); i++) {
			//test
			
			if(isSpecialTag == false) {
			if(str.charAt(i) == '<' & readingTag == false & current.contentEquals("")) {
				readingTag = true;
				buffer+='<';
			}else if(readingTag == true && (str.charAt(i) != '>' && str.charAt(i) != '<')) {
				buffer+= str.charAt(i);
				//System.out.println("buffer = " + buffer);
			} else if(str.charAt(i) == '>' & readingTag == true) {
				buffer+=">";
				System.out.println("generating with: "  + buffer );
				System.out.println(readTag(buffer));
				
				currentTag = Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1);
				System.out.println("current tag is a " + currentTag.type);
				readingTag = false;
				buffer = "";
				
				if(ld.findStructureCodeInDictonary(currentTag.type) == 2) {
				isSpecialTag = true;
					System.out.println("setting isSpecialTag = " + isSpecialTag);
				}
				}
			}else {
				
				if(str.charAt(i) == '<') {
					String temporaryStr = "";
					//boolean comparisonTest = false;
					
					if(str.charAt(i+1) == '/') {
						i += 2;
						
						temporaryStr = "</";
						for(int ix = 0; ix < currentTag.type.length(); ix++) {
							if(str.charAt(i+ix) != currentTag.type.charAt(ix) ) {
								i = i+ix;
								System.out.println("not the right tag" + " should be " + currentTag.type);
							break;	
							}else {
								temporaryStr += str.charAt(i+ix);
							}
						}
						
						
						if(temporaryStr.contentEquals("</" + currentTag.type)) {
							System.out.println("Found match. Tag = " + temporaryStr);
							currentTag.value += current;
							isSpecialTag = false; 
							readTag(temporaryStr+">");
						}else if(!temporaryStr.contentEquals("</")) {
							current += temporaryStr.substring(0, temporaryStr.length()-2);
							System.out.println("Adding to current");
						}else if(temporaryStr.contentEquals("</")) {
							current += str.charAt(i);
							
							System.out.println("Adding whatever");
						}
					}
				}
				
			}
			
			
			
			if(readingTag == false & (str.charAt(i) != '<' & str.charAt(i) != '>' ) ) {
				if(current == null) {
					current = "";
				}
				current += str.charAt(i);
				//System.out.println("current = " + current);
			}else if(readingTag == false & str.charAt(i) == '<') {
				System.out.println("runs this part");
				//If a new tag starts opening it will start from the bottom of the tag collection and fine the most recent open tag
				if(Tag.tempTagCollection != null && Tag.tempTagCollection.size() >= 1) {
					
					//System.out.println("Tada! You may have found your problem block");
				for(int ix = Tag.tempTagCollection.size(); ix > 0; ix--) {
					//System.out.println("Doing" + ix);
					if(Tag.tempTagCollection.get(ix-1).isOpen == true) {
						Tag.tempTagCollection.get(ix-1).setValue((Tag.tempTagCollection.get(ix-1).getValue() + current).trim());
						System.out.println("updated tag at index:" + ix + " new value = " + Tag.tempTagCollection.get(ix-1).getValue());
						break;
					}
				}
				}
				readingTag = true;
				current = "";
				buffer+= "<";
			}
			
			
			
			/*
			switch(str.charAt(i)) {
			
			
			
			case '\n':
			break;
			
			default:
				current += str.charAt(i);
				break;
			}
			
			if(str.charAt(i) == '\n') {
				chunks.add(current.trim());
			}else {
				current += str.charAt(i);
			}*/
			
		}
		System.out.println("current = " + current);
		System.out.println("Done reading site" + "| tagcount = " + Tag.tempTagCollection.size());
		Tag.PrintHierarchy();
		//Step 2 figure out how many tags in a chunk
		
		//Step 3 create collection of tags
		
		//Step 4 create hierarchy?
	}
}