package com.example.tchafa.data

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.type.Date

data class User(
    var name: String,
    var surname: String,
    var birthday: String,
    var langue: String,
    var Town: String,
)
{
    constructor(): this("","","","","")
}
