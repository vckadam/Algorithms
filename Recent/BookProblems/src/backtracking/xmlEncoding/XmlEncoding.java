package backtracking.xmlEncoding;

public class XmlEncoding {
	
	public String getEncoding(Tag tag) {
		if(tag == null) return "";
		StringBuilder sb = new StringBuilder();
		encodingHelper(sb, tag);
		return sb.toString().trim();
	}
	
	public void encodingHelper(StringBuilder current, Tag tag) {
		current.append(" ").append(tag.getName());
		for(Property prop : tag.getProps()) {
			current.append(" ").append(prop.getName()).append(" ").append(prop.getVal());
		}
		for(Tag t : tag.getTags()) {
			encodingHelper(current, t);
		}
		current.append(" ").append(tag.getValue());
		current.append(" ").append("0");
	}
}
