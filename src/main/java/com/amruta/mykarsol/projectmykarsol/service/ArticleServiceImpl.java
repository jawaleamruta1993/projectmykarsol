package com.amruta.mykarsol.projectmykarsol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.amruta.mykarsol.projectmykarsol.entity.Article;
import com.amruta.mykarsol.projectmykarsol.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticlesService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public void createArticle(Article article) {
		articleRepository.save(article);

	}

	@Override
	public Article getArticle(int id) {
		return articleRepository.findById(id).orElse(null);
	}

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();

	}

	@Override
	public void updateArticle(Article article) {
		articleRepository.save(article);

	}

	@Override
	public void deleteArticle(int id) {
		articleRepository.deleteById(id);

	}

}
