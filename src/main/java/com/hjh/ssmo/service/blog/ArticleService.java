package com.hjh.ssmo.service.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Article;
import com.hjh.ssmo.model.view.Pager;

public interface ArticleService {

	public List<Article> getArticleList(HashMap<String, Object> paramMap, Pager<Article> pager);

	public int addArticle(Article article);

	public Article getArticleById(String id);

	public int deleteArticle(String id);

	public int editArticle(Article article);

	public int updateStatue(Article article);

	/**
	 * 获取最新文章列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<Article> getLastArticleList(HashMap<String, Object> paramMap);

}
