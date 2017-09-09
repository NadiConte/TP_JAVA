package controlers;

import java.util.ArrayList;

import data.DataElemento;
import data.DataTipoElemento;
import entity.Elemento;
import entity.TipoElemento;
import ui.AMBCElemento;
public class CtrlABMElemento {
	

	private DataElemento dataElem;
	private DataTipoElemento dataTipo;
	private AMBCElemento iuEl;
	
	public void add(Elemento e){
		dataElem= new DataElemento();
		dataElem.add(e);
		
		}
	public void delete(Elemento e){
		dataElem= new DataElemento();
		dataElem.delete(e);
		
		}

	public void update(Elemento e){
		dataElem= new DataElemento();
		dataElem.update(e);
		
		}

	public Elemento getByNombre(Elemento e){
		dataElem= new DataElemento();
		return this.dataElem.getByNombre(e);
	
	}
	
	public Elemento getByTipo(String tipo){
		dataElem= new DataElemento();
		return this.dataElem.getByTipo(tipo);
	
	}	
	
	public Elemento getByNombre(String nombre){
		Elemento e=new Elemento();
		e.setNombre(nombre);
		return getByNombre(e);
		
	}
	

public ArrayList<Elemento> getElementos(String tipoel){ //por alguna extraña razon explota en esta linea
	return dataElem.getAll(tipoel);
	}
	
	/*public ArrayList<Elemento> getAll(String tipoel){
		dataElem= new DataElemento();
		return dataElem.getAll(tipoel);
	}
	*/
	public ArrayList<TipoElemento> getTipo(){
		return dataTipo.getAll();
	}
		
	
	public void DialogoElementos() {
		iuEl = new AMBCElemento();
		iuEl.start();// TODO Auto-generated method stub	
	}
}
