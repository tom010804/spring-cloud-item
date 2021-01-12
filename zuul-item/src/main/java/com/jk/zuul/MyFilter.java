package com.jk.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: 李旺
 * Date: 2021/1/11
 * Time: 20:54
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }
    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //获取浏览器请求路径
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String uri = request.getRequestURI();
        //判断路径是否过滤
        //是：不过滤 false  否 ：不是登录 true
        if (uri.contains("/page/login")){//不过滤
            return false;
        }
        if (uri.contains("/page/singOn")){//不过滤
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        if (StringUtils.isEmpty(userName)){//为空   为未登录
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(400);
            System.out.println("请求被拦截！！！！！！！");
            HttpServletResponse response = currentContext.getResponse();
            try {
                request.getRequestDispatcher("/login.html").forward(request,response);
            } catch (ServletException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {//已登录 继续往下走
            currentContext.setSendZuulResponse(true);
            System.out.println("不拦截！！！！！！！！");
        }
        return null;
    }
}
