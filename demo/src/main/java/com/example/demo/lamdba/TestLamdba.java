package com.example.demo.lamdba;

/*
 * @ClassName: TestLamdba
 * @description: lamdba表达式推导过程
 * @author: BeliieveForMe-GuoDF
 * @Email: 731998663@qq.com
 * @github: https://github.com/BeliieveForMe
 * @date: Created in 2021/4/26 0026
 * @Version 1.0.0
 */
public class TestLamdba {

    //静态代码块
    static class Love2 implements Ilove {
        @Override
        public void love(int i) {
            System.out.println("lamdba表达式推导----第"+i+"步");
        }
    }

    public static void main(String[] args) {

        //第一步
        Ilove love = new Love();
        love.love(1);

        //第二步
        Ilove love2 = new Love2();
        love2.love(2);

        //第三步
        //局部内部类
        class Love3 implements Ilove {
            @Override
            public void love(int i) {
                System.out.println("lamdba表达式推导----第"+i+"步");
            }
        }
        Ilove love3 = new Love3();
        love3.love(3);

        //第四部：匿名内部类
        Ilove love4 = new Ilove() {
            @Override
            public void love(int i) {
                System.out.println("lamdba表达式推导----第"+i+"步");
            }
        };
        love4.love(4);

        //第五步：推导出表达式
        Ilove love5 = (int i)-> {
                System.out.println("lamdba表达式推导----第"+i+"步");
            };
        love5.love(5);

        //第六步：简化表达式
        Ilove love6 = (i)-> System.out.println("lamdba表达式推导----第"+i+"步");
        love6.love(6);
    }
}

//函数式函数接口
interface Ilove{
    void love(int i);
}

//接口实现方法1--外部类实现
class Love implements Ilove{
    @Override
    public void love(int i) {
        System.out.println("lamdba表达式推导----第"+i+"步");
    }
}
