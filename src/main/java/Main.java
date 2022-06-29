import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int nrOfMaxDivisors = 0 ;
        int biggestNrDivisors = 0;

        ExecutorService es = Executors.newFixedThreadPool(10);

        try {
            Divisor divisor;
            for(int i = 0; i < 10000; i++){
                divisor = new Divisor(i);
                int nr = es.submit(divisor).get();
                if( nrOfMaxDivisors <= nr){
                    biggestNrDivisors = i;
                    nrOfMaxDivisors = nr;
                }
            }

            es.shutdown();
        }catch (Exception e){
            throw new RuntimeException(e);
        }


        System.out.println(biggestNrDivisors + " " + nrOfMaxDivisors);
    }
}
