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
import com.nekor.consulting.ecole.model.Subject;
import com.nekor.consulting.ecole.repository.SubjectRepository;

@RestController
@RequestMapping("/api/subject")
public class SubjectResource {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	  @PostMapping
	    private void createUpdateSubject(@RequestBody Subject subject) { 
		  if (subject.getId() == null) {
				subject.setId(UUID.randomUUID().toString());
			}
		  subjectRepository.save(subject);
	    }
	  
	  @DeleteMapping("{subjectId}")
	    private void createSubject(@PathVariable(name = "subjectId") String subjectId) {
		  subjectRepository.deleteById(subjectId);
	    }
	  
	  @GetMapping
	    private Optional<Subject> findSubjectId(@RequestParam(name = "subjectId") String subjectId) {
	      return  subjectRepository.findById(subjectId);
	    }
	  
	  @GetMapping("/all")
	    private List<Subject> findAllSubjects() {
	        return subjectRepository	.findAll();
	    }
	  



}
