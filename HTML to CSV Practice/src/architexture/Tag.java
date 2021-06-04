package architexture;

import java.util.ArrayList;
import java.util.Arrays;

public class Tag {
	public Tag parent = null;
	public static Tag[] site;
	public static ArrayList<Tag> tempTagCollection;
	public String value, type;
	public Tag[] children;
	public ArrayList<Tag> tempChildren = null;
	public boolean isOpen = true;
	public boolean isParent = false;
	public int tagIndex = -1;
	

	
	
	//first
	public String[] attributeName;
	public String[] attributeValue;
	
	static {
		tempTagCollection = new ArrayList<Tag>(); 
	}
	
	
	public Tag(String type, String value, String[] attributeName, String[] attributeValue) {
		
		System.out.println("--- Processing new tag --- \n type = "+type);
		
		if(value == null || value.isBlank())
		System.out.println("This tag has no value");
		else
		System.out.println("value = " + value.trim());
		if(attributeName != null & (attributeName != null && attributeName.length != 0)) {
			System.out.println("attributeName.length = " + attributeName.length + "\n now printing:");
			
			if((attributeName.length != attributeValue.length)) {
				if(attributeName != null && attributeName.length > attributeValue.length)
				correctAttributes(attributeName[0]);
			}
				
			for(int i = 0; i < attributeName.length; i++) {
				System.out.println("[" + i+"] = " + attributeName[i] + " , value = " + attributeValue[i]);
			}
		}else {
			System.out.println("This tag contains no attribute names or values");
		}
		
		this.type = type;
		this.value = value;
		this.attributeValue = attributeValue;
		this.attributeName = attributeName;
		
		
		if(tempTagCollection != null) {
			tempTagCollection.add(this);
			tagIndex = tempTagCollection.size() -1;
		}
		
		if(type.charAt(0) == '/') {
			isOpen = false;
		}
	}
	
	public static ArrayList<String>[] correctAttributes(String str) {
		
		ArrayList<String>[] temp = null;
		boolean quotedVal = false;
		//So I guess tag attributes don't need quotes
		System.out.println("processing: " +str);
		int equalsCount = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '=' && quotedVal == false) {
				equalsCount++;
			}else if(str.charAt(i) == '"' && quotedVal == false) {
				quotedVal = true;
			}else if(str.charAt(i) == '"' && quotedVal == true) {
				quotedVal = false;
			}
		}
		
		temp = new ArrayList[2];
		
		System.out.println("eqcount = "+equalsCount);
		String[] tempAttNames = new String[equalsCount];
		String[] tempAttVals = new String[equalsCount];
		
		String buffer = "";
		int currentCount = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '=' && quotedVal == false) {
				tempAttNames[currentCount] = buffer;
				if(str.charAt(i+1) == '"') {
					quotedVal = true;
					i++;
				}
				buffer = "";
			}else if(quotedVal == true && str.charAt(i) == '"') {
				quotedVal = false;
			}
			else if(str.charAt(i) == ' ') {
				tempAttVals[currentCount] = buffer;
				currentCount++;
				buffer = "";
			}else {
				buffer += str.charAt(i);
			}
		}
		
		if(!buffer.isBlank() || !buffer.contentEquals("")) {
			tempAttVals[currentCount] = buffer;
		}
		
		//attributeName = tempAttNames;
		//attributeValue = tempAttVals;
		ArrayList<String> tempArrayNames = new ArrayList<String>();
		ArrayList<String> tempArrayVals = new ArrayList<String>();
		for(int i = 0; i < equalsCount; i++) {
			System.out.println(tempAttNames[i] + " and " + tempAttVals[i]);
			tempArrayNames.add(tempAttNames[i]);
			tempArrayVals.add(tempAttVals[i]);
		}
		temp[0] = tempArrayNames;//(ArrayList<String>)(Arrays.asList(tempAttNames));
		temp[1] = tempArrayVals;//(ArrayList<String>)(Arrays.asList(tempAttVals));
		
		return temp;
	}
	
