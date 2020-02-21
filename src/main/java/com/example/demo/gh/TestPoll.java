package com.example.demo.gh;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestPoll {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Double>> resultList = new ArrayList<Future<Double>>();
        double allCount=0;
        long start = System.currentTimeMillis();
        //创建10个任务并执行
        for (int i = 0; i < 10000000; i++){
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<Double> future = executorService.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }
        //76010 2.6513828723147213E10

        //遍历任务的结果
        for (Future<Double> fs : resultList){
            try{
                while(!fs.isDone());{
                    allCount = allCount + fs.get();
                }//Future返回如果没有完成，则一直循环等待，直到Future返回完成
//                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(ExecutionException e){
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        System.out.println("结果：" + allCount);
    }

}



class TaskWithResult implements Callable<Double> {
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
     * 则该方法自动在一个线程上执行
     */
    @Override
    public Double call() throws Exception {
//        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());

        Test2 test = new Test2();
        double result = test.getHanZhi(160,1.23);
        //该返回结果将被Future的get方法得到
        return result;
    }
}
