package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Art;
import com.example.model.Artist;
import com.example.repository.ArtRepo;
import com.example.repository.ArtistRepo;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

	
	@Autowired
	ArtistRepo art1Repo;

	@Override
	public boolean addArtist(Artist artist) {
		return art1Repo.addArtist(artist);
	}

	@Override
	public List<Artist> getArtists() {
		return art1Repo.getArtists();
	}

	@Override
	public Artist findArtist(String artistTitle) {
		return art1Repo.findArtist(artistTitle);
	}

	@Override
	public boolean updateArtist(Artist artistId) {
		return art1Repo.updateArtist(artistId);
	}

	@Override
	public List<Artist> searchArtists(String artists) {
		return art1Repo.searchArtists(artists);
	}

	@Override
	public boolean deleteArtist(String artistId) {
		return art1Repo.deleteArtist(artistId);
	}

	@Override
	public List<Artist> validateLogIn(String logId, String pass) {
		return art1Repo.validateLogin(logId, pass);
	}
	
	@Override
	public List<Artist> validateArtist(String artistEmail) {
		return art1Repo.validateArtist(artistEmail);
	}
	
	

}
