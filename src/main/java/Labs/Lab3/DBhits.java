package Labs.Lab3;

import javax.faces.context.FacesContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBhits {
    static ArrayList<Hits> arrayList = new ArrayList<>();

    public static void addDB(Hits hit, String id) {
         arrayList.add(hit);
         System.out.println("Добавлено");
    }

    public static ArrayList<Hits> loadDB() {
        return arrayList;
    }

    public static int getCountHits(){
        return arrayList.size();
    }

    public static int getLuckyShots(){
        int lucky = 0;
        for(Hits hit : arrayList) {
            if (hit.isHit()){
                lucky+=1;
            }
        }
        return lucky;
    }

    public static void ClearDB(String id){
        arrayList.clear();
    }
}
