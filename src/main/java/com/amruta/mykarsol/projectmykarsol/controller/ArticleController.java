package com.amruta.mykarsol.projectmykarsol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.amruta.mykarsol.projectmykarsol.entity.Article;
import com.amruta.mykarsol.projectmykarsol.entity.Author;
import com.amruta.mykarsol.projectmykarsol.service.ArticlesService;
import com.amruta.mykarsol.projectmykarsol.service.AuthorService;
import com.amruta.mykarsol.projectmykarsol.service.EmailService;
import com.amruta.mykarsol.projectmykarsol.utility.LoggerUtil;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticlesService articleService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private EmailService emailService;

	@GetMapping("/add")
	public String showAddArticleForm(Model model) {
		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);
		model.addAttribute("article", new Article());
		return "addArticle";
	}

	@PostMapping("/add")
	public String addArticle(@ModelAttribute Article article, @RequestParam("bannerFile") MultipartFile bannerFile) {
		try {
			article.setBanner(bannerFile.getBytes());
			articleService.createArticle(article);
			emailService.sendEmail("amrutajawale2512@.com", "New Article Added",
					"Article titled '" + article.getTitle() + "' has been added.");
			LoggerUtil.logInfo("Article added successfully: " + article.getTitle());
		} catch (IOException e) {
			LoggerUtil.logError("Error uploading banner for article: " + article.getTitle(), e);
		}
		return "redirect:/articles/list";
	}

	@GetMapping("/update/{id}")
	public String showUpdateArticleForm(@PathVariable int id, Model model) {
		Article article = articleService.getArticle(id);
		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);
		model.addAttribute("article", article);
		return "updateArticle";
	}

	@PostMapping("/update")
	public String updateArticle(@ModelAttribute Article article, @RequestParam("bannerFile") MultipartFile bannerFile) {
		try {
			article.setBanner(bannerFile.getBytes());
			articleService.updateArticle(article);
			emailService.sendEmail("amrutajawale2512@gmail.com", "Article Updated",
					"Article titled '" + article.getTitle() + "' has been updated.");
			LoggerUtil.logInfo("Article updated successfully: " + article.getTitle());
		} catch (IOException e) {
			LoggerUtil.logError("Error uploading banner for article: " + article.getTitle(), e);
		}
		return "redirect:/articles/list";
	}

	@GetMapping("/view/{id}")
	public String viewArticle(@PathVariable int id, Model model) {
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		return "viewArticle";
	}

	@GetMapping("/list")
	public String listArticles(Model model) {
		List<Article> articles = articleService.getAllArticles();
		model.addAttribute("articles", articles);
		return "listArticles";
	}

	@GetMapping("/delete/{id}")
	public String deleteArticle(@PathVariable int id) {
		articleService.deleteArticle(id);
		emailService.sendEmail("amrutajawale2512@gmail.com", "Article Deleted",
				"Article with ID '" + id + "' has been deleted.");
		LoggerUtil.logInfo("Article deleted successfully: " + id);
		return "redirect:/articles/list";
	}

}
