public class Employee {
    private int id;
    private String emplName;

    public Employee(int id, String emplName) {
        this.id = id;
        this.emplName = emplName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return emplName;
    }

    // Override equals and hashCode to prevent duplicate comparison issues
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Employee)) {
            return false;
        }
        
        Employee e = (Employee) obj;
        return this.id == e.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + emplName;
    }

}