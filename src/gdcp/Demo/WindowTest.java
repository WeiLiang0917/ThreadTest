package gdcp.Demo;

/**
 * 例子，三个窗口买票，总票数100张
 * @author WeiLiang
 * @date 2021/6/22 - 19:41
 */
public class WindowTest {
    public static void main(String[] args) {
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
    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(getName()+"卖票票号为:"+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}