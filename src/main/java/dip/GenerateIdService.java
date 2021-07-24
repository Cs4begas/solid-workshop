package dip;

import java.util.Random;

public class GenerateIdService {
private Random random;
    public void setRandom(Random random) {
        this.random = random;
    }
    public String getId() {
        int number = random.nextInt(7);
        return  "XYZ" + number;
    }
}



//class MyRandom extends Random{ // by me
//    @Override
//    public int nextInt(int number){
//        return number;
//    }
//}