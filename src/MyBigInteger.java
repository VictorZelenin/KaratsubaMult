import java.util.Arrays;

/**
 * Created by User on 02.01.2016.
 */
public class MyBigInteger {



    public int[] read(String number) {

        int[] result = new int[number.length()];
        char[] array = number.toCharArray();

        int k = 0;

        for (int i = array.length - 1; i >= 0; i--) {

            String str = new String(String.valueOf(array[i]));
            result[k] = Integer.parseInt(str);
            k++;

        }

        result = getResult(result);

        //  System.out.println(Arrays.toString(result));
        //System.out.println(Arrays.toString(shift(result,1)));
        return result;
    }

    private int[] shift(int[] array, int digit) {

        for (int j = 0; j < digit; j++) {
            for (int i = array.length - 1; i >= 0; i--) {

                if (i == (array.length - 1)) {
                    array[array.length - 1] = 0;
                } else {
                    array[i + 1] = array[i];
                }

            }
            array[0] = 0;

        }

        return array;
    }

    public int[] add(int[] a, int[] b) {

        int numberOfDigit = Math.max(a.length, b.length);
        int minLength = Math.min(a.length, b.length);
        //boolean isFull = false;


        int[] result = new int[numberOfDigit];


        for (int i = 0; i < result.length; i++) {

            if (i >= minLength) {
                if (a.length > b.length) {
                    result[i] = a[i];
                } else {
                    result[i] = b[i];
                }
            } else {
                result[i] = a[i] + b[i];
            }


        }
        //  System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++) {
            if (result[i] > 9) {
                if (i == result.length - 1) {
                    result = newShift(result, 1);
                    result[result.length - 1] = result[result.length - 1] + 1;
                    result[result.length - 2] = result[result.length - 2] % 10;
                } else {
                    result[i + 1] = result[i + 1] + 1;
                    result[i] = result[i] % 10;
                }

            }
        }


