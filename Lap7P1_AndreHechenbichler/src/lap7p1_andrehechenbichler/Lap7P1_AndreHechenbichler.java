/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//fila 3, silla 3
package lap7p1_andrehechenbichler;
//esto es pura humildad
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author andre
 */
public class Lap7P1_AndreHechenbichler {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*************MENU*************");
        System.out.println("1. Tres en raya");
        System.out.println("2. Puntos de silla");
        System.out.println("3. Para salir");
        int op = leer.nextInt();
        while (op > 0 && op < 3) {
            switch (op) {
                case 1: {
                    int columna = 3;
                    int fila = 3;
                    System.out.println("TABLERO ACTUAL");
                    char[][] matrices = new char[fila][columna];
                    matrices = x0(fila, columna);
                    imprimir2(matrices);
                    //turno 1
                    System.out.println("Es el turno de el jugador X");
                    System.out.println("Ingrese la fila (0, 1, 2)");
                    int filax = leer.nextInt();
                    while (filax < -1 || filax > 3) {
                        System.out.println("Ingrese la fila (0, 1, 2) correctamente");
                        filax = leer.nextInt();
                    }
                    System.out.println("Ingrese la columna (0, 1, 2)");
                    int columnax = leer.nextInt();
                    while (columnax < -1 || columnax > 3) {
                        System.out.println("Ingrese la columna (0, 1, 2) correctamente");
                        columnax = leer.nextInt();
                    }
                    System.out.println("El usuario a elejido la posicion: " + filax + ", " + columnax);
                    System.out.println("TABLERO ACTUAL");
                    matrices = x00(fila, columna, filax, columnax);
                    imprimir2(matrices);
                    //va y
                    System.out.println("Es el turno de 0");
                    
                    int rand1 = random.nextInt((2 - 0) + 1) + 0;
                    int rand2 = random.nextInt((2 - 0) + 1) + 0;
                    boolean rev = revic(rand1, rand2, filax, columnax);
                    if (rev = true) {
                        rand1 = random.nextInt((2 - 0) + 1) + 0;
                        rand2 = random.nextInt((2 - 0) + 1) + 0;
                    }
                    if (rand1 == filax && rand2 == columnax) {
                        rand1 = random.nextInt((2 - 0) + 1) + 0;
                        rand2 = random.nextInt((2 - 0) + 1) + 0;
                    }
                    System.out.println("La maquina elijio la posicion: " + rand1 + ", " + rand2);
                    System.out.println("TABLERO ACTUAL");
                    matrices = x000(matrices, rand1, rand2, filax, columnax, columna, fila);
                    imprimir2(matrices);
                    //va x
                    System.out.println("Es el turno de el jugador X");
                    System.out.println("Ingrese la fila (0, 1, 2)");
                    int filax2 = leer.nextInt();
                    while (filax2 < -1 || filax2 > 3) {
                        System.out.println("Ingrese la fila (0, 1, 2) correctamente");
                        filax2 = leer.nextInt();
                    }
                    System.out.println("Ingrese la columna (0, 1, 2)");
                    int columnax2 = leer.nextInt();
                    while (columnax2 < -1 || columnax2 > 3) {
                        System.out.println("Ingrese la columna (0, 1, 2) correctamente");
                        columnax2 = leer.nextInt();
                    }
                    while(columnax2==columnax&&filax2==filax||columnax2==rand2&&filax2==rand1){
                        System.out.println("no se puede repetir");
                        System.out.println("Ingrese la fila (0, 1, 2) correctamente");
                        filax2 = leer.nextInt();
                        System.out.println("Ingrese la columna (0, 1, 2) correctamente");
                        columnax2 = leer.nextInt();
                    }
                    System.out.println("El usuario a elejido la posicion: " + filax2 + ", " + columnax2);
                    System.out.println("TABLERO ACTUAL");
                    matrices = x0000(matrices, rand1,  rand2,  filax, columnax, columna, fila, columnax2, filax2);
                    imprimir2(matrices);
                    //y 2
                    System.out.println("Es el turno de 0");
                    
                    int rand3 = random.nextInt((2 - 0) + 1) + 0;
                    int rand4 = random.nextInt((2 - 0) + 1) + 0;
                    if (rand3 == filax && rand4 == columnax||rand3==filax2&&rand4==columnax2||rand3==rand1&&rand4==rand2) {
                        rand4 = random.nextInt((2 - 0) + 1) + 0;
                        rand2 = random.nextInt((2 - 0) + 1) + 0;
                    }
                    System.out.println("La maquina elijio la posicion: " + rand3 + ", " + rand4);
                    System.out.println("TABLERO ACTUAL");
                    matrices = x0000(matrices, rand1, rand2, filax2, columnax2, columna, fila, filax, columnax);
                    imprimir2(matrices);
                    break;
                }
                case 2: {
                    System.out.println("Indique tamaño fila: "); 
                    int fila=leer.nextInt();
                    System.out.println("Indique tamaño columna: ");
                    int columna=leer.nextInt();
                    int [][] matrices=new int[fila][columna];
                    matrices=generarIntMatrizAleaotria(fila,columna);
                    System.out.println("Matriz generada");
                    imprimir(matrices);
                    System.out.println("Punto de seukka en la matriz es");
                    encontrarPuntoSilla(fila, columna, matrices);
                    
                break;}

            }
            System.out.println("*************MENU*************");
            System.out.println("1. Tres en raya");
            System.out.println("2. Puntos de silla");
            System.out.println("3. Para salir");
            op = leer.nextInt();
        }
    }
    public static int [][] generarIntMatrizAleaotria(int fila, int columna){
        int[][]temp=new int[fila][columna];
        for(int i=0; i<fila;i++){
            for(int j=0;j<columna;j++){
                temp[i][j]=random.nextInt((99-0)+1)+0;
            }
        }
    return temp;
    }
    public static void imprimir(int [][] matriz){
        for(int i=0; i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if(matriz[i][j]>10){
                System.out.print(matriz[i][j]+" ");
                }else{
                    System.out.print(matriz[i][j]+"  ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void encontrarPuntoSilla(int fila, int columna, int[][] matrices){
        boolean veri=false;
        boolean veri2=false;
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                for(int k=0;k<columna;k++){
                    if(matrices[fila][j]<matrices[i][j]){
                        veri=false;
                    }else{
                        veri=true;
                        }
                }
                for(int k=0;k<fila;k++){
                    if(matrices[i][columna]>matrices[i][j]){
                        veri=false;
                    }else{
                         veri2=true;
                    }
                }
                if(veri==true&&veri2==true){
                    System.out.println("Punto de silla en Matriz["+i+"]["+j+"]: "+matrices[i][j]);
                    veri=true;
                }
            }
        }
        if(veri==false||veri2==false){
            System.out.println("No se encontro ningun punto en la silla de la matriz");
        }
    }
    //public static char[][] nuevo(char matrices, int filax, int columnax){
    //char x='X';
    //  matrices[filax][columnax]='X';
    //}//
    public static void imprimir2(char[][] matrizestatic) {
        for (int i = 0; i < matrizestatic.length; i++) {
            for (int j = 0; j < matrizestatic[i].length; j++) {
                System.out.print("[" + matrizestatic[i][j] + "] ");
            }
            System.out.println("");
        }
    }

    public static boolean revic(int rand1, int rand2, int filax, int columnax) {
        boolean fact = false;
        if (rand1 == filax && rand2 == columnax) {
            fact = true;
        }
        return fact;
    }

    public static char[][] x0(int fila, int columna) {
        char t = ' ';
        char matrizestatic[][] = {{t, t, t},
        {t, t, t},
        {t, t, t}};
        return matrizestatic;
    }

    public static char[][] x00(int fila, int columna, int filax, int columnax) {
        char t = ' ';
        char matrizestatic[][] = {{t, t, t},
        {t, t, t},
        {t, t, t}};
        if (filax > -1 && filax < 3 && columnax > -1 && columnax < 3) {
            matrizestatic[filax][columnax] = 'X';
            int marc1=matrizestatic[filax][columnax];
        }
        return matrizestatic;
    }

    public static char[][] x000(char[][] matrices, int rand1, int rand2, int filax, int columnax, int columna, int fila) {
        matrices = x00(fila, columna, filax, columnax);
        char matrizestatic[][] = matrices;
        if (rand1 > -1 && rand1 < 3 && rand2 > -1 && rand2 < 3) {
            matrizestatic[rand1][rand2] = '0';
        }
        return matrizestatic;
    }

    public static char[][] x0000(char[][] matrices, int rand1, int rand2, int filax2, int columnax2, int columna, int fila, int filax, int columnax) {
        matrices = x000(matrices, rand1, rand2, filax, columnax, columna, fila);
        char matrizestatic[][] = matrices;
        if (filax > -1 && filax < 3 && columnax > -1 && columnax < 3) {
            matrizestatic[filax][columnax] = 'X';
        }
        if (filax2 > -1 && filax2 < 3 && columnax2 > -1 && columnax2 < 3) {
            matrizestatic[filax2][columnax2] = 'X';
        }
        return matrizestatic;
    }
    public static char[][] x00000(char[][] matrices, int rand1, int rand2, int filax, int columnax, int columna, int fila,int filax2,int columnax2,int rand3, int rand4) {
        matrices= x0000(matrices, rand1, rand2, filax2, columnax2, columna, fila, filax, columnax);
        char matrizestatic[][] = matrices;
        if (rand1 > -1 && rand1 < 3 && rand2 > -1 && rand2 < 3) {
            matrizestatic[rand1][rand2] = '0';
        }
        if(rand3 > -1 && rand3 < 3 && rand4 > -1 && rand4 < 3){
            matrizestatic[rand3][rand4]='0';
        }
        return matrizestatic;
    }
    // ya no se q hacer (*︵*)
    public static boolean verificarvictoria(char[][]matrices,char columnax, char filax, int fila, int columna){
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                if(matrices[i][j]==matrices[filax][columnax]){
                    return true;
                }
            }
        }
        for(int j=0;j<columna;j++){
            if(matrices[fila][j]==matrices[filax][columnax]){
                return true;
            }
        }
        return false;
    }
}
