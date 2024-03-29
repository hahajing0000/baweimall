package com.bawei.order.data.api

import retrofit2.http.POST
import rx.Observable
import com.bawei.order.data.protocol.AddShipAddressReq
import com.bawei.order.data.protocol.DeleteShipAddressReq
import com.bawei.order.data.protocol.EditShipAddressReq
import com.bawei.order.data.protocol.ShipAddress
import com.bawei.provider.entity.protocol.BaseResp
import retrofit2.http.Body


/*
    地址管理 接口
 */
interface ShipAddressApi {

    /*
        添加收货地址
     */
    @POST("shipAddress/add")
    fun addShipAddress(@Body req: AddShipAddressReq): Observable<BaseResp<String>>

    /*
        删除收货地址
     */
    @POST("shipAddress/delete")
    fun deleteShipAddress(@Body req: DeleteShipAddressReq): Observable<BaseResp<String>>


    /*
       hhhhh
    */
    @POST("shipAddress/is")
    fun delll(@Body req: DeleteShipAddressReq): Observable<BaseResp<String>>

    /*
        修改收货地址
     */
    @POST("shipAddress/modify")
    fun editShipAddress(@Body req: EditShipAddressReq): Observable<BaseResp<String>>

    /*
        查询收货地址列表
     */
    @POST("shipAddress/getList")
    fun getShipAddressList(): Observable<BaseResp<MutableList<ShipAddress>?>>

}
