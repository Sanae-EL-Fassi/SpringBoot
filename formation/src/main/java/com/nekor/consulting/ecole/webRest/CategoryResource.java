package com.nekor.consulting.ecole.webRest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nekor.consulting.ecole.model.Category;
import com.nekor.consulting.ecole.repository.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	  @PostMapping
	private void createUpdateCategory(@RequestBody Category category) {        
		  categoryRepository.save(category);
	    }
	  
	  @DeleteMapping("{name}")
	    private void createCategory(@PathVariable(name = "name") String name) {
		  categoryRepository.deleteById(name);
	    }
	  
	  @GetMapping
	    private Optional<Category> findCatrgoryId(@RequestParam(name = "name") String name) {
	      return  categoryRepository.findById(name);
	    }
	  
	  @GetMapping("/all")
	    private List<Category> findAllCatrgorys() {
	        return categoryRepository.findAll();
	    }
	  



}
