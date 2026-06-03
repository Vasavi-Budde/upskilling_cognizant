import java.util.concurrent.*;

class MyTask implements Callable<Integer> {

    private int num;

    MyTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() {

        return num * num;
    }
}
public class executorservice {
     public static void main(String[] args) throws Exception {

        ExecutorService service =
                Executors.newFixedThreadPool(3);

        Future<Integer> f1 =
                service.submit(new MyTask(2));

        Future<Integer> f2 =
                service.submit(new MyTask(3));

        Future<Integer> f3 =
                service.submit(new MyTask(4));

        System.out.println(f1.get());

        System.out.println(f2.get());

        System.out.println(f3.get());

        service.shutdown();
    }
}
