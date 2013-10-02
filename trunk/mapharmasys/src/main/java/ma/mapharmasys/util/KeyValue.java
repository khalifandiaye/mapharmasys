package ma.mapharmasys.util;

public class KeyValue {

	private String label;
	private Object key;

	public KeyValue() {
		super();
	}

	public KeyValue(String label, Object key) {
		super();
		this.label = label;
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

}
