package gdcp.day02;

/**
 * @author WeiLiang
 * @date 2021/6/22 - 21:13
 * 1.问题：过程中出现重票错票——线程安全问题
 * 2.问题出现的原因:当某个线程操作车票过程中，尚未操作完成时，其他
 * 线程参与进来，也操作车票
 * 3.如何解决:加锁，当一个线程在操作共享数据，其他线程不能进来，直到线程a操作完，其他
 * 线程才可以进来操作ticket，即使线程出现阻塞，也不能改变
 * 4.java中，我们通过同步机制，来解决线程的安全问题
 * 方式一:同步代码块
 *  synchronized(同步监视器){
 *      //需要被同步的代码
 *  }
 *  说明:1操作共享数据的代码，即为需要被同步的代码
 *         2共享数据:多个数据共同操作的变量比如:ticket就是共享数据
 *         3同步监视器，俗称，锁.任何一个类的对象都可以充当锁.
 *         4要求：多个线程必须要共用同一把锁
 * 方式二:同步方法
 *5.同步的方式：解决了我们的线程安全问题---好处
 *              操作同步代码时，只能有一个线程参与
 *                  其他线程等待，相当于一个单线程的过程，效率低--局限性
 *
 */
public class Window2 {
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
    Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized(obj){
                if (tirck>0){
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                    System.out.println(Thread.currentThread().getName()+tirck);
                    tirck--;
                }
                else {
                    break;
                }
            }

        }
    }
}
