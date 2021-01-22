package com.phaytran.dynamicViews

import java.io.Serializable

class Data:Serializable {
    var id:Int = 0
    lateinit var name:String

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }

    constructor()


}