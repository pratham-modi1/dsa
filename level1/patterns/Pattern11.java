package level1.patterns;

public class Pattern11 {
    public static void main(String[] args) {
        
        
    //better method
    int n = 6;
    for(int i=0;i<n;i++){
    
        int start = (n%2==0)? 1:0;
    
        for(int j=0;j<i;j++){
    
            System.out.print(start);
            start = 1-start;
        }
        System.out.println();

} 
    //alternate method
    // int n = 6;
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<i;j++){

    //         if((i%2==0 && j%2==0) || (j%2!=0 && i%2!=0)){
    //             System.out.print(0);
    //         }
    //         //if i and j both are even print 1
    //         else{
    //             System.out.print(1);
    //         }
    //     }
    //     System.out.println();
    // }
}}
