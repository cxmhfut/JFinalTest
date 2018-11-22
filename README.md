# JFinalTest

项目搭建过程

- pom.xml中配置填写JFinal的相关依赖描述
```xml
<dependencies>
    <dependency>
      <groupId>com.jfinal</groupId>
      <artifactId>jfinal</artifactId>
      <version>3.1</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>com.jfinal</groupId>
      <artifactId>jetty-server</artifactId>
      <version>8.1.8</version>
      <!--
      此处的 scope 值为 compile 仅为支持 IDEA 下启动项目
      打 war 包时需要改成 provided，以免将一些无用的 jar 打进去
      -->
      <scope>compile</scope>
    </dependency>
</dependencies>
```
- 创建MyConfig配置类
- web.xml中进行MyConfig的配置
```xml
<web-app>
    <display-name>Archetype Created Web Application</display-name>

    <filter>
        <filter-name>jfinal</filter-name>
        <filter-class>com.jfinal.core.JFinalFilter</filter-class>
        <init-param>
            <param-name>configClass</param-name>
            <param-value>com.cxmhfut.common.MyConfig</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>jfinal</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```
- 建立Controller并继承自JFinal的Controller
- 编写JFinal的启动方法，并启动项目
- 浏览器中输入访问地址