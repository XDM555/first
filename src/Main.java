import Objects.Admin;
import Objects.Bank;
import Objects.User;

import java.util.ArrayList;
import java.util.Scanner;

import static Objects.Bank.getUsers;

public class Main {
    public static void main(String[] args){
            mainmenu();
    }
    public static void mainmenu(){
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.print(textMenu.text[1] + textMenu.text[0]);
            char choise = sc.next().charAt(0);
            if (choise != '1' && choise != '2' && choise != '0') {
                System.out.println("Ты ввёл что-то не то, введи 1, 2 или 0");
                mainmenu();
                return;
            }
            else if(choise =='0'){
                //replay=false;
                return;
            }
            System.out.println(textMenu.text[2]);
            String name = sc.next();
            String surname = sc.next();
            int pin = sc.nextInt();
            if (choise == '1') {
                User user = new User(name, surname, pin);
                System.out.println(user);
                Bank.setUsers(user);
                System.out.println((Bank.getUsers()).size());
            } else {
                if ((Admin.name.equalsIgnoreCase(name)) && (Admin.surname.equals(surname)) && (Admin.pin == pin)) {
                    adminmenu();

                } else if (getUsers() != null) {
                    if (sravnenie(name, surname, pin) >= 0) {
                        System.out.println("Вы вошли в аккаунт!");
                        usersmenu(sravnenie(name, surname, pin));
                    } else {
                        System.out.println("Такого пользователя нет. Попробуйте еще раз!");
                    }
                } else {
                    System.out.println("Список клиентов пока пуст.");
                }
            }
        }
    }
    public static int sravnenie(String name, String surname, int pin) {
        ArrayList<User> massiv = getUsers();
        System.out.println(massiv.get(0).getName().equalsIgnoreCase(name));
        for (int i = 0; i < massiv.size(); i++) {
            if ((massiv.get(i).getName().equalsIgnoreCase(name)) && (massiv.get(i).getSurname().equalsIgnoreCase(surname)) && (massiv.get(i).getPin() == pin)) {
                return i;
            }
        }
        return -1;
    }
    public static void usersmenu(int id){
        Scanner sc=new Scanner(System.in);
        ArrayList<User> massiv = getUsers();
        double account_change;
        boolean replay=true;
        while(replay) {
            System.out.println(textMenu.text[4] + textMenu.text[0]);
            char choise = sc.next().charAt(0);
            switch ((int) choise) {
                case 49:
                    System.out.println("Ваш баланс составляет " + massiv.get(id).getSchet()/100);
                    break;
                case 50:
                    System.out.println("Введите сумму снятия: ");
                    account_change = 100 * sc.nextInt();
                    if (massiv.get(id).getSchet() >= account_change) {
                        massiv.get(id).setSchet((-1) * account_change);
                        Bank.setOperations("Пользователь: "+massiv.get(id).getName()+" "+massiv.get(id).getSurname()+". Снятие средств. Сумма - "+account_change/100);
                    } else {
                        System.out.println("Недостаточно средств");
                    }
                    break;
                case 51:
                    System.out.println("Введите сумму, которую хотите положить: ");
                    account_change = 100 * sc.nextInt();
                    massiv.get(id).setSchet(account_change);
                    Bank.setOperations("Пользователь: "+massiv.get(id).getName()+" "+massiv.get(id).getSurname()+". Начисление средств. Сумма - "+account_change/100);
                    break;
                case 52:
                    replay=false;
                    break;
                default:
                    System.out.println("Ты ввёл что-то не так!");
            }
        }
    }

    public static void adminmenu(){
        Scanner sc=new Scanner(System.in);
        boolean replay=true;
        while(replay){
            System.out.println(Admin.text + textMenu.text[0]);
            char choise = sc.next().charAt(0);
            switch ((int) choise) {
                case 49:
                    ArrayList<String> massiv = Bank.getOperations();
                    if (massiv != null) {
                        for (String i : massiv) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("Операций пока не было.");
                    }
                    break;
                case 50:
                    ArrayList<User> mass = Bank.getUsers();
                    if (mass != null) {
                        for (User i : mass) {
                            System.out.println(i.getName()+" " + i.getSurname() + " "+i.getSchet());
                        }
                    } else {
                        System.out.println("Пользователей пока нет.");
                    }
                    break;
                case 51:
                    replay = false;
                    break;
            }
        }
    }
}