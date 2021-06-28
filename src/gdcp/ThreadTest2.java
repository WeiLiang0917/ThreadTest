package gdcp;

/**
 * 创建多线程的方式二:实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法:run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start();
 * @author WeiLiang
 * @date 2021/6/22 - 19:51
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        //创建实现类的对象
        MTHread mtHread = new MTHread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mtHread);
        //通过Thread类的对象调用start();①启动线程，②调用当前线程run方法
        //-->调用了Runnable类的target的run();
        t1.start();
        //再启动一个线程遍历100以内的偶数
        Thread t2 = new Thread(mtHread);
        t2.start();
    }
}
//1.创建一个实现了Runnable接口的类
class MTHread implements Runnable{
//2.实现类去实现Runnable中的抽象方法:run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }

    }
}