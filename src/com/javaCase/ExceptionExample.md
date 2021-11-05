# 常见异常

```
java.lang.Throwable
     |---java.lang.Error  //严重的异常，一般无需编写特定的代码去处理
         |---OutOfMemoryError  //内存耗尽
         |---NoClassDefFoundError  //无法加载某个Class
         |---StackOverflowError  //栈溢出
     |---java.lang.Exception  //该类异常需要捕获
         |---编译时异常(checked)
             |---IOException  //IO(输入输出)异常
                 |---FileNotFoundException  //文件未找到异常
             |---ClassNotFoundException  //类未找到异常
         |---运行时异常(unchecked, RuntimeException)
             |---NullPointerException  //空指针异常
             |---ArrayIndexOutOfBoundsException  //数组越界异常
             |---StringIndexOutOfBoundsException  //字符串越界异常
             |---ClassCastException  //类型转换异常
             |---NumberFormatException  //数据格式异常
             |---InputMismatchException  //输入不匹配异常
             |---ArithmeticException  //算术异常
```

## NullPointerException

```
public class ExceptionTest {
    public static void main(String[] args) {
        int[] arr = null; //空指针
        System.out.println(arr[3]); //空指针异常
    }
}
```

## ArrayIndexOutOfBoundsException

```
//字符串越界异常
public class ExceptionTest {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[10]); //超出组标大小
    }
}
```

## StringIndexOutOfBoundsException

```
//数组越界异常
public class ExceptionTest {
    public static void main(String[] args) {
        //String 其实本身是个 char[] 数组
        String str = "THRFUR"; //下标最大为5
        System.out.println(str.charAt(10)); //超出组标大小
    }
}
```

## ClassCastException

```
//类型转换异常
import java.util.Date;

public class ExceptionTest {
    public static void main(String[] args) {
        Object obj = new Date();
        String str = (String) obj; //类型转换异常
    }
}
```

## NumberFormatException

```
//数据格式异常
import java.lang.Integer;

public class ExceptionTest {
    public static void main(String[] args) {
        String str = "a23";
        int num = Integer.parseInt(str); //Integer的字符串转数值API
        System.out.println(num); //a23不是数值
    }
}
```

## InputMismatchException

```
//输入不匹配异常
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num); //当输入不为Int型数值时，报错
    }
}
```

## ArithmeticException

```
//算数异常，常见的为除零
public class ExceptionTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        System.out.println(a/b);
    }
}
```

