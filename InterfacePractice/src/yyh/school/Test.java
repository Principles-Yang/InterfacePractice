package yyh.school;

import yyh.school.dao.Impl.DoctorManImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //new two student
        DoctorManImpl docStudent1 = new DoctorManImpl("拜登","男",28);
        DoctorManImpl docStudent2 = new DoctorManImpl("川建国","女",25);


        try {
            //Scanner input
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入拜登博士研究生的工资");
            docStudent1.payWage(sc.nextDouble());
            System.out.println("请输入拜登博士研究生的学费");
            docStudent1.payTuition(sc.nextDouble());
            System.out.println("请输入川建国博士研究生的工资");
            docStudent2.payWage(sc.nextDouble());
            System.out.println("请输入川建国博士研究生的学费");
            docStudent2.payTuition(sc.nextDouble());
        } catch (NumberFormatException a) {
            //Exception use
            System.out.println("请确认输入的是数字");
        }

        double dst1 = docStudent1.checkTuition();
        double dsw1 = docStudent1.checkWage();

        System.out.println(docStudent1.toString());
        System.out.println("拜登 的年收入是："+dsw1*12+"    拜登 的年学费是："+dst1 );
        System.out.print("拜登 全年的税为：   ");
        System.out.println(calcSalaryTax(BigDecimal.valueOf(dsw1),BigDecimal.valueOf(dst1)).multiply(BigDecimal.valueOf(12)));


        double dst2 = docStudent2.checkTuition();
        double dsw2 = docStudent2.checkWage();

        System.out.println(docStudent2.toString());
        System.out.println("川建国 的年收入是："+dsw2*12+"    川建国的年学费是："+dst2 );
        System.out.print("川建国 全年的税为：   ");
        System.out.println(calcSalaryTax(BigDecimal.valueOf(dsw2),BigDecimal.valueOf(dst2)).multiply(BigDecimal.valueOf(12)));



    }

    public static BigDecimal calcSalaryTax(BigDecimal preTaxIncome, BigDecimal tuition) {

        final double a=5000, b=8000, c=17000 , d=30000, e=40000, f=60000, g=85000;//各阶段起征点

        // 应纳税所得额 = 工资收入金额 － 学费 － 起征点(5000元)
        // 应纳税额 = 应纳税所得额 x 税率 － 速算扣除数
        /**
         * 2020年中國個人所得稅稅率
         * 月收入   税率
         * <5000   0%     0
         * <8000   3%     0
         * <17000  10%   210
         * <30000  20%  1440
         * <40000  25%  2660
         * <60000  30%  4410
         * <85000  35%  7160
         * >85000  40% 15160
         * */

        BigDecimal taxbase = preTaxIncome.subtract(tuition).subtract(BigDecimal.valueOf(a));
        int taxrate = 0;//这里税率没有除以百分比；
        int quickdeduction = 0;



        if (taxbase.compareTo(BigDecimal.ZERO) <= 0)//低于个税起征点
        {
            return BigDecimal.ZERO;
        } else if (taxbase.compareTo(BigDecimal.valueOf(a)) <= 0) {
            taxrate = 0;
            quickdeduction = 0;
        }
        else if (taxbase.compareTo(BigDecimal.valueOf(b)) <= 0) {
            taxrate = 3;
            quickdeduction = 0;
        }else if (taxbase.compareTo(BigDecimal.valueOf(c)) <= 0) {
            taxrate = 10;
            quickdeduction = 210;
        } else if (taxbase.compareTo(BigDecimal.valueOf(d)) <= 0) {
            taxrate = 20;
            quickdeduction = 1440;
        } else if (taxbase.compareTo(BigDecimal.valueOf(e)) <= 0) {
            taxrate = 25;
            quickdeduction = 2660;
        } else if (taxbase.compareTo(BigDecimal.valueOf(f)) <= 0) {
            taxrate = 30;
            quickdeduction = 4410;
        } else if (taxbase.compareTo(BigDecimal.valueOf(g)) <= 0) {
            taxrate = 35;
            quickdeduction = 7160;
        } else {
            taxrate = 45;
            quickdeduction = 15160;
        }

        BigDecimal t = BigDecimal.valueOf(taxrate).divide(BigDecimal.valueOf(100)); //除100
        BigDecimal re = taxbase.multiply(t).subtract(BigDecimal.valueOf(quickdeduction))  ;
        return re.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
