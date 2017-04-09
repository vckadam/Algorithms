class MyClass {
    public void method1(MyClass2 obj) throws InterruptedException{
        synchronized(this) {
            System.out.println("Inside method1");
            try { Thread.sleep(4000); } catch(Exception e) {System.out.println(e);}
            obj.method4();
        }
    }
    public void method3() {
        synchronized(this) {
            System.out.println("Inside method3");
        }
    }
}
class MyClass2 {
    public void method2(MyClass obj) throws InterruptedException {
        synchronized(this) {
            System.out.println("Inside method2");
            try { Thread.sleep(4000); } catch(Exception e) {System.out.println(e);}
            obj.method3();
        }
    }
    public synchronized void method4() {
        synchronized(this) {
            System.out.println("Inside method4");
        }
    }
}
public class HelloWorld{

     public static void main(String []args) throws InterruptedException{
        System.out.println("Hello World");
        MyClass obj = new MyClass();
        MyClass2 obj2 = new MyClass2();
        new Thread(new Runnable() {
            public void run() {
                try{
                obj.method1(obj2);
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try{
                obj2.method2(obj);
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
     }
}
