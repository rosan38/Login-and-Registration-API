/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Users;

/**
 *
 * @author rosan
 */
public interface UserService {

    String regUser(Users users);

    String login(Users users);

}
