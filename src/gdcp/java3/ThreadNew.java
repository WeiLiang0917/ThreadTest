package gdcp.java3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三:实现Callable接口   -----JDK5.0新增
 *
 *
 * @author WeiLiang
 * @date 2021/6/27 - 16:24
 */
//1.创建一个实现Callable的实现类

class NumThread implements Callable{
    @Override
    //2.实现call方法，将此线程需要执行的操作声明在返回值种
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread n1=new NumThread();
        //4.将Callable接口实现类的对象作为传递到FutureTask构造器种，
        // 创建FutureTask的对象
        FutureTask f1=new FutureTask(n1);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象
        // ，并调用start()
        new Thread(f1).start();
        try {
            //6.获取返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()返回值
            Object sum = f1.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
