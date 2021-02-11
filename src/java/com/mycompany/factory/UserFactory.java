/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factory;

import com.mycompany.models.User;
import com.mycompany.proxy.AdministratorProxy;
import com.mycompany.proxy.StudentProxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author centti
 */
public class UserFactory {

    List<User> users = new ArrayList<>();

    public User createUser(String type) {
        users.add(new AdministratorProxy());
        users.add(new StudentProxy());
        for (User user : users) {
            return user.returner(type);
        }
        return null;
    }
}
