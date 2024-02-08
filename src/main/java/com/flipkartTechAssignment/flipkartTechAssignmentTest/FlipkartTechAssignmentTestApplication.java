package com.flipkartTechAssignment.flipkartTechAssignmentTest;

import com.flipkartTechAssignment.flipkartTechAssignmentTest.onlineConnectionRepository.UserRepository;
import com.flipkartTechAssignment.onlineConnectionModel.User;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FlipkartTechAssignmentTestApplication {


	private final UserRepository userRepository;

	public FlipkartTechAssignmentTestApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {

		SpringApplication.run(FlipkartTechAssignmentTestApplication.class, args);
	}
	@PostConstruct
	public void initializeUsers() {
		List<User> users = Arrays.asList(
				new User("John", "Male", 27, "Boston"),
				new User("Maria", "Female", 26, "Seattle"),
				new User("Harry", "Male", 38, "Chicago"),
				new User("Julia", "Female", 29, "Boston")
		);
		userRepository.addAll(users);
	}
}
