package gdcp.java;

/**
 * @author WeiLiang
 * @date 2021/6/27 - 13:30
 * 使用同步机制，将单例模式中的懒汉式写为线程安全的
 */
public class BankTest {
}
class Bank{

    private Bank(){
    }
    private static Bank instance=null;
    private static synchronized Bank getInstance(){
        if (instance==null){
            instance=new Bank();
        }
        return instance;
    }
}