package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Art;
import com.example.model.Artist;



public interface ArtService {

	
	
   public List<Art> getArts();
	
	public Art findArt(Long artId);
	
	public boolean updateArt(Art artId);
	
	public boolean deleteArt(String artId);
	
	public List<Art> searchArts(String arts);

	public void addArt(String artTitle,
		     String artDescription,
			 double artPrice,
			  String artTagName,
			 String artStyle,
			 String imageType,
			 Long artistId,
			 MultipartFile image)throws IOException;
	
	public List<Art> getArtsByArtist(Long artistId);

	
}
