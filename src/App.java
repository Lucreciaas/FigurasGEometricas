import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class App {
    // Campos para su funcionamiento
    // Canvas es la ventana para graficar
    private Canvas miVentana;
    private Random aleatorio;
    // Mas informacion sobre ArrayList en la API de Java
    // API - Application Programming Interface
    //       Interface para Programacion de Aplicaciones
    //private ArrayList<Circulo> circulos;
  //  private ArrayList<Rectangulo> rectangulos;
  //  private ArrayList<Triangulo> triangulos;
    private ArrayList<FiguraGeometrica> figuras;
    private int ancho = 800;
    private int alto = 600;
    /**
     * Constructor sin parametros
     */
    public App () {
        aleatorio = new Random();
    //    circulos = new ArrayList<>();
    //    rectangulos = new ArrayList<>();
    //    triangulos = new ArrayList<>();
        figuras = new ArrayList<>();
        miVentana = new Canvas("Hola Ventana", ancho, alto);
        miVentana.setVisible(true);
      //  Poligono p= new Poligono();
    }
    /**
     * Solo lanza la aplicacion
     * @param args Los del Sistema Operativo
     * @throws Exception En caso de fallo
     */
    public static void main(String[] args) throws Exception {
        App miAplicacion = new App();
        miAplicacion.ejecutar();
       // miAplicacion.imagenes();
        miAplicacion.triangulos();
        miAplicacion.circulos();
        miAplicacion.rectangulos();
    }
    public void imagenes () {
        Dibujo dibujo = new Dibujo();
        miVentana.dibujarImagen(dibujo.getImagen(), dibujo.getAncho(), dibujo.getAlto());
    }

    public void triangulos () {
        Triangulo t1 = new Triangulo(200, 100);
        t1.getPos().setX(200);
        t1.getPos().setY(200);
        t1.setColor(Color.RED);
        miVentana.setColorDeLapiz(t1.getColor());
        miVentana.rellenarTriangulo(t1.getPos().getX(), t1.getPos().getY(), t1.getBase(), t1.getAltura());
        Triangulo t2 = new Triangulo(100, 250);
        t2.getPos().setX(500);
        t2.getPos().setY(300);
        t2.setColor(Color.BLUE);
        miVentana.setColorDeLapiz(t2.getColor());
        miVentana.rellenarTriangulo(t2.getPos().getX(), t2.getPos().getY(), t2.getBase(), t2.getAltura());
    }
    
     public void circulos () {
        Circulo c1 = new Circulo (100,350,400);
        c1.getPos().setX(350);
        c1.getPos().setY(400);
        c1.setColor(Color.GREEN);
        miVentana.setColorDeLapiz(c1.getColor());
        miVentana.rellenarCirculo(c1.getPos().getX(), c1.getPos().getY(), c1.getRadio());
        Circulo c2 = new Circulo(200,300,100);
        c2.getPos().setX(300);
        c2.getPos().setY(100);
        c2.setColor(Color.YELLOW);
        miVentana.setColorDeLapiz(c2.getColor());
        miVentana.rellenarCirculo(c2.getPos().getX(), c2.getPos().getY(), c2.getRadio());
    }
     
        public void rectangulos () {
        Rectangulo r1 = new Rectangulo (150,100,150,400);
        r1.getPos().setX(150);
        r1.getPos().setY(400);
        r1.setColor(Color.darkGray);
        miVentana.setColorDeLapiz(r1.getColor());
        miVentana.rellenarRectangulo(r1.getPos().getX(), r1.getPos().getY(), r1.getLado1(), r1.getLado2());
        Rectangulo r2 = new Rectangulo(100,50,200,100);
        r2.getPos().setX(200);
        r2.getPos().setY(100);
        r2.setColor(Color.PINK);
        miVentana.setColorDeLapiz(r2.getColor());
        miVentana.rellenarRectangulo(r2.getPos().getX(), r2.getPos().getY(), r2.getLado1(), r2.getLado2());
    }
          
    /**
     * Metodo para ejecutar las diferentes actividades
     */
    public void ejecutar () {
        // PrimerosEjemplos();
        // Metodo para movimiento de circulo
        // PelotaRebotando();
        // CrearFigurasGeometricas();
        CrearFigurasAleatorias(30);
        MostrarSuperficies();
        MostrarPerimetros();
        // Variable local para un subconjunto de los circulos
        //ArrayList<Circulo> enRango;
        // Selecciona los circulos que cumplen la condicion del radio
        //enRango = CirculosConRadioEnRango(40, 70);
        // Establece el color de los circulos de la coleccion
        //PintarCirculos(enRango, Color.BLUE);
        // Selecciona los circulos que cumplen la condicion del radio
        //enRango = CirculosConRadioEnRango(70, 100);
        // Establece el color de los circulos de la coleccion
        //PintarCirculos(enRango, Color.RED);
        miVentana.espera(15000);
        
        /*GraficarCirculosColeccionados();
        for (int i = 0; i < 100 ; i++) {
            miVentana.espera(500);
            BorrarCirculosColeccionados();
            ActualizarPosicionCirculos();
            if (i == 15) {
                PintarCirculos(circulos, Color.MAGENTA);
            }
            GraficarCirculosColeccionados();
        }*/
        // TODO - Repetir la animacion para Rectangulo
    }
        private void MostrarSuperficies() {
        for (FiguraGeometrica f : figuras) {
            // f -> tipo estatico FiguraGeometrica -> verifica el compilador
            System.out.println(f.getSuperficie());
            // dado el polimorfismo en la herencia
            // en ejecucion -> f -> tipo dinamico -> verifica la JVM
        }
    }
        
        private void MostrarPerimetros() {
        for (FiguraGeometrica f : figuras) {
            // f -> tipo estatico FiguraGeometrica -> verifica el compilador
            System.out.println(f.getPerimetro());
            // dado el polimorfismo en la herencia
            // en ejecucion -> f -> tipo dinamico -> verifica la JVM
        }
    }
    /**
     * Selecciona los circulos que cumplen la condicion del radio
     * @param min Radio minimo a considerar
     * @param max Radio maximo a considerar
     * @return La lista con circulos que cumplen la condicion
     */
    /*public ArrayList<Circulo> CirculosConRadioEnRango(int min, int max) {
        // Creo la nueva lista de circulos
        ArrayList<Circulo> lista = new ArrayList<>();
        for (Circulo c : circulos) {
            // Si esta en rango
            if ( (min <= c.getRadio()) && (c.getRadio() <= max) ) {
                // Lo agrego a la NUEVA lista
                lista.add(c);
            }
        }
        // Devuelvo los circulos que cumplen la condicion
        return lista;
    }*/
    
    // TODO - RectangulosConSuperficieEnRango()
    /**
     * Toma los circulos que se encuentran en las posiciones
     * entre 0 y 300 en X y entre 0 y 300 en Y
     * @return La lista de circulos en ese sector
     */
    public ArrayList<Circulo> CirculosEnUnArea () {
        // TODO - Implementar
        return null; // Reemplazar por la lista
    }
    
    // TODO - RectangulosEnUnArea()
    /**
     * Establece el color de los circulos de la coleccion
     * @param lista Los circulos a pintar
     * @param color El color para pintar los circulos
     */
   /* public void PintarCirculos(ArrayList<Circulo> lista, Color color) {
        for (Circulo c : lista) {
            c.setColor(color);
        }
    }*/
    // TODO - PintarRectangulos()
    /**
     * Genera los objetos graficos en forma aleatoria
     * y los agrega a la coleccion correspondiente
     * @param cantidad Cantidad de figuras a crear
     */
    /*public void CrearFigurasAleatorias (int cantidad) {
        for (int c = 0; c < cantidad; c++) {
            Circulo circulo = new Circulo ( aleatorio.nextInt(91) + 10 );
            circulo.getPos().setX( aleatorio.nextInt( getAncho() ) );
            circulo.getPos().setY ( aleatorio.nextInt( getAlto() ) );
            circulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            circulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );
            // Lo agrego en la coleccion
            circulos.add(circulo);
            // TODO - Repetir lo mismo para Rectangulo
        }*/
    public void CrearFigurasAleatorias (int cantidad) {
        for (int c = 0; c < cantidad; c++) {
            Circulo circulo = new Circulo (aleatorio.nextInt(91) + 10,
                                           aleatorio.nextInt( getAncho() ),
                                           aleatorio.nextInt( getAlto() ) );
            circulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            circulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );
            // Lo agrego en la coleccion
            // circulos.add(circulo);
            figuras.add(circulo);
            Triangulo triangulo = new Triangulo (aleatorio.nextInt(91) + 10,
                                        aleatorio.nextInt(91) + 10,
                                        aleatorio.nextInt( getAncho() ),
                                        aleatorio.nextInt( getAlto() ) );
            triangulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            triangulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );
            figuras.add(triangulo);
            Rectangulo rectangulo = new Rectangulo (aleatorio.nextInt(91) + 10,
                                        aleatorio.nextInt(91) + 10,
                                        aleatorio.nextInt( getAncho() ),
                                        aleatorio.nextInt( getAlto() ) );
            rectangulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            rectangulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );
            figuras.add(rectangulo);
    }
    }
    /**
     * Genera los objetos graficos y los agrega a la
     * coleccion correspondiente
     */
   /* public void CrearFigurasGeometricas () {
        System.out.println("Hay " + circulos.size() + " circulos creados");
        // Creo el primer objeto circulo
        Circulo circulo = new Circulo (100);
        circulo.getPos().setX(150);
        circulo.getPos().setY(150);
        circulo.getPos().setDespX(5);
        circulo.getPos().setDespY(5);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");
        // Creo el segundo objeto circulo
        circulo = new Circulo (50);
        circulo.getPos().setX(300);
        circulo.getPos().setY(250);
        circulo.getPos().setDespX(-15);
        circulo.getPos().setDespY(5);
        circulo.setColor(Color.RED);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");
        // Creo el tercer objeto circulo
        circulo = new Circulo (150);
        circulo.getPos().setX(400);
        circulo.getPos().setY(350);
        circulo.getPos().setDespX(5);
        circulo.getPos().setDespY(-15);
        circulo.setColor(Color.BLUE);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");
        // TODO Agregar 3 rectangulos a la coleccion
    }*/
    /**
     * Toma uno a uno los circulos de la coleccion y los
     * grafica en el canvas
     */    
    /* public void GraficarCirculosColeccionados () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            miVentana.setColorDeLapiz(c.getColor());
            miVentana.rellenarCirculo(c.getPos().getX(), c.getPos().getY(), c.getDiametro());
        }
    }
    /**
     * Toma uno a uno los circulos de la coleccion y los
     * grafica en el canvas
     */    
    /* public void BorrarCirculosColeccionados () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            miVentana.borrarCirculo(c.getPos().getX(), c.getPos().getY(), c.getDiametro());
        }
    }*/
    /**
     * Toma uno a uno los circulos de la coleccion y les
     * pide que actualicen su posicion
     */    
    /*public void ActualizarPosicionCirculos () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            c.actualizarPosicion();
        }
    }*/
    /**
     * Toma uno a uno los rectangulos de la coleccion y los
     * grafica en el canvas
     */    
    /*public void GraficarRectangulosColeccionados () {
        // TODO implementar el metodo
    }*/
    /**
     * Simula el rebote de una pelota en los bordes de la ventana
     */
    /* public void PelotaRebotando () {
        int desplazamiento = 10;
        Circulo circulo = new Circulo (20);
        circulo.getPos().setX(150);
        circulo.getPos().setY(350);
        miVentana.setColorDeLapiz(circulo.getColor());
        miVentana.rellenarCirculo(circulo.getPos().getX(), circulo.getPos().getY(), circulo.getDiametro());
        miVentana.espera(5000);
        for ( int repeticiones = 0 ; repeticiones < 600 ; repeticiones++ ) {
            miVentana.borrarCirculo(circulo.getPos().getX(), circulo.getPos().getY(), circulo.getDiametro());
            // Verifica rebote en los bordes
            if ((circulo.getPos().getX() + circulo.getDiametro() >= getAncho()) || 
                    (circulo.getPos().getX() <= 0)) {
                desplazamiento = - desplazamiento;
            }
            circulo.getPos().setX( circulo.getPos().getX() + desplazamiento );
            // Agreguen movimiento vertical
            // circulo.setY( circulo.getY() - 5 );
            miVentana.rellenarCirculo(circulo.getPos().getX(), circulo.getPos().getY(), circulo.getDiametro());
            miVentana.espera(75);
        }
        
    }
    public void RectanguloRebotando () {
        
    }
     /* public void PrimerosEjemplos () {
        Circulo circulo1 = new Circulo (100);
        Circulo circulo2 = new Circulo (300);
        Circulo circulo3 = new Circulo (1600);
        // Codificar acciones parecidas para la 
        // clase Rectangulo
        // Rectangulo ...
        circulo1.getPos().setX(250);
        circulo1.getPos().setY(250);
        circulo2.getPos().setX(150);
        circulo2.getPos().setY(150);
        // Dibujamos el primer Circulo
        // miVentana.setColorDeLapiz(Color.GREEN);
        miVentana.setColorDeLapiz(circulo3.getColor());
        miVentana.rellenarCirculo(circulo3.getPos().getX(), circulo3.getPos().getY(), circulo3.getDiametro());
        miVentana.setColorDeLapiz(circulo2.getColor());
        miVentana.rellenarCirculo(circulo2.getPos().getX(), circulo2.getPos().getY(), circulo2.getDiametro());
        miVentana.setColorDeLapiz(circulo1.getColor());
        miVentana.rellenarCirculo(circulo1.getPos().getX(), circulo1.getPos().getY(), circulo1.getDiametro());
        // Dibujar un rectangulo de color ROJO (RED)
        // Rectangulo r = new Rectangulo();
        // rellenarRectangulo(int xPos, int yPos, int ancho, int alto)
        // miVentana.rellenarRectangulo(r.getX(), r.getY(), 400, 300);
        /**
         * Ciclos de repeticion -> permiten iterar
         * 
         * while -> (hacer mientras) -> repeticion indefinida
         * 
         * for -> (para) -> repeticion definida
         */
        /*miVentana.espera(10000);
        // int repeticiones = 0;
        // while (repeticiones < 5) {
        //     miVentana.borrarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        //     circulo1.setX( circulo1.getX() + 10 );
        //     miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        //     repeticiones = repeticiones + 1;
        //     miVentana.espera(500);
        // }
        for ( int repeticiones = 0 ; repeticiones < 100 ; repeticiones++ ) {
            miVentana.borrarCirculo(circulo1.getPos().getX(), circulo1.getPos().getY(), circulo1.getDiametro());
            circulo1.getPos().setX( circulo1.getPos().getX() + 10 );
            circulo1.getPos().setY( circulo1.getPos().getY() - 5 );
            miVentana.rellenarCirculo(circulo1.getPos().getX(), circulo1.getPos().getY(), circulo1.getDiametro());
            miVentana.espera(250);
        }
        
        // DESAFIO
        // Hacer que un circulo crezca de tamaño, por ej. comenzar con
        //  radio = 50 y que llegue a radio = 400
    }
    /**
     * El ancho de la ventana grafica
     * @return el ancho
     */
    
    /**
     * El alto de la ventana grafica
     * @return el alto
     */
     public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
}
