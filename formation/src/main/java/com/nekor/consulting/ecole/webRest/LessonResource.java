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

import com.nekor.consulting.ecole.exceptions.MyException;
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
	private void createLesson(@PathVariable(name = "lessonId") String lessonId) throws MyException {
		Optional<Lesson> lessonTemp = lessonRepository.findById(lessonId);
		if (!lessonTemp.isPresent()) {
			throw new MyException("there is no Lesson with id: " + lessonId);
		}
		lessonRepository.deleteById(lessonId);
	}

	@GetMapping
	private Optional<Lesson> findlessonId(@RequestParam(name = "lessonId") String lessonId) throws MyException {
		Optional<Lesson> lessonTemp = lessonRepository.findById(lessonId);
		if (!lessonTemp.isPresent()) {
			throw new MyException("there is no Lesson with id: " + lessonId);
		}
		return lessonTemp;

	}

	@GetMapping("/classId/{classRoomId}")
	private List<Lesson> findyClassId(@PathVariable String classRoomId) throws MyException {
		List<Lesson> tempLessons = lessonRepository.findByClassRoomId(classRoomId);
		if (tempLessons.size() == 0) {
			throw new MyException("there is no Lesson with the class room id: " + classRoomId);
		}
		return tempLessons;
	}

	// find lesson by teacher id
	@GetMapping("/teacherId/{teacherId}")
	private List<Lesson> findyTeacherId(@PathVariable String teacherId) throws MyException {
		List<Lesson> tempLessons = lessonRepository.findByTeacherId(teacherId);
		if (tempLessons.size() == 0) {
			throw new MyException("there is no Lesson with the teacher id: " + teacherId);
		}
		return tempLessons;
	}

	// find lesson by student id
	@GetMapping("/studentId/{studentId}")
	private List<Lesson> findyStudnetId(@PathVariable String studentId) throws MyException {
		List<Lesson> tempLessons = lessonRepository.findByStudentId(studentId);
		if (tempLessons.size() == 0) {
			throw new MyException("there is no Lesson with the student id: " + studentId);
		}
		return tempLessons;
	}

	// find by student id and subject id
	@GetMapping("/studentsubject")
	private List<Lesson> findByStudentIdSubjectId(@RequestParam(name = "id1") String studentId,
			@RequestParam(name = "id2") String subjectId) throws MyException {
		List<Lesson> tempLessons = lessonRepository.findByStudentIdAndSubjectId(studentId, subjectId);
		if (tempLessons.size() == 0) {
			throw new MyException(
					"there is no Lesson for the student id: " + studentId + " and subject id" + subjectId);
		}
		return tempLessons;
	}

	// find start date of courses by student id
	@GetMapping("/fromdate/{studentId}")
	private List<LocalDate> findDateStart(@PathVariable String studentId) throws MyException {
		List<LocalDate> tempLessons = lessonRepository.findFromDateByStudentId(studentId);
		if (tempLessons.size() == 0) {
			throw new MyException("there is no sart date for the student id: " + studentId);
		}
		return tempLessons;
	}

	// get from date by student id and subject id
	@GetMapping("/fromdate")
	private List<LocalDate> findDateStart(@RequestParam(name = "id1") String studentId,
			@RequestParam(name = "id2") String subjectId) throws MyException {
		List<LocalDate> tempLessons = lessonRepository.findFromDateByStudentAndSubject(studentId, subjectId);
		if (tempLessons.size() == 0) {
			throw new MyException(
					"there is no sart date for the student id: " + studentId + " and subject id" + subjectId);
		}
		return tempLessons;
	}

	@GetMapping("/nextcourses/{lessonId}")
	private List<Lesson> getNextCourses(@PathVariable(name = "lessonId") String lessonId) throws MyException {
		List<Lesson> tempLessons = lessonRepository.getNextCourses(lessonId);
		if (tempLessons.size() == 0) {
			throw new MyException("there is no next course for the lesson id: " + lessonId);
		}
		return tempLessons;
	}

	@GetMapping("/lastcourses/{lessonId}")
	private List<Lesson> getLastCourses(@PathVariable(name = "lessonId") String lessonId) throws MyException {
		List<Lesson> tempLessons = lessonRepository.getLastCourses(lessonId);
		if (tempLessons.size() == 0) {
			throw new MyException("there is no last course for the lesson id: " + lessonId);
		}
		return tempLessons;
	}

	@GetMapping("/all")
	private List<Lesson> findAlllessons() throws MyException {
		List<Lesson> tempLessons =  lessonRepository.findAll();
		if (tempLessons.size() == 0) {
			throw new MyException("there is no lessons!!");
		}
		return tempLessons;
	}


}
