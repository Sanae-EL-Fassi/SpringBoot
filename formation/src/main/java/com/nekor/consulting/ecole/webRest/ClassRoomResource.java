package com.nekor.consulting.ecole.webRest;

import java.util.ArrayList;
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

import com.nekor.consulting.ecole.model.ClassRoom;
import com.nekor.consulting.ecole.model.Teacher;
import com.nekor.consulting.ecole.repository.ClassRoomRepository;

@RestController
@RequestMapping("/api/classroom")
public class ClassRoomResource {

	@Autowired
	ClassRoomRepository classRoomRepository;

	@PostMapping
	private void createUpdateClassRoom(@RequestBody ClassRoom classRoom) {
		if (classRoom.getId() == null) {
			classRoom.setId(UUID.randomUUID().toString());
		}
		classRoomRepository.save(classRoom);
	}

	@DeleteMapping("{classRoomId}")
	private void createClassRoom(@PathVariable String classRoomId) {
		classRoomRepository.deleteById(classRoomId);
	}

	@GetMapping
	private Optional<ClassRoom> findClassRoomId(@RequestParam(name = "classRoomId") String classRoomId) {
		return classRoomRepository.findById(classRoomId);
	}

	@GetMapping("/all")
	private List<ClassRoom> findAllClassRooms() {
		return classRoomRepository.findAll();
	}

	@GetMapping("/teachers/{classRoomId}")
	private List<String> findTeachersId(@PathVariable String classRoomId) {
		
		List<String> teachersIds = null;
		Optional<ClassRoom> classtemp = classRoomRepository.findById(classRoomId);
		
		if (classtemp != null) {
			teachersIds = new ArrayList<String>();
			List<Teacher> teachers = classtemp.get().getTeachers();
			for (Teacher t : teachers) {
				teachersIds.add(t.getId());
			}
		}
		return teachersIds;

	}

}
