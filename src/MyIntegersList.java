import java.util.Arrays;
import java.util.Objects;

public class MyIntegersList implements MyArrayList {

    private Integer[] terminal;
    private int terminalSize;
    private Integer item;
    // private static final double ADD_SIZE = 1.5;

    public MyIntegersList() {
        this.terminal = new Integer[2];
    }

    // для вывода данных создаем доступную копию массива
    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(terminal, terminalSize);
    }

    @Override
    public Integer add(Integer item) {
        // добавляем элемент по значению
        terminal[terminalSize] = item; //фактич. длина масива = колличеству элементов в нем
        terminalSize++;                // переменная фактич. длины масива увеличивается на 1
        if (terminal.length == terminalSize) {
            growArray();
        }
        return item;
    }

    @Override
    public Integer add(Integer index, Integer item) {// добавляем элемент по индексу и значению
        if (index < 0 || index > terminalSize) {
            throw new RuntimeException("Неверный индекс");
        } else if (index == terminalSize) {
            terminal[terminalSize] = item;
            terminalSize++;
            return item;
        } else {
            System.arraycopy(terminal, index, terminal, index + 1, terminalSize - index);
            terminalSize++;
        }
        return item;
    }

    public Integer set(int index, Integer item) {
        if (index < 0 || index > terminalSize) {
            throw new RuntimeException("Неверный индекс");
        } else {
            terminal[terminalSize] = item;
            // terminalSize++; -не добавляем, так как кол-во элементов и размер массива остается прежним.
        }
        return item;
    }

    @Override
    public Integer indexOf(Integer item) {
        for (int i = 0; i < terminalSize; i++) {
            if (Objects.equals(terminal[i], item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public Integer remove(Integer item) {
        int findIndex = indexOf(item);
        if (findIndex == -1) {
            throw new RuntimeException("Элемент отсутствует");
        }
        if (findIndex != terminal.length - 1) {
            System.arraycopy(terminal, findIndex + 1, terminal, findIndex, terminalSize - findIndex);
        }
        terminalSize--;
        return item;
    }


    @Override
    public Integer remove(int index) {
        if (index < 0 || index > terminalSize) {
            throw new RuntimeException("Неверный индекс");
        }
        if (index != terminal.length - 1) {
            System.arraycopy(terminal, index, terminal, index + 1, terminalSize - index);
        }
        terminalSize--;
        return item;
    }


    @Override
    public boolean contains(Integer item) {
        // используем метод поиска элемента
        sort();
        int min = 0;
        int max = terminal.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(item, terminal[mid])) {
                return true;
            }
            if (item.equals(terminal[mid])) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;           // если элемент есть, то возвращаем его
    }


    @Override
    public Integer lastIndexOf(Integer item) {
        for (int i = terminalSize - 1; i >= 0; i--) {
            if (Objects.equals(terminal[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(Integer index) {
        if (index < 0 || index > terminalSize) {
            throw new RuntimeException("Неверный индекс");
        }
        return terminal[index];
    }

    @Override
    public boolean equals(MyArrayList otherList) {
        if (otherList == null) {
            throw new RuntimeException("null");
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public Integer size() {
        return terminalSize;
    }

    @Override
    public boolean isEmpty() {
        return terminalSize == 0;
    }

    @Override
    public void clear() {
        terminalSize = 0;
    }


    @Override
    public void sort() {
quickSort(terminal,0,terminal.length-1);
    }

    @Override
    public boolean binarySearchContains(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void growArray() {
       /* Integer[] terminalNewCopy = new Integer[(int) (terminal.length * ADD_SIZE)];
        System.arraycopy(terminal, 0, terminalNewCopy, 0, terminal.length);
        terminal = terminalNewCopy;*/
        terminal = Arrays.copyOf(terminal, terminal.length + terminal.length / 2);
    }
    @Override
    public int arrLength() {
        return terminal.length;
    }

    private void quickSort(Integer[] terminal, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(terminal, begin, end);

            quickSort(terminal, begin, partitionIndex - 1);
            quickSort(terminal, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] terminal, int begin, int end) {
        int pivot = terminal[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (terminal[j] <= pivot) {
                i++;

                swapElements(terminal, i, j);
            }
        }

        swapElements(terminal, i + 1, end);
        return i + 1;
    }
    private static void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}






