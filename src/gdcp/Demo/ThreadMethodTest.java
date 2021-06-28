package gdcp.Demo;

/**
 * 测试Thread中的常用方法
 * 1.start()启动当前线程:调用当前线程的run方法
 * 2.run()通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.curreentThrad()//静态方法，返回当前代码执行线程String
 * 4.getName()获取当前线程的名字
 * 5.setName()设置当前线程的名字
 * 6.yield();释放当前cpu执行权，给其他线程
 * 7.join();在线程a中调用线程b的join方法则线程a就进入阻塞状态，直到线程b执行
 * 完成之后，线程a才结束阻塞状态
 * 8.stop().已经过时，强制结束线程，生命周期结束
 * 9.sleep(long millitime);让线程“睡眠”1秒=1000毫秒(倒计时)
 *                          在指定时间内，当前线程是阻塞状态
 * 10.isAlive()判断当前线程是否存活 boolean
 *
 *
 * 线程的优先级:
 * 1MIN_PRIORITY = 1;
 * 2 NORM_PRIORITY = 5;
 * 3MAX_PRIORITY = 10;
 * 2.如何获取和设置当前线程的优先级
 * getPriority();//获取当前线程的优先级
 * setPriority(int p);//设置优先级
 * 说明:高优先级的线程要抢占低优先级线程cpu的执行权，但是从概率上讲，高优先级的线程
 * 高概率的情况下被执行，并不意味着只有当前高优先级的线程执行完以后，低优先级的线程才会执行
 *
 * @author WeiLiang
 * @date 2021/6/21 - 20:54
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread3 myThread3=new MyThread3("Thread:1");
        myThread3.setName("线程一");
        myThread3.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(i);
            }
            if (i==20){
                try {
                    myThread3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+i);
            }
            if (i%20==0){
                this.yield();
            }
        }
    }
    public MyThread3(String name){
        super(name);
    }
}
