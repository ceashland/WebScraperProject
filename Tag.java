package architexture;

import java.util.ArrayList;

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
		
		System.out.println("--- Processing new tag --- \ntype = "+type);
		
		if(value == null || value.isBlank())
		System.out.println("This tag has no value");
		else
		System.out.println("value = " + value);
		if(attributeName != null & (attributeName != null && attributeName.length != 0)) {
			System.out.println("attributeName.length = " + attributeName.length + "\n now printing:");
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
	}
	
public Tag(String type, String value, String[] attributeName, String[] attributeValue, Tag[] children) {
		
	}

public void addChild(Tag child) {
	if(tempChildren != null) {
		tempChildren.add(child);
	}else {
		tempChildren = new ArrayList<Tag>();
		tempChildren.add(child);
	}
	this.isParent = true;
}

public void setParent(Tag tag) {
	this.parent = tag;
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

public void setParent(boolean isParent) {
	this.isParent = isParent;
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
		
		//Finds the highest encapsulation
		
		String tabs = "";
		for(int i = 0 ; i < index.size(); i++) {
			
			
			//System.out.println("tabs = " + Tag.tempTagCollection.get(index.get(i)).tabCount);
			
			for(int iy = 0; iy < Tag.tempTagCollection.get(index.get(i)).tabCount; iy++) {
				tabs = tabs + '-';
				System.out.println("tabs = " + tabs);
			}
			System.out.println('<' + Tag.tempTagCollection.get(index.get(i)).type + '>');
			//System.out.println(index.get(i));
			if(tempTagCollection.get(index.get(i)).children != null)
			for(int ix = 0; ix < tempTagCollection.get(index.get(i)).children.length;ix++) {
			
				System.out.println(tabs + '<' + tempTagCollection.get(index.get(i)).children[ix].type + '>');
			}
		}
		
		
		
	}
	
}
