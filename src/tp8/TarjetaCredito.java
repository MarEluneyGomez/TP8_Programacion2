package tp8;


public class TarjetaCredito implements PagoConDescuento {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con Tarjeta de Crédito: $" + monto);
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        System.out.println("Aplicando descuento del " + porcentaje + "% por pago con tarjeta.");
        return porcentaje;
    }
}
