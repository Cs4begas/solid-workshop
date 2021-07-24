package dip;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Random7 extends Random {
    private boolean called = false;
    private int counter = 0;

    @Override
    public int nextInt(int bound) {
        if(bound >= 5 && bound <= 10){
            this.called = true;
            this.counter++;
            return 100;
        }
    }

    class SpyRandom extends Random {
        private boolean called = false;

        @Override
        public int nextInt(int bound) {
            this.called = true;
            return 100;
        }

        public boolean isCalled() {
            return called;
        }
    }

    class GenerateIdServiceTest {

        @Test
        public void called_nextInt_of_Random() { //SPY คือไป Check Dependency Injection
            GenerateIdService service = new GenerateIdService();
            SpyRandom spy = new SpyRandom();
            service.setRandom(spy);
            service.getId();
            assertTrue(spy.isCalled()); // ตรวจสอบ behaviour ของ Dependency
        }
    }

    @Test
    @DisplayName("ต้องได้ id=XYZ7")
    public void case01() {
        // Dependency Injection (DI)
        // 1.Constructor Injection ใช้เมื่อทุก ๆ method ใน class required
        //GenerateIdService service = new GenerateIdService(new Random());
        GenerateIdService service = new GenerateIdService();
        service.setRandom(new Random7()); // วิธีนี้เค้าเรียก Test Double แต่เป็นการ Injection แบบ2. Setter/Property/Field injection ไม่สนใจโลกจะใช้ก็ set ถ้าใช้แล้วไม่ set ก็พัง
        //String id = service.getId(new Random()); 3. Method Injection ใช้เมื่อเฉพาะ method นั้นต้องการ
        assertEquals("XYZ7", id);
    }
}