import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HWList {
    public static void main(String[] args) {
        System.out.println("Работа со строками:");

        MyListImpl stringList = new MyListImpl("1", "2", null,  "3");
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

        System.out.println("Одинаковые ли массивы? " + stringList.equals(new MyListImpl("6", "3", "4")));

        System.out.println("Фактическое колличество элементов: " + stringList.size());

        System.out.println("Массив пустой? " + stringList.isEmpty());
        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.clear();
        System.out.println("Массив очищен.");
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("Конец работы со строками");

        System.out.println("Работа с числами");

        MyListIntegerImpl arr1 = new MyListIntegerImpl(100_000);
        MyListIntegerImpl arr2, arr3;
        Random random = new Random(100_000);
        for (int i = 0; i < 1_000; i++) {
            arr1.add(random.nextInt());
        }
//        arr2 = arr1;
//        arr3 = arr1;

        System.out.println(Arrays.toString(arr1.toArray()));

//        System.out.println("Сортировка пузырьком");
//        long start = System.currentTimeMillis();
//        sortBubble(arr1.toArray());
//        System.out.println(System.currentTimeMillis() - start);
//
//        System.out.println("Сортировка выбором");
//        start = System.currentTimeMillis();
//        sortSelection(arr2.toArray());
//        System.out.println(System.currentTimeMillis() - start);
//
//        System.out.println("Сортировка вставкой");
//        start = System.currentTimeMillis();
//        sortInsertion(arr3.toArray());
//        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Сортировка вставкой");
        long start = System.currentTimeMillis();
        arr1.sortSelection();
        System.out.println(System.currentTimeMillis() - start);

        System.out.println(Arrays.toString(arr1.toArray()));

        System.out.println("Массив содержит число 1231231233? -" + arr1.contains(1231231233));
        List<String> list = new ArrayList<>();
    }

    // Начало сортировок из урока
    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    //Конец сортировок из урока
}
