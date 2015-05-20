package matrixPixel;

import java.util.Arrays;

public class MatrixPixels {
    private int rows;
    private int cols;
    private Pixel[][] matrix;
    
    public MatrixPixels(){
        
    }
    
    
    public void setMatrix(Pixel[][] mat){
        this.matrix=mat;
    }
    
    public Pixel[][] getMatrix() {
        return matrix;
    }
    
    
    public Pixel getPixel(int x, int y) {
        return matrix[x][y];
    }

    public void setPixel(Pixel pix, int x, int y) {
        matrix[x][y] = pix;
    }
    
    public void operate(MatrixOperation operation) {
        int rows = this.matrix.length;
        int cols = this.matrix[0].length;
        Pixel[][] newMatrix = new Pixel[rows][cols];        
        for (int i = 0; i < rows; i++) {            
            for (int j = 0; j < cols; j++) {
                Pixel pixel = operation.withPixel(i, j, this.matrix);
                newMatrix[i][j] = pixel;
            }
        }
        
        this.matrix = newMatrix;
    }


    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        int i;
        int j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                matrixString.append(matrix[i][j].toString());
            }
            matrixString.append("\n");
            
            for (j = 0; j < cols; j++) {
                matrixString.append("--------------------------------");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();    }

    
}
