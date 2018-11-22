package com.cxmhfut.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
    /**
     * action定义模板
     */
    public void index() {
        String msg = getPara("msg", "defaultMessage");
        String values[] = getParaValues("test");//checkbox
        setAttr("msg", "Hello JFinal 3.0----->" + msg);
        renderTemplate("index.html");
    }
}
