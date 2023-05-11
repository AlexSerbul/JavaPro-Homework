package dz10;

import java.util.Random;

public class ValueCalculator {
    private float values[];
    private int size;
    private int half_size;

    public ValueCalculator(int size) {
        this.size = size;
        this.values = new float[size];
        this.half_size = size/2;
    }

    public void FillWithOnes() throws InterruptedException {
        long start = System.currentTimeMillis();

        for(int i=0; i<size; i++){
            values[i] = 1;

        }
        float a[] = new float[half_size];
        float b[] = new float[values.length-half_size];

        System.arraycopy(values,0,a,0,a.length);
        System.arraycopy(values,a.length,b,0,b.length);

        SetNewValue setNewValue_a = new SetNewValue(a);
        SetNewValue setNewValue_b = new SetNewValue(b);
        Thread t1 = new Thread(setNewValue_a);
        Thread t2 = new Thread(setNewValue_b);

        t1.start();
        t2.start();

        t1.interrupt();
        t2.interrupt();

        t1.join();
        t2.join();

        a = setNewValue_a.getValues();
        b = setNewValue_b.getValues();

        System.arraycopy(a,0,values,0,a.length);
        System.arraycopy(b,0,values,a.length,b.length);

        long finish = System.currentTimeMillis();

        System.out.println("Total time: " + (finish-start) + " ms");
    }

    private static class SetNewValue implements Runnable{
        private float values[];
        public SetNewValue(float[] values) {
            this.values = values;
        }
        @Override
        public void run() {
            for(int i = 0; i< values.length; i++){
                values[i] = (float)(values[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        public float[] getValues(){
            return values;
        }
    }
}
