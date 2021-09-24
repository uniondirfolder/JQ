package reflection;

import java.io.*;

public class CustomClassLoaderDemo extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        //return defineClass(name, bt, 0, bt.length);
        return defineClass("nvv.ReflectionTest", bt, 0, bt.length); // ToDo обработка строки из файла имя пакета + имя класа
    }
    private byte[] loadClassData(String file) {
        //read class
//        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");

        InputStream fi = null;
        try {
             fi = new FileInputStream(new File(file + ".class"));
            ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
            //write into byte
            int len =0;
            try {
                while((len=fi.read())!=-1){
                    byteSt.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //convert into byte array
            return byteSt.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        InputStream is = null;
//        try {
//            is = getClass().getClassLoader().getResource(file).openStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if(is!=null){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len =0;
        try {
            while((len=fi.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert into byte array
        return byteSt.toByteArray();
    }

}
