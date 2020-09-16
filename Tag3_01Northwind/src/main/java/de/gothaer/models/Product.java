package de.gothaer.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productID;

	private byte discontinued;

	private String productName;

	private String quantityPerUnit;

	private short reorderLevel;

	private BigDecimal unitPrice;

	private short unitsInStock;

	private short unitsOnOrder;

	//bi-directional many-to-one association to Order_detail
	@OneToMany(mappedBy="product")
	private List<Order_detail> orderDetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="SupplierID")
	private Supplier supplier;

	public Product() {
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public byte getDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(byte discontinued) {
		this.discontinued = discontinued;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return this.quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public short getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public short getUnitsInStock() {
		return this.unitsInStock;
	}

	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public short getUnitsOnOrder() {
		return this.unitsOnOrder;
	}

	public void setUnitsOnOrder(short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public List<Order_detail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<Order_detail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order_detail addOrderDetail(Order_detail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public Order_detail removeOrderDetail(Order_detail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}