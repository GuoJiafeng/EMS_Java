package gjf.com.ems_java.entity;

/**
 * Created by BlackBeard丶 on 2017/9/18.
 */

public class Emp {
    private String id;
    private String name;
    private String Salary;
    private String hireDate;
    private String married;
    private String deptName;

    public Emp() {
    }

    public Emp(String id, String name, String salary, String hireDate, String married, String deptName) {
        this.id = id;
        this.name = name;
        Salary = salary;
        this.hireDate = hireDate;
        this.married = married;
        this.deptName = deptName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Salary='" + Salary + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", married='" + married + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
