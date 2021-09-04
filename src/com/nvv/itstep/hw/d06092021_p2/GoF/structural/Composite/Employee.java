package com.nvv.itstep.hw.d06092021_p2.GoF.structural.Composite;

public interface Employee {

    public void add(Employee employee);
    public void remove(Employee employee);
    public Employee getChild(int i);
    public String getName();
    public double getSalary();
    public void print();
}