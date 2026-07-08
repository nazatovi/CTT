package com.ctt.adminispmobile.model

import com.google.gson.annotations.SerializedName

data class MonitoringData(

    @SerializedName("userName")
    val userName: String,

    @SerializedName("framedIpAddress")
    val framedIpAddress: String,

    @SerializedName("acctSessionTime")
    val acctSessionTime: String,

    @SerializedName("acctStartTime")
    val acctStartTime: String,

    @SerializedName("acctInputOcTets")
    val acctInputOctets: Double,

    @SerializedName("acctOutputOcTets")
    val acctOutputOctets: Double,

    @SerializedName("callingStationId")
    val callingStationId: String,

    @SerializedName("nasIpAddress")
    val nasIpAddress: String,

    @SerializedName("lastUpdate")
    val lastUpdate: String,

    @SerializedName("link")
    val connected: Boolean,

    @SerializedName("id")
    val id: Long

)