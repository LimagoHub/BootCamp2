package de.gothaer.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the `order details` database table.
 * 
 */
@Entity
@Table(name="`order details`")
@NamedQuery(name="Order_detail.findAll", query="SELECT o FROM Order_detail o")
public class Order_detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Order_detailPK id;

	private double discount;

	private short quantity;

	private BigDecimal unitPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OrderID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;

	public Order_detail() {
	}

	public Order_detailPK getId() {
		return this.id;
	}

	public void setId(Order_detailPK id) {
		this.id = id;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public double getTotal() {
		return getUnitPrice().doubleValue() * (double) getQuantity();
	}

}