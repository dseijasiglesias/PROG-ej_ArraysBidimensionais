package arraysbidimensionais;

import java.util.Random;
import javax.swing.JOptionPane;

public class Metodos {
    
    public static int[][] introducion_temeraturas(String cidades[], String dias[]){
        int [][] temperatura = new int [cidades.length][dias.length];
        int f, c, dato;
        
        for(f=0; f<temperatura.length; f++){
            for(c=0; c<temperatura[f].length; c++){
                temperatura[f][c] = Integer.parseInt(JOptionPane.showInputDialog(cidades[f] + ", " + dias[c] + ": "));
            }
        }
        return temperatura;
    }
    public static String[] introducion_cidades(){
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Cuantas ciudades desea introducir?"));
        String cidades [] = new String [dato];
        
        for(int i=0; i<cidades.length; i++){
            String ciudad = JOptionPane.showInputDialog("Cidade nº" + (i+1));
            cidades[i] = (ciudad.substring(0, 1).toUpperCase() + ciudad.substring(1).toLowerCase());
        }
        return cidades;
    }
    public static String[] introducion_dias(){
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Cuantos dias desea introducir"));
        String dias [] = new String [dato];
        for(int i=0; i<dias.length; i++){
            dias[i] = JOptionPane.showInputDialog("Introduzca una cadena de cartacteres para el " + (i+1) + "ª dia");
        }
        return dias;
    }
    public static int[][] generar_temperaturas(String cidades[], String dias[]){
        int temperatura[][] = new int [cidades.length][dias.length];
        Random rnd = new Random();
        for(int i=0; i<temperatura.length; i++){
            for(int j=0; j<temperatura[i].length; j++){
                temperatura[i][j] = rnd.nextInt(30);
            }
        }
        return temperatura;
    }
    
    public static void visualizar_matriz(int temperatura[][], String cidades[], String dias[]){
        int f, c, dato;
        String visualizar = "Temperatura de todas las ciudades \n";
        
        for(f=0; f<temperatura.length; f++){
            for(c=0; c<temperatura[f].length; c++){
                visualizar = visualizar + ("\n" + cidades[f] + ", " + dias[c] + ": " + temperatura[f][c]);
            }
            visualizar = visualizar + "\n";
        }
        JOptionPane.showMessageDialog(null, visualizar);
    }
    
    public static void visualizar_array(float med[], String cidades[]){
        String visualizar = "Visualizabdo medias por ciudades: \n";
        for(int i=0; i<med.length; i++){
            visualizar = visualizar + ("\n" + "La media de " + cidades[i] + " es de: " + med[i]);
        }
        JOptionPane.showMessageDialog(null, visualizar);
    }
    
    public static void visualizar_nina(int temperatura[][], String cidades[], String dias[]){
        int f, c, dato;
        
        for(int g=0; g<dias.length; g++){
            if(g==0){
                System.out.print("Cidades | ");
            }
            System.out.print(dias[g] + " | ");
        }
        
        for(f=0; f<temperatura.length; f++){
            System.out.println("\n__________________");
            for(c=0; c<temperatura[f].length; c++){
                if(c==0)
                    System.out.print(cidades[f]);
                System.out.print("\t" + temperatura[f][c] + " | ");
            }
        }
    }
    
    public static void medias(int temperatura[][], String cidades[], String dias[]){
        int f, c, dato;
        
        for(f=0; f<temperatura.length; f++){
            int media = 0, contador = 0;
            for(c=0; c<temperatura[f].length; c++){
                media = media + temperatura[f][c];
                contador++;
            }
            System.out.println("La media de " + cidades[f] + " es de: " + (media/contador));
        }
    }
    
    public static float[] mediasArray(int temperatura[][], float medias[]){
        int f, c, dato;
        for(f=0; f<temperatura.length; f++){
            int sumas = 0, contador = 0;
            for(c=0; c<temperatura[f].length; c++){
                sumas = sumas + temperatura[f][c];
                contador++;
            }
            medias[f] = (sumas/contador);
        }
        return medias;
    }
    
    public static void mediaIndividual(int temperatura[][], String cidades[], String dato){
        int contador = 0;
        int busqueda = -1;
        int resultado = 0;
        dato = (dato.substring(0, 1).toUpperCase() + dato.substring(1).toLowerCase());
        for(int i=0; i<cidades.length; i++){
            if(cidades[i].equalsIgnoreCase(dato)){
                busqueda = i;
            }
        }
        if(busqueda>-1){
            for(int i=0; i<temperatura[busqueda].length; i++){
                resultado = resultado + temperatura[busqueda][i];
                contador++;
            }
            JOptionPane.showMessageDialog(null, "La media de " + dato + " es de: " + (resultado/contador));
        }else{
            JOptionPane.showMessageDialog(null, "La media de " + dato + " no a podido ser calculada por no haber sido encontrada");
        }
        
    }
}
