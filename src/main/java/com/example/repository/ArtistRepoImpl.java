package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Artist;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class ArtistRepoImpl implements ArtistRepo {

	@Autowired
	EntityManager eMan;

	@Override
	public boolean addArtist(Artist artist) {
		eMan.persist(artist);
		return true;
	}

	@Override
	public List<Artist> getArtists() {
		return eMan.createQuery("from Artist").getResultList();
	}

	@Override
	public Artist findArtist(String artistId) {
		Artist artist1 = eMan.find(Artist.class, artistId);

		return artist1;
	}

	@Override
	public boolean updateArtist(Artist artist) {
		eMan.merge(artist);
		return true;
	}

	@Override
	public boolean deleteArtist(String artist) {
		Artist artist2 = eMan.find(Artist.class, artist);
		eMan.remove(artist2);
		return true;
	}

	@Override
	public List<Artist> searchArtists(String artist) {
		Query qry2 = eMan.createQuery("from Artist a1 where a1.artistId=?1");
		qry2.setParameter(1, artist);
		return qry2.getResultList();
	}

	@Override
	public List<Artist> validateLogin(String logid, String pass) {
		Query qry2 = eMan.createQuery("from Artist log where log.artistEmailID =?1 and log.password=?2");
		qry2.setParameter(1, logid);
		qry2.setParameter(2, pass);

		List<Artist> users = qry2.getResultList();
		if (users.size() > 0)
			return users;
		else
			return users;
	}
	
	
	@Override
	public List<Artist> validateArtist(String artistEmail) {
		Query qry = eMan.createQuery("from Artist a2 where a2.artistEmailID=?1");
		qry.setParameter(1, artistEmail);
		return qry.getResultList();
	}

}
