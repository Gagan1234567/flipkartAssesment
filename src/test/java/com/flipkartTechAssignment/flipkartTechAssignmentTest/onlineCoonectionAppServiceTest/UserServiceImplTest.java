package com.flipkartTechAssignment.flipkartTechAssignmentTest.onlineCoonectionAppServiceTest;


import com.flipkartTechAssignment.flipkartTechAssignmentTest.onlineConnectionRepository.UserRepository;
import com.flipkartTechAssignment.onlineConnectionModel.User;
import com.flipkartTechAssignment.onlineConnectionService.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPotentialMatches() {
        List<User> users = Arrays.asList(
                new User("Maria", "Female", 26, "Seattle"),
                new User("Julia", "Female", 29, "Boston")
        );
        when(userRepository.findPotentialMatches("John")).thenReturn(users);

        List<User> potentialMatches = userService.getPotentialMatches("John");
        assertEquals(2, potentialMatches.size());
    }
}
