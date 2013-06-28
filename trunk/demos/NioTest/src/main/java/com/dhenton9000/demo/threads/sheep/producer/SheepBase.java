package com.dhenton9000.demo.threads.sheep.producer;

public abstract class SheepBase {
  private String name = null;
  private int id = 0;
  
  
  public String bleet()
  {
	  return name + " says baah";
  }


public void setName(String name) {
	this.name = name;
}


public String getName() {
	return name;
}


public void setId(int id) {
	this.id = id;
}


public int getId() {
	return id;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}

public String toString()
{
	return "Sheep"+getId()+" -- "+getName();
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SheepBase other = (SheepBase) obj;
	if (id != other.id)
		return false;
	return true;
}
  




}
