package entities;

public class Rooms {

	private int vacancies;
	private String renter;
	private String idStudent;
	
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public String getRenter() {
		return renter;
	}
	public void setRenter(String renter) {
		this.renter = renter;
	}
	public String getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	@Override
	public String toString() {
		return "[ VACANCIES = " + getVacancies() + " ]\n"
			+ "[ RENTER = " + getRenter() + " ]\n"
			+ "[ REGISTRATION = " + getIdStudent() + " ]\n\n";
	}
	

}
