package com.example.c868;

import com.example.c868.model.CallRecord;
import com.example.c868.model.User;
import com.example.c868.repositories.CallRepository;
import com.example.c868.repositories.UserRepository;
import com.example.c868.security.Authority;
import com.example.c868.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;

@SpringBootTest
@RunWith(SpringRunner.class)
class C868ApplicationTests {

    @Test
    void contextLoads() {
    }

}
