package eidi2.sose25.weber.felix.sheet06;

import eidi2.sose25.weber.felix.sheet06.ex01.BinaryTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTestsSolution {

    private static Random random = new Random(42);
    private static final int N = 5000;

    @Test
    @Timeout(1)
    void testAdd() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(Math.abs(random.nextInt()));
        for (int n : list) tree.add(n);

        assertEquals(N, tree.size());

        Collections.sort(list);
        compareInorderToList(tree.inorder(), list);
    }

    @Test
    @Timeout(1)
    void testAddIt() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(Math.abs(random.nextInt()));
        for (int n : list) tree.addIt(n);

        assertEquals(N, tree.size());

        Collections.sort(list);
        compareInorderToList(tree.inorder(), list);
    }

    @Test
    @Timeout(1)
    void testAddBoth() {
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(Math.abs(random.nextInt()));
        for (int n : list) assertEquals(tree1.add(n), tree2.addIt(n));
    }

    @Test
    @Timeout(1)
    void testAddReturns() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        int[] arr = {5, 1, 4, 3, 7, 9, 8, 7, 3, 5, 6};
        boolean[] isDuplicate = {false, false, false, false, false, false, false, true, true, true, false};

        for (int k = 0; k < arr.length; k++) {
            assertEquals(!isDuplicate[k], tree.add(arr[k]));
        }
        assertEquals(8, tree.size());
    }

    @Test
    @Timeout(1)
    void testAddItReturns() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        int[] arr = {5, 1, 4, 3, 7, 9, 8, 7, 3, 5, 6};
        boolean[] isDuplicate = {false, false, false, false, false, false, false, true, true, true, false};

        for (int k = 0; k < arr.length; k++) {
            assertEquals(!isDuplicate[k], tree.addIt(arr[k]));
        }
        assertEquals(8, tree.size());
    }

    @Test
    @Timeout(1)
    void testStringOrder() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int[] arr = {5, 1, 4, 3, 7, 9, 8, 6};
        for (int x : arr) tree.add(x);

        assertEquals(8, tree.size());

        assertEquals("[5, 1, 4, 3, 7, 6, 9, 8]".replaceAll("[^\\d]+", ""), tree.preorder().replaceAll("[^\\d]+", ""));
        assertEquals("[1, 3, 4, 5, 6, 7, 8, 9]".replaceAll("[^\\d]+", ""), tree.inorder().replaceAll("[^\\d]+", ""));
        assertEquals("[3, 4, 1, 6, 8, 9, 7, 5]".replaceAll("[^\\d]+", ""), tree.postorder().replaceAll("[^\\d]+", ""));

        assertEquals("[5,1,4,3,7,6,9,8]", tree.preorder());
        assertEquals("[1,3,4,5,6,7,8,9]",tree.inorder());
        assertEquals("[3,4,1,6,8,9,7,5]",tree.postorder());
    }

    @Test
    @Timeout(3)
    void testRemove() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) list.add(Math.abs(random.nextInt()));
        for (int n : list) tree.add(n);

        Collections.sort(list);

        while (tree.size() > 0) {
            Integer n = random.nextDouble() < 0.1 ? random.nextInt() : list.get(random.nextInt(list.size()));
            boolean exists = list.contains(n);
            list.removeIf(e -> e.equals(n));
            assertEquals(exists, tree.remove(n));
            compareInorderToList(tree.inorder(), list);
        }
    }

    /* @Test
    @Timeout(1)
    void testMutate() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(Math.abs(random.nextInt()));
        for (int n : list) tree.add(n);

        tree.mutate(x -> 0);
        assertTrue(tree.inorder().replaceAll("[^\\d]+", "").replaceAll("[0]+", "#").equals("#"));
    }

    @Test
    @Timeout(1)
    void testFlat() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < N; i++) tree.add(Math.abs(random.nextInt()));

        List<Integer> list = tree.flat((x, y) -> { y.add(x); return y; }, new ArrayList<>());
        Collections.sort(list);
        compareInorderToList(tree.inorder(), list);
    }

    @Test
    @Timeout(1)
    void testFlatSum() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer sum = 0;
        for (int i = 0; i < N; i++) {
            int x = random.nextInt();
            tree.add(x);
            sum += x;
        }
        assertEquals(sum, tree.flat((x, y) -> x + y, 0));
    }

    @Test
    @Timeout(1)
    void testContains() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Math.abs(random.nextInt()));
        for (int n : list) tree.add(n);

        for (int i = 0; i < N; i++) {
            Integer n = random.nextDouble() < 0.1 ? random.nextInt() : list.get(random.nextInt(list.size()));
            boolean exists = list.contains(n);
            assertEquals(exists, tree.contains(n));
        }
    }

    @Test
    @Timeout(1)
    void testMax() {
        for (int i = 0; i < 100; i++) {
            BinaryTree<Integer> tree = new BinaryTree<>();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) list.add(Math.abs(random.nextInt()));
            for (int n : list) tree.add(n);
            Integer max = Collections.max(list);
            assertEquals(max, tree.max());
        }
    } */

    static void compareInorderToList(String str, List<Integer> list) {
        String[] fields = str.replaceAll("[\\]\\[ ]", "").split(",");
        int k = 0;
        if (fields.length == 1 && fields[0].isEmpty()) return;
        for (int n : list) {
            assertEquals(String.valueOf(n), fields[k++]);
        }
    }
}
