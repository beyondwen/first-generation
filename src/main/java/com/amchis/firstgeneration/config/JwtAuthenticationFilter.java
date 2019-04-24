package com.amchis.firstgeneration.config;

import com.amchis.firstgeneration.common.ErrorVo;
import com.amchis.firstgeneration.common.ReponseVo;
import com.amchis.firstgeneration.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if ("/guanli/denglu".equals(request.getServletPath())) {
                //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
                filterChain.doFilter(request, response);
            }
            if (isKehuapp(request) || isGuanli(request)) {
                String token = request.getHeader("Authorization");
                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                Claims claims = JwtUtil.parseJWT(token);
                String biaoji = (String) claims.get("Biaoji");
                String jueseBianma = (String) claims.get("JueseBianma");
                request.setAttribute("Biaoji", biaoji);
                request.setAttribute("JueseBianma", jueseBianma);
                //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
                filterChain.doFilter(request, response);
            } else if (isHuoban(request)) {
                filterChain.doFilter(request, response);
            }
        } catch (Exception e) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ErrorVo errorVo = new ErrorVo();
            errorVo.setBianma("DENGLU_CHAOSHI");
            errorVo.setMiaoshu("登录信息已超时，请重新登录！");
            out.write(new ObjectMapper().writeValueAsString(new ReponseVo("0", errorVo)));
            out.flush();
            //out.close();
        }
    }


    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean isHuoban(HttpServletRequest request) {
        boolean match = pathMatcher.match("/huoban/**", request.getServletPath());
        return match;
    }

    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean isKehuapp(HttpServletRequest request) {
        return pathMatcher.match("/kehuapp/**", request.getServletPath());
    }

    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean isGuanli(HttpServletRequest request) {
        if ("/guanli/denglu".equals(request.getServletPath())) {
            return false;
        }
        return pathMatcher.match("/guanli/**", request.getServletPath());
    }

}