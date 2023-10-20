package com.yt.october;

public class categorizeBoxcategorizeBox_2525 {
    public static void main(String[] args) {
        System.out.println(categorizeBox(9999, 9999, 9999, 200));
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        String res = "";
        boolean Bulky = false, Heavy = false;
        long v = (long) length * width * height;
        System.out.println(v);
        System.out.println(v >= 1e9);
        if(length >= 1e4 || width >= 1e4 || height >= 1e4 || mass >= 1e4 || v >= 1e9) {
            Bulky = true;
        }
        if(mass >= 100) {
            Heavy = true;
        }
        if(!Bulky && !Heavy) {
            return "Neither";
        }
        if(Bulky && !Heavy) {
            return "Bulky";
        }
        if(!Bulky && Heavy) {
            return "Heavy";
        }
        return "Both";
    }
}
