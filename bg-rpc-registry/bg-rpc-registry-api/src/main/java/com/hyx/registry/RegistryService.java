package com.hyx.registry;

import com.hyx.common.URL;

import java.util.List;

/**
 * 服务注册与发现接口.
 *
 * @author hyx
 **/

public interface RegistryService {
    
    /**
     * 注册服务
     * @param url 服务路由
     */
    void register(URL url);
    
    /**
     * 取消注册路由
     * @param url 服务路由
     */
    void unregister(URL url);
    
    /**
     * 服务发现
     * @param url 服务路由
     * @return 路由列表
     */
    List<URL> lookup(URL url);
}
