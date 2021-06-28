package gdcp.Demo;

/**
 * 创建三个窗口卖票，总票数为100张使用实现runnable接口的方式
 * @author WeiLiang
 * @date 2021/6/22 - 20:03
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        Thread t1 = new Thread(thread3);
        Thread t2 = new Thread(thread3);
        Thread t3 = new Thread(thread3);
        //因为共用一个thread3所以属性一致
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Thread3 implements Runnable{
private  int tirck=100;
    @Override
    public void run() {
        while (true){
            if (tirck>0){
                System.out.println(Thread.currentThread().getName()+tirck);
            }
            else {
                break;
            }
        }
    }
}
