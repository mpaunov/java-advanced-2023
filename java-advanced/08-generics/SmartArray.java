import java.util.function.Consumer;

public class SmartArray<T> {

    private Object[] data;
    private int index;

    public SmartArray() {
        this.data = new Object[2];
        this.index = 0;
    }

    public void add(T element) {
        if (index == data.length) {
            data = resize(data.length * 2);
        }

        data[index] = element;
        index++;
    }

    private String[] resize(int newSize) {

        String[] newData = new String[newSize];

        System.arraycopy(data, 0, newData, 0, index);

        return newData;
    }

    public int size() {
        return index;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)data[index];
    }

    public boolean contains(String element) {
        for (int i = 0; i < index; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        T element = get(index);

        for (int i = index; i < this.index - 1; i++) {
            data[i] = data[i + 1];
        }
        data[this.index - 1] = null;

        this.index--;

        if (this.index == data.length / 4) {
            data = resize(data.length / 2);
        }

        return element;
    }

    public void add(int index, T element) {

        T lastElement = get(this.index - 1);

        for (int i = this.index - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;

        add(lastElement);
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < index; i++) {
            consumer.accept(get(i));
        }
    }

}
