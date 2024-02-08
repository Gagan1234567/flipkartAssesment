package com.flipkartTechAssignment.flipkartTechAssignmentTest.onlineConnectionRepository;

import com.flipkartTechAssignment.onlineConnectionModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    void addAll(List<User> users);

    List<User> getAllUsers();

    List<User> findPotentialMatches(String username);
}
