package com.amruta.mykarsol.projectmykarsol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amruta.mykarsol.projectmykarsol.entity.Author;
import com.amruta.mykarsol.projectmykarsol.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

	
	
	@Autowired
    private AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

}
