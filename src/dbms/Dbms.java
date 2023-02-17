/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbms;

import dbmspages.frontpage;
import dbmspages.pendingbills;
import dbmspages.ptp;
import static dbmspages.ptp.check;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Dbms {

    /**
     * @param args the command line arguments
     * 
     */
    
    public static ArrayList<Integer> al;
    public static void main(String[] args) {
        // TODO code application logic here
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String date = f.format(d);
        
        String[] trimmedate = date.split("-",3);
        //for (String a : trimmedate)
        System.out.println(trimmedate[2]);
        int x = Integer.parseInt(trimmedate[2]);
        
        int y =3;
//        while(y--){
//            System.out.println(y);
//            y--;
//        
//        }

        al = new ArrayList<Integer>();
        while(true){
            al.add(0);
            if(al.contains(2))
                break;
            else
                System.out.println("no");
            al.add(2);
            al.add(3);
            al.add(1);
        
        }
        
        for(Integer str: al){
            System.out.println(str);
        
        }
        //System.out.println(x-2);
        //System.out.print(date);
    }
    
}
//for(Integer str:check){
//            System.out.println("after inititialization"+str);
//        
//        }
//        ptpname.setText(pendingbills.name);
//        ptpcid.setText(frontpage.usrname);
//        ptpbid.setText(pendingbills.bid);
//        check = new ArrayList<Integer>();
//        
//        
//        String[] curdate = frontpage.date.split("-",3);
//        String[] due = pendingbills.duedate.split("-",3);
//        x = Integer.parseInt(due[2]);
//        try {
//            //ptpbalance.setText(pendingbills.amount);
//            rs = pst.executeQuery("select fine from paid_list where no='"+pendingbills.bid+"'");
//            rs.next();
//            fine = rs.getString("fine");
//            totalamt = fine;
//            
//            for(Integer str:check){
//            System.out.println("after inititialization"+str);
//        
//        }
//            
//            if(check.contains(x)){
//                
//                System.out.println("contains");
//                System.out.print("in if");
//                totalamt = pendingbills.amount;
//                
//                
//
//            }
//            else{
//               
//                
//                System.out.println((Integer.parseInt(curdate[2])));
//                System.out.println((Integer.parseInt(due[2])));
//                System.out.println(((Integer.parseInt(due[2]))-(Integer.parseInt(curdate[2])))%5);
//                if(((Integer.parseInt(due[2]))-(Integer.parseInt(curdate[2])))%5==0){
//                    System.out.println("in else and in if");
//                    int x = (int) (Integer.parseInt(pendingbills.amount)*0.1+Integer.parseInt(fine)+Integer.parseInt(pendingbills.amount));
//                    System.out.println(x);
//                    totalamt = String.valueOf(x);
//                    System.out.println(totalamt);
//                    fine = String.valueOf(Integer.parseInt(pendingbills.amount)*0.1+Integer.parseInt(fine));
//                    //totalamt = String.valueOf(Integer.parseInt(pendingbills.amount)+Integer.parseInt(fine));
//                    System.out.println(fine);
//                }
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ptp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//            
//        try {
//            
//            pst.executeUpdate("update paid_list set fine='"+fine+"' where no='"+pendingbills.bid+"'");
//        } catch (SQLException ex) {
//            Logger.getLogger(ptp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //String n = String.valueOf(Integer.parseInt(totalamt)+Integer.parseInt(pendingbills.amount));
//        ptpbalance.setText(totalamt);
//        ptpfine.setText(fine);
//        if(!check.contains(x))
//            check.add(x);
//        for(Integer str:check){
//            System.out.println(str);
//        
//        }
