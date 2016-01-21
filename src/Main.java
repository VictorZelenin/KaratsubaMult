class Main {
    public static void main(String[] args) {
        int[] a = new MyBigInteger().read("8711129198194917883527844183686122989894424943636426448417394566");
        int[] b = new MyBigInteger().read("2924825637132661199799711722273977411715641477832758942277358764");

      

        long startTime = System.currentTimeMillis();
        System.out.println("Karatsuba");
        MyBigInteger.print(new MyBigInteger().multiplyKaratsuba(a, b));
        long karatsubaTime = System.currentTimeMillis();
        System.out.println();
        System.out.println(karatsubaTime - startTime + " ms");

        System.out.println("STD");
        MyBigInteger.print(new MyBigInteger().multiply(a, b));
        System.out.println();
        System.out.println(System.currentTimeMillis() - karatsubaTime + " ms");


    }

}
