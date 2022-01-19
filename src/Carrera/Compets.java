
package Carrera;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Compets extends Thread{
    private JLabel etiqueta;
    private frameCompets pets;

    public Compets(JLabel etiqueta, frameCompets pets) {
        this.etiqueta = etiqueta;
        this.pets = pets;
    }
    
    @Override
    public void run(){
        int cat=0;
        int dog=0;
        while(true){ //bucle infinito
            try{
                sleep((int)(Math.random()*2000));
                cat=pets.getCat().getLocation().x;
                dog=pets.getDog().getLocation().x;
                
                if(cat<pets.getMeta().getLocation().x-125 && dog<pets.getMeta().getLocation().x-125){
                    etiqueta.setLocation(etiqueta.getLocation().x+40,etiqueta.getLocation().y);
                    pets.repaint();
                }
                else{
                    break; //Terminar el bucle
                }
            }
            catch(InterruptedException e){
                System.out.println(e); //Deteccion de errores
            }
            
            if(etiqueta.getLocation().x>=pets.getMeta().getLocation().x-125){
                if(cat>dog){
                    Icon icono=new ImageIcon(getClass().getResource("/Carrera/manchas.png"));
                    JOptionPane.showMessageDialog(null, "Ganó Manchas","Resultado",JOptionPane.INFORMATION_MESSAGE,icono);
                }
                else if(dog>cat){
                    Icon icono=new ImageIcon(getClass().getResource("/Carrera/luffi.png"));
                    JOptionPane.showMessageDialog(null, "Ganó Luffi","Resultado",JOptionPane.INFORMATION_MESSAGE,icono);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empate","Resultado",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}