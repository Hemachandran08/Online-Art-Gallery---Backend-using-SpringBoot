package com.example.repository;

import java.util.List;

import com.example.model.Artist;

public interface ArtistRepo 
{
	
	public boolean addArtist(Artist artist);
	
	public List<Artist> getArtists();
	
	public Artist findArtist(String artistId);
	
	public boolean updateArtist(Artist artist);
	
	public boolean deleteArtist(String artist);
	
	public List<Artist> searchArtists(String artist);

	List<Artist> validateLogin(String logid, String pass);

	List<Artist> validateArtist(String artist);
	
}
