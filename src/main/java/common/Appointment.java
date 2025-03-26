package common;

import java.io.Serializable;

public class Appointment implements Serializable {
    private int id;
    private String patientName;
    private String doctorName;
    private String department;
    private String date;
    private String timeSlot;

    public Appointment(int id, String patientName, String doctorName, String department, String date, String timeSlot) {
        this.id=id;
        this.patientName=patientName;
        this.department = department;
        this.doctorName=doctorName;
        this.timeSlot=timeSlot;
        this.date=date;
    }
    public int getID() {return id;}
    public void setID(int id) {this.id=id;}

    public String getPatientName(){return patientName;}
    public void setPatientName(String patientName){this.patientName=patientName;}

    public String getDoctorName(){return  doctorName;}
    public void setDoctorName(String doctorName){this.doctorName=doctorName;}

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

//    @Override
    public String ToString() {
        return "Appointment{ "+
                "id="+id+
                ",patient=" + patientName+
                ",doctor=" + doctorName+
                ",depatment=" + department+
                ",date=" + date+
                ",timeslot=" + timeSlot+
                " }";
    }
}
