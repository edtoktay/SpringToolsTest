/**
 * 
 */
package org.edtoktay.testproject.entity;

/**
 * @author deniz.toktay
 *
 */
public enum Role {
	ADMIN, MERC, CLIENT;

	public String authority() {
		return "ROLE_" + this.name();
	}
}
