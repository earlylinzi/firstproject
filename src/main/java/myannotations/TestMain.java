package myannotations;

public class TestMain {
    public static void main(String[] args) {
        try {
            AnnoCreator.annoFiled();
            AnnoCreator.annoMethod();
            AnnoCreator.annoType();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
