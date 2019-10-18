

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class Sort_Hotel {
    static Connection conn = null;


    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static ResultSet rs2 = null;

    public int Sort_Hotel (int row_value) {

    conn = SQLConnection.ConnectDB();
    int RET = 0;    
//----------------------------EXTERNAL DEV-----------------------------------------------------------------------------------
        

        
        String sqlhotel="SELECT `hotel_id`,`package` FROM `hotel` order BY package";
        String sqlhotel_cnt="SELECT COUNT(*) FROM `hotel` ";
        String sqlmeal="SELECT `food_id`,`package`FROM `foods` order BY package";
        String sqldeco="SELECT `deco_id`,`package` FROM `decos` order BY package";
        String sqljwel="SELECT `jewel_id`,`package` FROM `jewelry` order BY package";
        String sqldress="SELECT `item_id`,`package` FROM `dresses_makeup` order BY package";
        
        
                    try{
                        int count=0;
                        String id[]={};

                        ArrayList row = new ArrayList();

                        pst = conn.prepareStatement(sqlhotel_cnt);
                        rs2 = pst.executeQuery();
                        while (rs2.next()) {                
                            count=rs2.getInt(1);
                        }
                        System.out.println(count);
                        pst = conn.prepareStatement(sqlhotel);
                        rs = pst.executeQuery();
                        while(rs.next()){
                            row.add(rs.getString(1)); 
                        }
                        id =(String[]) row.toArray(new String[row.size()]);
                        for (int i = 0; i < id.length; i++) {
                            System.out.println(id[row_value]);//<<<-----------------------------------------------------   
                        }  
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    //================================

                        try {
                        int count=0;

                        String pkg[]={};
                        ArrayList row = new ArrayList();


                        //Map <String, Integer> map = new HashMap<String, Integer>();

                        pst = conn.prepareStatement(sqlhotel_cnt);
                        rs2 = pst.executeQuery();
                        while (rs2.next()) {                
                            count=rs2.getInt(1);
                        }
                        System.out.println(count);
                        pst = conn.prepareStatement(sqlhotel);
                        rs = pst.executeQuery();


                        while(rs.next()){

                            row.add(rs.getString(2)); 

                        }


                        pkg =(String[]) row.toArray(new String[row.size()]);

                        for (int i = 0; i < pkg.length; i++) {
                            System.out.println(pkg[row_value]);//<<-------------------------------------------------   
                            RET= Integer.parseInt(pkg[row_value]);
                        }


                    } catch (Exception e) {
                        //System.out.println(e);
                    }   

        
        
        
        
  

                        return RET;

//----------------------------EXTERNAL DEV-----------------------------------------------------------------------------------
        
    }
    
}
