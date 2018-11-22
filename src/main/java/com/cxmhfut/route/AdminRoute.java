package com.cxmhfut.route;

import com.cxmhfut.controller.AdminController;
import com.jfinal.config.Routes;

/**
 * 后端路由配置
 */
public class AdminRoute extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/WEB-INF");
        add("/admin", AdminController.class);
    }
}
