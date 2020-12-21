package com.bawei.user.service.impl

import com.bawei.base.ext.convert
import com.bawei.base.ext.convertBoolean
import com.bawei.user.data.protocol.UserInfo
import com.bawei.user.data.respository.UserRepository
import com.bawei.user.service.UserService
import rx.Observable
import javax.inject.Inject

/*
    用户模块业务实现类
 */
class UserServiceImpl @Inject constructor():UserService {
    @Inject
    lateinit var repository:UserRepository

    /*
        注册
     */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode).convertBoolean()
    }

    /*
        登录
     */
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile, pwd, pushId).convert()
    }

    /*
        忘记密码
     */
    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return repository.forgetPwd(mobile, verifyCode).convertBoolean()
    }

    /*
        重置密码
     */
    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return repository.resetPwd(mobile, pwd).convertBoolean()
    }

    /*
        修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }

}
