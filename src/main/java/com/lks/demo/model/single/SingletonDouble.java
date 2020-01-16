package com.lks.demo.model.single;

/**
 * 雙重判斷
 *
 * @author likesheng
 * @Time 2019/11/12
 **/
public class SingletonDouble {

    private SingletonDouble() {
    }

    private static volatile SingletonDouble instance;

    /**
     * 双重判断对象
     *
     * @return
     */
    public static SingletonDouble getInstance(){
        //1.第一次判断，多线程的情况下，线程一进入创建，第二个线程刚进入，避免了创建新对象
        if (instance==null){
            synchronized (SingletonDouble.class){
                /**
                 * 第二个判断是因为当两个线程都过了第一个判断标准时,进入等待，其中有一个线程创建完后，线程二获取到对象锁，进入
                 * 注意这时候的instance已经创建完成，线程二进入如果没有判断的话，他将会直接进行创建，会创建出多余的对象
                 */
                if(instance == null){
                    instance = new SingletonDouble();
                }
            }
        }
        return instance;
    }
}
