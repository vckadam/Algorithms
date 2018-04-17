package backtracking.xmlEncoding;

import java.util.List;

public class Tag {
	
	private String name;
	private List<Property> props;
	private List<Tag> tags;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Property> getProps() {
		return props;
	}
	public void setProps(List<Property> props) {
		this.props = props;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
