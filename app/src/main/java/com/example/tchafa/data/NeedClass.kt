package com.example.tchafa.data
import java.time.Duration

data class Need(
    var Title :String,
    var Description :String,
    var localisation : String,
    var sector :String,
){
    constructor(): this("" ,"","","")
}
