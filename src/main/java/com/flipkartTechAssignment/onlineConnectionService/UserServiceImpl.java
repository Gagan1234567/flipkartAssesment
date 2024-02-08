package com.flipkartTechAssignment.onlineConnectionService;



import com.flipkartTechAssignment.flipkartTechAssignmentTest.onlineConnectionRepository.UserRepository;
import com.flipkartTechAssignment.onlineConnectionModel.User;
import com.flipkartTechAssignment.onlineConnectionUtil.MatchComparator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getPotentialMatches(String username) {
        List<User> users = userRepository.getAllUsers();
        User currentUser = findUserByUsername(users, username);
        if (currentUser == null) {
            throw new IllegalArgumentException("User not found");
        }

        List<User> potentialMatches = new ArrayList<>();
        for (User user : users) {
            if (isPotentialMatch(currentUser, user)) {
                potentialMatches.add(user);
            }
        }

        Collections.sort(potentialMatches, new MatchComparator(currentUser));

        return potentialMatches;
    }

    private User findUserByUsername(List<User> users, String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private boolean isPotentialMatch(User currentUser, User potentialMatch) {
        return (currentUser.getCity().equals(potentialMatch.getCity())
                || Math.abs(currentUser.getAge() - potentialMatch.getAge()) < 10)
                && !currentUser.equals(potentialMatch);
    }
}