public Tag(String type, String value, String[] attributeName, String[] attributeValue, Tag[] children) {
		
	}

public void addChild(Tag child) {
	//child.tabCount = this.tabCount + 1;
	if(tempChildren != null) {
		tempChildren.add(child);
		child.tabCount = this.tabCount+1;
	}else {
		tempChildren = new ArrayList<Tag>();
		tempChildren.add(child);
	}
	this.isParent = true;
}

public void setParent(Tag tag) {
	
	this.parent = tag;
	if(this.parent != null)
	this.tabCount = this.parent.tabCount+1;
}



	
	public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public boolean isOpen() {
	return isOpen;
}

public void setOpen(boolean isOpen) {
	this.isOpen = isOpen;
	
	if(tempChildren != null)
	this.children = this.tempChildren.toArray(new Tag[tempChildren.size()]);
}

public boolean isParent() {
	
	//this.children = this.tempChildren.toArray(new Tag[tempChildren.size()]);
	
	return isParent;
}

public void setIsParent(boolean isParent) {
	this.isParent = isParent;

	this.tabCount = this.parent.tabCount+1;
}

public Tag getParent() {
	return parent;
}

	public static void addTag(Tag newTag) {
		
		if(tempTagCollection != null) {
			tempTagCollection.add(newTag);
		}else {
			tempTagCollection = new ArrayList<Tag>();
			tempTagCollection.add(newTag);
		}
		
	}
	
	
	
	public String toString() {
		//return
		
		String attributeSection = "";
		
		if(attributeName != null  & (attributeName != null && attributeName.length != 0)) {
			for(int i = 0; i < attributeName.length; i++) {
				attributeSection = attributeSection + attributeName[i] + "=\""+ attributeValue[i]+ "\" ";
			}
			
		}
		
		return '<' + type + ' ' + attributeSection.stripTrailing() + '>';
	}
	
	int tabCount = 0;
	
	public static void PrintHierarchy() {
		
		ArrayList<Integer> index = new ArrayList<Integer>(); 
		int innerParentCount = 0;
		for(int i = 0; i < tempTagCollection.size(); i++) {
			if(tempTagCollection.get(i).isParent == true) {
				index.add(i);
			}
		}
		if(index.isEmpty() == false) {
			innerParentCount++;
		}
		/*
		//boolean alreadyAdded = false;
		for(int i = 0; i < index.size(); i++) {
			
			System.out.println("going through index1");
			if(index.size() > 1 || tempTagCollection.get(index.get(i)).parent != null) {
				innerParentCount++;
				System.out.println("going through index");
				Tag currentTag =tempTagCollection.get(i);
				for(int ix = 0; ix < currentTag.children.length; ix++) {
					 int childID = currentTag.children[ix].tagIndex;
					for(int iy = i; iy < index.size(); iy++) {
						if(index.get(i) == childID) {
							tempTagCollection.get(i).tabCount = innerParentCount;
							i++;
							System.out.println("printed tabs");
						}
					}
				}
			}else if(index.size() == 1) {
				tempTagCollection.get(index.get(0)).tabCount = 1;
			}
		}
		*/
		//Finds the highest encapsulation
		
		String tabs = "";
		for(int i = 0 ; i < index.size(); i++) {
			
			
			//System.out.println("tabs = " + Tag.tempTagCollection.get(index.get(i)).tabCount);
			
			
			System.out.println("---Parent <" + Tag.tempTagCollection.get(index.get(i)).type + ">---");
			//System.out.println(index.get(i));
			if(tempTagCollection.get(index.get(i)).children != null)
			for(int ix = 0; ix < tempTagCollection.get(index.get(i)).children.length;ix++) {
			
				for(int iy = 0; iy < Tag.tempTagCollection.get(index.get(i)).children[ix].tabCount ; iy++) {
					tabs = tabs + '-';
					//System.out.println("tabs = ");
				}
				
				System.out.println(tabs + '<' + tempTagCollection.get(index.get(i)).children[ix].type + '>');
				tabs = "";
			}
		}
		
		
		
	}
	
}
