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
        UsernamePasswordToken token = new UsernamePasswordToken("zxl","123456");

        //进行登录
        try {
            subject.login(token);
            System.out.println("认证成功！");
        }catch (Exception e){
            System.out.println("认证失败！");
        }

        System.out.println(subject.isAuthenticated()); //判断是否认证过
        System.out.println(subject.hasRole("role2")); //判断是否
        System.out.println(subject.hasRole("role1"));
        System.out.println(subject.isPermitted("user:create"));

        //退出登录
        subject.logout();

        //System.out.println(subject.isAuthenticated());

    }

    /*public static void main(String[] args) {

        String password = "123456";
        String salt = "abc";

        Md5Hash md5Hash = new Md5Hash(password,salt,1);
        System.out.println(md5Hash.toString());


    }*/
}
