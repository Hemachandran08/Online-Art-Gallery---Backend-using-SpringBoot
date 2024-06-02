//package com.example.model;
//
//import java.sql.Date;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//
//@Entity
//@Table(name="tb_order")
//public class OrderClass {
//	
//	
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long orderId;
//	private String name;
//    private String description;
//    private double price;
//
//	@ManyToOne
//	@JoinColumn(name = "customer_id")
//    private Customer customer;
//	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<Art> arts;
//	
////	@Temporal(TemporalType.TIMESTAMP)
////    private Date orderDate;
//
//	public OrderClass() {
//		
//	}
//
//	public OrderClass(Long orderId, Customer customer) {
//		super();
//		this.orderId = orderId;
//		this.customer = customer;
//		
//	}
//
//	public Long getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public void setArts(List<Art> arts2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public List<Long> getArtIds() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//}
