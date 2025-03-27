package rmiclient;

import common.Appointment;
import common.HospitalService;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        try{
            HospitalService hospitalService=(HospitalService) Naming.lookup("rmi://localhost:1099/HospitalService");
//            Appointment appointment=new Appointment(0,"dudu619","张新亮","西安国际医学中心","2025-3-16","10:00-11:00");
            Scanner scanner=new Scanner(System.in);
            while (true){
                System.out.println("请选择操作：");
                System.out.println("1. 预约挂号");
                System.out.println("2. 查询预约（根据ID）");
                System.out.println("3. 查询预约（根据患者姓名）");
                System.out.println("4. 取消预约");
                System.out.println("5. 退出");

                int choice=scanner.nextInt();
                scanner.nextLine();
                switch (choice){

                    case 1:
                        System.out.println("请输入预约信息");
                        System.out.println("患者姓名：");
                        String patientName=scanner.nextLine();
                        System.out.print("医生姓名：");
                        String doctorName = scanner.nextLine();
                        System.out.print("科室：");
                        String department = scanner.nextLine();
                        System.out.print("日期：");
                        String date = scanner.nextLine();
                        System.out.print("时间段：");
                        String timeSlot = scanner.nextLine();

                        Appointment appointment = new Appointment(1,patientName,doctorName,department,date,timeSlot);
                        boolean isadded =hospitalService.bookAppointment(appointment);
                        if(isadded){
                            System.out.println("预约成功");
                        }else {
                            System.out.println("预约失败，请稍后再试");
                        }
                        break;

                    case 2:
                    System.out.print("请输入预约ID：");
                    int appointmentIdQuery = scanner.nextInt();
                    Appointment appointmentById = hospitalService.queryByID(appointmentIdQuery);
                    if (appointmentById != null) {
                        System.out.println("预约信息：");
                        System.out.println("患者姓名：" + appointmentById.getPatientName());
                        System.out.println("医生姓名：" + appointmentById.getDoctorName());
                        System.out.println("科室：" + appointmentById.getDepartment());
                        System.out.println("日期：" + appointmentById.getDate());
                        System.out.println("时间段：" + appointmentById.getTimeSlot());
                    } else {
                        System.out.println("未找到该预约！");
                    }
                    break;

                    case 3:
                        System.out.print("请输入患者姓名：");
                        String patientNameQuery = scanner.nextLine();
                        List<Appointment> appointments = hospitalService.queryByPatient(patientNameQuery);
                        if (appointments.isEmpty()) {
                            System.out.println("未找到该患者的预约！");
                        } else {
                            System.out.println("预约信息：");
                            for (Appointment app : appointments) {
                                System.out.println("预约ID：" + app.getID());
                                System.out.println("医生姓名：" + app.getDoctorName());
                                System.out.println("科室：" + app.getDepartment());
                                System.out.println("日期：" + app.getDate());
                                System.out.println("时间段：" + app.getTimeSlot());
                                System.out.println("-------------------");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("请输入预约ID：");
                        int cancelId = scanner.nextInt();
                        boolean cancelSuccess = hospitalService.cancelAppointment(cancelId);
                        if (cancelSuccess) {
                            System.out.println("取消预约成功！");
                        } else {
                            System.out.println("取消预约失败！");
                        }
                        break;
                    case 5:
                        System.out.println("退出系统...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("请输入有效选项！");
                }

            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
