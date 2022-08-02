import java.util.Arrays;

public class MyIntegersList implements MyArrayList {

    private Integer[] terminal;
    private int terminalSize;
    private Integer item;

    public MyIntegersList() {
        this.terminal = new Integer[10];
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
            if (terminal[i] == item) {
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
        Integer removeItem = terminal[index];
        if (index != terminal.length - 1) {
            System.arraycopy(terminal, index, terminal, index + 1, terminalSize - index);
        }
        terminalSize--;
        return item;
    }


    @Override
    public boolean contains(Integer item) {
        Integer findItem = indexOf(item); // используем метод поиска элемента
        return findItem != -1;            // если элемент есть, то возвращаем его
    }


    @Override
    public Integer lastIndexOf(Integer item) {
        for (int i = terminalSize - 1; i >= 0; i--) {
            if (terminal[i] == item) {
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

}


