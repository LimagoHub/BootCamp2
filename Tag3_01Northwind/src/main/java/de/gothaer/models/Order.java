package de.gothaer.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int orderID;

	private BigDecimal freight;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date requiredDate;

	private String shipAddress;

	private String shipCity;

	private String shipCountry;

	private String shipName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date shippedDate;

	private String shipPostalCode;

	private String shipRegion;

	private int shipVia;

	//bi-directional many-to-one association to Order_detail
	@OneToMany(mappedBy="order")
	private List<Order_detail> orderDetails;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustomerID")
	private Customer customer;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EmployeeID")
	private Employee employee;

	public Order() {
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public BigDecimal getFreight() {
		return this.freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return this.requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getShipAddress() {
		return this.shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return this.shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipCountry() {
		return this.shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getShipName() {
		return this.shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Date getShippedDate() {
		return this.shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getShipPostalCode() {
		return this.shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipRegion() {
		return this.shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public int getShipVia() {
		return this.shipVia;
	}

	public void setShipVia(int shipVia) {
		this.shipVia = shipVia;
	}

	public List<Order_detail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<Order_detail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order_detail addOrderDetail(Order_detail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public Order_detail removeOrderDetail(Order_detail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}