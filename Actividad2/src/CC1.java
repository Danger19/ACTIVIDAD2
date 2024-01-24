//Aquí importamos la clase Scanner para poder leer
//la entrada del maestro en cuestión.
import java.util.Scanner;
//Declaramos la clase
public class CC1 {

    //Aquí vamos a definir los atributos de clase
    //Estos van a almacenar el nombre y las calificaciones
    private String nombre;
    private double[] calificaciones;

    // Ahora definimos que tome los parámetros de nombre y calificaciones
    //Y los asignamos para los atributos de la clase
    public CC1(String nombre, double[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    // Aquí nos vamos a a trabajar sobre el arreglo de calificaciones
    //vamos con unu bucle for-each donde hacemos el típico promedio
    //sumamos y dividimos por la longitud del arreglo
    public double CPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    // Ahora nos vamos a la calificación final (que proviene del promedio)
    // Tomamos el parametro y definimos según la tabla el carácter que
    //va a devolver por medio de un if
    public char Final(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Aquí vamos a pedirle al maestro que ingrese los datos de su
    //alumno, solicitamos nombre y calificaciones y las devolvemos
    public static CC1 Usuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        double[] calificaciones = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese la calificación " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextDouble();
        }

        return new CC1(nombre, calificaciones);
    }

    // Aquí vamos a imprimir el nombre, calificaciones, promedio y la final
    public void Resultados() {
        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        double promedio = CPromedio();
        char calificacionFinal = Final(promedio);

        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + calificacionFinal);
    }

    // Y por último hacemos un método main creando una instanica de CC1
    //Con el método Usuario y luego llamando al método Resultados para
    //verlo en la consola
    public static void main(String[] args) {
        CC1 calculadora = Usuario();
        calculadora.Resultados();
    }
}

