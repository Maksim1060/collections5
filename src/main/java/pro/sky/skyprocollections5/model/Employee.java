package pro.sky.skyprocollections5.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String lstName;
    private String firstName;
    private int salary;
    private int department;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Employee(String lstName, String firstName) {
        Random random=new Random();
        this.lstName = lstName;
        this.firstName = firstName;
        this.salary = random.nextInt(10000) + 1000;
        this.department=random.nextInt(2)+1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lstName, employee.lstName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lstName, firstName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lstName='" + lstName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getLstName() {
        return lstName;
    }

    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFullName(){return firstName+" " + lstName;}
}