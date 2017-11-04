public class Person3{
        private String name;
        private int age;
        public Person3(String thename){
            name = thename;
        }
        public static void main(String args[]){
            Person3 p=new Person3("jan");
            System.out.println(p.name);
           // System.out.println(p.age);
            Integer t1=127;
            Integer t2=127;
            System.out.println(t1==t2);
            Integer t3=128;
            Integer t4=128;
            System.out.println(t3==t4);
            Integer t5=new Integer(127);
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t5);
            System.out.println(t1==t5);
        }
    }