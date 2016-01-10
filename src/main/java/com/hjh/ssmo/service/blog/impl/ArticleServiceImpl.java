package com.hjh.ssmo.service.blog.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hjh.ssmo.mapper.blog.ArticleMapper;
import com.hjh.ssmo.model.blog.Article;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.service.blog.ArticleService;
import com.hjh.ssmo.util.SsmoCommonUtil;

@Component("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> getArticleList(HashMap<String, Object> paramMap, Pager<Article> pager) {
		List<Article> articleList = null;
		int count = articleMapper.getArticleCount(paramMap);
		pager.setTotalCount(count);
		if (count > 0) {
			paramMap.put("start", pager.getStart());
			paramMap.put("limit", pager.getLimit());
			articleList = articleMapper.getArticleList(paramMap);
		}
		return articleList;
	}

	@Override
	public int addArticle(Article article) {
		int count = articleMapper.addArticle(article);
		for (Tag tag : article.getTagList()) {
			article.setTagId(tag.getId());
			articleMapper.addArticleTag(article);
		}

		// 提取文章图片地址
		List<String> imageList = getImageSrc(article.getContent());
		if (!SsmoCommonUtil.isEmptyCollection(imageList)) {
			for (String imageUrl : imageList) {
				article.setImageUrl(imageUrl.substring(imageUrl.indexOf("uploads") + 8));
				articleMapper.addArticleImage(article);
			}
		}

		return count;
	}

	public static List<String> getImageSrc(String htmlCode) {
		List<String> imageSrcList = new ArrayList<String>();
		Pattern p = Pattern
				.compile(
						"<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>",
						Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(htmlCode);
		String quote = null;
		String src = null;
		while (m.find()) {
			quote = m.group(1);
			src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);
			imageSrcList.add(src);
		}
		return imageSrcList;
	}

	@Override
	public Article getArticleById(String id) {
		return articleMapper.getArticleById(id);
	}

	@Override
	public int editArticle(Article article) {
		// 删除原来的文章标签关系
		articleMapper.deleteArticleTag(article);
		int count = articleMapper.editArticle(article);
		for (Tag tag : article.getTagList()) {
			article.setTagId(tag.getId());
			articleMapper.addArticleTag(article);
		}

		// 删除原来的文章图片关系
		articleMapper.deleteArticleImage(article);
		// 提取文章图片地址
		List<String> imageList = getImageSrc(article.getContent());
		if (!SsmoCommonUtil.isEmptyCollection(imageList)) {
			for (String imageUrl : imageList) {
				article.setImageUrl(imageUrl.substring(imageUrl.indexOf("uploads") + 8));
				articleMapper.addArticleImage(article);
			}
		}

		return count;
	}

	@Override
	public int deleteArticle(String id) {
		articleMapper.deleteArticleImageById(id);
		articleMapper.deleteArticleTagById(id);
		// 删除文章
		return articleMapper.deleteArticle(id);
	}

	@Override
	public int updateStatue(Article article) {
		return articleMapper.updateStatue(article);
	}

	@Override
	public List<Article> getLastArticleList(HashMap<String, Object> paramMap) {
		List<Article> articleList = articleMapper.getLastArticleList(paramMap);
		return articleList;
	}

}
