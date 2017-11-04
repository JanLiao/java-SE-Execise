public class Person1{
        private String name;
        private int age;
        public Person1(String name){
            this.name = name;
        }
        public Person1(String name,int age){
            this(name);
            this.age = age;
        }
        public static void main(String args[]){
            Person1 p=new Person1("jan",25);
            System.out.println(p.name);
            System.out.println(p.age);
            
        }
    }