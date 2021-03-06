package Project02_21;


public class Student {
	
	private String name;
	private char gender;
	private Date birthday;
	private Preference pref;
	
	private boolean matched;
	
	int compatibility= 0;
	int preference = 0;
	int ageDiff = 0;
	int monthDiff;
	
	public Student(String studentName, char studentGender, Date studentBirthDay, Preference studentPref) {
		
		name = studentName;
		gender = studentGender;
		birthday = studentBirthDay;
		pref = studentPref;
		
	}
	
	public String getName() {
		return this.name;
	}

	public char getGender() {
		return this.gender;
	}

	public Date getBirthDay() {
		return this.birthday;
	}

	public Preference getPref() {
		return this.pref;

	}

	public boolean getMatch() {

		return matched;

	}

	public void setMatch(boolean b) {

		this.matched = b;
	}

	// compares two different students
	public int compare(Student st) {
		// Compatibility Score Calculation
		if (gender != st.gender) {
			return 0;
		}
		int compatabilityScore = (40 - pref.compare(st.pref))
				+ (60 - birthday.compare(st.birthday));
		if (compatabilityScore < 0) {
			return 0;
		} else if (compatabilityScore > 100) {
			return 100;
		}
		return compatabilityScore;
	}
	}

