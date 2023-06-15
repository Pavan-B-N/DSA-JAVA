public class LinearStringSearch {
    public static void main(String[] args) {
        String str = "java";
        System.out.println(linearStringSearch(str, 'v'));
    }

    // linear search for a string searches a character in the string
    static int linearStringSearch(String str, char target) {
        int i=0;
        for(char e:str.toCharArray()){
            if(e==target){
                return i;//character found in the given string
            }
            i++;
        }
        return -1;
    }
}
