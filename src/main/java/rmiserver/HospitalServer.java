package rmiserver;

import common.HospitalService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HospitalServer  {
    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            HospitalService server= new HospitalService_impl();
            Naming.rebind("HospitalService", server);
            System.out.println("医院预约系统RMI服务器已启动...");

            String[] boundNames = Naming.list("rmi://localhost:1099/");
            System.out.println("已绑定的服务：");
            for (String name : boundNames) {
                System.out.println(" - " + name);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
