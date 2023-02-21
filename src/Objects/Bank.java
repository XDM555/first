package Objects;

import java.util.ArrayList;

public class Bank {
    private double schet;
    private static ArrayList <User> users=new ArrayList<User>();
    private static ArrayList<String> operations=new ArrayList<String>();

    public static void setUsers(User user) {
        users.add(user);
    }

    public static ArrayList<String> getOperations(){
        return operations;
    }
    public static void setOperations(String newOperation){
        operations.add(newOperation);
    }

    public static ArrayList <User> getUsers(){
        return users;
    }
}
