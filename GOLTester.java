import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GOLTester {

    //////////////////////////////////////////////////
    //          CONWAY'S GAME OF LIFE TESTS         //
    //////////////////////////////////////////////////

    /*
     * neighbors:
     * Test case 1:
     * array = {{0,0,1}
     *          {0,1,1}
     *          {1,1,1}}
     * neighbors(0,0) → 1
     */

    @Test
    void neighbors1() {

        int[][] array = {{0,0,1}, {0,1,1}, {1,1,1}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(1, gol.neighbors(0,0));

    }

    /*
     * neighbors:
     * Test case 2:
     * array = {{1,1,1}
     *          {1,1,1}
     *          {1,1,1}}
     * neighbors(0,0) → 3
     */

    @Test
    void neighbors2() {

        int[][] array = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(3, gol.neighbors(2, 2));

    }

    /*
     * neighbors:
     * Test case 3:
     * array = {{0,1}
     *          {0,1}}
     *
     * neighbors(0,1) → 1
     */

    @Test
    void neighbors3() {

        int[][] array = {{0,1}, {0,1}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(1, gol.neighbors(0,1));

    }

    /*
     * neighbors:
     * Test case 4:
     * array = {{1,1}
     *          {1,1}}
     *
     * neighbors(1,1) → 3
     */

    @Test
    void neighbors4() {

        int[][] array = {{1,1}, {1,1}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(3, gol.neighbors(0,0));

    }

    /*
     * neighbors:
     * Test case 5:
     * array = {{0,1,0,1}
     *          {1,0,0,1}
     *          {0,0,1,1}
     *          {1,1,0,0}}
     *
     * neighbors(1,1) → 3
     */

    @Test
    void neighbors5() {

        int[][] array = {{0,1,0,1}, {1,0,0,1}, {0,0,1,1}, {1,1,0,0}};
        GameOfLife gol = new GameOfLife(array);
        assertEquals(3, gol.neighbors(1,1));

    }

    ///////////////////////////////////////////////////////////////

    /*
     * oneStep:
     * Test case 1:
     * initial array = {{1,1,1}
     *                  {1,1,1}
     *                  {1,1,1}}
     *
     * oneStep() → {{1,0,1}
     *              {0,0,0}
     *              {1,0,1}}
     */

    @Test
    void oneStep1() {

        int[][] array = {{1,1,1}, {1,1,1}, {1,1,1}};
        int[][] result = {{1,0,1}, {0,0,0}, {1,0,1}};

        GameOfLife gol = new GameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 2:
     * initial array = {{0,1,0,1}
     *                  {1,0,0,1}
     *                  {0,0,1,1}
     *                  {1,1,0,0}}
     *
     * oneStep() → {{0,0,1,0}
     *              {0,1,0,1}
     *              {1,0,1,1}
     *              {0,1,1,0}}
     */

    @Test
    void oneStep2() {

        int[][] array = {{0,1,0,1}, {1,0,0,1}, {0,0,1,1}, {1,1,0,0}};
        int[][] result = {{0,0,1,0}, {0,1,0,1}, {1,0,1,1}, {0,1,1,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 3:
     * initial array = {{1,1,1,1}
     *                  {0,0,0,0}
     *                  {1,1,1,1}
     *                  {0,0,0,0}}
     *
     * oneStep() → {{0,1,1,0}
     *              {0,0,0,0}
     *              {0,1,1,0}
     *              {0,1,1,0}}
     */

    @Test
    void oneStep3() {

        int[][] array = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};
        int[][] result = {{0,1,1,0}, {0,0,0,0}, {0,1,1,0}, {0,1,1,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 4:
     * initial array = {{0,0,0,0,0}
     *                  {0,0,0,0,0}
     *                  {0,1,1,1,0}
     *                  {0,0,0,0,0}
     *                  {0,0,0,0,0}}
     *
     * oneStep() → {{0,0,0,0,0}
     *              {0,0,1,0,0}
     *              {0,0,1,0,0}
     *              {0,0,1,0,0}
     *              {0,0,0,0,0}}
     */

    @Test
    void oneStep4() {

        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        int[][] result = {{0,0,0,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,0,0,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 5:
     * initial array = {{0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,1,1,1,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}}
     *
     * oneStep() → {{0,0,0,0,0,0}
     *              {0,1,1,0,0,0}
     *              {0,1,0,0,0,0}
     *              {0,0,0,0,1,0}
     *              {0,0,0,1,1,0}
     *              {0,0,0,0,0,0}}
     */

    @Test
    void oneStep5() {

        int[][] array = {{0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        int[][] result = {{0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,0,0,0,0},
                {0,0,0,0,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    ///////////////////////////////////////////////////////////////

    /*
     * evolution:
     * Test case 1:
     * initial array = {{1,1,1}
     *                  {1,1,1}
     *                  {1,1,1}}
     *
     * evolution(3) → {{0,0,0}
     *                 {0,0,0}
     *                 {0,0,0}}
     */

    @Test
    void evolution1() {

        int[][] array = {{1,1,1}, {1,1,1}, {1,1,1}};
        int[][] result = {{0,0,0}, {0,0,0}, {0,0,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.evolution(3);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * evolution:
     * Test case 2:
     * initial array = {{0,1,0,1}
     *                  {1,0,0,1}
     *                  {0,0,1,1}
     *                  {1,1,0,0}}
     *
     * evolution(2) → {{0,0,1,0}
     *                 {0,1,0,1}
     *                 {1,0,0,1}
     *                 {0,1,1,1}}
     */

    @Test
    void evolution2() {

        int[][] array = {{0,1,0,1}, {1,0,0,1}, {0,0,1,1}, {1,1,0,0}};
        int[][] result = {{0,0,1,0}, {0,1,0,1}, {1,0,0,1}, {0,1,1,1}};

        GameOfLife gol = new GameOfLife(array);

        gol.evolution(2);


        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * evolution:
     * Test case 3:
     * initial array = {{1,1,1,1}
     *                  {0,0,0,0}
     *                  {1,1,1,1}
     *                  {0,0,0,0}}
     *
     * evolution(5) → {{0,0,0,0}
     *                 {0,0,0,0}
     *                 {0,1,1,0}
     *                 {0,1,1,0}}
     */

    @Test
    void evolution3() {

        int[][] array = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};
        int[][] result = {{0,0,0,0}, {0,0,0,0}, {0,1,1,0}, {0,1,1,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.evolution(5);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }


    /*
     * evolution:
     * Test case 4:
     * initial array = {{0,0,0,0,0}
     *                  {0,0,0,0,0}
     *                  {0,1,1,1,0}
     *                  {0,0,0,0,0}
     *                  {0,0,0,0,0}}
     *
     * evolution(9) → {{0,0,0,0,0}
     *                 {0,0,1,0,0}
     *                 {0,0,1,0,0}
     *                 {0,0,1,0,0}
     *                 {0,0,0,0,0}}
     */

    @Test
    void evolution4() {

        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        int[][] result = {{0,0,0,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,0,0,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.evolution (5);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * evolution:
     * Test case 5:
     * initial array = {{0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,1,1,1,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}}
     *
     * evolution(4) → {{0,0,0,0,0,0}
     *                 {0,1,1,0,0,0}
     *                 {0,1,0,0,0,0}
     *                 {0,0,0,0,1,0}
     *                 {0,0,0,1,1,0}
     *                 {0,0,0,0,0,0}}
     */

    @Test
    void evolution5() {

        int[][] array = {{0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        int[][] result = {{0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,0,0,0,0},
                {0,0,0,0,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        GameOfLife gol = new GameOfLife(array);

        gol.evolution(9);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }





    //////////////////////////////////////////////////
    //           TORUS GAME OF LIFE TESTS           //
    //////////////////////////////////////////////////

    /*
     * neighbors:
     * Test case 1:
     * array = {{0,0,1}
     *          {0,1,1}
     *          {1,1,1}}
     * neighbors(0,0) → 6
     */

    @Test
    void neighborsTorus1() {

        int[][] array = {{0,0,1}, {0,1,1}, {1,1,1}};
        TorusGameOfLife gol = new TorusGameOfLife(array);
        assertEquals(6, gol.neighbors(0,0));

    }

    /*
     * neighbors:
     * Test case 2:
     * array = {{1,1,1}
     *          {1,1,1}
     *          {1,1,1}}
     * neighbors(0,0) → 6
     */

    @Test
    void neighborsTorus2() {

        int[][] array = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        TorusGameOfLife gol = new TorusGameOfLife(array);
        assertEquals(8, gol.neighbors(2, 2));

    }

    /*
     * neighbors:
     * Test case 3:
     * array = {{0,1}
     *          {0,1}}
     *
     * neighbors(0,1) → 2
     */

    @Test
    void neighborsTorus3() {

        int[][] array = {{0,1}, {0,1}};
        TorusGameOfLife gol = new TorusGameOfLife(array);
        assertEquals(2, gol.neighbors(0,1));

    }

    /*
     * neighbors:
     * Test case 4:
     * array = {{1,1}
     *          {1,1}}
     *
     * neighbors(1,1) → 3
     */

    @Test
    void neighborsTorus4() {

        int[][] array = {{1,1}, {1,1}};
        TorusGameOfLife gol = new TorusGameOfLife(array);
        assertEquals(8, gol.neighbors(0,0));

    }

    /*
     * neighbors:
     * Test case 5:
     * array = {{0,1,0,1}
     *          {1,0,0,1}
     *          {0,0,1,1}
     *          {1,1,0,0}}
     *
     * neighbors(1,1) → 3
     */

    @Test
    void neighborsTorus5() {

        int[][] array = {{0,1,0,1}, {1,0,0,1}, {0,0,1,1}, {1,1,0,0}};
        TorusGameOfLife gol = new TorusGameOfLife(array);
        assertEquals(3, gol.neighbors(1,1));

    }

    ///////////////////////////////////////////////////////////////

    /*
     * oneStep:
     * Test case 1:
     * initial array = {{1,1,1}
     *                  {1,1,1}
     *                  {1,1,1}}
     *
     * oneStep() → {{0,0,0}
     *              {0,0,0}
     *              {0,0,0}}
     */

    @Test
    void oneStepTorus1() {

        int[][] array = {{1,1,1}, {1,1,1}, {1,1,1}};
        int[][] result = {{0,0,0}, {0,0,0}, {0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 2:
     * initial array = {{0,1,0,1}
     *                  {1,0,0,1}
     *                  {0,0,1,1}
     *                  {1,1,0,0}}
     *
     * oneStep() → {{0,1,0,1}
     *              {0,1,0,0}
     *              {0,0,1,0}
     *              {0,1,0,0}}
     */

    @Test
    void oneStepTorus2() {

        int[][] array = {{0,1,0,1}, {1,0,0,1}, {0,0,1,1}, {1,1,0,0}};
        int[][] result = {{0,1,0,1}, {0,1,0,0}, {0,0,1,0}, {0,1,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 3:
     * initial array = {{1,1,1,1}
     *                  {0,0,0,0}
     *                  {1,1,1,1}
     *                  {0,0,0,0}}
     *
     * oneStep() → {{1,1,1,1}
     *              {0,0,0,0}
     *              {1,1,1,1}
     *              {0,0,0,0}}
     */

    @Test
    void oneStepTorus3() {

        int[][] array = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};
        int[][] result = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 4:
     * initial array = {{0,0,0,0,0}
     *                  {0,0,0,0,0}
     *                  {0,1,1,1,0}
     *                  {0,0,0,0,0}
     *                  {0,0,0,0,0}}
     *
     * oneStep() → {{0,0,0,0,0}
     *              {0,0,1,0,0}
     *              {0,0,1,0,0}
     *              {0,0,1,0,0}
     *              {0,0,0,0,0}}
     */

    @Test
    void oneStepTorus4() {

        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        int[][] result = {{0,0,0,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * oneStep:
     * Test case 5:
     * initial array = {{0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,1,1,1,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}}
     *
     * oneStep() → {{0,0,0,0,0,0}
     *              {0,1,1,0,0,0}
     *              {0,1,0,0,0,0}
     *              {0,0,0,0,1,0}
     *              {0,0,0,1,1,0}
     *              {0,0,0,0,0,0}}
     */

    @Test
    void oneStepTorus5() {

        int[][] array = {{0,0,0,0,0,0},
                         {0,1,1,0,0,0},
                         {0,1,1,0,0,0},
                         {0,0,0,1,1,0},
                         {0,0,0,1,1,0},
                         {0,0,0,0,0,0}};

        int[][] result = {{0,0,0,0,0,0},
                          {0,1,1,0,0,0},
                          {0,1,0,0,0,0},
                          {0,0,0,0,1,0},
                          {0,0,0,1,1,0},
                          {0,0,0,0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.oneStep();

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    ///////////////////////////////////////////////////////////////

    /*
     * evolution:
     * Test case 1:
     * initial array = {{1,1,1}
     *                  {1,1,1}
     *                  {1,1,1}}
     *
     * evolution(3) → {{0,0,0}
     *                 {0,0,0}
     *                 {0,0,0}}
     */

    @Test
    void evolutionTorus1() {

        int[][] array = {{1,1,1}, {1,1,1}, {1,1,1}};
        int[][] result = {{0,0,0}, {0,0,0}, {0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.evolution(3);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * evolution:
     * Test case 2:
     * initial array = {{0,1,0,1}
     *                  {1,0,0,1}
     *                  {0,0,1,1}
     *                  {1,1,0,0}}
     *
     * evolution(2) → {{0,1,0,0}
     *                 {1,1,0,0}
     *                 {0,1,1,0}
     *                 {1,1,0,0}}
     */

    @Test
    void evolutionTorus2() {

        int[][] array = {{0,1,0,1}, {1,0,0,1}, {0,0,1,1}, {1,1,0,0}};
        int[][] result = {{0,1,0,0}, {1,1,0,0}, {0,1,1,0}, {1,1,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.evolution(2);


        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * evolution:
     * Test case 3:
     * initial array = {{1,1,1,1}
     *                  {0,0,0,0}
     *                  {1,1,1,1}
     *                  {0,0,0,0}}
     *
     * evolution(5) → {{1,1,1,1}
     *                 {0,0,0,0}
     *                 {1,1,1,1}
     *                 {0,0,0,0}}
     */

    @Test
    void evolutionTorus3() {

        int[][] array = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};
        int[][] result = {{1,1,1,1}, {0,0,0,0}, {1,1,1,1}, {0,0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.evolution(5);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }


    /*
     * evolution:
     * Test case 4:
     * initial array = {{0,0,0,0,0}
     *                  {0,0,0,0,0}
     *                  {0,1,1,1,0}
     *                  {0,0,0,0,0}
     *                  {0,0,0,0,0}}
     *
     * evolution(9) → {{0,0,0,0,0}
     *                 {0,0,1,0,0}
     *                 {0,0,1,0,0}
     *                 {0,0,1,0,0}
     *                 {0,0,0,0,0}}
     */

    @Test
    void evolutionTorus4() {

        int[][] array = {{0,0,0,0,0}, {0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,0,0}, {0,0,0,0,0}};
        int[][] result = {{0,0,0,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,1,0,0}, {0,0,0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.evolution (5);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }

    /*
     * evolution:
     * Test case 5:
     * initial array = {{0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,1,1,1,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}
     *                  {0,0,0,0,0,0}}
     *
     * evolution(4) → {{0,0,0,0,0,0}
     *                 {0,1,1,0,0,0}
     *                 {0,1,0,0,0,0}
     *                 {0,0,0,0,1,0}
     *                 {0,0,0,1,1,0}
     *                 {0,0,0,0,0,0}}
     */

    @Test
    void evolutionTorus5() {

        int[][] array = {{0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        int[][] result = {{0,0,0,0,0,0},
                          {0,1,1,0,0,0},
                          {0,1,0,0,0,0},
                          {0,0,0,0,1,0},
                          {0,0,0,1,1,0},
                          {0,0,0,0,0,0}};

        TorusGameOfLife gol = new TorusGameOfLife(array);

        gol.evolution(9);

        for(int i = 0; i < array.length; i++){
            assertArrayEquals(result[i],gol.getCurrentBoard()[i]);
        }

    }



}
