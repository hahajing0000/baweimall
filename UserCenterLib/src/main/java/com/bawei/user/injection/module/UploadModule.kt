package com.bawei.user.injection.module

import com.bawei.user.service.UploadService
import com.bawei.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/*
    上传Module
 */
@Module
class UploadModule {

    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }

}
