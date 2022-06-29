import java.util.concurrent.Callable;

public class Divisor implements Callable<Integer> {
        int nr;

        public Divisor(int n){
            nr = n;
        }

        public int NrOfDivs(){
            int nr_div = 0;
            for ( int i = 1; i <= Math.sqrt(nr); i++){
                if( nr % i == 0){
                    if (nr / i == i) {
                        nr_div++;
                    }else
                        nr_div = nr_div + 2;
                }
            }
            return nr_div;
        }


    @Override
    public Integer call() throws Exception {
        return NrOfDivs();
    }
}
