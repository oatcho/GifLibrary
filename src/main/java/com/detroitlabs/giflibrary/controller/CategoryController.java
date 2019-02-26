package com.detroitlabs.giflibrary.controller;


import com.detroitlabs.giflibrary.data.CategoryRepository;
import com.detroitlabs.giflibrary.data.GifRepository;
import com.detroitlabs.giflibrary.model.Category;
import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String displayAllCategories(ModelMap modelMap){
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories";
    }

    @RequestMapping("/categories/{id}")
    public String findGifsByCategoryId (ModelMap modelMap, @PathVariable int id){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategory(id);
        modelMap.put("gifs", gifs);
        return "category";
    }

    @RequestMapping(value = "/search", method = GET)
    public String userSearchThroughGifs (ModelMap modelMap, @RequestParam ("q") String search){
        List<Gif> matchingGifs = gifRepository.searchResult(search);
        modelMap.put("matchingGifs", matchingGifs);
        return "search";
    }
}
