package com.cxmhfut.common;

import com.cxmhfut.controller.IndexController;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {

    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/", IndexController.class);
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
}
