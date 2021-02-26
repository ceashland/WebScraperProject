package architexture;

import java.util.ArrayList;

public class Tag {
	public Tag parent = null;
	public static Tag[] site;
	public static ArrayList<Tag> tempTagCollection;
	public String value, type;
	public Tag[] children;

	
	
	//first
	public String[] attributeName;
	public String[] attributeValue;
	
	public Tag(String type, String value, String[] attributeName, String[] attributeValue) {
		
	}
	
public Tag(String type, String value, String[] attributeName, String[] attributeValue, Tag[] children) {
		
	}


	
	public static void addTag(Tag newTag) {
		
		if(tempTagCollection != null) {
			tempTagCollection.add(newTag);
		}else {
			tempTagCollection = new ArrayList<Tag>();
			tempTagCollection.add(newTag);
		}
		
	}
	
	
	
}
