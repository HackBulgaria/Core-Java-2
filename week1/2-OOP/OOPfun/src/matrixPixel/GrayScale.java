package matrixPixel;

public class GrayScale implements MatrixOperation {

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        float red = matrix[x][y].getR();
        float green = matrix[x][y].getG();
        float blue = matrix[x][y].getB();
        float grey = (red + green + blue) / 3;
        return new Pixel(grey, grey, grey);

    }

}
