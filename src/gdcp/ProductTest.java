package gdcp;

/**
 * @author WeiLiang
 * @date 2021/6/27 - 16:11
 */
public class ProductTest{
    public static void main(String[] args){
        Clerk clerk=new Clerk();
        Producer p1=new Producer(clerk);
        p1.setName("生产者");
        Customer c1=new Customer(clerk);
        c1.setName("消费者");
        Customer c2=new Customer(clerk);
        c2.start();
        p1.start();
        c1.start();
    }
}
class Clerk{
    private static int productConut=0;
//生产产品
    public synchronized void produceProduct() {
        if (productConut<20){
            productConut++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productConut+"个产品");
        notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//消费产品
    public synchronized void CustomerProduct() {
        if (productConut>0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+productConut+"个产品");
            productConut--;
        notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{//生产者
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始消费产品");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Customer extends Thread{
    private Clerk clerk;
    public Customer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始生产产品");
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.CustomerProduct();
        }
    }
}