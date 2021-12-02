package com.hackerrank.springsecurity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.springsecurity.dto.Book;
import com.hackerrank.springsecurity.dto.Reader;
import com.hackerrank.springsecurity.dto.User;
import com.hackerrank.springsecurity.repository.UserRepository;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityTest {
    ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    private Book book;
    private Reader reader;
    
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void contextLoads() {
        System.out.println("Inside contextLoads");
    	userRepository.save(new User(1l, "john_doe", "{noop}student_password", "READER_USER"));
    	userRepository.save(new User(2l, "jane_doe", "{noop}admin_password", "OFFICE_ADMIN"));
    	
        book = new Book(123, "Basic Mathematics", "Tom", "22B", null);
        reader = new Reader(100, "Jerry", "Mouse");
        mapper = new ObjectMapper();
    }

    @Test
    public void testGetBookDetailsWithNoCredentials() throws Exception {
        mockMvc.perform(get("/book"))
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.message").value("Books"));
    }

    @Test
    public void testAddBookWithAdminCredentials() throws Exception {
        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))
                .header("Authorization", "Basic amFuZV9kb2U6YWRtaW5fcGFzc3dvcmQ="))
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.message").value("Added"));
    }

    @Test
    public void testAddBookWithStudentCredentials() throws Exception {
        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))
                .header("Authorization", "Basic am9obl9kb2U6c3R1ZGVudF9wYXNzd29yZA=="))
        		.andExpect(status().isForbidden());
    }

    @Test
    public void testAddBookWithIncorrectCredentials() throws Exception {
        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))
                .header("Authorization", "Basic am9uX2RvZTpzdG50X3Bhc3N3b3Jk"))
                .andExpect(status().isUnauthorized());   
    }

    @Test
    public void testAddReaderToCourseWithStudentCredentials() throws Exception {
        mockMvc.perform(post("/reader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(reader))
                .header("Authorization", "Basic am9obl9kb2U6c3R1ZGVudF9wYXNzd29yZA=="))
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.message").value("Added"));
    }

    @Test
    public void testAddReaderToCourseWithAdminCredentials() throws Exception {
        mockMvc.perform(post("/reader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(reader))
                .header("Authorization", "Basic amFuZV9kb2U6YWRtaW5fcGFzc3dvcmQ="))
                .andExpect(jsonPath("$.statusCode").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.message").value("Added"));

    }

    @Test
    public void testAddReaderToCourseWithIncorrectCredentials() throws Exception {
        mockMvc.perform(post("/reader")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(reader))
                .header("Authorization", "Basic amFlX2RvZTphZG1pX3Bhc3N3b3Jk"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
                
    }

}
