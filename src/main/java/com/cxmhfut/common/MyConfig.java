package com.cxmhfut.common;

import com.cxmhfut.route.AdminRoute;
import com.cxmhfut.route.FrontRoute;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        //设置为开发模式
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        //routes.add("/", IndexController.class);
        //routes.add("/", IndexController.class, "/abc");
        //routes.add("/blog", BlogController.class, "/blog");
        //routes.add("/user", UserController.class, "/user");
        routes.add(new FrontRoute());
        routes.add(new AdminRoute());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }

    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/");
    }

    @Override
    public void afterJFinalStart() {
        super.afterJFinalStart();
        System.out.println("afterJFinalStart...");
    }

    @Override
    public void beforeJFinalStop() {
        super.beforeJFinalStop();
        System.out.println("beforeJFinalStop...");
    }
}
