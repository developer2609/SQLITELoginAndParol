package com.developer.registerproject.db2

import com.developer.registerproject.model.Login

interface MyDbInterface2 {

    fun addlogin(login: Login)
    fun getLogins():List<Login>
}