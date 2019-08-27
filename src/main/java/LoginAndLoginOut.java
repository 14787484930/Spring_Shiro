import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * @author zxl
 * @date 2019/8/27 11:55
 * @describe
 */
public class LoginAndLoginOut {

    public static void main(String[] args) {
        


        Subject subject = ShiroUtils.getSubject();

        //创建登录令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zxl","456");

        //进行登录
        subject.login(token);

        System.out.println(subject.isAuthenticated());

        //退出登录
        subject.logout();

        System.out.println(subject.isAuthenticated());

    }
}
