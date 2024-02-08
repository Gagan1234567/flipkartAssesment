package com.flipkartTechAssignment.onlineConnectionService;

import com.flipkartTechAssignment.onlineConnectionModel.User;

import java.util.List;

public interface UserService {
    List<User> getPotentialMatches(String username);
}
