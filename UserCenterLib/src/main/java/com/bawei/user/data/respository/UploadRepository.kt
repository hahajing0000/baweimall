package com.bawei.user.data.respository

import com.bawei.provider.entity.protocol.BaseResp
import com.bawei.user.data.api.UploadApi
import com.zy.netutilslib.RetrofitFactory
import rx.Observable
import javax.inject.Inject

/*
    上传相关 数据层
 */
class UploadRepository @Inject constructor(){
    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }


}
