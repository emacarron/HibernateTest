package net.javabeat.hibernate;

import java.io.Serializable;

/**
 * Model class for Conact
 */
public class Contact implements Serializable {
	private Integer contactId;
	private String name;

	public Contact() {
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
