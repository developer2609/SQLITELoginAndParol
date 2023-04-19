package com.developer.registerproject.model

class Login {
    var id: Int? =null
    var login:String?=null
     var parol:String?=null

    constructor(login: String?, parol: String?) {
        this.login = login
        this.parol = parol
    }

    constructor(id: Int?, login: String?, parol: String?) {
        this.id = id
        this.login = login
        this.parol = parol
    }


}