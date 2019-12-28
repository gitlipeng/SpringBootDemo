package com.example.demo.gh;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        BigDecimal bigDecimal = BigDecimal.valueOf (-0.001773174	);
//        System.out.println(bigDecimal.toString());

        long start = System.currentTimeMillis();
        for(int i = 0; i < 1; i++){
            test.getHanZhi(new BigDecimal(280),new BigDecimal(3.23));
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    public void getHanZhi(BigDecimal c, BigDecimal mpa){
        // 换算温度
        c = c.add(new BigDecimal(273.16));
        // 计算t
        BigDecimal t = new BigDecimal(540).divide(c,9, RoundingMode.HALF_UP);
//        System.out.println(t.toString());
        BigDecimal aCount = getACount(t);
//        System.out.println("-----------------------------------------------------------");
        BigDecimal bCount = getBCount(t,mpa);

        // 过热燃气焓值 =D34*(C44+D78)*K44*F6
        // t * (aCount + bCount) *BaseDate.P1 * c

//        System.out.println("-----------------------------------------------------------");
        BigDecimal result = t.multiply(aCount.add(bCount)).multiply(BaseDate.P1).multiply(c);
//        System.out.println("result : " + result.toString());
    }

    public BigDecimal getBCount(BigDecimal t,BigDecimal mpa){
        BigDecimal pai = mpa;

        //计算变量b 并加和
        BigDecimal bCount = BigDecimal.ZERO;
        for(int k = 0; k< BaseDate.p311List.size();k++){
            P311 p311 = BaseDate.p311List.get(k);
            BigDecimal i = new BigDecimal(p311.getI());
            BigDecimal j = new BigDecimal(p311.getJ());
            BigDecimal n = new BigDecimal(p311.getN());

            //= Q35*($D$33^(O35))*P35*(($D$34-0.5)^(P35-1))

//            n * (pai ^ i)*j * ((t - 0.5) ^ (j-1))

            BigDecimal b = n.multiply(pow(pai,i.intValue())).multiply(j).multiply(pow(t.subtract(new BigDecimal(0.5)),j.intValue() -1));
//            System.out.println("第" + k + "个:" + b.toString());
            bCount = bCount.add(b);
        }
//        System.out.println("bCount:" + bCount);
        return bCount;
    }

    public BigDecimal getACount(BigDecimal t){
        //计算变量a 并加和
        BigDecimal aCount = BigDecimal.ZERO;
        for(int i = 0; i< BaseDate.p310List.size();i++){
            BigDecimal j = new BigDecimal(BaseDate.p310List.get(i).getJ());
            BigDecimal n = new BigDecimal(BaseDate.p310List.get(i).getN());
            BigDecimal a = n.multiply(j).multiply(pow(t,j.intValue()-1));
//            System.out.println("第" + i + "个:" + a.toString());
            aCount = aCount.add(a);
        }

//        System.out.println(aCount.toString());
        return aCount;
    }

    public BigDecimal pow(BigDecimal a,int n){
        if(a.compareTo(BigDecimal.ZERO) ==0){
            return BigDecimal.ZERO;
        }
        if(n < 0){
            return BigDecimal.ONE.divide(a.pow(-n),2, RoundingMode.HALF_UP);
        }else{
            return a.pow(n);
        }
    }


}
