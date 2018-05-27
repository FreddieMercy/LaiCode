package HashMap_Freddie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashMap<K,V> {
    interface FUNC<K, V> {
        V method(K k, V v, int i);
    }
    class EntryPair {
        public final K key;
        public final V value;

        public EntryPair(K k, V v) {
            key = k;
            value = v;
        }
    }
    HashSet<K> keys = new HashSet<>();
    List<List<EntryPair>> values;
    int capacity = 0;
    float growthRate = 0.0f;
    int size = 0;
    public static final int defaultCapacity = 10;
    public static final float defaultGrowthRate = 0.75f;
    public HashMap(int c) {
        this(c, defaultGrowthRate);
    }
    public HashMap(float g) {
        this(defaultCapacity, g);
    }
    public HashMap(int capacity, float g) {
        this.growthRate = (g > 0) ? g : defaultGrowthRate;
        this.capacity = (capacity >= 1) ? capacity : defaultCapacity;
        initialization_Values();
    }
    public HashMap() {
        this(defaultCapacity, defaultGrowthRate);
    }
    public int size() {
        return size;
    }
    void initialization_Values() {

        values = new ArrayList<>();
        for (int i = 0; i < this.capacity; ++i) {
            values.add(new ArrayList<>());
        }
    }
    public boolean ContainsKey(K k) {
        return keys.contains(k);
    }
    public boolean ContainsValue(V v) {
        for (List<EntryPair> m : values) {
            for (EntryPair p : m) {
                if (EqualS(p.value, v)) {
                    return true;
                }
            }
        }

        return false;
    }
    public V remove(K k) {
        return rm(k);
    }
    public V delete(K k) {
        return rm(k);
    }
    boolean needReHash() {
        return size() >= growthRate * capacity;
    }
    int getIndex(K k) {
        if (k == null) {
            return 0;
        }
        return Math.abs(k.hashCode()) % capacity;
    }
    V search(K k, V v, FUNC<K, V> func) {
        if (!ContainsKey(k)) {
            return null;
        }
        int i = 0;
        int index = getIndex(k);
        while (i < values.get(index).size()) {

            if (EqualS(k, values.get(index).get(i).key)) {
                break;
            }
            i++;
        }
        return func.method(k, v, i);
    }
    V rm(K k) {
        return search(k, null, new FUNC<K, V>() {
            public V method(K k, V v, int i) {
                V toRM = values.get(getIndex(k)).get(i).value;
                values.get(getIndex(k)).remove(i);
                keys.remove(k);
                size--;
                return toRM;
            }
        });
    }
    void reHash() {
        if (needReHash()) {
            capacity *=1+growthRate;
            capacity++;
            List<List<EntryPair>> tmp = values;
            initialization_Values();
            keys.clear();
            for (List<EntryPair> t : tmp) {
                for (EntryPair k : t) {
                    put(k.key, k.value);
                }
            }
        }
    }
    boolean EqualS(Object k, Object m) {
        return k == m || k.equals(m);
    }
    public V get(K k) {
        return search(k, null, new FUNC<K, V>() {
            public V method(K k, V v, int i) {
                return values.get(getIndex(k)).get(i).value;
            }
        });
    }
    public V put(K k, V v) {

        if (!keys.add(k)) {
            return update(k, v);
        } else {
            values.get(getIndex(k)).add(new EntryPair(k, v));
            size++;
            reHash();
            return null;
        }
    }
    public V update(K k, V v) {
        return search(k, v, new FUNC<K, V>() {
            public V method(K k, V v, int i) {
                V val = values.get(getIndex(k)).get(i).value;
                values.get(getIndex(k)).set(i, new EntryPair(k, v));
                return val;
            }
        });
    }
}