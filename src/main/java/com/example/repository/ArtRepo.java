package com.example.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Art;

public interface ArtRepo 
{
	
	public void addArt(

			 String artTitle,
		     String artDescription,
			 double artPrice,
			  String artTagName,
			 String artStyle,
			 String imageType,
			 Long artistId,
			 MultipartFile image
		              )throws IOException;
	
	public List<Art> getArts();
	
	public Art findArt(Long artId);
	
	public boolean updateArt(Art artId);
	
	public boolean deleteArt(String artId);
	
	public List<Art> searchArts(String art);

	List<Art> getArtsByArtist(Long artistId);
	
}
