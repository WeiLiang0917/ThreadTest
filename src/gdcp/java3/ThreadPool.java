package gdcp.java3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 4.使用线程池
 * @author WeiLiang
 * @date 2021/6/27 - 16:44
 */
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"第"+i);
            }
        }
    }
}
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.指定执行的线程的操作，需要提供实现的Runnable接口或
        // Callable接口实现的对象
        service.execute(new NumberThread());//适用与Runnable
        service.execute(new NumberThread1());//适用与Runnable
//        service.submit();//适合适用于Callable
        //关闭连接池
        service.shutdown();
    }
}
