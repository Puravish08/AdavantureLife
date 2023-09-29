package com.example.adventerlife.ModelClass

import android.net.Uri

class MountainModal {
    var palce: String = ""
    var Location: String = ""
    var Price: String = ""
    var Rate: String = ""
    var key: String = ""
    var ImageUri: String = ""

    constructor(

        palce: String,
        Location: String,
        Price: String,
        Rate: String,
        key: String,
        ImageUri: Uri
    )
    {
        this.ImageUri = ImageUri.toString()
        this.palce = palce
        this.Location = Location
        this.Price = Price
        this.Rate = Rate
        this.key = key
    }
    constructor() {

    }
}