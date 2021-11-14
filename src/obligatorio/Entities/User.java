/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.Entities;

/**
 *
 * @author ADRO
 */
public class User {
    private String userId;
    private String name;
    private String lastName;
    private String password;
    private String phone;
    private String email;
    private String addressId;
    private String balance;
    
    public User(String idUser, String name, String lastName, String password, String phone, String email, String idAddress, String balance) {
        this.userId = idUser;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.addressId = idAddress;
        this.balance = balance;
    }

    public String getBalance() {
        return balance;
    }

    public String getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getIdAddress() {
        return addressId;
    }
    
}
