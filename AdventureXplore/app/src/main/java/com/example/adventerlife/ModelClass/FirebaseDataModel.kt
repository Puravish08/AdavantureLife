package com.example.adventerlife.ModelClass

import android.net.Uri

class FirebaseDataModel {
     var palce: String = ""
     var Price: String = ""
     var key: String = ""
     var imageUrl: String = ""

     constructor(
         palce: String,
         Price: String,
         key: String,
         ImageUri: Uri
     )
     {
         this.imageUrl = ImageUri.toString()
         this.palce = palce
         this.Price = Price
         this.key = key
     }
     constructor() {

     }




 }


