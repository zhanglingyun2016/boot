package maker.shiro;


import cn.hutool.json.JSONUtil;
import org.apache.ibatis.annotations.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
\


/**
 *
 */
@Component
public class JwtFilter extends AuthenticatingFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if (StringUtils.isEmpty(jwt)){
            return null;
        }
        return new JwtToken(jwt);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if (StringUtils.isEmpty(jwt)){
            return true;
        }else {
            //校验jwt
//            Claim claim = jwtUtil.getClaimByToken(jwt);
            int claim;
            /*if (claim == null || jwtUtil.){

            }
            */
            //执行登录
        }

        return false;
    }
    protected boolean onLooginFailure(AuthenticationToken token,
                                      AuthenticationException e,
                                      ServletRequest request,
                                      ServletResponse response){
        HttpServletResponse response1 = (HttpServletResponse)response;
        Throwable throwable = e.getCause() == null?e:e.getCause();
       /* Result result = Result.fail(throwable.getMessage());
        String json = JSONUtil.toJsonStr(result);
        try {
            response1.getWriter().print(json);
        }catch (Exception e1){

        }*/

        return false;

    }

}
