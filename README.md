## 实验四：接口，博士研究生计算个税

## 一、实验目的
 1.掌握Java中抽象类和抽象方法的定义；<br>
 2.掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法<br>
 3.了解异常的使用方法，并在程序中根据输入情况做异常处理<br>

### Technology：
 - [x] 利用BigDecimal解决double的精度问题；
 - [x] 接口的使用；



## 二、实验内容
##### 逻辑与业务要求:
  某学校为了给学生提供勤工俭学机会，也减轻授课教师的部分压力，准许博士研究生参与课程的助教工作。此时，该博士研究生有双重身份：学生和助教教师。<br>
  1.设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。<br>
  2.设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。（其他属性及方法，可自行发挥）<br>
  3.编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额（根据输入情况，要在程序中做异常处理，请自行检索）。<br>


#### 实验要求
- [x] 1.在 博士研究生类中实现各个接口定义的抽象方法;
- [x] 2.对年学费和年收入进行统计，用收入减去学费，求得纳税额；
- [x] 3.国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用static   final修饰定义。
- [x] 4.实例化研究生类时，可采用运行时通过main方法的参数args一次性赋值，也可采用Scanner类实现运行时交互式输入。
- [x] 5.根据输入情况，要在程序中做异常处理
- [x] 6.编写实验报告。


## 三、实验设计
 ##### 流程图
 ![](https://github.com/Principles-Yang/InterfacePractice/blob/master/pic/diagram2.png) <br><br>

 ##### 类图（含继承、多态、对象的属性和方法等）
  ![](https://github.com/Principles-Yang/InterfacePractice/blob/master/pic/diagram1.png) <br><br>

  ##### 目录结构
  ![](https://github.com/Principles-Yang/InterfacePractice/blob/master/pic/meum.png) <br><br>

  ##### 个税的各阶段起征点
  ![](https://github.com/Principles-Yang/InterfacePractice/blob/master/pic/tax.png) <br><br>

  ##### 个税计算参考
  ![](https://github.com/Principles-Yang/InterfacePractice/blob/master/pic/CalcTax.png) <br><br>


## 四、关键代码
1.父类Students：
```Java
public class Students {
    private String name;
    private String sex;
    private int age;

    public Students(){

    }

    public Students(String name,String sex, int age){
        this.name=name;
        this.sex=sex;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
```
2.学生管理类接口
```Java
public interface StudentMan {
    public double payTuition( double Tuition);
    public double checkTuition();
}
   ```
3.教师管理类接口
```Java
 public interface TeacherMan {
    public double payWage(double wage);
    public double checkWage();
}
   ```

4.博士研究生类
 ```Java
    @Override
    public double payTuition(double t) {
        return tuitiion=t;
    }

    @Override
    public double checkTuition() {
        return tuitiion;
    }

    @Override
    public double payWage(double w) {
        return wage=w;
    }

    @Override
    public double checkWage() {
        return wage;
    }
 ```

 5.静态方法 calcSalaryTax用以计算税收 （用BigDeciaml类型解决精度问题、用final修饰各阶段值）
 ```Java
        System.out.println(calcSalaryTax(BigDecimal.valueOf(dsw1),BigDecimal.valueOf(dst1)).multiply(BigDecimal.valueOf(12)));

    public static BigDecimal calcSalaryTax(BigDecimal preTaxIncome, BigDecimal tuition) {

        final double a=5000, b=8000, c=17000 , d=30000, e=40000, f=60000, g=85000;//各阶段起征点

        BigDecimal t = BigDecimal.valueOf(taxrate).divide(BigDecimal.valueOf(100)); //除100
        BigDecimal re = taxbase.multiply(t).subtract(BigDecimal.valueOf(quickdeduction))  ;
        return re.setScale(2,BigDecimal.ROUND_HALF_UP);
 ```


6.异常的处理
 ```Java
       try {
            System.out.println("请输入川建国博士研究生的工资");
            docStudent2.payWage(sc.nextDouble());
            System.out.println("请输入川建国博士研究生的学费");
            docStudent2.payTuition(sc.nextDouble());
        } catch (NumberFormatException a) {
            System.out.println("请确认输入的是数字");
        } catch (Exception e){
            System.out.println("您的输入不符合要求");
        }
 ```


## 五、系统运行截图

  #### 最终结果展示
  ![](https://github.com/Principles-Yang/InterfacePractice/blob/master/pic/result.png) <br><br>

  
  
## 七、感想与体会
   1.本次按照软件开发流程进行，编写较为容易。<br>
   2.巩固了java知识点，如：封装、继承、多态等。<br>
   3.学习了接口的使用。<br>
   4.学习到了异常的处理。<br>
   5.新学习的BigDecimal总结如下：<br>

    > Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。双精度浮点型变量double可以处理16位有效数，
    > 但在处理经济问题时，可能需要对更大或者更小的数进行运算和处理。一般情况下，对于那些不需要准确计算精度的数字，我们可以直接用使
    > Float和Double处理，但是Double.valueOf(String) 和Float.valueOf(String)会丢失精度。所以开发中，如果我们需要精确计算的结果，
    > 则必须使用BigDecimal类来操作。

