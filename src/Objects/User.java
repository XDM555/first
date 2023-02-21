package Objects;

import java.util.ArrayList;

public class User{
    private String name;
    private String surname;
    private int pin;
    private double schet=0;

    public User(String name, String surname, int pin) {
        setName(name);
        setSurname(surname);
        setPin(pin);
    }

    public double getSchet(){
        return schet;
    }
    public void setSchet(double chang ){
        this.schet+=chang;
    }

    public double getPin(){
        return pin;
    }
    public void setPin(int newPin){
        this.pin=newPin;
    }

    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String newSurname){
        this.surname=newSurname;
    }

}
