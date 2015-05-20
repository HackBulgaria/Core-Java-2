package cars;

class Car {
    private String brand;
    private int mileage;
    
    public Car(){
        this.mileage=0;
    }
   
    

    public Car(String brand, int mileage) {
        super();
        this.setBrand(brand);
        this.setMileage(mileage);
    }



    public String getBrand() {
        return brand;
    }



    public void setBrand(String brand) {
        this.brand = brand;
    }



    public int getMileage() {
        return mileage;
    }



    public void setMileage(int mileage) {
        if(mileage>0){
        this.mileage = mileage;
        }
        else{
            System.out.println("Mileage should be possitive number!");
        }
    }

    

    @Override
    public String toString() {
        return "The brand is " + brand + ", mileage=" + mileage + "]";
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
