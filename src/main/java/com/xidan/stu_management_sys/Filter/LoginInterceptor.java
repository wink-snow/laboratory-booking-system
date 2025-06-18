package com.xidan.stu_management_sys.Filter;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private final ObjectMapper mapper = new ObjectMapper();  // 用于序列化 Result

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 保证返回中文不乱码
        response.setContentType("application/json;charset=UTF-8");

        // 1. 放行登录接口
        String url = request.getRequestURL().toString();
        log.info("请求的 url: {}", url);
        if (url.contains("login")) {
            log.info("登录操作，放行");
            return true;
        }

        // 2. 获取并校验 token
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头 token 为空");
            Result<?> error = Result.fail("NOT_LOGIN");
            response.getWriter().write(JSON.toJSONString(error));
            return false;
        }

        try {
            JwtUtils.parseJWT(jwt);          // 校验签名 & 过期时间
        } catch (Exception e) {
            log.info("解析令牌失败: {}", e.getMessage());
            Result<?> error = Result.fail("NOT_LOGIN");
            response.getWriter().write(JSON.toJSONString(error));
            return false;
        }

        log.info("令牌合法，放行");
        return true;
    }


    /**
     * 向前端输出统一的 JSON 结果，并阻止 Handler 继续执行
     */
    private boolean writeJson(HttpServletResponse response, Result<?> result) throws Exception {
        response.setStatus(HttpServletResponse.SC_OK);                 // 200
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(mapper.writeValueAsString(result));
        return false;  // 返回 false 代表拦截（不再进入 Controller）
    }
}
