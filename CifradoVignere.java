package Cifrados;

public class CifradoVignere {

    public static void main(String[] args) {

        char[] abecedario = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String cadena = "JJVO";
        String clave = "culo";
        boolean opcion = false; // false descifrar || true cifrar

        cadena = cadena.toUpperCase();
        cadena = cadena.replaceAll(" ", "");
        char[] arrayCadena = cadena.toCharArray();

        clave = clave.toUpperCase();
        clave = clave.replaceAll(" ", "");
        char[] arrayClave = clave.toCharArray();

        char[] abecedarioDeClave = new char[arrayCadena.length];

        for (int i = 0, j = 0; i < abecedarioDeClave.length; i++, j++) {

            if ((j + 1) > arrayClave.length) {
                j = 0;
            }
            abecedarioDeClave[i] = arrayClave[j];

        }

        if (opcion) {

            System.out.println("M = " + cadena);
            System.out.println("K = " + clave);
            for (int i = 0; i < arrayCadena.length; i++) {

                arrayCadena[i] = abecedario[modulo(
                        encotrarPosicionLetraEnAbecedario(arrayCadena[i], abecedario) +
                                encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario))];

                System.out.println(
                        "M" + i + " = " + (char) cadena.charAt(i) + "+" + abecedarioDeClave[i] + " mod(27)" + " = " +
                                encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario) + "+"
                                + encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario) + " mod(27) = "
                                + (encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario)
                                        + encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario))
                                + " mod(27) = " + modulo((encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario)
                                + encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario))) +" = " +(char) arrayCadena[i]);
            }

        } else {

            System.out.println("C = " + cadena);
            System.out.println("K = " + clave);

            for (int i = 0; i < arrayCadena.length; i++) {

                arrayCadena[i] = abecedario[modulo(
                        encotrarPosicionLetraEnAbecedario(arrayCadena[i], abecedario) -
                                encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario))];

                System.out.println(
                        "M" + i + " = " + (char) cadena.charAt(i) + "-" + abecedarioDeClave[i] + " mod(27)" + " = " +
                                encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario) + "-"
                                + encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario) + " mod(27) = "
                                + (encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario)
                                        - encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario))
                                + " mod(27) = " + modulo((encotrarPosicionLetraEnAbecedario((char) cadena.charAt(i), abecedario)
                                - encotrarPosicionLetraEnAbecedario(abecedarioDeClave[i], abecedario))) + " = " + (char) arrayCadena[i]);

            }
        }

        System.out.println("Resultado: " + new String(arrayCadena));
    }

    public static int encotrarPosicionLetraEnAbecedario(char letra, char[] abecedario) {
        int posicion = 0;

        for (int i = 0; i < abecedario.length; i++) {
            if (letra == abecedario[i]) {
                posicion = i;
                return posicion;
            }
        }

        return -1;
    }

    public static int modulo(int posicion) {
        if (posicion > 26) {
            posicion = posicion - 27;
        }
        if (posicion < 0) {
            posicion = posicion + 27;
        }

        return posicion;
    }

}
