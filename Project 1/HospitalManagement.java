//BI17110005   MOHD FARHAN BIN ALIUDDIN
//HOSPITAL MANAGEMENT SYSTEM

import java.io.*;
import java.util.*;
import java.util.Calendar;

class staff
{
    String staff_id, sname, desg, gender;
    int salary;
    void new_staff()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        staff_id = input.nextLine();
        System.out.print("name:-");
        sname = input.nextLine();
        System.out.print("desigination[ nurse / worker ]:-");
        desg = input.nextLine();
        System.out.print("gender:-");
        gender = input.nextLine();
        System.out.print("salary:-");
        salary = input.nextInt();
    }
    void staff_info()
    {
        System.out.println(staff_id + "\t" + sname + "\t" + gender + "\t" + salary);
    }
}
class doctor
{
    String d_id, d_name, specialist, appoint, doc_qual;
    int droom;
    void new_doctor()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        d_id = input.nextLine();
        System.out.print("name:-");
        d_name = input.nextLine();
        System.out.print("specialization:-");
        specialist = input.nextLine();
        System.out.print("work time:-");
        appoint = input.nextLine();
        System.out.print("qualification:-");
        doc_qual = input.nextLine();
        System.out.print("room no.:-");
        droom = input.nextInt();
    }
    void doctor_info()
    {
        System.out.println(d_id + "\t" + d_name + "  \t" + specialist + "     \t" + appoint + "    \t" + doc_qual + "       \t" + droom);
    }
}
class patient
{
    String p_id, p_name, disease, gender, admit_status;
    int age;
    void new_patient()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        p_id = input.nextLine();
        System.out.print("name:-");
        p_name = input.nextLine();
        System.out.print("disease:-");
        disease = input.nextLine();
        System.out.print("gender:-");
        gender = input.nextLine();
        System.out.print("admit_status:-");
        admit_status = input.nextLine();
        System.out.print("age:-");
        age = input.nextInt();
    }
    void patient_info()
    {
        System.out.println(p_id + "\t" + p_name + " \t" + disease + "     \t" + gender + "      \t" + admit_status + "\t" + age);
    }
}
class medical
{
    String med_name, med_comp, exp_date;
    int med_cost, count;
    void new_medi()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("name:-");
        med_name = input.nextLine();
        System.out.print("comp:-");
        med_comp = input.nextLine();
        System.out.print("exp_date:-");
        exp_date = input.nextLine();
        System.out.print("cost:-");
        med_cost = input.nextInt();
        System.out.print("no of unit:-");
        count = input.nextInt();
    }
    void find_medi()
    {
        System.out.println(med_name + "  \t" + med_comp + "    \t" + exp_date + "     \t" + med_cost);
    }
}
class lab
{
    String facility;
    int lab_cost;
    void new_faci()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("facility:-");
        facility = input.nextLine();
        System.out.print("cost:-");
        lab_cost = input.nextInt();
    }
    void faci_list()
    {
        System.out.println(facility + "\t\t" + lab_cost);
    }
}
class facility 
{
    String fac_name;
    void add_faci()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("facility:-");
        fac_name = input.nextLine();
    }
    void show_faci()
    {
        System.out.println(fac_name);
    }
}
public class HospitalManagement
{
    public static void main(String args[])
    {
        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Calendar calendar = Calendar.getInstance();
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
        System.out.println("------------------- Welcome to Hospital UMS Management System --------------------------\n");
        System.out.print("Time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        System.out.println("\t\t\t\t\t\tDate: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
        doctor[] d = new doctor[25];
        patient[] p = new patient[100];
        lab[] l = new lab[20];
        facility[] f = new facility[20];
        medical[] m = new medical[100];
        staff[] s = new staff[100];
        int i;
        for (i = 0; i < 25; i++)
            d[i] = new doctor();
        for (i = 0; i < 100; i++)
            p[i] = new patient();
        for (i = 0; i < 20; i++)
            l[i] = new lab();
        for (i = 0; i < 20; i++)
            f[i] = new facility();
        for (i = 0; i < 100; i++)
            m[i] = new medical();
        for (i = 0; i < 100; i++)
            s[i] = new staff();

        

        Scanner input = new Scanner(System.in);
        int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1;
        while (status == 1)
        {
            System.out.println("\n--------------------------------- MAIN MENU ----------------------------------\n");
            System.out.println("1.Doctors  2. Patients  3.Medicines  4.Laboratories  5. Facilities  6. Staff \n");
            choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    {
                        System.out.println("----------------------- DOCTOR SECTION ---------------------------------------\n");
                        s1 = 1;
                        while (s1 == 1)
                        {
                            System.out.println("1.Add New Entry\n2.Current Doctors List");
                            c1 = input.nextInt();
                            switch (c1)
                            {
                                case 1:
                                    {
                                        d[count1].new_doctor();count1++;
                                        break;
                                    }
                                case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("id \t Name\t Specialist \t Timing \t Qualification \t Room No.");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count1; j++)
                                        {
                                            d[j].doctor_info();
                                        }
                                        break;
                                    }
                            }
                            System.out.println("\nPrevious Menu, Press 1 and Main Menu, Press 0");
                            s1 = input.nextInt();
                        }
                        break;
                    }
                case 2:
                    {
                        System.out.println("---------------------- PATIENT SECTION ---------------------------------------\n");
                        s2 = 1;
                        while (s2 == 1)
                        {
                            System.out.println("1.Add New Entry\n2.Current Patients List");
                            c1 = input.nextInt();
                            switch (c1)
                            {
                                case 1:
                                    {
                                        p[count2].new_patient();count2++;
                                        break;
                                    }
                                case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("id \t Name \t Disease \t Gender \t Admit Status \t Age");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count2; j++) {
                                            p[j].patient_info();
                                        }
                                        break;
                                    }
                            }
                            System.out.println("\nPrevious Menu, Press 1 and Main Menu, Press 0");
                            s2 = input.nextInt();
                        }
                        break;
                    }
                case 3:
                    {
                        s3 = 1;
                        System.out.println("---------------------- MEDICINE SECTION -------------------------------------\n");
                        while (s3 == 1)
                        {
                            System.out.println("1.Add New Entry\n2. Current List of Medicines");
                            c1 = input.nextInt();
                            switch (c1)
                            {
                                case 1:
                                    {
                                        m[count3].new_medi();count3++;
                                        break;
                                    }
                                case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("Name \t Company \t Expiry Date \t Cost");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count3; j++) {
                                            m[j].find_medi();
                                        }
                                        break;
                                    }
                            }
                            System.out.println("\nPrevious Menu, Press 1 and Main Menu, Press 0");
                            s3 = input.nextInt();
                        }
                        break;
                    }
                case 4:
                    {
                        s4 = 1;
                        System.out.println("--------------------- LABORATORY SECTION --------------------------------------\n");
                        while (s4 == 1)
                        {
                            System.out.println("1.Add New Entry \n2.Current List of Laboratories");
                            c1 = input.nextInt();
                            switch (c1)
                            {
                                case 1:
                                    {
                                        l[count4].new_faci();count4++;
                                        break;
                                    }
                                case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("Facilities\t\t Cost");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count4; j++) {
                                            l[j].faci_list();
                                        }
                                        break;
                                    }
                            }
                            System.out.println("\nPrevious Menu, Press 1 and Main Menu, Press 0");
                            s4 = input.nextInt();
                        }
                        break;
                    }
                case 5:
                    {
                        s5 = 1;
                        System.out.println("----------------- HOSPITAL FACILITY SECTION ----------------------------------\n");
                        while (s5 == 1)
                        {
                            System.out.println("1.Add New Facility\n2.Current List of Facilities");
                            c1 = input.nextInt();
                            switch (c1)
                            {
                                case 1:
                                    {
                                        f[count5].add_faci();count5++;
                                        break;
                                    }
                                case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("Current Active Facilities:");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count5; j++) {
                                            f[j].show_faci();
                                        }
                                        break;
                                    }
                            }
                            System.out.println("\nPrevious Menu, Press 1 and Main Menu, Press 0");
                            s5 = input.nextInt();
                        }
                        break;
                    }
                case 6:
                    {
                        s6 = 1;
                        System.out.println("------------------------ STAFF SECTION -------------------------------------\n");
                        while (s6 == 1)
                        {
                            String a = "nurse", b = "worker";
                            System.out.println("1.Add New Entry \n2.Current Nurses List\n3.Current Workers List");
                            c1 = input.nextInt();
                            switch (c1){
                                case 1:
                                    {
                                        s[count6].new_staff();count6++;
                                        break;
                                    }
                                case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("id \t Name \t Gender \t Salary");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count6; j++)
                                        {
                                            if (a.equals(s[j].desg))
                                                s[j].staff_info();
                                        }
                                        break;
                                    }
                                case 3:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("id \t Name \t Gender \t Salary");
                                        System.out.println("--------------------------------------------------------------------------------");
                                        for (j = 0; j < count6; j++)
                                        {
                                            if (b.equals(s[j].desg))
                                                s[j].staff_info();
                                        }
                                        break;
                                    }
                                
                            }
                            System.out.println("\nPrevious Menu, Press 1 and Main Menu, Press 0");
                            s6 = input.nextInt();
                        }
                        break;
                    }
                      default:
                    {
                        System.out.println(" Error Wrong Input!!!");
                    }
            }
            System.out.println("\nReturn back to MAIN MENU, Press 1");
            status = input.nextInt();
        }
    }
}