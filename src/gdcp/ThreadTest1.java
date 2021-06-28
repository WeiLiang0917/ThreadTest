package gdcp;

/**
 * 多线程的创建，方式一;继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()--将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用Thread的start()
 * 例子:遍历100以内的所有偶数
 * @author WeiLiang
 * @date 2021/6/21 - 19:41
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread=new MyThread();
        //4.通过此对象调用Thread的start()
        myThread.start();
        //myThread.start();
    }

}
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}