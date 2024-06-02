package com.example.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Art;
import com.example.model.Artist;
import com.example.service.ArtService;

import jakarta.ws.rs.core.HttpHeaders;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/rest/art")
public class ArtController {

	@Autowired
	ArtService artService;

	public ArtController(ArtService artService) {
		
		this.artService = artService;
	}

	public ArtController() {
		
	}
	
	@GetMapping("/GetArts")
	public List<Art> getArts(){
		return artService.getArts();
	}
	
	
	@GetMapping("/GetArtById/{artId}")
	public Art findArt(@PathVariable("artId") Long artId) {
		return artService.findArt(artId);
	}
	
	@PutMapping("/UpdateArt")
	public boolean updateArt(@RequestBody Art art) {
		return artService.updateArt(art);
	}
	
	@DeleteMapping("/DeleteArt/{artId}")
	public boolean deleteArt(@PathVariable("artId") String artId) {
		return artService.deleteArt(artId);
	}
	
	@GetMapping("/SearchArt/{artId}")
	public List<Art> searchArts(@PathVariable("artId") String artId){
		return artService.searchArts(artId);
	}
	
	@PostMapping("/art")
	public ResponseEntity<String> handleArtUpload(
			@RequestParam String artTitle,
			@RequestParam  String artDescription,
			@RequestParam  double artPrice,
			@RequestParam  String artTagName,
			@RequestParam  String artStyle,
			@RequestParam  Long artistId,
			@RequestParam MultipartFile image){
		try {
			
			artService.addArt(artTitle,
					artDescription,
					artPrice,
					artTagName,
					artStyle, 
					artStyle,
					artistId, 
					image);
			return ResponseEntity.ok("Success");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Failed");
		}
	}
	
	
	@GetMapping("/findImage/{artTitle}")
	public ResponseEntity<ByteArrayResource> doGetArt(@PathVariable("artTitle") Long artTitle) {
		try {
			Art art = artService.findArt(artTitle);
			byte[] image = Base64.getDecoder().decode(art.getImage());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(art.getImageType())).header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + art.getArtTitle() + "\"")
					.body(new ByteArrayResource(image));
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@GetMapping("/getArtsByArtist/{artistId}")
	public List<Art> getArtsByArtist(@PathVariable("artistId") Long artistId){
	    return artService.getArtsByArtist(artistId);
	}

}
