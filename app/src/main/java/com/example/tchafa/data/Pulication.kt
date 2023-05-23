package com.example.tchafa.data

data class Publication(
    var id :Int?,
    var PublishedBy :String,
    var Title :String,
    var Localisation :String,
    var Secteur :String,
    var Description :String,
    var duree :String,
    var salaire :String
){
    constructor():this(null,"","","","","","","")

}