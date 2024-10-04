package com.CoffeeShop;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Coffee c;
        Inventory i = new Inventory();
        login l = new login();
        int op = 0, con = 0;
        String name, id, type, u_name, pwd;
        User u;
        
        do {
            System.out.println("Login Details ");
            System.out.println("Enter User Name: ");
            u_name = scan.next();
            System.out.println("Enter Password: ");
            pwd = scan.next();
            u = new User(u_name, pwd);
            int lc = l.checkUser   (u);
            
            if (lc==1) {
                do {
                    System.out.println("1-Add\n2-Update\n3-Remove\n4-Search\n5-Display\n6-Logout\n7-Exit");
                    System.out.println("Enter Option: ");
                    int option = scan.nextInt();
                    
                    switch (option) {
                        case 1:
                            System.out.println("Enter ID: ");
                            id = scan.next() + scan.nextLine();
                            System.out.println("Enter Name: ");
                            name = scan.next() + scan.nextLine();
                            System.out.println("Enter Type: ");
                            type = scan.next() + scan.nextLine();
                            System.out.println("Enter Price: ");
                            float price = scan.nextFloat();
                            i.add(new Coffee(id, name, type, price));
                            break;
                            
                        case 2:
                            System.out.println("Enter ID: ");
                            id = scan.next() + scan.nextLine();
                            i.update(id);
                            break;
                            
                        case 3:
                            System.out.println("Enter ID: ");
                            id = scan.next() + scan.nextLine();
                            i.remove(id);
                            break;
                            
                        case 4:
                            System.out.println("Enter ID: ");
                            id = scan.next() + scan.nextLine();
                            c = i.search(id);
                            if (c != null) {
                                System.out.println(c);
                            } else {
                                System.out.println("Coffee not found!");
                            }
                            break;
                            
                        case 5:
                            i.show();
                            break;
                            
                        case 6:
                            System.out.println("Logging out...");
                            op = -1;
                            break;
                            
                        case 7:
                            System.out.println("Exiting...");
                            op = -1;
                            con = -1;
                            break;
                            
                        default:
                            System.out.println("Invalid Option!");
                            break;
                    }
                    
                } while (op != -1);
                
            } else if(lc==2){
                i.show();
            }
            else
                System.out.println("Invalid Login. Showing Inventory.");
            
        } while (con != -1);
        
        scan.close();
    }
}