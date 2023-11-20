package playground.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostFrequentlyUsedInATextTest {

    @Test
    public void sampleTests() {
        assertEquals(Arrays.asList("e", "d", "a"), MostFrequentlyUsedInAText.top3("a a a  b  c c  d d d d  e e e e e"));
        assertEquals(Arrays.asList("e", "ddd", "aa"), MostFrequentlyUsedInAText.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
        assertEquals(Arrays.asList("won't", "wont"), MostFrequentlyUsedInAText.top3("  //wont won't won't "));
        assertEquals(List.of("e"), MostFrequentlyUsedInAText.top3("  , e   .. "));
        assertEquals(List.of(), MostFrequentlyUsedInAText.top3("  ...  "));
        assertEquals(List.of(), MostFrequentlyUsedInAText.top3("  '  "));
        assertEquals(List.of(), MostFrequentlyUsedInAText.top3("  '''  "));
        assertEquals(List.of(), MostFrequentlyUsedInAText.top3("  '''  "));
        assertEquals(List.of("ina", "yzraasvbgc", "dhymrgk"), MostFrequentlyUsedInAText.top3("DhyMRgK DhyMRgK inA inA DhyMRgK?YzRAaSVbGc!inA DhyMRgK inA-YzRAaSVbGc inA:inA inA DhyMRgK inA/inA inA inA inA:inA inA?YzRAaSVbGc!inA!YzRAaSVbGc YzRAaSVbGc YzRAaSVbGc inA,DhyMRgK DhyMRgK;inA YzRAaSVbGc inA?inA;inA inA!inA!inA DhyMRgK:YzRAaSVbGc,inA:YzRAaSVbGc_\n"));


        assertEquals(Arrays.asList("a", "of", "on"), MostFrequentlyUsedInAText.top3(String.join("\n", "In a village of La Mancha, the name of which I have no desire to call to",
                "mind, there lived not long since one of those gentlemen that keep a lance",
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                "coursing. An olla of rather more beef than mutton, a salad on most",
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                "on Sundays, made away with three-quarters of his income.")));
    }
}