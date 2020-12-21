package com.bawei.user.injection.module

import com.bawei.user.service.UserService
import com.bawei.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/*
    用户模块Module
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }

}

