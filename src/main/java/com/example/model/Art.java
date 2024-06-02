package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Art {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artId;
	private String artTitle;
	private String artDescription;
	private double artPrice;
	private String artTagName;
	private String artStyle;
	private String imageType;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;

	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public Art() {

	}

	

	public Art(Long artId, String artTitle, String artDescription, double artPrice, String artTagName, String artStyle,
			String imageType, byte[] image, Artist artist, Cart cart) {
		super();
		this.artId = artId;
		this.artTitle = artTitle;
		this.artDescription = artDescription;
		this.artPrice = artPrice;
		this.artTagName = artTagName;
		this.artStyle = artStyle;
		this.imageType = imageType;
		this.image = image;
		this.artist = artist;
		this.cart = cart;
	}



	public Long getArtId() {
		return artId;
	}

	public void setArtId(Long artId) {
		this.artId = artId;
	}

	public String getArtTitle() {
		return artTitle;
	}

	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
	}

	public String getArtDescription() {
		return artDescription;
	}

	public void setArtDescription(String artDescription) {
		this.artDescription = artDescription;
	}

	public double getArtPrice() {
		return artPrice;
	}

	public void setArtPrice(double artPrice) {
		this.artPrice = artPrice;
	}

	public String getArtTagName() {
		return artTagName;
	}

	public void setArtTagName(String artTagName) {
		this.artTagName = artTagName;
	}

	public String getArtStyle() {
		return artStyle;
	}

	public void setArtStyle(String artStyle) {
		this.artStyle = artStyle;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public String getImageType() {
		return imageType;
	}



	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
	
	
	

}
