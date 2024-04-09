class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // check if starting pixel is already same as new color
        if(image[sr][sc] == color) return image;
        int initColor = image[sr][sc];
        fourDFill(initColor, color, image, sr, sc);
        return image;
    }
    public void fourDFill(int initColor, int newColor, int[][] image, int sr, int sc) {
        // check edge cases
        if(sr<0||sc<0||sr>image.length-1||sc>image[0].length-1||image[sr][sc]!=initColor) return;
        // color current pixel
        image[sr][sc] = newColor;
        // check left pixel
        fourDFill(initColor, newColor, image, sr, sc-1);
        // check right pixel
        fourDFill(initColor, newColor, image, sr, sc+1);
        // check upper pixel
        fourDFill(initColor, newColor, image, sr-1, sc);
        // check lower pixel
        fourDFill(initColor, newColor, image, sr+1, sc);
    }
}
