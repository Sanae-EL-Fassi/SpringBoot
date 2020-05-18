package com.nekor.consulting.ecole.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nekor.consulting.ecole.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, String>, JpaSpecificationExecutor<Lesson> {
	
	List<Lesson> findByClassRoomId(String idClassRoom);
	List<Lesson> findByTeacherId(String idTeacher);
	
	@Query("SELECT l from Lesson l where l.classRoom =(select s.classRoom from Student s where s.id =:idstudent)")
    List<Lesson> findByStudentId(@Param("idstudent") String idStudent);
	
	
	@Query("select l from Lesson l where l.subject.id=:idsubject and (l.classRoom=(select s.classRoom from Student s where s.id =:idstudent))")
	 List<Lesson> findByStudentIdAndSubjectId(@Param("idstudent") String idStudent, @Param("idsubject") String idSubject);
	
	
	
	@Query("SELECT l.createDate from Lesson l where l.classRoom =(select s.classRoom from Student s where s.id =:idstudent)")
    List<LocalDate> findFromDateByStudentId(@Param("idstudent") String idStudent);
	
	@Query("SELECT l.createDate from Lesson l where (l.classRoom =(select s.classRoom from Student s where s.id =:idstudent) and l.subject.id=:idsubject)")
    List<LocalDate> findFromDateByStudentAndSubject(@Param("idstudent") String idStudent,@Param("idsubject") String idSubject);

	
	@Query("select l from Lesson l where l.createDate>(select c.createDate from Lesson c where c.id=:idCourse)")
	List<Lesson> getNextCourses(@Param("idCourse") String idCourse);
}