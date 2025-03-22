package com.devteria.identityservice.service;

import com.devteria.identityservice.dto.request.CourseRequest;
import com.devteria.identityservice.dto.response.CourseResponse;
import com.devteria.identityservice.entity.Course;
import com.devteria.identityservice.mapper.CourseMapper;
import com.devteria.identityservice.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CourseService {
    CourseRepository courseRepository;
    CourseMapper courseMapper;

    public CourseResponse create(CourseRequest request){
        Course course = courseMapper.toFile(request);
        course = courseRepository.save(course);
        return courseMapper.toFileResponse(course);
    }

    public List<CourseResponse> getAll(){
        var files= courseRepository.findAll();
        return files.stream().map(courseMapper::toFileResponse).toList();
    }

    public void delete(String fileName){
        courseRepository.deleteById(fileName);
    }
}
