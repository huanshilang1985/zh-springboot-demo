package com.zh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Author zhanghe
 * Desc: 自定义过滤器
 * 自定义级别：
 * PRE --> 在路由之前使用，过滤IP，身份验证，日志打印
 * ROUTING --> 在路由器之后，微服务之前，比如负载均衡
 * POST --> 微服务之后，处理请求抱头，统一返回格式
 * ERROR --> 请求出错之后，异常信息的包装
 * <p>
 * Date 2019/8/29 18:03
 */
public class MyFilter extends ZuulFilter {

    /**
     * 定义过滤器级别类型
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义过滤器优先级别，越小越优先
     * 比如写2个PRE过滤器，（只对相同级别类型的过滤器起作用）
     */
    @Override
    public int filterOrder() {
        //PRE_DECORATION_FILTER_ORDER是默认级别，-1是要比默认级别高
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 过滤器是否启用：true、false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String remoteAddr = request.getRemoteAddr();
        String uri = request.getRequestURI();  //路由后的地址
        String uri2 = context.get(FilterConstants.REQUEST_URI_KEY).toString();
        System.out.println("访问者IP：" + remoteAddr + "访问了:" + uri + "路由后的地址：" + uri2);
        return null;
    }
}
