package main;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import architexture.Tag;
import main.dictionaries.DictionaryReader;

import java.net.MalformedURLException;
public class Main {

	public static void main(String[] args) throws IOException{
		boolean testing = true;
		if(testing == true) {
			
		StringBuilder sbTest = new StringBuilder();
		/*
		String newLine = "\n";
		String concatString = "ello this is the strin";
		System.out.println("concatString.Length ="+concatString.length()); //length = 22
		System.out.println("sbTest.Length = " + sbTest.length()); // length = 0;
		sbTest.append("Hg");
		sbTest.insert(1, newLine);
		System.out.println("sbTest.Length = " + sbTest.length()); //length = 2
		sbTest.insert(1, newLine);
		System.out.println("sbTest = " + sbTest.toString());
		
			//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		*/
		//System.out.println("3/2 = " +((float)3/(float)2));
		
		String[] tagNames = new String[0];
		String[] tagAttributes = new String[0];
		String[] tagAttributesValues = new String[0];
		String line; //= "<h2 class=\"coffee\"  id=\"testID\"><h3> test this is a test is it working ?</h3></h2>";
		line = "<parent1>\r\n" + 
				"\r\n" + 
				"	<parent2>\r\n" + 
				"		<parent3>\r\n" + 
				"			<child1></child 1>\r\n" + 
				"			</child2>\r\n" + 
				"		</parent3>\r\n" + 
				"\r\n" + 
				"		<parent4>\r\n" + 
				"			<child4></child4>\r\n" + 
				"			</child5>\r\n" + 
				"			<child6></child6>\r\n" + 
				"		</parent4>\r\n" + 
				"	</parent2>\r\n" + 
				"</parent1>";
		Tag[] tempArry = readMultipleTags(line);
		
		System.out.println("---Reading tempTagCollection---");
		if(Tag.tempTagCollection != null)
		for(int i = 0; i < Tag.tempTagCollection.size(); i ++) {
			System.out.println(Tag.tempTagCollection.get(i).toString());
		}
		
		System.out.println("---Reding Hierarchy ---");
		Tag.PrintHierarchy();
		/*System.out.println("---Test Scan ---");
		for(int i = Tag.tempTagCollection.size()-1; i >= 0; i-- ) {
			System.out.println(i);
		}*/
		
		//System.out.println("testing");
		//if(tagNames != null)
		
		
		
		}else{
		DictionaryReader dr = new DictionaryReader("./dictionary/htmlDictonary.txt");
		String[][] htmlDict = dr.outputDictionary();
		
		//for(int i = 0; i < htmlDict.length; i++) {
			//System.out.println(htmlDict[i]);
		//}
		
		String classToLookFor = "icl-u-xs-my--none jobsearch-ReqAndQualSection-item--closedBullets";
		
		
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
		String site = "https://www.indeed.com/viewjob?cmp=El-Hogar-Community-Services&t=Administrative+Assistant&jk=42310489837d1188&sjdu=QwrRXKrqZ3CNX5W-O9jEvcD9A2--9riq-7sA7JLcQXPJQ06vzH2zhtCREOgeKB3-epCFhUgtF4h1LQPStbU7lnDyNyfdhx64XG2UkQVjfbg&tk=1eukkars3nq1a800&adid=5945611&ad=-6NYlbfkN0C-JuSQS1CacF0HjptwGahH1uXHgeSf5TGulbWbZELbsJVzoQnxNJyNAWyshxqCr_5WjN2EtSmRj667BOVA6SKtpmYbfPUbLZXI5uWxDVGoCp6T91hQxg5G_KcTLhkPElbxmpq_wOjgB7NFds3EO752v6fwgXUdvTf-aYTRqQkm9RpiB_ftyDD3cDTsLzv0g_s1ufIVOsvdXS3N9hQgx1R1v24Pk8xCi54224OqAC9atp_uOlxGLmgKyPJibjAIJphUw7I-jhXD--Q4jw6J7-gFHadLYIYJ7jZ4fuNun_ZAzBuvSOv4vhkXJ9yKH1oN5W6WIEiKeRkn3pGNuMTz-msw&pub=4a1b367933fd867b19b072952f68dceb&vjs=3";
		StringBuilder buffer;// = new StringBuilder();
		try{
			URL url = new URL(site);
			BufferedReader readr =  
		              new BufferedReader(new InputStreamReader(url.openStream())); 
		  
		            // Enter filename in which you want to download 
		            BufferedWriter writer =  
		              new BufferedWriter(new FileWriter("Download.html")); 
		              
		            // read each line from stream till end 
		            String line; 
		            int lineNumber = 0;
		            while ((line = readr.readLine()) != null) { 
		            	
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
		            	lineNumber++;
		            	
		            	writer.write(line + '\n'); 
		            } 
		  
		            readr.close(); 
		            writer.close(); 
		            System.out.println("Successfully Downloaded."); 
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
				}else if(line.charAt(i) != '>'){
					tagsName = tagsName + line.charAt(i);
				}else {
					readingTagName = false;
					//Tag(String type, String value, String[] attributeName, String[] attributeValue)
					//System.out.println("Dead drop add");
					
					if(!tagsName.isBlank()) {
					tempCol.add(new Tag(tagsName, tagValue, null,null));
					activeParent = findParent(tagsName);
					if(activeParent != null) {
						System.out.println("found parent1");
						activeParent.addChild(Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1));
						Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).setParent(activeParent);
					}
					}
					tagValue = "";
					readingValue = false;
					tagsName = "";
					
				}
			}
			
			if(readingAttributeName == true) {
				if(line.charAt(i) == '=') {
					
					readingAttributeName = false;
					tagAttributeNameList.add(attributesName.trim());
					attributesName = "";
					readingAttributeValue = true;
					
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
			
			if(line.charAt(i) == '>') {
				//time to submit!
				//Tag(String type, String value, String[] attributeName, String[] attributeValue)
				
				//if(!tagsName.trim().isBlank())
				//System.out.println("I found an ending!");
				if(i == line.length()-1 || (i+1 < line.length()-1 && line.charAt(i+1) == '<')) {
					//System.out.println("Adding from end");
					if(!tagsName.isBlank()) {
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
	
	public static Tag readTag(String line) {
		Tag tag = null;
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
					}
					}
					
					tagValue = "";
					readingValue = false;
					tagsName = "";
					
				}
			}
			
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
			
			if(line.charAt(i) == '>') {
				//time to submit!
				//Tag(String type, String value, String[] attributeName, String[] attributeValue)
				
				//if(!tagsName.trim().isBlank())
				//System.out.println("I found an ending!");
				if(i == line.length()-1 || (i+1 < line.length()-1 && line.charAt(i+1) == '<')) {
					//System.out.println("Adding from end");
					if(!tagsName.isBlank())
				tag = new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()]));
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
					tag = new Tag(tagsName, tagValue, tagAttributeNameList.toArray(new String[tagAttributeNameList.size()]),tagAttributeValueList.toArray(new String[tagAttributeValueList.size()]));
					readingValue = false;
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
					//attributeName = "";
					readingAttributeName = false;
					readingAttributeValue = false;
					//readingTagName = true;
				}
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
		
		Tag activeParent = null;
		boolean foundClose = false;
		
		if(Tag.tempTagCollection != null && !Tag.tempTagCollection.isEmpty()&& Tag.tempTagCollection.size() > 1) {
		if(tagType.contains("/")) {
			//Will close the parentTag
			for(int i = Tag.tempTagCollection.size()-1; i >= 0; i-- ) {
				if(foundClose == false && Tag.tempTagCollection.get(i).type.equalsIgnoreCase(tagType.replace("/", ""))) {
					Tag.tempTagCollection.get(i).setOpen(false); 
					Tag.tempTagCollection.get(Tag.tempTagCollection.size()-1).parent = Tag.tempTagCollection.get(i);
					foundClose = true;
				}else if(foundClose == true & Tag.tempTagCollection.get(i).isOpen){
					if(Tag.tempTagCollection != null && !Tag.tempTagCollection.isEmpty() && Tag.tempTagCollection.size() > 1)
					activeParent = Tag.tempTagCollection.get(i);
				}
			}	
		}else {
			//Will add to the parentTag
			if(Tag.tempTagCollection != null && !Tag.tempTagCollection.isEmpty())
			for(int i = Tag.tempTagCollection.size()-1; i >= 0; i-- ) {
				if(Tag.tempTagCollection.get(i).isOpen == true) {
					activeParent = Tag.tempTagCollection.get(i);
				}
			}
		}
		}
		if(activeParent != null)
		System.out.println("Active parent = "+  activeParent.toString());
		return activeParent;
	}
}