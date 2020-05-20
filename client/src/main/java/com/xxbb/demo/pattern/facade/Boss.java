package com.xxbb.demo.pattern.facade;

/**
 * @author xxbb
 */
public class Boss {
    private Employee employee=new Employee();
    private Worker worker=new Worker();
    public void work(){
        employee.work();
        worker.work();
    }
}
