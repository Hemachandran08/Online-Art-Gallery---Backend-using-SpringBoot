package com.example.service;

import java.util.List;

import com.example.model.Art;
import com.example.model.Artist;
import com.example.repository.ArtRepo;

public interface ArtistService {

public boolean addArtist(Artist artist);
	
	public List<Artist> getArtists();
	
	public Artist findArtist(String artistId);
	
	public boolean updateArtist(Artist artistId);
	
	public boolean deleteArtist(String artistId);
	
	public List<Artist> searchArtists(String artists);

	public List<Artist> validateLogIn(String logId,String pass);

	List<Artist> validateArtist(String artistEmail);
	
}
