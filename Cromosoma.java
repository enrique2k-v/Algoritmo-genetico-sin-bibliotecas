/**
*La clase cromosoma representa la posible solucion de nuestro algoritmo genetico 
*@autor Jose Enrique Vargas Oaxaca
*@version 1.0 15/09/2021
*/

import java.util.ArrayList;

public class Cromosoma implements Comparable<Cromosoma>{

	private ArrayList<Character> cromosoma = new ArrayList<Character>();
	private String objetivo = "hola";
	public int aptitud=0;
		
	public Cromosoma(){
		this.Inicializar();
	}
	
	public ArrayList getCromosoma(){
		return this.cromosoma;
	}
	
	/**
	*El metodo Inicializar coloca el conjunto de genes a nuestro comomosma 	
	*	
	*/
	public void Inicializar(){
		for(int i=0;i<objetivo.length();i++){
			this.cromosoma.add(this.objetivo.charAt((int)(Math.random()*objetivo.length()+0)));
		}
		
	}
	
	/**
	*El metodo FuncionAptitud permite ver la aptiud de un individuo
	*con repecto al objetivo
	*@return aptitud del individuo
	*/
	public int FuncionAptitud(){
		for(int i=0;i<this.cromosoma.size();i++){
			if(Character.compare(cromosoma.get(i),this.objetivo.charAt(i))==0){
				this.aptitud++;
			}
		}
	return this.aptitud;
	}
	
	public String toString(){
		return "El cromosoma es: "+ this.cromosoma + " y su aptitud es: "+ this.aptitud;	
	}

	/**
	*El metodo Cruza permite crear nuevos hijos 
	*
	*/	
	
	public void Cruza(Cromosoma padre,Cromosoma madre){
		char padreTemporal;
		for (int i=Math.round(objetivo.length()/3);i<Math.round((objetivo.length()/3)*2);i++){
			padreTemporal = padre.cromosoma.get(i);
			padre.cromosoma.set(i,madre.cromosoma.get(i));
			madre.cromosoma.set(i,padreTemporal);
		}
	}
	
	/**
	*El metodo de Mutacion modifica un solo elemento del cromosoma
	*/
	public void Mutacion(Cromosoma hijo1 ,Cromosoma hijo2){
		hijo1.cromosoma.set((int)(Math.random()*objetivo.length()+0),this.objetivo.charAt((int)(Math.random()*objetivo.length()+0)));
		hijo2.cromosoma.set((int)(Math.random()*objetivo.length()+0),this.objetivo.charAt((int)(Math.random()*objetivo.length()+0)));
	}
	
	@Override
	public int compareTo(Cromosoma p1) {
		return  new Integer(this.aptitud).compareTo(new Integer(p1.aptitud));
	}
	
}
