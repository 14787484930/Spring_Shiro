import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author zxl
 * @date 2019/8/27 14:37
 * @describe
 */
public class ShiroUtils {

    public static Subject getSubject(){
        //获取securitymanager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro02/shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        //将SecuritityManger绑定给SecuritityUtils
        SecurityUtils.setSecurityManager(securityManager);

        //通过SecuritityUtils得到subject
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
}
