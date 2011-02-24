package common;

public class Record {

	private int nurseId;
	private int doctorId;
	private int patientId;

	private int recordId;

	private String content;

	public Record(int recordId, int nurseId, int doctorId, int patientId,
			String content) {
		this.recordId = recordId;
		this.nurseId = nurseId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.content = content;
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

	public int getId() {
		return recordId;
	}

}
