package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long artistId;
	private String artistName;
	private String artistBio;
	private String artistEmailID;
	private String artistMobileNumber;
	private String artistAddress;
	private String password;

//	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
//	private List<Art> arts;

	
	
	public Artist(Long artistId, String artistName, String artistBio, String artistEmailID, String artistMobileNumber,
			String artistAddress,String password) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistBio = artistBio;
		this.artistEmailID = artistEmailID;
		this.artistMobileNumber = artistMobileNumber;
		this.artistAddress = artistAddress;
		this.password = password;
//		this.arts = arts;
	}

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistBio() {
		return artistBio;
	}

	public void setArtistBio(String artistBio) {
		this.artistBio = artistBio;
	}

	public String getArtistEmailID() {
		return artistEmailID;
	}

	public void setArtistEmailID(String artistEmailID) {
		this.artistEmailID = artistEmailID;
	}

	public String getArtistMobileNumber() {
		return artistMobileNumber;
	}

	public void setArtistMobileNumber(String artistMobileNumber) {
		this.artistMobileNumber = artistMobileNumber;
	}

	public String getArtistAddress() {
		return artistAddress;
	}

	public void setArtistAddress(String artistAddress) {
		this.artistAddress = artistAddress;
	}



	public String getPassword() {
		return password;
	}

	

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
