package com.cxmhfut.controller;

import com.cxmhfut.interceptor.AInterceptor;
import com.cxmhfut.interceptor.BInterceptor;
import com.cxmhfut.interceptor.ClassInterceptor;
import com.cxmhfut.interceptor.MethodInterceptor;
import com.cxmhfut.model.Blog;
import com.cxmhfut.service.ServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;

@Before(ClassInterceptor.class)
public class IndexController extends Controller {
    /**
     * action定义模板
     */
    @Clear
    public void index() {
        String msg = getPara("msg", "defaultMessage");
        String values[] = getParaValues("test");//checkbox
        setAttr("msg", "Hello JFinal 3.0----->" + msg);
        getModel(Blog.class);
        renderTemplate("index.html");
    }

    public void add() {
        renderTemplate("add.html");
    }

    public void doAdd() {
        System.out.println(getModel(Blog.class));
        renderText("提交成功");
    }

    /**
     * 测试 Method Interceptor 的用法
     */
    @Before(MethodInterceptor.class)
    public void testMethod() {
        renderTemplate("index.html");
    }

    public void testInjectMethod() {
        ServiceImpl service = Duang.duang(ServiceImpl.class);
        //ServiceImpl service = Duang.duang(ServiceImpl.class, InjectInterceptor.class);
        service.testInject();
        renderTemplate("index.html");
    }

    @Before({AInterceptor.class, BInterceptor.class})
    public void testInterceptorStack() {
        renderTemplate("index.html");
    }
}
