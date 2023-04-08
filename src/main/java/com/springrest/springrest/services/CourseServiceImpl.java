package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseDao courseDao;
	/* List<Course>list; */
	public CourseServiceImpl() {
		
		/*
		 * list = new ArrayList<>(); list.add(new
		 * Course(145,"Java core course","This course contains basic of java"));
		 * list.add(new
		 * Course(4343,"Spring boot course","Creating rest api using spring boot"));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}
	@SuppressWarnings("deprecation")
	public Course getCourse(long courseId) {
		/*
		 * Course c= null; for(Course course : list) { if(course.getId() == courseId) {
		 * c = course; break; } }
		 */
		
		return courseDao.getOne(courseId);
		
	}

	@Override
	public Course addCourse(Course course) {
		/* list.add(course); */
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*
		 * list.forEach(e -> { if(e.getId() == course.getId()) {
		 * e.setTittle(course.getTittle()); e.setDescription(course.getDescription()); }
		 * });
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
		
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
	

}
