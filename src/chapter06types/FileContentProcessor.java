package chapter06types;

import java.io.File;
import java.util.List;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:8/11/2018 00:48
 * Project:KotlinInAction
 */
public interface FileContentProcessor {
    void processContents(File file, byte[] binaryContents, List<String> textContents);
}
