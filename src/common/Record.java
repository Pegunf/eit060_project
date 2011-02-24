package common;

public class Record {

	private int nurseId;
	private int doctorId;
	private int patientId;
	private int divisionId;
	
	private int recordId;

	private String content;

	public Record(int recordId, int nurseId, int doctorId, int patientId,int divisionId,
			String content) {
		this.recordId = recordId;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.divisionId = divisionId;
		this.content = content;
	}

	public void setContent(String newContent){
		content = newContent;
	}
	
	public String getContent() {
		return content;
	}

	public int getNurseId() {
		return nurseId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public int getPatientId() {
		return patientId;
	}
	public int getDivisionId(){
		return divisionId;	
	}
	public int getId() {
		return recordId;
	}

}
