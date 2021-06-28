package gdcp.Demo;

/**
 * @author WeiLiang
 * @date 2021/6/27 - 13:22
 */
public class WindowTest4 {
    public static void main(String[] args) {
    Thread5 thread5 = new Thread5();
    Thread t1 = new Thread(thread5);
    Thread t2 = new Thread(thread5);
    Thread t3 = new Thread(thread5);
    //因为共用一个thread3所以属性一致
    t1.setName("窗口一");
    t2.setName("窗口二");
    t3.setName("窗口三");
    t1.start();
    t2.start();
    t3.start();
}
}
class Thread5 implements Runnable{
    private static int tirck=100;
    private static synchronized void show(){
        if (tirck>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+tirck);
            tirck--;
        }
    }
    @Override
    public void run() {
        while (true){
           show();
        }
    }
}
