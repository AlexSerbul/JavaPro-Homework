package dz7;

public class ArrayValueCalculator {
    public static void main(String[] args) {
        String strings[][] = new String[][] {
            {"1","3","7","-3"},
            {"5","4","40","-8"},
            {"2","5","3","9"},
            {"-8","3","5","1"}
        };

        try {
            doCalc(strings);
        } catch (ArrayDataException e) {
            System.out.println("ArrayDataException");
        } catch (ArraySizeException e) {
            System.out.println("ArraySizeException");
        } catch (RuntimeException e){
            System.out.println("Other exception");
        }

    }

    private static int doCalc(String[][] input) throws ArraySizeException, ArrayDataException{
        int result = 0;

        if(input.length!=4){
            throw new ArraySizeException();
        }

        for(int i=0;i<4;i++){
            if(input[i].length!=4){
                throw new ArraySizeException();
            }

            for(int j=0;j<4;j++){
                try {
                    result += Integer.parseInt(input[i][j]);
                }catch (Exception e){
                    throw new ArrayDataException();
                }
            }
        }

        return result;
    }
}
