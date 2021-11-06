public class Array {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        for (int i=0;i<arr.length;i++){
            if (i==0) {
                arr[i]=0;
            }else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        for (int i=0;i< arr.length;i++) {
            if (i == arr.length - 1) {
                arr[i] = 0;
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        for (int i=0;i<arr.length;i++){
            if (i==3){
                arr[i]=0;
            }else {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
