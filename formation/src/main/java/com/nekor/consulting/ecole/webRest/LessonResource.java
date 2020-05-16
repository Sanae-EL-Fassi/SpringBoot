package com.nekor.consulting.ecole.webRest;

import java.time.LocalDate;
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

import com.nekor.consulting.ecole.model.Lesson;
import com.nekor.consulting.ecole.repository.ClassRoomRepository;
import com.nekor.consulting.ecole.repository.LessonRepository;

@RestController
@RequestMapping("/api/lesson")
public class LessonResource {
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	ClassRoomRepository classRoomRepository;
	
	  @PostMapping
	    private void createUpdatelesson(@RequestBody Lesson lesson) { 
		  if (lesson.getId() == null) {
			  lesson.setId(UUID.randomUUID().toString());
			}
		  lessonRepository.save(lesson);
	    }
	  
	  @DeleteMapping("{lessonId}")
	    private void createLesson(@PathVariable(name = "lessonId") String lessonId) {
		  lessonRepository.deleteById(lessonId);
	    }
	  
	  @GetMapping
	    private Optional<Lesson> findlessonId(@RequestParam(name = "lessonId") String lessonId) {
	      return  lessonRepository.findById(lessonId);
	    }
	  
	  @GetMapping("/classId/{classRoomId}")
	  private List<Lesson> findyClassId(@PathVariable String classRoomId) {
	       return lessonRepository.findByClassRoomId(classRoomId);
		                 
	  }
	  //find lesson by teacher id
	  @GetMapping("/teacherId/{teacherId}")
	  private List<Lesson> findyTeacherId(@PathVariable String teacherId) {
	       return lessonRepository.findByTeacherId(teacherId);
		                 
	  }
	  //find lesson by student id
	  @GetMapping("/studentId/{studentId}")
	  private List<Lesson> findyStudnetId(@PathVariable String studentId) {
	       return lessonRepository.findByStudentId(studentId);
		                 
	  }
	  
	  //find by student id and subject id
	  @GetMapping("/studentsubject")
	  private List<Lesson> findByStudentIdSubjectId(@RequestParam(name="id1") String studentId, @RequestParam(name= "id2") String subjectId){
		  return lessonRepository.findByStudentIdAndSubjectId(studentId, subjectId);
	  }
	  
	  //find start date of courses by student id
	  @GetMapping("{studentId}")
	  private List<LocalDate> findDateStart(@PathVariable String studentId) {
	       return lessonRepository.findFromDateByStudentId(studentId);
		                 
	  }
	  
	  //find next cours
	/*  @GetMapping("/nextcourse/{lessonId}")
	  private Optional<Lesson> findNextLessons(@PathVariable String lessonId){
	 // return lessonRepository.findNextCourses(lessonId);
		  return  lessonRepository.findById(lessonId);
    }
			  
*/	  
	/*  @GetMapping("/nextcourses")
	  private List<Lesson> findNextLessons(){
		  return  lessonRepository.findNextCourses();
    }
    
    */
			    
	  @GetMapping("/all")
	    private List<Lesson> findAlllessons() {
	        return lessonRepository	.findAll();
	    }
	  



}
