package HashMap_Freddie;

import org.junit.*;
import java.util.HashSet;


import static junit.framework.TestCase.assertEquals;

public class HashMapTest {

    HashMap<Integer, String> map = new HashMap<>(0);
    int upper = 10000;
    int lower = -10000;

    @BeforeClass
    public static void Initialization() {

    }

    @Test
    public void defaultCapacity() {
        assertEquals(10, HashMap.defaultCapacity);
    }

    @Test
    public void CapacityAnddefaultCapacity() {
        assertEquals(10, map.capacity);
    }

    @Test
    public void HashSetCanAddNullOrNot() {
        HashSet<Integer> set = new HashSet<>();
        assertEquals(true, set.add(null));
    }

    @Test
    public void NullKey() {
        map.put(null, "1");
        assertEquals("1", map.get(null));
    }

    @Test
    public void IntegerToString_BruteForce() {
        IntegerToString_put();
        boolean equal = true;

        for (int i = lower; i <= upper; ++i) {
            equal &= map.get(i).equals(Integer.toBinaryString(i));
        }

        assertEquals(true, equal);
        IntegerToString_ContainsKey();
        IntegerToString_ContainsValue();
        IntegerToString_Change();
        IntegerToString_RM();
    }

    public void IntegerToString_put() {
        boolean isNUll = true;
        for (int i = lower; i <= upper; ++i) {
            isNUll &= null == map.put(i, Integer.toBinaryString(i));
        }
        assertEquals(true, isNUll);
    }

    public void IntegerToString_ContainsKey() {

        boolean equal = true;

        for (int i = lower; i <= upper; ++i) {
            equal &= map.ContainsKey(i);
        }

        assertEquals(true, equal);
    }

    public void IntegerToString_ContainsValue() {

        boolean equal = true;

        for (int i = lower; i <= upper; ++i) {
            equal &= (map.ContainsValue(Integer.toBinaryString(i)));
        }

        assertEquals(true, equal);
    }
    public void IntegerToString_Change() {

        for (int i = lower; i <= upper; ++i) {
            assertEquals(map.get(i),map.put(i, "0"));
            assertEquals("0",map.get(i));
        }
    }
    public void IntegerToString_RM() {

        for (int i = lower; i <= upper; ++i) {
            int size = map.size();
            assertEquals(map.get(i),map.remove(i));
            assertEquals(null,map.get(i));
            assertEquals(size,map.size()+1);
        }
    }
    @Test
    public void putNull() {

        for (int i = lower; i <= upper; ++i) {
            map.put(i, null);
        }

        for (int i = lower; i <= upper; ++i) {
            assertEquals(null,map.get(i));
            assertEquals(true, map.ContainsKey(i));
        }

        for (int i = lower; i <= upper; ++i) {
            int size = map.size();
            assertEquals(map.get(i),map.remove(i));
            assertEquals(null,map.get(i));
            assertEquals(size,map.size()+1);
            assertEquals(false, map.ContainsKey(i));
        }
    }
    @Test
    public void Size() {
        int size = 0;
        for (int i = 0; i < map.values.size(); ++i) {
            size += map.values.get(i).size();
        }
        assertEquals(size, map.size);
    }
}