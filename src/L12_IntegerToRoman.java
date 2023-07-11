package src;

public class L12_IntegerToRoman {
    public String integerConversion(int num){
        if (num == 0)//base case
            return "";

        if (num<=3){//checking for a once place
            if (num == 1)
                return "I";
            num = num-1;
            return integerConversion(num)+"I";
        }
        if (num == 4)
            return "IV";
        if (num<=8){
            if (num==5)
                return "V";
            num = num-1;;
            return integerConversion(num)+"I";
        }
        if (num == 9)
            return "IX";


        if (num<=30){//checking for a tens place
            if (num==10)
                return "X";
            num = num-10;
            return integerConversion(num)+"X";
        }
        if (num == 40)
            return "XL";
        if (num<=80){
            if (num==50)
                return "L";
            num = num-10;;
            return integerConversion(num)+"X";
        }
        if (num == 90)
            return "XC";


        if (num<=300){//checking for a hundred place
            if (num==100)
                return "C";
            num = num-100;
            return integerConversion(num)+"C";
        }
        if (num == 400)
            return "CD";
        if (num<=800){
            if (num==500)
                return "D";
            num = num-100;;
            return integerConversion(num)+"C";
        }
        if (num == 900)
            return "CM";


        if (num == 1000)//checking for a thousand place
            return "M";
        num = num - 1000;
        return integerConversion(num)+"M";
    }

    public int numberOfDigit(int num){//to find the number of digit in the given number
        if (num == 0)
            return 0;

        return numberOfDigit(num/10)+1;
    }

    public String intToRoman(int num){//making every place to roman one by one
        String roman = "";
        int length = numberOfDigit(num);
        for (int i = 0;i<length;i++){
            roman = integerConversion((int) ((num%10)*Math.pow(10,i))) + roman;
            num = num/10;
        }
        return roman;
    }
}
