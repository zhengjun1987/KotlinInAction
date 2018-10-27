package chapter03functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/10/27 17:25
 * Project:KotlinInAction
 */
public class ExtensionsKit {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        test(strings);
        Collection<String> collection = strings;
        test(collection);

        String joinToString = new JoinKt().joinToString(Arrays.asList("1,2,3".split(",")), "-", "", "");
        System.out.println("joinToString = " + joinToString);
    }

    private static <T> void test(Collection<T> args) {
        System.out.println("ExtensionsKit.test Collection<T> " + "args = [" + args + "]");
    }

    private static <T> void test(ArrayList<T> args) {
        System.out.println("ExtensionsKit.test ArrayList<T> " + "args = [" + args + "]");
    }
}
