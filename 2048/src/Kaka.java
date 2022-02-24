public class Kaka {

    public static int width;
    public static int height;
    public int[] pixels;

    public Kaka(int width, int height, int color) {
        Kaka.width = width;
        Kaka.height = height;
        this.pixels = new int[width * height];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixels[x + y * width] = color;

                if(x % 100 < 3 || x % 100 > 97 || y % 100 < 3 || y % 100 > 97) {
                    pixels[x + y * width] = 0xffff00ff;
                }
            }
        }
    }

}
