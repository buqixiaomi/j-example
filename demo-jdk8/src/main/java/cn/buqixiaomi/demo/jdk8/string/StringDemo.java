package cn.buqixiaomi.demo.jdk8.string;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-08-14 4:57
 */
public class StringDemo {

    public static void main(String[] args) {
//        constructorDemo();
//        stringInitDemo();
//        reflectionDemo();
//        internDemo();
//        simpleDemo();
//        stringLocationDemo();
        System.out.println(longPalindrome("1239567890987654321"));
        System.out.println(longPalindrome2("1239567890987654321"));
        doManacher("1239567890987654321");
    }

    /**
     * manacher算法求取最大回文
     * 算法思想
     * 1 把偶数、奇数长的字符序列变成奇数长度 （所有的空隙位置(包括首尾)插入同样的符号）
     * 2 创建一个与字符串等长的数组，用来记录字符序列相应位置上字符的最长回文半径，半径为1时默认为字符本身
     * 3 然后以每个字符为中轴遍历字符序列，之后求数组的最大值即为最大的半径，即为最长的回文半径
     * @param s
     */
    public static void doManacher(String s) {
        //在字符串两头和质检添加特殊字符转成奇数长度，原理：奇数+奇数+1=奇数，偶数+偶数+1=奇数。
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb = sb.append(s.substring(i, i + 1)).append("#");
        }
        s = sb.toString();

//		以每个字符为轴求最长回文串半径，其中半径=1表示字符本身。
        int[] p = new int[s.length()];
        int left, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            for (left = i - 1, right = i + 1; left >= 0 && right <= (2 * i) && right < s.length(); left--, right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    len = len + 1;
                    continue;//如果匹配成功就继续
                } else {
                    break;//不成功就跳出循环
                }
            }
            p[i] = len;
        }//end wai for

        //求最大的p[i]值
        int pos, maxValuePos = 0;
        for (int i = 0; i < p.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < p.length; j++) {
                if (p[i] < p[j]) {
                    pos = j;
                    int tep = p[i];
                    p[i] = p[pos];
                    p[pos] = tep;
                }
                if (i == 0){
                    maxValuePos = pos;
                }
            }
        }
        //求得的回文串一定是奇数长度
        int realLen = ((p[0] * 2 - 1) - 1) / 2;//最长回文串的长度，去掉其他字符
        System.out.println("最长的回文串长度为：" + realLen);


        //求最长回文串内容
        String huiwen;
        StringBuffer realHuiwen = new StringBuffer();
        if (realLen == 1) {
            System.out.println("最长回文串为：" + s.charAt(maxValuePos));
        } else {
//              截出来
            huiwen = s.substring((maxValuePos + 1 - p[0]), maxValuePos + p[0]);
//             去掉辅助字符
            for (int j = 0; j < huiwen.length(); j++) {
                if (j % 2 != 0){
                    realHuiwen = realHuiwen.append(huiwen.charAt(j));
                }
            }
            System.out.println("最长回文串为：" + realHuiwen.toString());
        }

    }

    /**
     *  最长回文
     *  中心扩展
     *  因为回文字符串是以中心轴对称的，所以如果我们从下标 i 出发，用2个指针向 i 的两边扩展判断是否相等，
     *  那么只需要对0到n-1的下标都做此操作，就可以求出最长的回文子串。
     *  但需要注意的是，回文字符串有奇偶对称之分，即”abcba”与”abba”2种类型，因此需要在代码编写时都做判断
     * @param s
     * @return
     */
    public  static String longPalindrome2(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String subS = s.substring(begin + 1, end);
        return subS;
    }

    /**
     * 最长回文
     * 动态规划
     * 从左开始遍历，然后不断的从原字符串中拿出1到length-1长度的字串，进行判断
     * 这里用一个二维数组来表示回文字符串的起始位置和结束位置，值1代表的是回文字符串，0代表不是
     * @param s
     * @return
     */
    public static String longPalindrome(String s) {
        if (s == null){
            return null;
        }
        if(s.length() <=1){
            return s;
        }
        int maxLen = 0;
        String longestStr = null;
        int length = s.length();
        int[][] table = new int[length][length];
        //every single letter is palindrome
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        printTable(table);
        //two consecutive same letters are palindrome
        for (int i = 0; i <= length - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)){
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }
        System.out.println(longestStr);
        printTable(table);
        //condition for calculate whole table
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length-l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen) {
                        longestStr = s.substring(i, j + 1);
                    }
                } else {
                    table[i][j] = 0;
                }
                printTable(table);
            }
        }
        return longestStr;
    }
    public static void printTable(int[][] x){
        for(int [] y : x){
            for(int z: y){
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }

    /**
     * 验证常量池所在的内存区域
     * 执行时，需指定内存小一些 -Xmx10m -Xms10m -XX:-UseGCOverheadLimit
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * jdk 1.7 之后常量池移到了堆中，
     */
    public static void stringLocationDemo(){
        List<String> list = new ArrayList<>();
        int i =0;
        while (true){
            System.out.println("1");
            list.add(String.valueOf("上级分类上级分类可使肌肤数据福克斯江东父老世纪东方"+ (i++)).intern());
        }
    }

    /**
     *
     */
    public static void simpleDemo(){
        String s = " ";
        String s1 = "abcdab";
        System.out.println(s1.replace("ab","你好"));
        System.out.println(s1.replaceAll("ab","你好"));
        System.out.println(s1.replaceFirst("ab","你好"));

        String s2 = s1.concat("123");
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1.substring(1,2);
        System.out.println(s3);

        String s4 = "死垃圾分类即阿里客服圣诞节啊弗兰克斯";
        System.out.println(s4.hashCode());

        String sss = "11";
        String sss2 = new String("11");
        System.out.println(s.hashCode() + "-----" + s2.hashCode());
        System.out.println(s == s2);

        String ss2 = new String("了讲述了房间");
        String ss = "了讲述了房间";
        System.out.println(ss.hashCode() + "-----" + ss2.hashCode());
        System.out.println(ss == ss2);
    }

    public static void caseDemo(){
        String s = "a";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        char c = 'a';
        System.out.println();
    }

    /**
     * intern 返回的永远是常量对象
     */
    public static void internDemo(){
        String s1 = new String("a");
        String s = "a";
        System.out.println(s1==s);
        String s2 = s1.intern();
        System.out.println(s2==s);

        String s3 = new String("b");
        String s4 = s3.intern();
        System.out.println(s3 == s4);
    }

    /**
     * 反射改变String 内部char[] 值
     */
    public static void reflectionDemo(){

        String ns4 = new String("早上好");
        String s4 = "早上好";
        //返回false 表示创建了两个对象，常量池中的和new 堆中的
        System.out.println(s4 == ns4);

        String s5 = "中午好";
        String ns5 = new String("中午好");
        //返回false 表示创建了两个对象，常量池中的和new 堆中的
        System.out.println(s5 == ns5);

        //那么问题是，new的过程到底是怎么样的呢？

        try {
            Field valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
            char[] valueChar = (char[]) valueField.get(ns4);
            valueChar[2]='?';
            //输出 早上？
            System.out.println(ns4);
            //输出 早上？，s4 和ns4 相等，表示表示常量池和堆中的对象内部引用同一个char[]
            //所以常量池的对象 肯定是在new 之后就产生了的，而不是到String s4 = "早上好" 定义时才创建对象
            //否则引用的char[] 不能是同一个
            System.out.println(s4);

            char[] valueChar5 = (char[]) valueField.get(ns5);
            valueChar5[2]='?';
            //输出 中午？
            System.out.println(ns5);
            //输出 中午？，s5 和ns5 相等，表示表示常量池和堆中的对象内部引用同一个char[]
            //所以在new Sting的时候，回去判断常量池是否存在，如果存在，怎使用已有的char[]创建。
            System.out.println(s5);

            //综上所述，new String()时，会先在常量池里判断是否有等值对象，如果有则使引用其底层char[]创建对象；若没有，则
            //创建对象，并在常量池中也创建一个等值对象，引用同一个char[]存储

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * String 构造初始化
     */
    public static void stringInitDemo() {

        //创建1个对象，1个引用，在常量池中创建了一个"hello"对象，在栈中分配了一个引用s1指向常量池"hello"对象
        String s1 = "hello";
        //创建 0个对象，1个引用，因为常量池中已经存在"hello" 对象，在栈中分配了一个引用s2指向常量池"hello"对象
        String s2 = "hello";

        //创建了2个对象，1个引用，在常量池中创建了一个"hi"对象，在堆中使用new 创建了一个"hi"对象，在栈中分配了一个引用ns1指向堆中"hi"对象
        String ns1 = new String("hi");
        //创建了1个对象，1个引用，因为常量池中已经存在"hi" 对象，在堆中使用new 创建了一个"hi"对象，在栈中分配了一个引用ns2指向堆中"hi"对象
        String ns2 = new String("hi");

        //创建1个对象，1个引用，在常量池中创建了一个"你好"对象，在栈中分配了一个引用s3指向常量池"你好"对象
        String s3 = "你好";
        //创建了1个对象，1个引用，因为常量池中已经存在"你好" 对象，在堆中使用new 创建了一个"你好"对象，在栈中分配了一个引用ns3指向堆中"你好"对象
        String ns3 = new String("你好");


    }

    /**
     * 构造函数参数count 指字符串长度
     */
    public static void constructorDemo(){
        char[] chars = {'1','2','3','4','5'};
        String a = new String(chars,0,1);
        System.out.println(a);
    }
}
