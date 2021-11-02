/**
 * @author thrfur
 * 用接口给一个有工资收入和稿费收入的小伙伴算税
 */

public class incomeTax {
    public static void main(String[] args) {
        Income[] income = new Income[] {new workIncome(10000),new writeIncome(2000)};
        double totalTax = 0;
        for (Income incomes: income){
            totalTax += incomes.getTax();
        }
        System.out.println(totalTax);
    }
}


interface Income {
    double getTax();
}

class workIncome implements Income {
    private double income;
    public double tax = 0;

    public workIncome(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        if (income > 5000) {
            tax = ((income - 5000) * 0.2);
        }else return 0;
        return tax;
    }
}

class writeIncome implements Income {
    private double income;
    private double tax = 0;

    public writeIncome(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        tax = income * 0.2;
        return tax;
    }
}
