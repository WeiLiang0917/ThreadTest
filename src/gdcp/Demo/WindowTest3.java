package gdcp.Demo;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author WeiLiang
 * @date 2021/6/27 - 13:14
 */
public class WindowTest3 {
    public static void main(String[] args) {

        Thread4 t1 = new Thread4();
        Thread4 t2 = new Thread4();
        Thread4 t3 = new Thread4();
        //因为共用一个thread3所以属性一致
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Thread4 extends Thread{
    private  int tirck=100;
private synchronized void show(){//同步监视器:this
//synchronized (this){
    if (tirck>0){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+tirck);
        tirck--;
    }
//}



}
    @Override
    public synchronized void run() {
        while (true){
show();
        }
    }
}
