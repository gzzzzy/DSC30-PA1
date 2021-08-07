
public class Startup {
    public static void main(String[] args) {
        // (1)
        /*
         * String[] str={"m", "ari", "na la", "nglois.", "dsc30", "!"}; boolean[]
         * b=arrEvenOdd(str); for(int i=0;i<b.length;++i) System.out.println(b[i]);
         */

        // (2)
        /*
         * System.out.println(spellDigits("DSC 30"));
         * System.out.println(spellDigits("A1B2c3d4E5"));
         * System.out.println(spellDigits("No digits"));
         */

        // (3)
        /*
         * System.out.println(swapCase("abcdefg, hijklmn, OPQRST, UVWXYZ!"));
         * System.out.println(swapCase("ENCRYPT encrypt?"));
         * System.out.println(swapCase("CsE BaSeMeNt >.<"));
         */

        // 4
        /*
         * double[][] input={ {-100.0,11.12,133.001}, {4122.5,25.23,-61.442},
         * {-1092.1,2.84,771.555} }; int[][] output=binarizeMatrixByMidrange(input);
         * for(int i=0;i<output.length;++i){ for(int j=0;j<output[0].length;++j){
         * System.out.printf("%-4d",output[i][j]); } System.out.print('\n'); }
         */

        // 5
        // int[] set1={},set2={1,2,3};
        // int[] set1={1,2,3,5},set2={1,2,3};
        // int[] set1={-2,6,7,8},set2={-10,-2,1,2,3,6,7,8,9};
        // int[] set1={3,5},set2={4};
        // System.out.println(allByOneChecker(set1, set2));

        // 6
        /*
         * System.out.println(numpadSRC(35777)); System.out.println(numpadSRC(546540));
         * System.out.println(numpadSRC(7711404)); System.out.println(numpadSRC(123));
         */
    }

    // #1
    public static boolean[] arrEvenOdd(String[] arr) {
        /**
         * Checks whether an odd position contains a string with odd length and an even position contains a string with even length.
         * @param:
         *      arr: String[], an array of String.
         * @return: boolean[], for any index i of arr, if the string length at index i has the same parity as the index, the value at index i of the returned boolean array will be true. Otherwise, the value will be false.  
         */
        int length = arr.length;
        boolean[] re = new boolean[length];
        for (int i = 0; i < length; ++i) {
            if ((i & 1) == (arr[i].length() & 1)) {
                re[i] = true;
            }
        }
        return re;
    }

    // #2
    public static String spellDigits(String input) {
        /**
         * @param: 
         *      input: String.
         * @return: String, string with all digits (0-9) replaced with their upper-case spelled-out word.
         */
        int length = input.length();
        char cur = '\u0000';
        String re = new String();
        for (int i = 0; i < length; ++i) {
            cur = input.charAt(i);
            if (cur <= '9' && cur >= '0') {
                switch (cur) {
                    case '0':
                        re += "ZERO";
                        break;
                    case '1':
                        re += "ONE";
                        break;
                    case '2':
                        re += "TWO";
                        break;
                    case '3':
                        re += "THREE";
                        break;
                    case '4':
                        re += "FOUR";
                        break;
                    case '5':
                        re += "FIVE";
                        break;
                    case '6':
                        re += "SIX";
                        break;
                    case '7':
                        re += "SEVEN";
                        break;
                    case '8':
                        re += "EIGHT";
                        break;
                    case '9':
                        re += "NINE";
                        break;
                    default:
                }
            } else {
                re += cur;
            }
        }
        return re;
    }

    // #3
    public static String swapCase(String input) {
        /**
         * @param:
         *      input: String.
         * @return: String, a new string with all letters swapped to uppercase or lowercase.
         */
        int length = input.length();
        char cur;
        String re = new String();
        for (int i = 0; i < length; ++i) {
            cur = input.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                re += (char) (cur - ('a' - 'A'));
            } else if (cur >= 'A' && cur <= 'Z') {
                re += (char) (cur + ('a' - 'A'));
            } else {
                re += cur;
            }
        }
        return re;
    }

    // #4
    public static int[][] binarizeMatrixByMidrange(double[][] matrix) {
        /**
         * @param:
         *      matrix: double[][], a valid 2-dimensional matrix.
         * @return: int[][], the binarized matrix .
         * To binarize a matrix, each element smaller than the midrange (the average of maximum and minimum element) is changed to 0, and other elements are changed to 1.
         */
        int row = matrix.length, col = matrix[0].length, i, j;
        double max = matrix[0][0], min = matrix[0][0], midrange;
        int[][] re = new int[row][col];
        for (i = 0; i < row; ++i) {
            for (j = 0; j < col; ++j) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        midrange = min + (max - min) / 2;
        for (i = 0; i < row; ++i) {
            for (j = 0; j < col; ++j) {
                if (matrix[i][j] >= midrange) {
                    re[i][j] = 1;
                }
            }
        }
        return re;
    }

    // #5
    public static boolean allByOneChecker(int[] set1, int[] set2) {
        /**
         * @param:
         *      set1: int[].
         *      set2: int[].
         * @return: true if every element of set1 is within distance one on the number line from an element of set2, false otherwise
         */
        int set1_len = set1.length, set2_len = set2.length, i = 0, j = 0;
        if (set1_len == 0) {
            return true;
        } else if (set2_len == 0) {
            return false;
        } else {
            while (i < set1_len && j < set2_len) {
                if (Math.abs(set1[i] - set2[j]) <= 1) {
                    ++i;
                } else {
                    ++j;
                }
            }
            if (i == set1_len) {
                return true;
            } else {
                return false;
            }
        }
    }

    // #6
    public static boolean numpadSRC(int num) {
        /**
         * @param: 
         *      num: int.
         * @return: true if all digits in num are in the same row or column of the numpad, false otherwise. 
         * If num only has 1 digit (0 - 9), it will count as in the same row or column.
         */
        if (num < 0) {
            throw new ArithmeticException("num cannot be negative!");
        } else if (num < 10) {
            return true;
        } else {
            boolean flag1 = true, flag2 = true;
            // if same column
            int temp = num, tail = 0, remainder = 0;
            while (temp != 0) {
                remainder = temp % 10;
                if (remainder != 0) {
                    break;
                }
                temp /= 10;
            }
            temp = num;
            while (temp != 0) {
                tail = temp % 10;
                if (tail == 0 || tail % 3 == remainder % 3) {
                    temp /= 10;
                } else {
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {
                return true;
            }
            // if same row
            int center = 0;
            temp = num;
            while (temp != 0) {
                tail = temp % 10;
                if (tail != 0) {
                    break;
                }
                temp /= 10;
            }
            if (tail >= 1 && tail <= 3) {
                center = 2;
            } else if (tail >= 4 && tail <= 6) {
                center = 5;
            } else if (tail >= 7 && tail <= 9) {
                center = 8;
            }
            temp = num;
            while (temp != 0) {
                tail = temp % 10;
                if (Math.abs(tail - center) <= 1) {
                    temp /= 10;
                } else {
                    flag2 = false;
                    break;
                }
            }
            if (flag2) {
                return true;
            } else {
                return false;
            }
        }
    }
}
