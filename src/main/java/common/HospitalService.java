package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HospitalService extends Remote {
    boolean bookAppointment(Appointment appointment) throws RemoteException;
    Appointment queryByID(int appointmentID) throws RemoteException;
    List<Appointment> queryByPatient(String patinetName) throws RemoteException;
    boolean cancelAppointment(int appointmentID) throws RemoteException;
}
