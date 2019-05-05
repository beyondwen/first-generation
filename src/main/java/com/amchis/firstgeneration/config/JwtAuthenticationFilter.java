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
            if (noNeedCheck(request)) {
                //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
                filterChain.doFilter(request, response);
            } else if (isKehuapp(request) || isGuanli(request) || isHuoban(request)) {
                String token = request.getHeader("Authorization");
                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                Claims claims = JwtUtil.parseJWT(token);
                String biaoji = (String) claims.get("Biaoji");
                String jueseBianma = (String) claims.get("JueseBianma");
                String shoujihao = (String) claims.get("Zhanghao");
                request.setAttribute("Biaoji", biaoji);
                request.setAttribute("JueseBianma", jueseBianma);
                request.setAttribute("Shoujihao", shoujihao);
                //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
                filterChain.doFilter(request, response);

            }
        } catch (Exception e) {
            System.out.println(e.getClass());
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

    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean noNeedCheck(HttpServletRequest request) {
        if ("/guanli/denglu".equals(request.getServletPath())) {
            return true;
        }
        if ("/guanli/appzuixinbanben".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/bangdingkongzhiqiluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/cuowuluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/gl12he13sluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/gl13he13sluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/gl1he2sluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/gl1he4sluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/gl2he16sluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/jiankangwenjuanluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/jiaoyanluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/jiaoyanleixingluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/jueseluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/kehuyaowuluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/manyiduluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/mokuailuru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/richangluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/shebeiliushuihaoluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/tianxiebiaojiluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/tijianluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/weixinzhanghaoluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/yonghuluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/yonghuguanlizheluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/ziduanluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/ziyuanluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/huoban/ziyuanleixingluru".equals(request.getServletPath())) {
            return true;
        }
        if ("/kehuapp/zhuce".equals(request.getServletPath())) {
            return true;
        }
        if ("/kehuapp/denglu".equals(request.getServletPath())) {
            return true;
        }
        return false;
    }


}