package com.nekor.consulting.ecole.webRest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nekor.consulting.ecole.model.ContentType;
import com.nekor.consulting.ecole.model.Establishment;
import com.nekor.consulting.ecole.repository.ContentTypeRepository;

@RestController
@RequestMapping("/api/contenttype")
public class ContentTypeResource {
	
	@Autowired
	ContentTypeRepository contentTypeRepository;
	
	  @PostMapping
	    private void createUpdateContentType(@RequestBody ContentType contentType) {        
		  contentTypeRepository.save(contentType);
	    }
	  
	  @DeleteMapping("{type}")
	    private void createContentType(@PathVariable(name = "type") String type) {
		  contentTypeRepository.deleteById(type);
	    }
	  
	  @GetMapping
	    private Optional<ContentType> findContentTypeId(@RequestParam(name = "type") String type) {
	      return  contentTypeRepository.findById(type);
	    }
	  
	  @GetMapping("/all")
	    private List<ContentType> findAllContentTypes() {
	        return contentTypeRepository.findAll();
	    }
	  



}
