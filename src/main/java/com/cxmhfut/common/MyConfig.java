package com.cxmhfut.common;

import com.cxmhfut.interceptor.GlobalInterceptor;
import com.cxmhfut.model.Blog;
import com.cxmhfut.route.AdminRoute;
import com.cxmhfut.route.FrontRoute;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("db.properties");
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
        //配置c3p0数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));

        plugins.add(druidPlugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);

        arp.setBaseSqlTemplatePath(PathKit.getWebRootPath()+"/WEB-INF");
        arp.addSqlTemplate("sql/demo.sql");

        arp.addMapping("t_blog", Blog.class);
        plugins.add(arp);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new GlobalInterceptor());
        //interceptors.addGlobalServiceInterceptor(new InjectInterceptor());//给所有的Service添加拦截器
    }

    @Override
    public void configHandler(Handlers handlers) {
        //创建上下文
        handlers.add(new ContextPathHandler("ctx"));
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
