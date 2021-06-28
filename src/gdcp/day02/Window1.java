package gdcp.day02;

/**
 * @author WeiLiang
 * @date 2021/6/22 - 21:41
 * 使用同步代码块解决线程继承安全性
 *
 */
public class Window1 { public static void main(String[] args) {
    Window t1=new Window();
    Window t2=new Window();
    Window t3=new Window();
    t1.setName("窗口一");
    t2.setName("窗口二");
    t3.setName("窗口三");
    t1.start();
    t2.start();
    t3.start();

}
}
class Window extends Thread{
    private static int ticket=100;
    static Object obj=new Object();
    @Override
    public void run() {
        synchronized (obj){//此时的this：唯一的window1的对象
            while(true){
                if(ticket>0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"卖票票号为:"+ticket);
                    ticket--;
                }else {
                    break;
                }
        }

        }
    }
}