package com.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Tax implements List<Tax> {
	private int id;
	private int employeeId;
	private int taxyear;
	private double taxableincome;
	private double amount;
	public Tax() {
	
		
	}
	public Tax(int id, int employeeId, int taxyear, double taxableincome, double amount) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.taxyear = taxyear;
		this.taxableincome = taxableincome;
		this.amount = amount;
	}
	public Tax(int employeeId, int taxyear, double taxableincome, double amount) {
		super();
		this.employeeId = employeeId;
		this.taxyear = taxyear;
		this.taxableincome = taxableincome;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getTaxyear() {
		return taxyear;
	}
	public void setTaxyear(int taxyear) {
		this.taxyear = taxyear;
	}
	public double getTaxableincome() {
		return taxableincome;
	}
	public void setTaxableincome(double taxableincome) {
		this.taxableincome = taxableincome;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Tax [id=" + id + ", employeeId=" + employeeId + ", taxyear=" + taxyear + ", taxableincome="
				+ taxableincome + ", amount=" + amount + "]";
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<Tax> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(Tax e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends Tax> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends Tax> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Tax get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tax set(int index, Tax element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(int index, Tax element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Tax remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<Tax> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<Tax> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Tax> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
