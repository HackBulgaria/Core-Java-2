package matrixPixel;

public class BrightnessReducer implements MatrixOperation{
    private float reduceFactor;
    public BrightnessReducer(float bfact){
        super();
        this.reduceFactor=bfact;
    }
    

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        
       return new Pixel(matrix[x][y].getR()*this.reduceFactor,
               matrix[x][y].getG()*this.reduceFactor,matrix[x][y].getB()*this.reduceFactor);
    }

}
