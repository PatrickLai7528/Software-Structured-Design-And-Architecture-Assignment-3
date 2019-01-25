package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookImageUtils {
    private static List<String> randomlyImageList;
    static {
        randomlyImageList = new ArrayList<>();
        randomlyImageList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ64jKugBxuDZNS_k04j62eIRmc94hVG" +
                "-cpdV5_hwcxcKIUnuzJ");
        randomlyImageList.add("https://encrypted-tbn0.gstatic" +
                ".com/images?q=tbn:ANd9GcQI5ZlHx6MNcUOqXdMHKphwGIpSFPtDkm_17DmbhKbz8oqrIfEB");
        randomlyImageList.add("https://encrypted-tbn0.gstatic" +
                ".com/images?q=tbn:ANd9GcTfMd7kLz-GzZF-8ck0ChTGaFmuz3RFKUji54zI2WEp_JfsDjn1");
        randomlyImageList.add("https://encrypted-tbn0.gstatic" +
                ".com/images?q=tbn:ANd9GcThB6FKkzznvkF_o0GKeEAX13oW1d1iqsRtHlsT9w-VNMyj57td-g");
        randomlyImageList.add("https://encrypted-tbn0.gstatic" +
                ".com/images?q=tbn:ANd9GcTJf3flj7R1zOMhs7vh8ri0Oc3nDgNbZvfLr1Wwj8sxqOnXh6EI");
        randomlyImageList.add("https://encrypted-tbn0.gstatic" +
                ".com/images?q=tbn:ANd9GcQTWGOfRuhoMAIEmkHXOAk_namHPYvqKFJpOSJAMIj4yx1qchqh");
        randomlyImageList.add("https://encrypted-tbn0.gstatic" +
                ".com/images?q=tbn:ANd9GcQmtuRZAuvTyYvdlQ8leMKpRSNzM7KfpSuB67m8IL8FDYpiSs45");
        randomlyImageList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8vSbZlb_MlK5-ni7o6HFg5cNFWC-U" +
                "-tFYSW11Su0qlhXMo-INqQ");
    }
    public static String getBookImageRandomly() {
        Random random = new Random();
        int result = random.nextInt(randomlyImageList.size());
        return randomlyImageList.get(result);
    }

    public static List<String> getBookImageListRandomly(int length){
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < length; i++){
            ret.add(getBookImageRandomly());
        }
        return ret;
    }
}
