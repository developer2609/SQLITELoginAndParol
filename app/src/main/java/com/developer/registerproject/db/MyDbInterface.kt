package com.developer.registerproject.db

import com.developer.registerproject.model.Users

interface MyDbInterface {

    fun addUser(users: Users)
    fun getAllUsers():List<Users>

}