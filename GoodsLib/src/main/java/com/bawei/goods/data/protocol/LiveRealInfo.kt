package com.bawei.goods.data.protocol

import android.os.Parcel
import android.os.Parcelable

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
data class LiveRealInfo(val id:Int,val livepath:String,val livedesc:String,val imgpath:String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(livepath)
        parcel.writeString(livedesc)
        parcel.writeString(imgpath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LiveRealInfo> {
        override fun createFromParcel(parcel: Parcel): LiveRealInfo {
            return LiveRealInfo(parcel)
        }

        override fun newArray(size: Int): Array<LiveRealInfo?> {
            return arrayOfNulls(size)
        }
    }
}