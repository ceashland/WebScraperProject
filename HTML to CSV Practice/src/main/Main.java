package main;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import main.dictionaries.DictionaryReader;

import java.net.MalformedURLException;
public class Main {

	public static void main(String[] args) throws IOException{
		boolean testing = false;
		if(testing == true) {
			
		StringBuilder sbTest = new StringBuilder();
		
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
		            	writer.write(line); 
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
}
