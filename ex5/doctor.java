class Doctor {
    protected int id;
    protected String name;

    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals to compare Doctor objects by id and name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return id == doctor.id && (name != null ? name.equals(doctor.name) : doctor.name == null);
    }

    // Override hashCode to return doctor id
    @Override
    public int hashCode() {
        return id;
    }

    // toString to print name (for Doctor, no department)
    @Override
    public String toString() {
        return "Doctor Name: " + name;
    }
}

class Surgeon extends Doctor {
    private String department;

    public Surgeon(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    // Override equals to include department in comparison
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Surgeon surgeon = (Surgeon) obj;
        return (department != null ? department.equals(surgeon.department) : surgeon.department == null);
    }

    // hashCode remains same as Doctor (based on id)
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // Override toString to print name with department
    @Override
    public String toString() {
        return "Surgeon Name: " + name + ", Department: " + department;
    }
}

public class Maindoctor{
    public static void main(String[] args) {
        Surgeon surgeon1 = new Surgeon(101, "Dr. Smith", "Cardiology");
        Surgeon surgeon2 = new Surgeon(101, "Dr. Smith", "Cardiology");
        Surgeon surgeon3 = new Surgeon(102, "Dr. John", "Neurology");

        // Test equals()
        System.out.println("surgeon1 equals surgeon2? " + surgeon1.equals(surgeon2)); // true
        System.out.println("surgeon1 equals surgeon3? " + surgeon1.equals(surgeon3)); // false

        // Test hashCode()
        System.out.println("surgeon1 hashCode: " + surgeon1.hashCode()); // 101
        System.out.println("surgeon3 hashCode: " + surgeon3.hashCode()); // 102

        // Test toString()
        System.out.println(surgeon1.toString()); // Surgeon Name: Dr. Smith, Department: Cardiology
        System.out.println(surgeon3.toString()); // Surgeon Name: Dr. John, Department: Neurology
    }
}
