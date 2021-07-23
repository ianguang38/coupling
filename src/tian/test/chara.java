package tian.test;

public class chara {
    private int id;
    private String name;
    private String image;

    public chara(int i,String n,String im){
        id=i;
        name=n;
        image=im;
    }


    public String[] toRow(){
        String[] i={Integer.toString(id),name,image};
        return(i);

    }


}
