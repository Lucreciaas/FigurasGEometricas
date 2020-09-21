import java.awt.Color;

public class Rectangulo extends FiguraGeometrica {

    private int lado1;
    private int lado2;
    
  
    public Rectangulo(int lado1, int lado2, int x, int y){
        super (x,y);
        this.lado1 = lado1;
        this.lado2 = lado2;
        determinarColor();
    }

    // Determina el color del rectangulo segun la superficie

    private void determinarColor() {
        if (getSuperficie() < 100) {
            setColor(Color.BLUE);
        }
        else if (getSuperficie() < 200) {
            setColor(Color.GREEN);
        }
        else if (getSuperficie() < 300) {
            setColor(Color.YELLOW);
        }
        else if (getSuperficie() < 400) {
            setColor(Color.ORANGE);
        }
        else if (getSuperficie() < 500) {
            setColor(Color.RED);
        }
        else {
            setColor(Color.MAGENTA);
        }
    }


    public int getSuperficie() {
        return lado1 * lado2;        
    }

     public double getPerimetro () {
        return 0.0;
    }
   
    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

 

}

