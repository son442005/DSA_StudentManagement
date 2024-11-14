public class MyList {

    private Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    //Add
    public void add(Student x){
        Node q = new Node(x);
        if(isEmpty()){
            head = tail = q;
        }
        else {
            tail.next = q;
            tail = q;
        }
    }

    //Edit
    public void editStudent(int id, String newName, double newMarks) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                current.student = new Student(id, newName, newMarks);
                return;
            }
            current = current.next;
        }
    }

    //Delete
    public void deleteStudent(int id) {
        if (head == null) return;

        if (head.student.getId() == id) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.student.getId() == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    //Sort by Marks (Using Bubble Sort)
    public void sortStudentsById() {
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if (current.student.getMarks() < current.next.student.getMarks()) {
                    Student temp = current.student;
                    current.student = current.next.student;
                    current.next.student = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Sort by Name (Using Selection Sort)
    public void sortStudentsByName() {
        Node current = head;
        while (current != null) {
            Node min = current;
            Node next = current.next;
            while (next != null) {
                if (next.student.getName().compareToIgnoreCase(min.student.getName()) < 0) {
                    min = next;
                }
                next = next.next;
            }
            if (min != current) {
                Student temp = current.student;
                current.student = min.student;
                min.student = temp;
            }
            current = current.next;
        }
    }


    //Search by Id
    public Student searchStudent(int id) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                return current.student;
            }
            current = current.next;
        }
        return null; // Not found
    }

    //Paste
    public void traverse(){
        Node p = head;
        while(p != null){
            p.printNode();
            p = p.next;
        }
    }
}
