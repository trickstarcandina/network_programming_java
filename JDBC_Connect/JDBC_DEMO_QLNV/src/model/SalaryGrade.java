package model;

import java.io.Serializable;

/**
 * The persistent class for the SALARY_GRADE database table.
 *
 */
public class SalaryGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    public SalaryGrade(int grade, float highSalary, float lowSalary) {
        super();
        this.grade = grade;
        this.highSalary = highSalary;
        this.lowSalary = lowSalary;
    }

    private int grade;

    private float highSalary;

    private float lowSalary;

    public SalaryGrade() {
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getHighSalary() {
        return this.highSalary;
    }

    public void setHighSalary(float highSalary) {
        this.highSalary = highSalary;
    }

    public float getLowSalary() {
        return this.lowSalary;
    }

    public void setLowSalary(float lowSalary) {
        this.lowSalary = lowSalary;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            this.grade, this.highSalary, this.lowSalary
        };
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if (obj instanceof SalaryGrade){
            SalaryGrade sa = (SalaryGrade) obj;
            if(this.getGrade() == sa.getGrade()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.grade;
        hash = 89 * hash + Float.floatToIntBits(this.highSalary);
        hash = 89 * hash + Float.floatToIntBits(this.lowSalary);
        return hash;
    }
}
