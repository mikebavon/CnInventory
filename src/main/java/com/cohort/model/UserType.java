package com.cohort.model;

import com.cohort.bean.*;

public enum UserType {
    USER(LoginNormalUserBean.class),
    ADMIN(LoginAdminUserBean.class),
    SUPER_ADMIN(LoginSuperAdminUserBean.class),
    SUPER_SUPER_ADMIN(LoginSuperSuperAdminUserBean.class);

    private Class<? extends LoginUserBeanI> clazz;

    UserType(Class<? extends LoginUserBeanI> clazz){
        this.clazz = clazz;
    }

    public Class<? extends LoginUserBeanI> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends LoginUserBeanI> clazz) {
        this.clazz = clazz;
    }
}
