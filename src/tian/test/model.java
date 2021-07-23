package tian.test;

import java.util.ArrayList;
import java.io.File;
import java.util.Vector;

public class model {
    private Vector<Vector<Object>> data;

    public model(){
        data=new Vector<Vector<Object>>();
    }
    public Vector<Vector<Object>> getData(){
        return data;
    };

    public void addChara(File[] files){
        int n0=data.size();
        for(File f:files){
            Vector<Object> row=new Vector<>();
            row.add(++n0);
            row.add(f.toString());
            row.add(f.toString());
            data.add(row);
        }
    }

    public String[] getFiles(){
        String[] files=new String[data.size()];
        int i=0;
        for(Vector<Object> row:data){
            files[i++]=(String)row.get(2);
        }
        return files;
    }

}
