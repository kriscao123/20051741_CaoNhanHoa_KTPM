package com.devteria.identityservice.controller;

import com.devteria.identityservice.dto.request.ApiResponse;
import com.devteria.identityservice.dto.request.CourseRequest;
import com.devteria.identityservice.dto.response.CourseResponse;
import com.devteria.identityservice.service.CourseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CourseController {
    CourseService courseService;

    @PostMapping
    ApiResponse<CourseResponse> create(@RequestBody CourseRequest request){
        return  ApiResponse.<CourseResponse>builder()
                .result(courseService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<CourseResponse>> getAll(){
        return ApiResponse.<List<CourseResponse>>builder()
                .result(courseService.getAll())
                .build();
    }

    @DeleteMapping("/{file}")
    ApiResponse<Void> delete(@PathVariable String file){
        courseService.delete(file);
        return ApiResponse.<Void>builder().build();
    }
}
