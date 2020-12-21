package com.bawei.user.service.impl

import com.bawei.base.ext.convert
import com.bawei.user.data.respository.UploadRepository
import com.bawei.user.service.UploadService
import rx.Observable
import javax.inject.Inject

/*
    上传业务实现类
 */
class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
       return repository.getUploadToken().convert()
    }

}
