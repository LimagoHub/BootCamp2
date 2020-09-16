package de.gothaer.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the `order details` database table.
 * 
 */
@Embeddable
public class Order_detailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int orderID;

	@Column(insertable=false, updatable=false)
	private int productID;

	public Order_detailPK() {
	}
	public int getOrderID() {
		return this.orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Order_detailPK)) {
			return false;
		}
		Order_detailPK castOther = (Order_detailPK)other;
		return 
			(this.orderID == castOther.orderID)
			&& (this.productID == castOther.productID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderID;
		hash = hash * prime + this.productID;
		
		return hash;
	}
}