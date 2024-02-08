package com.flipkartTechAssignment.flipkartTechAssignmentTest.onlineCoonectionAppControllerTest;



import com.flipkartTechAssignment.onlineConnectionController.UserController;
import com.flipkartTechAssignment.onlineConnectionModel.User;
import com.flipkartTechAssignment.onlineConnectionService.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPotentialMatches() throws Exception {
        List<User> users = Arrays.asList(
                new User("Maria", "Female", 26, "Seattle"),
                new User("Julia", "Female", 29, "Boston")
        );
        when(userService.getPotentialMatches("John")).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/John/potential-matches")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
