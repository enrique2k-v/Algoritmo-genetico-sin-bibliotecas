import javax.swing.*;
public class Main{

	public static void main(String[] args){
		Generaciones();
	}
	public static void Generaciones(){
		
		int generaciones = 0;
		//poblacion inicial
		Poblacion p=new Poblacion();
		//aptitud de cada cromosoma
		p.AptitudPoblacion();
		String str = "";
		System.out.println(p);
		boolean parada=false;
		
		while(true){
			
			p.CruzaPoblacion();
			p.MutacionPoblacion();
			p.AptitudPoblacion();
			System.out.println(p);
			
			generaciones++;
			for(int i=0;i<p.poblacion.size();i++){			
				str = p.poblacion.get(i).getCromosoma().toString().replaceAll("\\[|\\]", "").replaceAll(", ","");
				if("holaMundo".equals(str)){
					parada = true;					
					break;	
				}
					str="";
			
				
			}
		
			if(parada == false){
				continue;
			}else{
				break;
			}
			
		}		
	}
}
