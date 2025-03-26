package rmiserver;
import common.HospitalService;
import common.Appointment;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HospitalService_impl extends UnicastRemoteObject implements HospitalService {
    private  static int id=1;
    private List<Appointment> appointments=new ArrayList<>();
   protected HospitalService_impl () throws RemoteException {
       super();
   }
    @Override
    public boolean bookAppointment(Appointment appointment) throws RemoteException {
        int appointmentID=id++;
        appointment.setID(appointmentID);
        boolean idadded=appointments.add(appointment);
        return idadded;
    }
    @Override
    public Appointment queryByID(int appointmentID) throws RemoteException {
        return appointments.stream()
                .filter(a->a.getID()==appointmentID)
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Appointment> queryByPatient(String patinetName) throws RemoteException {
        List<Appointment> result= new ArrayList<>();
        for (Appointment a:appointments) {
            if(Objects.equals(a.getPatientName(), patinetName)) {
                result.add(a);
            }
        }
        return result;
    }

    @Override
    public boolean cancelAppointment(int appointmentID) throws RemoteException{
       return appointments.removeIf(a->a.getID() == appointmentID);
    }
}
