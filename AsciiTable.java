public class AsciiTable {
    public static void main(String[] args) {
        printAsciiTable(65,96);
        // symbolAtAscii(40);

    }
    static void printAsciiTable(int start,int maxRange){
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<maxRange;i++){
            char ch=(char)i;
            // System.out.printf("%c = %d\n",ch,(int)ch);
            sb.append(ch+" = "+(int)ch+"\n");
        }
        System.out.println(sb);
    }
    static void symbolAtAscii(int asciiValue){
        char ch=(char)asciiValue;
        System.out.printf("Ascii symbol at %d is %c",asciiValue,ch);
    }
}
