//华为面试春招编程题
import java.util.Scanner;
//第一题，判断给定字符串中最大对称字符串的字符数
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] chars = string.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            int max1 = 0;
            while (chars[i - max1] == chars[i + max1]){
                max1++;
                if((i - max1 < 0) || (i + max1 >= chars.length)){
                    break;
                }
            }
            if(maxLength < 2 * (max1 - 1) + 1){
                maxLength = 2 * max1 - 1;
            }
            int max2 = 0;
            if (i + 1 < chars.length){
                if(chars[i] == chars[i + 1]){
                    while (chars[i - max2] == chars[i + 1 + max2]){
                        max2++;
                        if ((i - max2 < 0) || (i + 1 + max2 >= chars.length)){
                            break;
                        }
                    }
                }
            }

            if (maxLength < 2 * max2){
                maxLength = 2 * max2;
            }
        }
        System.out.print(maxLength);
    }
}

//第二题：给定IPV6具体地址，判断其类型
//public class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String adress = in.nextLine();
//        if(adress.length() != 39){
//            System.out.print("Error");
//            return;
//        }
//        String[] part = adress.split(":");
//        if(part.length != 8){
//            System.out.print("Error");
//            return;
//        }
//        for (int i = 0; i < 8; i++) {
//            char[] chars = part[i].toCharArray();
//            for (int j = 0; j < chars.length; j++) {
//                if(!(chars[j] >='0' && chars[j] <='9') || (chars[j] >= 'A' && chars[j] <= 'F')){
//                    System.out.print("Error");
//                    return;
//                }
//            }
//        }
//        char[] last = part[7].toCharArray();
//        if(last[3] == '1'){
//            System.out.print("Loopback");
//            return;
//        }
//        char[] first = part[0].toCharArray();
//        if (first[0] == 'F'){
//            if(first[1] == 'E'){
//                if (first[2] == '8'){
//                    System.out.print("LinkLocal");
//                    return;
//                }else if(first[2] == 'C'){
//                    System.out.print("SiteLocal");
//                    return;
//                }
//            }else if(first[1] == 'F'){
//                System.out.print("Multicast");
//                return;
//            }
//        }else if(first[0] == '2'){
//            System.out.print("GlobalUnicast");
//            return;
//        }
//        System.out.print("Unspecified");
//    }
//}
//第三题，0-1背包问题
//public class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int max = Integer.parseInt(in.nextLine());
//        String weightStr = in.nextLine();
//        String[] weightStrArr = weightStr.split(" ");
//        int[] weight = new int[weightStrArr.length];
//        for (int i = 0; i < weightStrArr.length; i++) {
//            weight[i] = Integer.parseInt(weightStrArr[i]);
//        }
//        String valueStr = in.nextLine();
//        String[] valueStrArr = valueStr.split(" ");
//        int[] value = new int[valueStrArr.length];
//        for (int i = 0; i < valueStrArr.length; i++) {
//            value[i] = Integer.parseInt(valueStrArr[i]);
//        }
//        //动态规划
//        int[][] v = new int[weight.length + 1][max + 1];
//        for (int i = 0; i <= v.length; i++) {
//            v[0][i] = 0;
//        }
//        for (int i = 1; i <= weight.length; i++) {
//            for (int j = 0; j <= max; j++) {
//                if (weight[i - 1] > j) {
//                    v[i][j] = v[i - 1][j];
//                }else {
//                    if (v[i - 1][j] > v[i - 1][j - weight[i - 1]] + value[i - 1]){
//                        v[i][j] = v[i - 1][j];
//                    }else {
//                        v[i][j] = v[i - 1][j - weight[i - 1]] + value[i - 1];
//                    }
//                }
//            }
//        }
//        int[] item = new int[weight.length];
//        for (int i = weight.length - 1; i >= 0; i--) {
//            if (v[i + 1][max] == v[i][max]){
//                item[i] = 0;
//                continue;
//            }
//            else if (max - weight[i] >=0 && v[i + 1][max] == v[i][max - weight[i]] + value[i]){
//                item[i] = 1;
//                max = max - weight[i];
//            }
//        }
//        for (int i = 0; i < item.length; i++) {
//            System.out.print(item[i]+" ");
//        }
//    }
//}
