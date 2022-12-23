import java.util.Arrays;
import java.util.Objects;

public class MyListIntegerImpl implements MyListInteger{

    Integer[] integerList;

    public MyListIntegerImpl(int size) {
        size = Math.min(0, size);
        this.integerList = new Integer[size];
    }

    public MyListIntegerImpl(Integer... args) {
        this.integerList = Arrays.stream(args)
                .filter(Objects::nonNull)
                .toArray(Integer[]::new);
    }

    @Override
    public Integer add(Integer item) {
        if (item != null) {
            Integer[] newIntegerList = Arrays.copyOf(integerList, integerList.length + 1);
            newIntegerList[newIntegerList.length - 1] = item;
            integerList = newIntegerList;
            return integerList[integerList.length - 1];
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= 0 && index < integerList.length) {
            if (item != null) {
                Integer[] newIntegerList1 = Arrays.copyOfRange(integerList, 0, index + 1);
                Integer[] newIntegerList2 = Arrays.copyOfRange(integerList, index, integerList.length);
                newIntegerList1[newIntegerList1.length - 1] = item;
                Integer[] newIntegerList = Arrays.copyOf(newIntegerList1, newIntegerList1.length + newIntegerList2.length);
                System.arraycopy(newIntegerList2, 0, newIntegerList, newIntegerList1.length, newIntegerList2.length);
                integerList = newIntegerList;
                return integerList[index];
            } else {
                throw new IllegalArgumentException("Элемент не может быть null");
            }
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + integerList.length);
        }

    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= 0 && index < integerList.length) {
            if (item != null) {
                integerList[index] = item;
                return integerList[index];
            } else {
                throw new IllegalArgumentException("Элемент не может быть null");
            }
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + integerList.length);
        }
    }

    @Override
    public Integer remove(Integer item) {
        if (item != null && contains(item)) {
            for (int i = 0; i < integerList.length; i++) {
                if (integerList[i].equals(item)) {
                    return remove(i);
                }
            }
            return item;
        } else {
            throw new IllegalArgumentException("Элемент не может быть null или элемент отсутствует в списке");
        }
    }

    @Override
    public Integer remove(int index) {
        if (index >= 0 && index < integerList.length) {
            Integer item = integerList[index];
            Integer[] newIntegerList1 = Arrays.copyOfRange(integerList, 0, index);
            Integer[] newIntegerList2 = Arrays.copyOfRange(integerList, index + 1, integerList.length);
            Integer[] newIntegerList = Arrays.copyOf(newIntegerList1, newIntegerList1.length + newIntegerList2.length);
            System.arraycopy(newIntegerList2, 0, newIntegerList, newIntegerList1.length, newIntegerList2.length);
            integerList = newIntegerList;
            return item;
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + (integerList.length - 1));
        }
    }

    @Override
    public boolean contains(Integer item) {
        if (item != null) {
            int min = 0;
            int max = integerList.length - 1;

            while (min <= max) {
                int mid = (min + max) / 2;

                if (item == integerList[mid]) {
                    return true;
                }

                if (item < integerList[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        if (item != null) {
            for (int i = 0; i < integerList.length; i++) {
                if (integerList[i].equals(item)) {
                    return i;
                }
            }
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item != null) {
            for (int i = integerList.length - 1; i >= 0; i--) {
                if (integerList[i].equals(item)) {
                    return i;
                }
            }
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < integerList.length) {
            return integerList[index];
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + integerList.length);
        }
    }

    @Override
    public boolean equals(MyList otherList) {
        if (otherList != null) {
            return Arrays.deepEquals(this.toArray(), otherList.toArray());
        } else {
            throw new IllegalArgumentException("Сравниваемый массив не может быть null");
        }
    }

    @Override
    public int size() {
        return integerList.length;
    }

    @Override
    public boolean isEmpty() {
        return integerList.length == 0;
    }

    @Override
    public void clear() {
        integerList = new Integer[0];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, integerList.length);
    }


    public void sortSelection() {
        for (int i = 0; i < integerList.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integerList.length; j++) {
                if (integerList[j] < integerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integerList, i, minElementIndex);
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
