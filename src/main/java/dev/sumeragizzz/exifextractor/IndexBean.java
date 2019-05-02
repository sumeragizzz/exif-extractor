package dev.sumeragizzz.exifextractor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class IndexBean {

	public IndexBean() {
		// NOP
	}

	private String value;

	public String execute() {
		System.out.println(value);
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
