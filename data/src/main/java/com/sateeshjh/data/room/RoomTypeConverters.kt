package com.sateeshjh.data.room

import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sateeshjh.domain.model.Owner

class RoomTypeConverters {

    @TypeConverters
    fun ownerToString(owner: Owner): String {
        return Gson().toJson(owner)
    }

    @TypeConverters
    fun stringToOwner(str: String): Owner {
        return Gson().fromJson(str, Owner::class.java)
    }
}

class ListOfStringToStringTypeConverter {

    @TypeConverters
    fun stringToOwner(str: List<String>): String {
        return Gson().toJson(str)
    }

    @TypeConverters
    fun strToListString(str: String): List<String> {
        return Gson().fromJson(str, object :TypeToken<List<String>>(){}.type)
    }
}