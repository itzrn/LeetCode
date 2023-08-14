package src;

public class L605_CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){ // base case
            return true;
        }

        if(flowerbed.length == 1){ // checking all the condition when the length of array is 1
            if(n == 1 && flowerbed[0] == 0){
                return true;
            }
            return false;
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){ // checking for index 0 alone , bcz here we have to check only two condition
            flowerbed[0] = 1;
            n--;
        }

        for(int  i =1;i<flowerbed.length-1;i++){ // i = 1 to i < flowerbed.length-1, conditions are same, so checking at one place
            if(flowerbed[i-1] ==0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0){
                return true;
            }
        }

        if(flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length-2] == 0){ // checking for index flowerbed.length-1 alone, bcz here we have to check only two condition
            flowerbed[flowerbed.length-1] = 1;
            n --;
        }

        return n == 0;
    }
}
