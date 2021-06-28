package gdcp.Demo;

/**
 * 1.创建两个分线程，其中一个遍历100的偶数，另一个100基数
 * @author WeiLiang
 * @date 2021/6/21 - 20:01
 */
public class ThreadDemo {
    public static void main(String[] args) {
       /* myThread myThread1=new myThread();
        myThread1.start();
        myThread2 myThread2=new myThread2();
        myThread2.start();*/
       //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2==0){
                        System.out.println(i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2!=0){
                        System.out.println(i);
                    }
                }
            }
        }.start();
    }
}
class myThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}
class myThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2!=0){
                System.out.println(i);
            }
        }
    }
}