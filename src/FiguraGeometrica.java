import java.awt.Color;

public abstract class FiguraGeometrica {
    private Color color ;
    private Posicion pos;
    
    public FiguraGeometrica() {
        pos = new Posicion (0, 0);
           }

    public FiguraGeometrica(int x, int y) {
        pos = new Posicion (x, y);
    }
    
    public FiguraGeometrica (int x, int y, Color color) {
        this.color = color;
        pos = new Posicion(x, y);
    }
    
    public FiguraGeometrica (Posicion pos, Color color) {
        this.color = color;
        this.pos = pos;
    }
    
    // Metodos abstractos -> deben implementarlos las subclases
    public abstract double getSuperficie ();
    public abstract double getPerimetro ();
    /**
     * Actualizar posicion del objeto
     */
   public void actualizarPosicion () {
       getPos().nuevaPosicion();
   }
   public Posicion getPos() {
        return pos;
    }
   
   public void setPos (Posicion pos){
        this.pos = pos;
    }
   public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
 
}
