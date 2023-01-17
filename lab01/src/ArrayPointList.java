import javax.lang.model.type.NullType;
import java.awt.*;
import java.util.ArrayList;


public class ArrayPointList implements PointList {
    private int size = 0;
    private int cursor = 0;
    private int flagClear = 0;
    private int amount;
    private final ArrayList<Point> array;

    public ArrayPointList() {
        array = new ArrayList<>(MAX_SIZE);
        this.amount = MAX_SIZE;
    }

    public ArrayPointList(int Amount) {
        array = new ArrayList<>(Amount);
        this.amount = Amount;
    }


    @Override
    public void append(Point newPoint) {
        if (isFull()) return;
        if (flagClear == 1) array.add(0,newPoint);
        else array.add(newPoint);
        size += 1;
        cursor = this.size - 1;



    }

    @Override
    public void clear() {
        this.size = 0;
        this.flagClear = 1;
        this.cursor = this.size - 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        if (getSize() == this.amount) return true;
        return false;
    }

    @Override
    public boolean goToBeginning() {
        if (!isEmpty()) {
            cursor = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToEnd() {
        if (!isEmpty()) {
            cursor = size - 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToNext() {
        if (size == 0) return false;
        if (this.cursor == this.size - 1) return false;
        cursor++;
        return true;
    }

    @Override
    public boolean goToPrior() {
        if (cursor == 0) return false;
        cursor--;
        return true;
    }

    @Override
    public Point getCursor() {
        if (isEmpty()) return null;
        Point reto = new Point(array.get(cursor).x, array.get(cursor).y);
        return reto;
    }

    public int getSize() {
        return this.size;
    }

    public int getCursorSize() {
        return this.cursor;
    }


}
