/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Posicion {

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    private int x;
    private int y;
    private int despX;
    private int despY;
    
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    /* public void actualizarPosicion () {
        setX( getX() + getDespX() );
        setY( getY() + getDespY() );
    }*/
    
    public void nuevaPosicion () {
       setX( getX() + getDespX() );
       setY( getY() + getDespY() );
   }

    public int getDespX() {
        return despX;
    }

    public void setDespX(int despX) {
        this.despX = despX;
    }

    public int getDespY() {
        return despY;
    }

    public void setDespY(int despY) {
        this.despY = despY;
    }
    
  
}
