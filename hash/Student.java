package hash;

class Student {
	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Simple hash based on id
	@Override
	public int hashCode() {
		return id; // very simple so we can trace manually
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) return false;
		Student other = (Student) obj;
		return this.id == other.id;
	}

	@Override
	public String toString() {
		return name + "(" + id + ")";
	}
}

