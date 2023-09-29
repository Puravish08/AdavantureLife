package com.example.adventerlife.ModelClass

class TopDestinationModel {
    lateinit var location : String
    lateinit var image : String
    lateinit var key : String

    constructor(location:String,key : String,image : String)
    {
        this.location=location
        this.key=key
        this.image=image

    }

    constructor()
    {

    }
}