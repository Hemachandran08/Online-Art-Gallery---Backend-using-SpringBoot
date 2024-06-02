package com.example.repository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Art;
import com.example.model.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class ArtRepoImpl implements ArtRepo{
	
	
	@Autowired
	EntityManager eMan;
	
	

	@Override
	public void addArt(String artTitle,
		     String artDescription,
			 double artPrice,
			  String artTagName,
			 String artStyle,
			 String imageType,
			 Long artistId,
			 MultipartFile image) {
		Artist artist = eMan.find(Artist.class, artistId);
		
//		eMan.persist();
		
		try {
			Art art = new Art();
			art.setArtTitle(artTitle);
			art.setArtDescription(artDescription);
			art.setArtPrice(artPrice);
			art.setArtTagName(artTagName);
			art.setArtStyle(artStyle);
			art.setImageType(imageType);
			art.setArtist(artist);
			byte[] imageBytes = Base64.getEncoder().encode(image.getBytes());
			art.setImage(imageBytes);
			
			eMan.persist(art);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Art> getArts() {
		return eMan.createQuery("from Art").getResultList();
	}

	@Override
	public Art findArt(Long artId) {
		Art art1 = eMan.find(Art.class, artId);
		return art1;
	}

	@Override
	public boolean updateArt(Art artRepo) {
		eMan.merge(artRepo);
		return true;
	}

	@Override
	public boolean deleteArt(String artRepo) {
		Art art2 = eMan.find(Art.class, artRepo);
		eMan.remove(art2);
		return true;
	}

	@Override
	public List<Art> searchArts(String art) {
		Query qry1 = eMan.createQuery("from Art a where a.art=?1");
		qry1.setParameter(1, art);
		return qry1.getResultList();
	}
	
	@Override
	public List<Art> getArtsByArtist(Long artistId){
		TypedQuery<Art> query = eMan.createQuery("FROM Art a WHERE a.artist.artistId = :artistId", Art.class);
		query.setParameter("artistId", artistId);
		return query.getResultList();
	}

}
