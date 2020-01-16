package com.lks.demo.model.proxy;

/**
 *
 * 代理对象
 *
 * @author lks
 * @Time 2019/11/13
 **/
public class ProxyProject implements Subject{

    private Project project;

    @Override
    public void request() {
        if(project == null){
            project = new Project();
        }
        preRequest();
        project.request();
        postRequest();

    }

    public void preRequest()
    {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest()
    {
        System.out.println("访问真实主题之后的后续处理。");
    }


}
