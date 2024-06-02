package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Art;
import com.example.repository.ArtRepo;

@Service
@Transactional
public class ArtServiceImpl implements ArtService {

	@Autowired
	ArtRepo art1Repo;

	public ArtServiceImpl(ArtRepo art1Repo) {
		super();
		this.art1Repo = art1Repo;
	}

	public ArtServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addArt(String artTitle, String artDescription, double artPrice, String artTagName, String artStyle,
			String imageType, Long artistId, MultipartFile image) throws IOException {

		art1Repo.addArt(artTitle, artDescription, artPrice, artTagName, artStyle, imageType, artistId, image);

	}

	@Override
	public List<Art> getArts() {
		return art1Repo.getArts();
	}

	@Override
	public Art findArt(Long artId) {
		return art1Repo.findArt(artId);
	}

	@Override
	public boolean updateArt(Art artId) {
		return art1Repo.updateArt(artId);
	}

	@Override
	public List<Art> searchArts(String arts) {
		return art1Repo.searchArts(arts);
	}

	@Override
	public boolean deleteArt(String artId) {
		return art1Repo.deleteArt(artId);
	}

	@Override
	public List<Art> getArtsByArtist(Long artistId) {
		return art1Repo.getArtsByArtist(artistId);
	}

}
