public class Student {
    private int id;
    private String name;
    private double marks;
    private String rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = determineRank(marks);
    }

    public String getrank(){
        return rank;
    }

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = determineRank(marks);
    }

    private String determineRank(double marks) {
        if (marks >= 0 && marks < 5.0) return "Fail";
        if (marks >= 5.0 && marks < 6.5) return "Medium";
        if (marks >= 6.5 && marks < 7.5) return "Good";
        if (marks >= 7.5 && marks < 9.0) return "Very Good";
        if (marks >= 9.0 && marks <= 10) return "Excellent";
        return "Error!!";
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Mark: " + marks + ", Rank: " + rank + "\n";
    }
}
