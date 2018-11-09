package chapter06types;

import java.util.List;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:8/11/2018 00:16
 * Project:KotlinInAction
 */
public class CollectionUtils {
    public static List<String> uppercaseAll(List<String> strings){
        for (String string : strings) {
            strings.set(strings.indexOf(string),string.toUpperCase());
        }
        return strings;
    }
}
