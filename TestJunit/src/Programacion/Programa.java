package Programacion;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Programaci�n de tareas. Se trata de una serie de tareas ejecutadas en
 * determinados horarios.
 *
 * @author <a href="mailto:oegoni@gmail.com"> Oscar E. Go�i</a>
 */

public class Programa {

	private ArrayList _items;

	/**
	 * Construye una instancia de un programa
	 */
	public Programa() {
		_items = new ArrayList();
	}

	/**
	 * Retorna cantidad de veces q se repetir� una tarea.
	 * 
	 * @param Tarea tarea que se tomar� en cuenta para contar
	 * @return Ocurrencias de la tarea en la programaci�n actual.
	 */
	public int getCantOcurrencias(Tarea tSearch) {
		Iterator i = _items.iterator();
		int cont = 0;
		while (i.hasNext()) {
			Programacion p = (Programacion) i.next();
			Tarea t = p.getTask();
			if (t == tSearch)
				cont++;

		}
		return cont;
	}

	/**
	 * Retorna cantidad de tareas que se ejecutan entre dos horarios
	 * 
	 * @param t1 tiempo de inicio
	 * @param t2 tiempo de fin
	 * @return Ocurrencias de la tarea en la programaci�n actual.
	 */
	public int getCantTareasEntre(Date t1, Date t2) {
		Iterator i = _items.iterator();
		int cont = 0;
		while (i.hasNext()) {
			Programacion p = (Programacion) i.next();
			if ((p.getInicio().getTime() > t1.getTime()) && (p.getFin().getTime() < t2.getTime()))
				cont++;
		}
		return cont;
	}

	/**
	 * Agrega una programacion al programa actual
	 * 
	 * @param p Programacion.
	 */
	public void addProgramacion(Programacion p) {
		_items.add(p);
	}

	/**
	 * Elimina una programaci'on.
	 * 
	 * @param p Programacion a eliminar del programa.
	 * @throws ProgramacionNoEncontradaFoundException Si no existe esa programaci'on
	 *                                                dentro del programa.
	 */
	public void removeProgramacion(Programacion p) throws ProgrmacionNoEncontradaException {
		if (!_items.remove(p)) {
			throw new ProgrmacionNoEncontradaException();
		}
	}

	/**
	 * Retorna la cantidad de programaciones ue posee un programa
	 * 
	 * @return Cantidad de programaciones.
	 */
	public int getCantProgramaciones() {
		return _items.size();
	}

	/**
	 * Elimina todas las programaciones.
	 */
	public void eliminarProgramaciones() {
		_items = new ArrayList();
	}

	/**
	 * Indica si no hay programaciones por realizar.
	 * 
	 * @return true si no hay programaciones y falso en caso contrario.
	 */
	public boolean programaVacio() {
		return (_items.size() == 0);
	}

	public void iniciar() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		// latch.await();

		/*
		 * for(int i =0;i<100; i++) try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}
}