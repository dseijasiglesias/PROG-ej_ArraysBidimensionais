package arraysbidimensionais;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ArraysBidimensionais {

    public static void main(String[] args) {
        
        //Matriz: 4 cidades, 3 temperaturas;
        String [] cidades = {"Vigo", "Pontevedra", "Compostela", "Ourense"};
        String [] dias = {"Luns", "Mercores", "Venres"};
        int [][] temperatura = {{ 15, 12, 16}, {10, 11, 11}, {7, 8, 9}, {6, 5, 7}};
        int f, c, dato;
        
        float medias[] = new float[cidades.length];
        float med[];
        
        boolean modificador = false;
        do{
            int dato2 = JOptionPane.showOptionDialog(null, ("Que desea comprobar?"), 
                    "Seijas's Arrays", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                    new Object[]{"Introducir datos", "Visualizar temperaturas", "visualizar tabla", "Medias+", "Salir"}, null);
            
            switch(dato2){
                
                //escribir manualamnete en el array
                case 0:
                    
                    boolean modificador2 = false;
                    
                    do{
                        int dato3 = JOptionPane.showOptionDialog(null, "Que elementos desea introducir?", "Introducion manual de elementos", JOptionPane.YES_NO_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Cidades, dias, e temperaturas", "Cidades e temperaturas", "Dias e temperaturas", "Cidades e Dias", "Temperaturas", "Generar temperaturas", "Volver"}, null);
                    
                        switch(dato3){
                            case 0:
                                cidades = Metodos.introducion_cidades();
                                dias = Metodos.introducion_dias();
                                temperatura = Metodos.introducion_temeraturas(cidades, dias);
                                break;
                                
                            case 1:
                                cidades = Metodos.introducion_cidades();
                                temperatura = Metodos.introducion_temeraturas(cidades, dias);
                                break;
                                
                            case 2:
                                dias = Metodos.introducion_dias();
                                temperatura = Metodos.introducion_temeraturas(cidades, dias);
                                break;
                                
                            case 3:
                                cidades = Metodos.introducion_cidades();
                                dias = Metodos.introducion_dias();
                                temperatura = Metodos.generar_temperaturas(cidades, dias);
                                break;
                            
                            case 4:
                                temperatura = Metodos.introducion_temeraturas(cidades, dias);
                                break;
                            
                            case 5:
                                temperatura = Metodos.generar_temperaturas(cidades, dias);
                                break;
                            
                            case 6:
                                modificador2 = true;
                                break;
                                
                            default:
                                modificador2 = true;
                                break;
                        }
                    }while(modificador2 == false);
                    //temperatura = Metodos.introducion(cidades, dias);
                    break;
                
                    //visualizar matriz
                case 1:
                    Metodos.visualizar_matriz(temperatura, cidades, dias);
                    break;
                    
                    //visualizar tabla
                case 2:
                    Metodos.visualizar_nina(temperatura, cidades, dias);
                    break;
                    
                    //medias
                case 3:
                    boolean modificador1 = false;
                    do{
                        int dato3 = JOptionPane.showOptionDialog(null, ("Que media desea ver?"), 
                                "Seijas's Arrays - Medias", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                                new Object[]{"Medias por ciudad", "Elegir ciudad para ver media", "visualizar tabla", "Medias de temperaturas por ciudades", "Volver"}, null);
                        
                        switch(dato3){
                            
                            //medias de todas las ciudades
                            case 0:
                                med = Metodos.mediasArray(temperatura, medias);
                                Metodos.visualizar_array(med, cidades);
                                break;
                            
                            case 1:
                                String pedido = JOptionPane.showInputDialog("Que ciudad deseas ver");
                                Metodos.mediaIndividual(temperatura, cidades, pedido);
                                break;
                            
                            default:
                                modificador1 = true;
                                break;
                        }
                    }while(modificador1 == false);
                    break;
                    
                    
                    //salir del programa
                case 5:
                    modificador = true;
                    break;
                    
                    //sallir del prorama
                default:
                    modificador = true;
                    break;
            }
                
        }while(modificador ==  false);
        
        
    }
}