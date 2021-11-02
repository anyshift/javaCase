/**
 * @author thrfur
 * 仿造 StringBuilder 设计一个链式操作。
 */

public class chainOperation {
    public static void main(String[] args) {
        chainAdd ca = new chainAdd();
        ca.add(1)
          .add(2)
          .add(3)
          .increase()
          .add(4);
        System.out.println(ca.totalValue());
    }
}

class chainAdd {
    private int sum = 0;

    public chainAdd add(int n) {
        sum += n;
        return this; //进行链式操作的关键是，定义的append()方法会返回this
    }

    public chainAdd increase() {
        sum ++;
        return this;  //进行链式操作的关键是，定义的append()方法会返回this
    }

    public int totalValue() {
        return sum;
    }
}