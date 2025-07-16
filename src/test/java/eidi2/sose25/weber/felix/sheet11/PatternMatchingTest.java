package eidi2.sose25.weber.felix.sheet11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PatternMatchingTest {

    private static final String[] needles = {
            "lauch", "babcabab", "erdbeere", "aaaab",
            "erdbeere", "esel", "barbara"
    };

    private static final String[] haystacks = {
            "baerlauch",
            "abababcbababcababcab",
            "erdbebenbringenerdezumbeben",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            "erdbebendeerdigebeerensindauchbekanntalserdbeeren",
            "lesendelesesessel",
            "rhabarberbarbarasbar"
    };

    private static final int[] indices = {
            4, 9, -1, 88, 40, -1, 9
    };

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testBF() {
        for (int i = 0; i < needles.length; i++) {
            String needle = needles[i];
            String haystack = haystacks[i];

            int[] result = PatternMatching.bruteForce(needle, haystack);
            int index = result[0];
            int comps = result[1];

            assertEquals(indices[i], index,
                    String.format("Expected index %d but was %d for needle='%s' in haystack='%s'",
                            indices[i], index, needle, haystack));
            assertTrue(comps <= needle.length() * haystack.length(),
                    "Too many comparisons in bruteForce");
        }
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testBM() {
        for (int i = 0; i < needles.length; i++) {
            String needle = needles[i];
            String haystack = haystacks[i];

            int[] result = PatternMatching.boyerMoore(needle, haystack);
            int index = result[0];
            int comps = result[1];

            assertEquals(indices[i], index,
                    String.format("Expected index %d but was %d for needle='%s' in haystack='%s'",
                            indices[i], index, needle, haystack));
            assertTrue(comps <= needle.length() * haystack.length(),
                    "Too many comparisons in boyerMoore");
        }
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testKMP() {
        for (int i = 0; i < needles.length; i++) {
            String needle = needles[i];
            String haystack = haystacks[i];

            int[] result = PatternMatching.kmp(needle, haystack);
            int index = result[0];
            int comps = result[1];

            assertEquals(indices[i], index,
                    String.format("Expected index %d but was %d for needle='%s' in haystack='%s'",
                            indices[i], index, needle, haystack));
            assertTrue(comps <= needle.length() * haystack.length(),
                    "Too many comparisons in kmp");
        }
    }
}