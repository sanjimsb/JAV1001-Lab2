/*************************************************
****  Name            : Bipin Man Singh Bhandari
****  Student Numnber : A00239909
****  Program         : JAV1001-Lab1
**************************************************/
import java.util.Arrays;
import java.util.Scanner;

public class ArrayTools {
    public static String getUserInput;
    public static String getStringToEncrypt;
    public static int getValueToEncryptWith;
    public static int getSearchKey;
    public static int getArrayLength;
    public static int[] getArrayFromUser;
    
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        printInputValue();
        getUserInput = scanInput.next();

        switch(getUserInput){
            case"1":
                System.out.println("Enter a string to encrypt");
                getStringToEncrypt = scanInput.next();
                System.out.println("\nEnter a string to encrypt with");
                
                try{
                    getValueToEncryptWith = scanInput.nextInt();
                }catch(Exception e){
                    System.out.println("\nPlease run the program again with valid value i.e. Int");
                    System.exit(0);
                }

                System.out.println(cipherAndDicipherText(getStringToEncrypt, getValueToEncryptWith));
            break;
            case"2":
                getArrayElementFromUser(scanInput);

                System.out.println("The Average of your entered array is " + returnTheAverage(getArrayFromUser,getArrayLength));
            break;
            case"3":
                getArrayElementFromUser(scanInput);

                System.out.println("\nEnter the array element that you want to search");
                getSearchKey = scanInput.nextInt();
                System.out.println(checkIfAarryElementExists(getArrayFromUser,getSearchKey));
            break;
            case"4":
                getArrayElementFromUser(scanInput);

                System.out.println(Arrays.toString(getReversedArray(getArrayFromUser,getArrayLength)));
            break;
            default:
                System.out.println("Please run the program again with valid value");
                System.exit(0);
            break;
        }

        scanInput.close();
    }

    public static void getArrayElementFromUser(Scanner getScanObject){
        System.out.println("Enter the length of an array");

        try{
            getArrayLength = getScanObject.nextInt();
        }catch(Exception e){
            System.out.println("\nPlease run the program again with valid value i.e. Int");
            System.exit(0);
        }

        System.out.println("Enter the length of an array");
        getArrayFromUser = new int[getArrayLength];

        for(int i=0;i<getArrayLength;i++){
            System.out.println("\nEnter the  array element");

            try{
                getArrayFromUser[i] = getScanObject.nextInt();
            }catch(Exception e){
                System.out.println("\nPlease run the program again with valid value i.e. Int");
                System.exit(0);
            }
        }
    }

    // prints the default message 
    public static void printInputValue(){
        System.out.println("Enter 1 to encrypt a value");
        System.out.println("Enter 2 to get average of an array");
        System.out.println("Enter 3 to check if array contains the certain value");
        System.out.println("Enter 4 to reverse the array's order");
    }

    // checks and returns if the array element exists on the array 
    public static boolean checkIfAarryElementExists(int[] getArrayFromUser, int getArrayElemnt){
        boolean defaultStatus = false;
        for(int i=0;i<getArrayLength;i++){
            if(getArrayFromUser[i] == getArrayElemnt){
                defaultStatus = true;
                break;
            }
        }
        return defaultStatus;
    }

    
    // returns the average of all elements within the array  
    public static double returnTheAverage(int[] getArrayFromUser, int getArrayLength){
        //can use getArrayFromUser.length to determing the length of an array
        int totalValue = 0;
        double getAverage = 0.0;
        for(int i=0;i<getArrayLength;i++){
            totalValue += getArrayFromUser[i];
        }
        getAverage = (double)totalValue/getArrayLength;

        return getAverage;
    }

    // reverses the array and returns the reversed array 
    public static int[] getReversedArray(int[] getArrayFromUser, int getArrayLength){
        int[] reversedArray = new int[getArrayLength];
        for(int i=0;i<getArrayLength;i++){
            reversedArray[i] = getArrayFromUser[(getArrayLength - 1) - i];
        }
        return reversedArray;
    }

    // cipher the string and returns the ciphered string 
    public static StringBuffer cipherAndDicipherText(String getStringToEncrypt, int getValueToEncryptWith){
        StringBuffer cipherText = new StringBuffer();
 
        for (int i=0; i<getStringToEncrypt.length(); i++){
            if (Character.isUpperCase(getStringToEncrypt.charAt(i))){
                char ch = (char)((getStringToEncrypt.charAt(i) + getValueToEncryptWith - 65) % 26 + 65);
                cipherText.append(ch);
            }else{
                char ch = (char)((getStringToEncrypt.charAt(i) + getValueToEncryptWith - 97) % 26 + 97);
                cipherText.append(ch);
            }
        }
        
        return cipherText;
    }
}