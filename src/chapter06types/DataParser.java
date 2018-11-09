package chapter06types;

import java.util.List;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:9/11/2018 00:08
 * Project:KotlinInAction
 */
public interface DataParser<T> {
    void parseData(String input,List<T> output,List<String> errors);
}
