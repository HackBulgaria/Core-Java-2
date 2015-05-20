package matrixPixel;

public class Pixel {
    private float R;
    private float G;
    private float B;

    public Pixel(){
        
    }

    public Pixel(float f, float h, float i) {
        super();
        this.R = f;
        this.G = h;
        this.B = i;
    }

    public float getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public float getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public float getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    @Override
    public String toString() {
        return "Pixel (Red:" + R + ", Green:" + G + ", Blue:" + B + ")";
    }
    
    
    
}
