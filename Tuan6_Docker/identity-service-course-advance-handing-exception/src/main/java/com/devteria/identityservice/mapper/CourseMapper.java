package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.CourseRequest;
import com.devteria.identityservice.dto.response.CourseResponse;
import com.devteria.identityservice.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toFile(CourseRequest request);
    CourseResponse toFileResponse(Course course);

}
