package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    // ADD TESTS TO CHECK PARTITIONS

    @Test
    public static int[][] matrix(int[][] matrix) {



        int[][] matrix2;



        int rows = matrix.length;

        int cols = matrix[0].length;



        matrix2 = new int[rows][cols];



        int arr[] = new int[rows * cols];

        int k = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                arr[k] = matrix[i][j];

                k++;



            }

        }



        int r = 0, c = 0;

        k = 0;

        while (r < rows && c < cols) {

            for (int i = c; i < cols; i++) {

                matrix2[r][i] = arr[k];

                k++;

            }

            r++;

            for (int i = r; i < rows; i++) {

                matrix2[i][cols - 1] = arr[k];

                k++;

            }

            cols--;

            if (r < rows) {

                for (int i = cols - 1; i >= c; i--) {

                    matrix2[rows - 1][i] = arr[k];

                    k++;

                }

                rows--;

            }



            if (c < cols) {



                for (int i = rows - 1; i >= r; i--) {

                    matrix2[i][c] = arr[k];

                    k++;

                }

                c++;

            }



        }



        return matrix2;

    }



    public static void main(String[] args) {

        int a[][] =



                {{7,5,1, 4, 6},

                        {3, 2, 9, 1, 8},

                        {8, 3, 2, 4, 1},

                        {10, 11, 15, 19, 14},

                };



        int res[][] = matrix(a); // FUNCTION CALLED AND STORED IN RES MATRIX

        int row = res.length;

        int col = res[0].length;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++)

                System.out.print(res[i][j] + " ");// PRINT THE RES MATRIX

            System.out.println("");

        }



    }




}


