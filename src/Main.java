import Implementaciones.GrafoMA;
import Implementaciones.GrafosLD;
import Interfaces.GrafosTDA;

public class Main {
    public static void main(String[] args) {
        probar(new GrafoMA(), "Matriz de adyacencia");
        probar(new GrafosLD(), "Lista de adyacencia");
    }

    static void probar(GrafosTDA g, String nombre) {
        g.inicializarGrafo();
        g.agregarVertice(1);
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarArista(1, 2, 5);
        g.agregarArista(1, 3, 7);

        System.out.println("== " + nombre + " ==");
        System.out.println("Existe 1->2: " + g.existeArista(1, 2));
        System.out.println("Peso 1->3: " + g.pesoArista(1, 3));

        g.eliminarArista(1, 2);
        System.out.println("Existe 1->2 tras eliminarla: " + g.existeArista(1, 2));
    }
}