        //   System.out.println(Arrays.toString(result));
        return result;
    }


    public static void print(int[] array) {
        int[] result = new int[array.length];

        int k = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            result[k] = array[i];
            k++;
        }


        for (int i = 0; i < result.length; i++) {

            if (result[i] == 0 && i == 0) {

            } else {
                System.out.print(new String(String.valueOf(result[i])));
            }
        }


    }

    public int[] subtract(int[] a, int[] b) {
        int[] result = new int[Math.max(a.length, b.length)];
        int minLength = Math.min(a.length, b.length);


        for (int i = 0; i < result.length; i++) {

            if (i >= minLength) {
                if (a.length > b.length) {
                    result[i] = a[i];
                } else {
                    result[i] = b[i];
                }
            } else {

                result[i] = a[i] - b[i];

            }


        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < 0) {
                if (i == result.length - 1) {
                    System.out.println("negative number");
                } else {

                    result[i] = 10 + result[i];
                    result[i + 1] = result[i + 1] - 1;
                }
            }
        }


        return result;
    }

    public int[] multiply(int[] a, int[] b) {
        int numOfDigit = Math.max(a.length, b.length);
        int[] result = new int[2 * numOfDigit];
        int[][] temp = new int[numOfDigit][2 * numOfDigit];

//        for (int i = 0; i < numOfDigit; i++) {
//            for (int j = 0; j < 2 * numOfDigit; j++) {
//                temp[i][j] = 0;
//
//            }
//        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                temp[i][j] = a[j] * b[i];
//                if (temp[i][j] > 9){
//                    temp[i][j] = temp[i][j] % 10;
//                    temp[i][j + 1] = temp[i][j + 1] + temp[i][j]/10;
//                }
            }
        }


        for (int i = 0; i < numOfDigit; i++) {
            if (i != 0) {
                shift(temp[i], i);
            }
            for (int j = 0; j < 2 * numOfDigit; j++) {
                if (temp[i][j] > 9) {
                    temp[i][j + 1] = temp[i][j + 1] + temp[i][j] / 10;
                    temp[i][j] = temp[i][j] % 10;
                }
            }
        }

        if (numOfDigit == 1) {

            result = temp[0];
        } else {

            for (int i = 0; i < numOfDigit; i++) {

                //System.out.println(Arrays.toString(temp[i]));

                result = add(result, temp[i]);


            }

        }


        //     System.out.println(Arrays.toString(result));
        return result;
    }

    public int[] addWithCarry(int[] a, int[] b) {

        int numberOfDigit = Math.max(a.length, b.length);
        int minLength = Math.min(a.length, b.length);
        //boolean isFull = false;


        int[] result = new int[numberOfDigit + 1];


        for (int i = 0; i < result.length - 1; i++) {

            if (i >= minLength) {
                if (a.length > b.length) {
                    result[i] = a[i];
                } else {
                    result[i] = b[i];
                }
            } else {
                result[i] = a[i] + b[i];
            }


        }
        //  System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++) {
            if (result[i] > 9) {
                result[i + 1] = result[i + 1] + 1;
                result[i] = result[i] % 10;
            }
        }


        //   System.out.println(Arrays.toString(result));
        return result;
    }

    private int[] privateShift(int[] a, int n) {
        int[] result = new int[a.length + n];

        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }

        result = shift(result, n);

        //System.out.println(Arrays.toString(result));

        return result;
    }

    private int[] newShift(int[] a, int n) {
        int[] result = new int[a.length + n];

        for (int i = 0; i < result.length; i++) {
            if (i < a.length) {
                result[i] = a[i];

            } else {
                result[i] = 0;
            }

        }

        return result;
    }

    public int[] multiplyKaratsuba(int[] a, int[] b) {

        int n = Math.max(a.length, b.length);
        int delta;


        int[] result;
        int[] A;
        int[] B;
        int[] C;
        int[] D;

        if (a.length > b.length) {
            delta = a.length - b.length;
        } else {
            delta = b.length - a.length;
        }


        if (a.length != b.length) {
            if (n % 2 == 0) {
                if (a.length > b.length) {
                    b = newShift(b, delta);
                } else {
                    a = newShift(a, delta);

                }

            } else {
                n = n + 1;

                if (a.length > b.length) {
                    a = newShift(a, 1);
                    b = newShift(b, delta + 1);
                } else {
                    a = newShift(a, delta + 1);
                    b = newShift(b, 1);
                }
            }


        }


        if ((a.length % 2) != 0) {
            A = new int[n / 2 + 1];
            B = new int[n / 2 + 1];

            for (int i = 0; i < a.length / 2 + 1; i++) {
                B[i] = a[i];
            }

            int k = 0;
            for (int i = a.length / 2 + 1; i < a.length; i++) {
                A[k] = a[i];
                k++;
            }

        } else {
            A = new int[n / 2];
            B = new int[n / 2];

            for (int i = 0; i < a.length / 2; i++) {
                B[i] = a[i];
            }

            int k = 0;
            for (int i = a.length / 2; i < a.length; i++) {
                A[k] = a[i];
                k++;
            }

        }

        if ((b.length % 2) != 0) {
            C = new int[n / 2 + 1];
            D = new int[n / 2 + 1];

            for (int i = 0; i < b.length / 2 + 1; i++) {
                D[i] = b[i];
            }

            int k = 0;
            for (int i = b.length / 2 + 1; i < b.length; i++) {
                C[k] = b[i];
                k++;
            }


        } else {

            C = new int[n / 2];
            D = new int[n / 2];

            for (int i = 0; i < b.length / 2; i++) {
                D[i] = b[i];
            }

            int k = 0;
            for (int i = b.length / 2; i < b.length; i++) {
                C[k] = b[i];
                k++;
            }
        }


        if (A.length == 1 && B.length == 1 && add(A, B).length == 1 && add(C, D).length == 1) {
            int[] k1 = multiply(A, C);
            int[] k2 = multiply(B, D);
            int[] k3 = subtract(multiply(add(A, B), add(C, D)), add(k1, k2));

            System.out.print(" K3 =  ");
            print(k3);
            System.out.println();



            // int[] k31 = new int[]{(A[0] + B[0]) * (C[0] + D[0]) - A[0]*C[0] - B[0]*D[0]};

            result = addWithCarry(privateShift(k1, 2), addWithCarry(privateShift(k3, 1), k2));


            return result;
        }


        int[] K1 = multiplyKaratsuba(A, C);
        int[] K2 = multiplyKaratsuba(B, D);

        int[] mas1 = add(A, B);
        int[] mas2 = add(C, D);
        int[] mas3 = add(K1, K2);

//        int counter = 0;

        // int[] K3 = subtract(multiplyKaratsuba(addWithCarry(A, B), addWithCarry(C, D)), addWithCarry(K1, K2));
        int[] K3 = subtract(multiplyKaratsuba(mas1, mas2), mas3);
        K3 = getResult(K3);



        System.out.print("K1 = ");
        print(K1);
        System.out.print("   K2 = ");
        print(K2);
//        System.out.println("K3 = ");
//        print(K3);
//

        System.out.print("\nK3 = ");
        //   K3 = getResult(K3);
        print(K3);


        System.out.println();
        System.out.println();


        if (a.length == b.length && Math.max(a.length, b.length) % 2 != 0) {

            result = addWithCarry(privateShift(K1, n + 1), add(privateShift(K3, n / 2 + 1), K2));
        } else {
            result = addWithCarry(privateShift(K1, n), add(privateShift(K3, n / 2), K2));
        }

        return getResult(result);
    }


    private int[] getResult(int[] a) {
        int[] result;

        int counterOfZeros = 0;

//        if (a.length == 1){
//            return a;
//        }


        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != 0) {
                break;
            } else {
                counterOfZeros++;
            }
        }

        result = new int[a.length - counterOfZeros];

        for (int i = 0; i < result.length; i++) {
            result[i] = a[i];
        }


        return result;
    }



}
