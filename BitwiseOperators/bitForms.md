```java
// int[] arr={2,3,4,1,2,1,3,6,4};
//output = 6
static int findUniqueElementByXOR(int[] arr){
    int unique=0;
    for(int ele:arr){
            unique=unique^ele;
    }
    return unique;
}
```