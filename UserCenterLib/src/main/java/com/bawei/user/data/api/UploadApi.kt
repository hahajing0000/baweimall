package com.bawei.user.data.api

import com.bawei.provider.entity.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/*
    上传相关 接口
 */
interface UploadApi {

    /*
        获取七牛云上传凭证
     */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}
