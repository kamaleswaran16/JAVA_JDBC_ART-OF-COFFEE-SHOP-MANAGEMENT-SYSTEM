package com.CoffeeShop;
public class login {
    
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin";
    private static final String VALID_USERNAME1 = "user";
    private static final String VALID_PASSWORD1 = "user";
    

    public int checkUser (User u) {
      
        if (u.getU_name().equals(VALID_USERNAME) && u.getPassword().equals(VALID_PASSWORD)) {
            System.out.println("Login successful ");
            return 1;
        } else if (u.getU_name().equals(VALID_USERNAME1) && u.getPassword().equals(VALID_PASSWORD1)) {
            System.out.println("Login successful ");
            return 2;
        }
        else{
            System.out.println("Login failed  " );
            return 2;
        }
    }
}
