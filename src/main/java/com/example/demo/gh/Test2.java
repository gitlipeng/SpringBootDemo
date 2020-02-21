package com.example.demo.gh;

import java.text.DecimalFormat;


public class Test2 {
    DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        double allCount=0;
        DecimalFormat df = new DecimalFormat("#.##");
        Test2 test = new Test2();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            double result = test.getHanZhi(160,1.23);
            allCount = allCount + result;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        System.out.println("result : " + allCount);
    }

    public double getHanZhi(double c, double mpa){
        // 换算温度
        c = c + 273.16;
        // 计算t
        double t = 540 / c ;
//        System.out.println(t.toString());
        double aCount = getACount(t);
//        System.out.println("-----------------------------------------------------------");
        double bCount = getBCount(t,mpa);

        // 过热燃气焓值 =D34*(C44+D78)*K44*F6
        // t * (aCount + bCount) *BaseDate.P1 * c

//        System.out.println("-----------------------------------------------------------");
//        double result = t.multiply(aCount.add(bCount)).multiply(BaseDate.P1).multiply(c).setScale(2, double.ROUND_HALF_UP);;
        double result = t*(aCount+bCount)*BaseDate.P2*c;
//        System.out.println("result : " + df.format(result));
        return result;
    }

    public double getACount(double t){
        //计算变量a 并加和
        double aCount = 0;
        for(int i = 0; i< BaseDate.p310List.size();i++){
            P310 p310 = BaseDate.p310List.get(i);
            int j =p310.getJ();
            double n = p310.getN();
            double a = n*j*(Math.pow(t,j-1));
//            System.out.println("第" + i + "个:" + a);
            aCount = aCount+a;
        }

//        System.out.println(aCount);
        return aCount;
    }

    public double getBCount(double t,double mpa){
        double pai = mpa;

        //计算变量b 并加和
        double bCount = 0;
        for(int k = 0; k< BaseDate.p311List.size();k++){
            P311 p311 = BaseDate.p311List.get(k);
            int i = p311.getI();
            int j = p311.getJ();
            double n = p311.getN();

            //= Q35*($D$33^(O35))*P35*(($D$34-0.5)^(P35-1))

//            n * (pai ^ i)*j * ((t - 0.5) ^ (j-1))

            double b = n*(Math.pow(pai,i))*j*(Math.pow(t-0.5,j-1));
//            System.out.println("第" + k + "个:" + b);
            bCount = bCount + b;
        }
//        System.out.println("bCount:" + bCount);
        return bCount;
    }
}
