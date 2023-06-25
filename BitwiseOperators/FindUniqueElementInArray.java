package BitwiseOperators;

public class FindUniqueElementInArray {
    public static void main(String[] args) {
        //even number of times repetation
        int[] arr={2,3,4,4,4,1,2,1,3,6,4};
        //output = 6
        // int ans=findUniqueElementByLS(arr);
        int ans=findUniqueElementByXOR(arr);
        System.out.println(ans);
    }
    //using xor
    //Time complexity=o(n)
    //this method is applicable only for even number of times the number appears but not fot odd
    static int findUniqueElementByXOR(int[] arr){
        int unique=0;
        for(int ele:arr){
             unique=unique^ele;
        }
        return unique;
    }
    //usig linear search
    //Time complexity = o(n^2)
    static int findUniqueElementByLS(int[] arr){
        for(int i=0;i<arr.length;i++){
            boolean isFound=false;
            for(int j=0;j<arr.length;j++){
                if(i==j){
                    continue;
                }else if(arr[i]==arr[j]){
                    isFound=true;
                    break;
                }
            }
            if(!isFound){
                return arr[i];
            }
        }
        return 0;
    }
}
