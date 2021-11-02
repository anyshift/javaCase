/**
 * @author: thrfur
 * @Description: 求完美数。
 * @CreateDate: 2021年11月2日14点47分
 */

public class perfectNumber {
    public static void main(String[] args) {
        perfect pf = new perfect();
        pf.Number(1000);
    }
}

/**
 * @param: num 自定义的任意数值
 */
class perfect {
    public void Number(int num) {
        for (int i = 1; i<=num; i++){
            int total = 0;
            for (int j = 1; j<i; j++){
                if (i%j ==0){
                    //就说明 j 是 i 的因子
                    total += j;
                }
            }
            if (total == i){
                System.out.print(i + " ");
            }
        }
    }
}