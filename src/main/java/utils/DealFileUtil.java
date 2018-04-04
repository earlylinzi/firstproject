package utils;

import java.io.*;

public class DealFileUtil {



    public static void main(String[] ages) throws Exception {

        File file = new File("E:/短信邮件的状态值.txt");

        readFilebyLine(file);

//        String readLastLine = readLastLine(file, "UTF-8");
//
//        System.out.println(readLastLine);

    }


    public static void readFilebyLine(File file) throws Exception {


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String lineString = "";
        String lineString2 = "";

        for (int i = 1; null != lineString ; i++) {

         lineString = bufferedReader.readLine();
         lineString2 = bufferedReader.readLine();
         if(null != lineString2){
           System.out.println(lineString);

         }
         if(null != lineString){

            System.out.println(lineString2);
         }

        }





    }








    public static String readLastLine(File file, String charset) throws IOException {
        if (!file.exists() || file.isDirectory() || !file.canRead()) {
            return null;
        }
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            long len = raf.length();
            if (len == 0L) {
                return "";
            } else {
                long pos = len - 1;
                while (pos > 0) {
                    pos--;
                    raf.seek(pos);
                    System.out.println(raf.getFilePointer());
                    if (raf.readByte() == '\n') {
                        break;
                    }
                }
                if (pos == 0) {
                    raf.seek(0);
                }
                byte[] bytes = new byte[(int) (len - pos)];
                raf.read(bytes);
                raf.write("aaaaa".getBytes(),1892,5);
                if (charset == null) {
                    return new String(bytes);
                } else {
                    return new String(bytes, charset);
                }
            }
        } catch (FileNotFoundException e) {
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (Exception e2) {
                }
            }
        }
        return null;
    }
}
