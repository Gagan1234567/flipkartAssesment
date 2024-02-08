package com.flipkartTechAssignment.onlineConnectionUtil;


import com.flipkartTechAssignment.onlineConnectionModel.User;

import java.util.Comparator;

public class MatchComparator implements Comparator<User> {
    private final User currentUser;

    public MatchComparator(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public int compare(User user1, User user2) {

        int ageGap1 = Math.abs(currentUser.getAge() - user1.getAge());
        int ageGap2 = Math.abs(currentUser.getAge() - user2.getAge());
        if (ageGap1 != ageGap2) {
            return Integer.compare(ageGap1, ageGap2);
        }


        if (currentUser.getCity().equals(user1.getCity()) && !currentUser.getCity().equals(user2.getCity())) {
            return -1;
        } else if (!currentUser.getCity().equals(user1.getCity()) && currentUser.getCity().equals(user2.getCity())) {
            return 1;
        }


        if (!currentUser.getGender().equals(user1.getGender()) && currentUser.getGender().equals(user2.getGender())) {
            return -1;
        } else if (currentUser.getGender().equals(user1.getGender()) && !currentUser.getGender().equals(user2.getGender())) {
            return 1;
        }


        return 0;
    }
}
