package dz5;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(10,-13);
        printColor(35);
        compareNumbers(6,14);
        System.out.println(sumInRange(4,24));
        isIntPositive(-6);
        System.out.println(isIntNegative(0));
        printStringNTimes("Lorem ipsum",4);
        System.out.println(isYearLeap(2400));
    }
    private static void printThreeWords(){
        System.out.println("Orange \nBanana \nApple");
    }
    private static void checkSumSign(int a,int b){
        int sum = a+b;
        String message;
        if(sum>=0){
            message = "Сума позитивна";
        }else message = "Сума негативна";
        System.out.println(message);
    }

    private static void printColor(int value){
        String color = "Колір не задан";
        if(value<=0) color = "Червоний";
        if(value>0 && value<=100) color = "Жовтий";
        if(value>100) color = "Зелений";
        System.out.println(color);
    }
    private static void compareNumbers(int a,int b){
        String result;
        if(a>=b){
            result = "a>=b";
        }else result = "a<b";
        System.out.println(result);
    }
    private static boolean sumInRange(int a,int b){
        boolean result = false;
        int sum = a+b;
        if(sum>=10 && sum<=20) result = true;
        return result;
    }
    private static void isIntPositive(int i){
        String message;
        if(i>=0){
            message = "Позитивне";
        }else message = "Негативне";
        System.out.println(message);
    }
    private static boolean isIntNegative(int i){
        boolean result = false;
        if(i<0) result = true;
        return result;
    }
    private static void printStringNTimes(String string,int n){
        for (int i=0;i<n;i++){
            System.out.println(string);
        }
    }
    private static boolean isYearLeap(int year){
        boolean result = false;
        if(year%4==0 && (year%100!=0 || year%400==0)) result = true;
        return result;
    }
}
