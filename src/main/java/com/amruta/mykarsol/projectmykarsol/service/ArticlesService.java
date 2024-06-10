package com.amruta.mykarsol.projectmykarsol.service;

import java.util.List;

import com.amruta.mykarsol.projectmykarsol.entity.Article;

public interface ArticlesService {
	
	void createArticle(Article article);
    Article getArticle(int id);
    List<Article> getAllArticles();
    void updateArticle(Article article);
    void deleteArticle(int id);

}
