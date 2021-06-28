package gdcp.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WeiLiang
 * @date 2021/6/27 - 13:55
 */
public class LockTest {
    public static void main(String[] args) {
        Window w1=new Window();
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
class Window implements Runnable{
        private static  int ticket=100;
        //实例化ReentrantLock
        private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //2.调用lock()锁定方法
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票数量"+ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }finally {
                //3.调用
                lock.unlock();
            }
            }

    }
}