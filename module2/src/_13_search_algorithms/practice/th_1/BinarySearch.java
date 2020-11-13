package _13_search_algorithms.practice.th_1;

public class BinarySearch {
    static int[] list = {2,4,7,10,11,15,19,20,22,25,29,31,40,70,75,82,91,99};

    static int binarySearch(int[] list , int key){
        int low = 0;
        int high = list.length -1;
        while (high >=low){
            int mid = (low + high )/2;
            if (key < list[mid]){
                high = mid - 1;
            } else if (key == list[mid]){
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 3));
        System.out.println(binarySearch(list, 75));
        System.out.println(binarySearch(list, 29));
        System.out.println(binarySearch(list, 91));
        System.out.println(binarySearch(list, 99));
    }
}
