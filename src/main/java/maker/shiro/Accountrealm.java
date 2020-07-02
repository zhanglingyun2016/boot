package maker.shiro;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import maker.entity.User;
import maker.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 继承AuthorizingRealm
 */
@Component  //注入到Bean里面
public class Accountrealm extends AuthorizingRealm {
//    @Autowired
//    private JwtUtils jwtUtils;
//    @Autowired
//    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @Override
    public boolean sipports(AuthenticationToken token){
        return token instanceof JwtToken;
    }





    /**
     * 进行登录处理
     * 拿到权限的用户信息，进行封装，再进行返回
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
//        JwtToken jwtToken = (JwtToken)token;
        int userId = 1;
//        userService.getUserByid(Long.valueOf(userId));
//
//        if (us){
//
//        }
//        String userId = jwtUtil.getClaimByToken(String) jwtToken.
        User user = userService.getUserById(Math.toIntExact(Long.valueOf(userId)));
        if (user == null){
            throw new UnknownAccountException("账户不存在！");
        }
//        AccountProfile profile = new AccountProfile();
//        BeanUtil.copyProperties(user);
        return null;
    }


    /**
     * 获取到 authenticationToken数据token 进行密码的校验
     * 校验成功返回基本的信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
