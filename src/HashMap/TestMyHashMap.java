package HashMap;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Тестируем put
        System.out.println("put('one', 1): " + map.put("one", 1)); // null
        System.out.println("put('two', 2): " + map.put("two", 2)); // null

        // Тестируем get
        System.out.println("get('one'): " + map.get("one")); // 1
        System.out.println("get('two'): " + map.get("two")); // 2
        System.out.println("get('three'): " + map.get("three")); // null

        // Обновление значения
        System.out.println("put('one', 10): " + map.put("one", 10)); // 1 (старое значение)
        System.out.println("get('one'): " + map.get("one")); // 10

        // Тестируем remove
        System.out.println("remove('two'): " + map.remove("two")); // 2
        System.out.println("get('two'): " + map.get("two")); // null
        System.out.println("remove('nonexistent'): " + map.remove("nonexistent")); // null

        // Проверяем вспомогательные методы
        System.out.println("size(): " + map.size()); // 1
        System.out.println("isEmpty(): " + map.isEmpty()); // false

        map.clear();
        System.out.println("After clear - isEmpty(): " + map.isEmpty()); // true
    }
}
