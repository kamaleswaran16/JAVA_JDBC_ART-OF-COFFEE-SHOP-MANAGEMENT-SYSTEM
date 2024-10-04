package com.CoffeeShop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Inventory {
    private List<Coffee> coffees = new ArrayList<>();
    Statement stmt;
    ResultSet rs;
    String qry = null;
    DBUtil db = new DBUtil();
    int count;
    Connection con;

    public void add(Coffee c) {
        try {
            Connection con = db.getDBConnection();
            stmt = con.createStatement();
            qry = "INSERT INTO details(id, name, type, price) VALUES('" + c.getId() + "','" + c.getName() + "','" + c.getType() + "','" + c.getPrice() + "')";
            count = stmt.executeUpdate(qry);
            if (count == 1)
                System.out.println("Inserted Successfully");
            else
                throw new Exception();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Coffee search(String id) {
        try {
            Connection con = db.getDBConnection();
            stmt = con.createStatement();
            qry = "SELECT * FROM details WHERE id='" + id + "'";
            rs = stmt.executeQuery(qry);
            if (rs.next()) {
                return new Coffee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void update(String id) {
        Scanner sc = new Scanner(System.in);
        int ch;

        try {
            con = db.getDBConnection();
            stmt = con.createStatement();

            System.out.print("Enter to update 1.Name 2.Type 3.Price 4.Exit: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter New Name: ");
                    String newName = sc.next();
                    qry = "UPDATE details SET name='" + newName + "' WHERE id='" + id + "'";
                    break;

                case 2:
                    System.out.println("Enter New Type: ");
                    String newType = sc.next();
                    qry = "UPDATE details SET type='" + newType + "' WHERE id='" + id + "'";
                    break;

                case 3:
                    System.out.println("Enter New Price: ");
                    float newPrice = sc.nextFloat();
                    qry = "UPDATE details SET price=" + newPrice + " WHERE id='" + id + "'";
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
                    return;
            }

            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Record updated successfully.");
            } else {
                throw new Exception("No record updated.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(String id) {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            qry = "DELETE FROM details WHERE id='" + id + "'";
            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Coffee removed successfully.");
            } else {
                System.out.println("Coffee not found!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void show() {
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM details");
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}