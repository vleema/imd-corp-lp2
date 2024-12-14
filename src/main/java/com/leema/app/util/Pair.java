package com.leema.app.util;

import java.util.List;

public class Pair<K, V> {

	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public List<K> listOutL(List<Pair<K, V>> lista) {
		return lista.stream().map(Pair::getKey).toList();
	}

	public List<V> listOutR(List<Pair<K, V>> lista) {
		return lista.stream().map(Pair::getValue).toList();
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
