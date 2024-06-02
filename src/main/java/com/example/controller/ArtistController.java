package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Artist;
import com.example.service.ArtistService;

import jakarta.ws.rs.Path;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/rest/art")
public class ArtistController {

	@Autowired
	ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		
		this.artistService = artistService;
	}

	public ArtistController() {
		
	}
	
	
	@DeleteMapping("/deleteMapping/{artistId}")
	public boolean deleteArtist(@PathVariable("artistId")String artist) {
		return artistService.deleteArtist(artist);
	}
	
	@GetMapping("/getArtist")
	public Iterable<Artist> getArtist(){
		return artistService.getArtists();
	}

	@PostMapping("/addArtist")
	public boolean addArtist(@RequestBody Artist artist) {
		System.out.println(artist);
		return artistService.addArtist(artist);
	}
	
	@PutMapping("/updateArtist")
	public boolean updateArtist(@RequestBody Artist artist) {
		return artistService.updateArtist(artist);
	}
	
	@GetMapping("/getArtistById/{artistId}")
	public Artist findArtist(@PathVariable("artistId") String artistId) {
		return artistService.findArtist(artistId);
	}

	@GetMapping("/searchArtist/{artistId}")
	public List<Artist> searchArtist(@PathVariable("artistId") String artistId) {
		return artistService.searchArtists(artistId);
	}
	
	@GetMapping("/validateLogin/{artistEmailID}/password/{password}")
	public List<Artist> validateLogin(@PathVariable("artistEmailID") String id,@PathVariable("password") String pass) {
		return artistService.validateLogIn(id, pass);
	}
	
	@GetMapping("/validateArtist/{artistEmailID}")
	public List<Artist> findArtistEmail(@PathVariable(("artistEmailID")) String artistEmailID) {
		return artistService.validateArtist(artistEmailID);
	}
	
	

}

