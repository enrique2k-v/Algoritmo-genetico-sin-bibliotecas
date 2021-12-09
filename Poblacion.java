import java.util.ArrayList;
import java.util.*;

/**
*La clase poblacion reprenta el conjunto de posibles soluciones
*@autor Jose Enrique Vargas Oaxaca
*@version 1.0 
*@see Cromosoma
*/
public class Poblacion extends Cromosoma {
	public ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();
	public Cromosoma mejorIndividuo = new Cromosoma();
	
	public Poblacion(){
		InicializarPoblacion();
	}
	/**
	*El metodo InicializarPoblacion permite crear una poblacion de cromosomas
	*
	*/
	public void InicializarPoblacion(){
		for(int i=0;i<6;i++){
			poblacion.add(new Cromosoma());
		}
		
	}
	
	/**
	*El metodo AptitudPoblacion permite conocer la aptitud de cada cromosoma 
	*
	*/
	public void AptitudPoblacion(){
		for(int i=0;i<6;i++){
			poblacion.get(i).aptitud=0;
			poblacion.get(i).FuncionAptitud();
		}
		
	}
	/**
	*El metodo Seleccion permite obtener el mejor individuo para pasar a la siguiente 
	*generacion
	*/
	public void Seleccion(){
		this.AptitudPoblacion();
		Collections.sort(this.poblacion);
		Collections.reverse(this.poblacion);
		this.mejorIndividuo = this.poblacion.get(0);		
		
	}

	/**
	*El metodo cruza permite cruzar dos cromosomas dando como resultado dos hijos
	*hasta que termine de cruzar toda la poblacion
	*/
	public void CruzaPoblacion(){
		for(int i=0;i<=poblacion.size()-2;i+=2){
			super.Cruza(poblacion.get(i),poblacion.get(i+1));
		}
	}
	
	/**
	*El metodo MutacionPoblacion cambiara un bit de cada cromosoma hijo
	*
	*/
	public void MutacionPoblacion(){
		for(int i=0;i<=poblacion.size()-2;i+=2){
			super.Mutacion(poblacion.get(i),poblacion.get(i+1));
		}
		
		//this.Seleccion();
		//this.poblacion.set(this.poblacion.size()-1,this.mejorIndividuo);
	}
	
	public String toString(){
	        String cad = "";
		for(int i=0;i<poblacion.size();i++){	
			cad += poblacion.get(i).getCromosoma() +  "-->" + poblacion.get(i).aptitud+"\n";
		}
		return cad;
	}
	
}
