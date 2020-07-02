package maker.controller;


import maker.service.UserService;
import maker.utils.ResultInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public  ResultInfo index(){
        User user = userService.getUserById(1);
        ResultInfo info = ResultInfo.success("200","查询成功",user);
//        System.out.println(info);

        return info;

    }

}
