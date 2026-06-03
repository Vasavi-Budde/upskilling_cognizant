public class virtualthreads {
     public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 1; i <= 100000; i++) {
            int num = i;
            Thread.startVirtualThread(() -> {
                System.out.println(
                        "virtual thread " + num);
            });
        }
        long end = System.currentTimeMillis();
        System.out.println(  "time : " + (end - start) + " ms");
    }
}
