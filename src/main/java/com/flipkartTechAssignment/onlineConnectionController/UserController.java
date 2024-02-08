package com.flipkartTechAssignment.onlineConnectionController;

import com.flipkartTechAssignment.onlineConnectionModel.User;
import com.flipkartTechAssignment.onlineConnectionService.UserService;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}/potential-matches")
    public List<User> getPotentialMatches(@PathVariable String username) {
        return userService.getPotentialMatches(username);
    }
}
