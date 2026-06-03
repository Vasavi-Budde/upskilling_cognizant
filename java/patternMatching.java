class patternMatching{
    public static void check(Object obj){
        switch(obj){
            case Integer i ->
                System.out.println("Integer : "+i);
            case String s ->
                System.out.println("String : "+s);
            case Double d ->
                System.out.println("Double : "+d);
            default ->
                System.out.println("Unknown");
        }
    }
    public static void main(String[] args) {
        check(15);
        check(35.5);
        check("vasavi");
        check(1.5);
    }
}