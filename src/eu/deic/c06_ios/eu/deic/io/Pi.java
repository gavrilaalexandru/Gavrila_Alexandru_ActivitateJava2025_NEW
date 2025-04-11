package eu.deic.c06_ios.eu.deic.io;

import java.io.Serializable;
import java.net.URL;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class ObjectsGraph implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -689547391845626872L;
    public URL o1;
    public URL o2;

    public ObjectsGraph(URL o1, URL o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public String toString() {
        return new String("o1 = " + this.o1
                + ", o2 = " + this.o2);
    }
}

class ObjectsSave {
    public static void main(String[] args) {
        ObjectsGraph og = null;

        try {
            System.out.println("Saving objects ...");

            ObjectOutputStream sout = new ObjectOutputStream(
                    new FileOutputStream("test4.txt"));

            URL o1 = new URL("http://www.google.com");
            URL o2 = o1;
            URL o3 = o1;

            og = new ObjectsGraph(o1, o2);
            sout.writeObject(og);
            //sout.reset();
            sout.writeObject(o3);
            sout.flush();

            System.out.println("og written: " + og);
            System.out.println("o3 written: "+ o3);

            boolean exp = ( (og.o1 == o3) && (og.o1 == og.o2) );
            System.out.println("exp boolean = " + exp);

            sout.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class ObjectsRestore {
    public static void main(String[] args) {
        ObjectsGraph og = null;
        try {
            System.out.println("Objects Restore ...");
            FileInputStream fin = new FileInputStream("test4.txt");
            ObjectInputStream sin = new ObjectInputStream(fin);

            og = (ObjectsGraph)sin.readObject();
            System.out.println("og read = " + og);

            URL o3 = (URL)sin.readObject();
            System.out.println("o3 read = " + o3);

            boolean exp = ( (og.o1 == o3) && (og.o1 == og.o2) );
            System.out.println("exp boolean = " + exp);

            sin.close();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Pi {

}
