package com.am.test.application;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Application {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        addUsers();
        showUsers();
        changeTimestampAndStatus();
        showUsers();
        checkTimestampStatus();
        showUsers();


    }

    public static void showUsers() {
        System.out.println();
        System.out.println("Users :");
        for (User user : users) System.out.println(user);
        System.out.println();
    }

    public static void addUsers(){
        System.out.println("\nAdding users!\n");
        users.add(new User("Ion", "Deleu", 34, "ion.deleu@mail.ru"));
        users.add(new User("Mihai", "Mereuta", 22, "mihai.mereuta@mail.ru"));
        users.add(new User("Sergiu", "Rusu", 46, "rusu.serghei@mail.ru"));
        users.add(new User("Denis", "Melnic", 67, "melnic.denis4@mail.ru"));
        users.add(new User("Cristi", "Burduja", 32, "burduja_cristi@mail.ru"));
        users.add(new User("Ilie", "Neamtu", 18, "ilie_neamtu@mail.ru"));
    }

    public static void changeTimestampAndStatus(){
        System.out.println("\nChange timestamp and status for 4 and 5 users\n");
        Calendar c = Calendar.getInstance();
        Date referenceDate = new Date();
        c.setTime(referenceDate);
        c.add(Calendar.DAY_OF_YEAR, -2);
        users.get(4).setTimestamp(new Timestamp(c.getTimeInMillis()));
        c.setTime(referenceDate);
        c.add(Calendar.MONTH, -3);
        users.get(5).setTimestamp(new Timestamp(c.getTimeInMillis()));
        users.get(5).setStatusInactive();
    }

    public static void checkTimestampStatus(){
        System.out.println("\nChecking and changing user status by timestamp\n");
        for(User user : users){
            if(user.status == User.Status.NEW && (System.currentTimeMillis() >= (user.getTimestamp().getTime() + (24. * 3600 * 1000))) ){
                user.setStatusActive();
            }else if(user.status == User.Status.INACTIVE && (System.currentTimeMillis() >= (user.getTimestamp().getTime() + (30. * 24 * 3600 * 1000)))){
                user.setStatusBlocked();
            }
        }
    }
}
