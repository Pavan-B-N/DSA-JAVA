//find smallest letter greater than the target
//letters=["c","f","j"] and target="a" then ans="c"
//if atrget='c' then ans='f'
//Binary Search
//make sure that letters are wrap around means if target=z then ans=arr[0] i.e if no element found that is larger than the target simply return the first letter from the array i.e >=j everything will be equal to c which is arr[0] , so array get wrapped
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] arr={'c','f','j'};
        char target='j';
        System.out.println(nextLargestLetter(arr, target));
    } 
    static char nextLargestLetter(char[]  arr,char target){
        int start=0;
        int end=arr.length-1;
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }else{
                //note start should be updated in else case because when both elements are equal also we should increment start so that we will get next letter
                start=mid+1; 
            }
        }
        //start points to the smallest element that is greater than the target usually the ceil of the number
        return arr[start%arr.length];

    }
}
