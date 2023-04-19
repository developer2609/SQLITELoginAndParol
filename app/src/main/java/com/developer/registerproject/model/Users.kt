package com.developer.registerproject.model

 class Users {
     var id: Int? =null
     var name: String? = null
     var number: String? =null
     var username: String? =null
     var parol: String? =null





     constructor(id: Int?, name: String?, number: String?, username: String?, parol: String?) {
         this.id = id
         this.name = name
         this.number = number
         this.username = username
         this.parol = parol
     }

     constructor(name: String?, number: String?, username: String?, parol: String?) {
         this.name = name
         this.number = number
         this.username = username
         this.parol = parol
     }


 }