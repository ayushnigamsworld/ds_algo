package com.hackerrank.springsecurity.controller;

import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.springsecurity.dto.ApiResponse;
import com.hackerrank.springsecurity.dto.Book;
import com.hackerrank.springsecurity.dto.Reader;

@RestController
public class CourseController {

    @RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_OFFICE_ADMIN")
    public ResponseEntity<ApiResponse> addCourse(@RequestBody Book course) {
        return new ResponseEntity(new ApiResponse(200, "Added"), HttpStatus.OK);
    }

    @RequestMapping(value = "/reader", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_READER_USER')")
    public ResponseEntity<ApiResponse> registerStudent(@RequestBody Reader student) {
        return new ResponseEntity(new ApiResponse(200, "Added"), HttpStatus.OK);
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasRole('ROLE_READER_USER')")
    public ResponseEntity<ApiResponse> getCourses() {
        return new ResponseEntity(new ApiResponse(200, "Books"), HttpStatus.OK);
    }
}