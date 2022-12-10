import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList{

    transient String[] stringList;

    public StringListImpl(int size) {
        size = Math.min(0, size);
        this.stringList = new String[size];
    }

    public StringListImpl(String... args) {
        this.stringList = Arrays.stream(args)
                .filter(Objects::nonNull)
                .toArray(String[]::new);
    }

    @Override
    public String add(String item) {
        if (item != null) {
            String[] newStringList = Arrays.copyOf(stringList, stringList.length + 1);
            newStringList[newStringList.length - 1] = item;
            stringList = newStringList;
            return stringList[stringList.length - 1];
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
    }

    @Override
    public String add(int index, String item) {
        if (index >= 0 && index < stringList.length) {
            if (item != null) {
                String[] newStringList1 = Arrays.copyOfRange(stringList, 0, index + 1);
                String[] newStringList2 = Arrays.copyOfRange(stringList, index, stringList.length);
                newStringList1[newStringList1.length - 1] = item;
                String[] newStringList = Arrays.copyOf(newStringList1, newStringList1.length + newStringList2.length);
                System.arraycopy(newStringList2, 0, newStringList, newStringList1.length, newStringList2.length);
                stringList = newStringList;
                return stringList[index];
            } else {
                throw new IllegalArgumentException("Элемент не может быть null");
            }
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + stringList.length);
        }

    }

    @Override
    public String set(int index, String item) {
        if (index >= 0 && index < stringList.length) {
            if (item != null) {
                stringList[index] = item;
                return stringList[index];
            } else {
                throw new IllegalArgumentException("Элемент не может быть null");
            }
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + stringList.length);
        }
    }

    @Override
    public String remove(String item) {
        if (item != null && contains(item)) {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    return remove(i);
                }
            }
            return item;
        } else {
            throw new IllegalArgumentException("Элемент не может быть null или элемент отсутствует в списке");
        }
    }

    @Override
    public String remove(int index) {
        if (index >= 0 && index < stringList.length) {
            String item = stringList[index];
            String[] newStringList1 = Arrays.copyOfRange(stringList, 0, index);
            String[] newStringList2 = Arrays.copyOfRange(stringList, index + 1, stringList.length);
            String[] newStringList = Arrays.copyOf(newStringList1, newStringList1.length + newStringList2.length);
            System.arraycopy(newStringList2, 0, newStringList, newStringList1.length, newStringList2.length);
            stringList = newStringList;
            return item;
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + stringList.length);
        }
    }

    @Override
    public boolean contains(String item) {
        if (item != null) {
            for (String element : stringList) {
                if (element.equals(item)) {
                    return true;
                }
            }
        } else {
        throw new IllegalArgumentException("Элемент не может быть null");
    }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item != null) {
            for (int i = 0; i < stringList.length; i++) {
                if (stringList[i].equals(item)) {
                    return i;
                }
            }
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item != null) {
            for (int i = stringList.length - 1; i >= 0; i--) {
                if (stringList[i].equals(item)) {
                    return i;
                }
            }
        } else {
            throw new IllegalArgumentException("Элемент не может быть null");
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index < stringList.length) {
            return stringList[index];
        } else {
            throw new IllegalArgumentException("Индекс позиции не может быть меньше 0 или больше длинны массива: " + stringList.length);
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList != null) {
            return Arrays.deepEquals(stringList, otherList.toArray());
        } else {
            throw new IllegalArgumentException("Сравниваемый массив не может быть null");
        }
    }

    @Override
    public int size() {
        return stringList.length;
    }

    @Override
    public boolean isEmpty() {
        return stringList.length == 0;
    }

    @Override
    public void clear() {
        stringList = new String[0];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringList, stringList.length);
    }
}
