package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ColeccionadorDeObjetos {
	
	public Object getFirstFrom(List collection) {
		return collection.get(0);
	}

	public void addLast(Object element, Collection collection) {
		collection.add(element);
	}
	public Collection getSubCollection(List collection, int from, int to) {
		return collection.subList(from, to);
	}
	public Boolean containsElement(Collection collection, Object element) {
		return collection.contains(element);
	}
	
}
