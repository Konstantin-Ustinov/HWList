import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWList {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl("1", "2", null,  "3");
        System.out.println("Создан массив:" + Arrays.toString(stringList.toArray()));

        System.out.println("Добавлен элемент: " + stringList.add("4"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Добавлен элемент: " + stringList.add(2, "5") + " На индекс: " + 2);
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Элемент: " + stringList.toArray()[2] + " Заменен на: " + stringList.set(2, "6"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Удален элемент: " + stringList.remove("2"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Удален элемент: " + stringList.remove(0) + " По индексу: " + 0);
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Индекс элемента " + 3 + " : " + stringList.indexOf("3"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Индекс несуществующего элемента " + 8 + " : " + stringList.indexOf("8"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Индекс элемента с конца " + 4 + " : " + stringList.lastIndexOf("4"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Индекс несуществующего элемента с конца " + 8 + " : " + stringList.lastIndexOf("8"));
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Получить элемент по индексу " + 1 + " : " + stringList.get(1));

        System.out.println("Одинаковые ли массивы? " + stringList.equals(new StringListImpl("6", "3", "4")));

        System.out.println("Фактическое колличество элементов: " + stringList.size());

        System.out.println("Массив пустой? " + stringList.isEmpty());
        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.clear();
        System.out.println("Массив очищен.");
        System.out.println(Arrays.toString(stringList.toArray()));

        List<String> list = new ArrayList<>();
    }
}
