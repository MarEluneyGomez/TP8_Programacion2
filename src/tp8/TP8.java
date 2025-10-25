package tp8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TP8 {

    public static void main(String[] args) {

        System.out.println("=== PARTE 1: Interfaces ===");

        Cliente c1 = new Cliente("Martín");
        Pedido pedido = new Pedido(c1);
        pedido.agregarProducto(new Producto("Teclado", 25000));
        pedido.agregarProducto(new Producto("Mouse", 8000));
        pedido.cambiarEstado("Enviado");

        System.out.println("Total del pedido: $" + pedido.calcularTotal());

        PagoConDescuento pago = new TarjetaCredito();
        System.out.println("Aplicando descuento del 10%...");
        double totalConDescuento = pago.aplicarDescuento(pedido.calcularTotal());
        pago.procesarPago(totalConDescuento);

        System.out.println("\n=== PARTE 2: Excepciones ===");

        Scanner sc = new Scanner(System.in);

        // 1. División segura
        System.out.println("\n[1] División segura");
        try {
            System.out.print("Ingrese dividendo: ");
            int a = sc.nextInt();
            System.out.print("Ingrese divisor: ");
            int b = sc.nextInt();
            System.out.println("Resultado: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        }

        sc.nextLine(); 

        // 2. Conversión de cadena a número
        System.out.println("\n[2] Conversión de cadena a número");
        System.out.println("Se leerá una cadena de texto y se intentará convertirla a número entero.");

        try {
            System.out.print("Ingrese un número en texto: ");
            String texto = sc.nextLine(); 
            int numero = Integer.parseInt(texto); 
            System.out.println("Conversión exitosa. Número convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: El valor ingresado no es un número válido.");
        }

        // 3.1 Lectura de archivo correcta
        System.out.println("\n[3.1] Lectura de archivo correcta");
        try (BufferedReader br = new BufferedReader(new FileReader("src/tp8/archivo.txt"));){

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        // 3.2 Lectura de archivo con error
        System.out.println("\n[3.2] Lectura de archivo con error");
        try (BufferedReader br = new BufferedReader(new FileReader("src/tp8/alchivo.txt"));){
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        // 4. Excepción personalizada
        System.out.println("\n[4] Validación de edad");
        try {
            System.out.print("Ingrese su edad: ");
            int edad = sc.nextInt();
            validarEdad(edad);
            System.out.println("Edad válida: " + edad);
        } catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5.1 try-with-resources correcto
        System.out.println("\n[5.1] Lectura con try-with-resources");
        try (BufferedReader br = new BufferedReader(new FileReader("src/tp8/archivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }

        // 5.2 try-with-resources con error
        System.out.println("\n[5.2] Lectura con try-with-resources (archivo con error)");
        try (BufferedReader br = new BufferedReader(new FileReader("src/tp8/alchivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }

    }

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe estar entre 0 y 120 años.");
        }
    }
}
    
