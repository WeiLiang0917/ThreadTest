package gdcp.java2;

/**
 * @author WeiLiang
 * @date 2021/6/27 - 15:45
 */
class Number implements Runnable{
    private int number=1;
    @Override
    public void run() {

            while (true){
                synchronized (this){
                    notify();
                if (number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        wait();//使用调用如下wait()方法的线程进入阻塞状态

                    } catch (InterruptedException e) {


                    }
                }else {
                    break;
                }
            }
        }

    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number n=new Number();
        Thread t1=new Thread(n);
        Thread t2=new Thread(n);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
