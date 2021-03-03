package IO;

import java.io.*;
import java.util.Vector;

public class Example {

    public Example() {
        try{
            //exp01();
            //exp02();
            //exp03();
            //exp04();
            //exp05();
            //exp06();
            //exp07();
            //exp08();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void exp01() throws Exception {

        FileWriter f1 = new FileWriter("");
        FileReader f2 = new FileReader("");

        FileOutputStream fout = new FileOutputStream("");
        FileInputStream fin = new FileInputStream("");

        BufferedReader br = new BufferedReader(new FileReader(""));
        LineNumberReader br_l = new LineNumberReader(new FileReader(""));
        br_l.getLineNumber();
        LineNumberInputStream lnis;


        // These wrapper classes allow the use of formatted output e.g float double int String Object
        PrintWriter pw = new PrintWriter("");
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(""));
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(""));

        ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(""));
        obs.writeObject(new A());

        ObjectInputStream f10 = new ObjectInputStream(new FileInputStream(""));
        A a1 = (A)f10.readObject();

        RandomAccessFile randomAccessFile = new RandomAccessFile("","r");

        // Handles the hierarchy of files and directories and allows their manipulation
        File f = new File("");
        File content[] = f.listFiles();


    }

    void exp02() throws Exception {
        FileReader fr = new FileReader("src/IO/Example.java");

        int c;
        while((c = fr.read()) != -1){
            System.out.print((char)c);
        }

        fr.close();
    }

    void exp03() throws Exception {
        FileReader fileReader = new FileReader("src/IO/Example.java");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }

    void exp04() throws Exception {

        File file = new File("src/IO/Example.java");

        if(file.exists()){

            FileInputStream fileInputStream = new FileInputStream(file);
            byte t[] = new byte[(int)file.length()];
            fileInputStream.read(t);
            String content = new String(t);
            fileInputStream.close();
            System.out.println(content);

        }
    }

    void exp05() throws Exception {
        new File("resources").mkdir();
        FileWriter out = new FileWriter("resources/data.txt");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                int x = (int)(Math.random() * 1000);
                out.write(x+",");
            }
            int x = (int)(Math.random() * 1000);
            out.write(x+ "\r\n");
        }

        out.close();
    }

    void exp06() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("resources/data.txt"));

        String row;

        while((row = in.readLine()) != null){
            String t[] = row.split(",");
            for (int i = 0; i < t.length; i++) {
                int x = Integer.parseInt(t[i].trim());
                System.out.println(x+",");
            }
            System.out.println();
        }

        in.close();
    }

    void exp07() throws Exception {
        Product p1 = new Product(101,"clavier",280);
        Product p2 = new Product(102,"souris",280);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/serializedObj.txt"));

        out.writeInt(2);
        out.writeObject(p1);
        out.writeObject(p2);

        out.close();
    }

    void exp08() throws Exception {
        Vector<Product> v = new Vector<>();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("resources.serializedObj.txt"));

        int n = in.readInt();

        for (int i = 0; i < n; i++) {
            Product p = (Product)in.readObject();
            System.out.println(v);
            v.add(p);
        }

        in.close();

        Product p1 = new Product(101,"clavier",280);
        Product p2 = new Product(102,"souris",280);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/serializedObj.txt"));

        out.writeInt(v.size());


        for (int i = 0; i < v.size(); i++) {
            v.get(i).setPrice(v.get(i).getPrice() * 0.9);

            out.writeObject(v);

        }

        out.close();
    }

    public static void main(String[] args) {
        new Example();
    }
}
