package rmiserver;

import common.HospitalService;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class HospitalServer  {
    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            HospitalService server= new HospitalService_impl();
            Naming.rebind("HospitalService", server);
            System.out.println("医院预约系统RMI服务器已启动...");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
