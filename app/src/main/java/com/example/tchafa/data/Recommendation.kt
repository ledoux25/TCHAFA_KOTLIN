package com.example.tchafa.data

data class Recommendation(
    var FullName : String?,
    var EmailRecom : String?,
    var NumeroRecom : String?,
    var Recommendation : String?,
    var Etat : String?,
) {
    constructor():this("","","","","")
}