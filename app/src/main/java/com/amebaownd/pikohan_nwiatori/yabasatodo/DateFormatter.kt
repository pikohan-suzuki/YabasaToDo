package com.amebaownd.pikohan_nwiatori.yabasatodo

import java.text.SimpleDateFormat

object DateFormatter {
    private val pattern = SimpleDateFormat("yyyy/MM/dd")
    fun timeToDateStr(time:Long):String{
        return pattern.format(time)
    }
    fun dateStrToTime(dateStr:String):Long?{
        return pattern.parse(dateStr)?.time
    }
}