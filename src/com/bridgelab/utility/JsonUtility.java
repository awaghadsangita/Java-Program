package com.bridgelab.utility;

import java.util.List;

public class JsonUtility<T,t> {

	public T findClassObject(List<T> objList,t searchItem)
	{
		T obj=null;
		for(int i=0;i<objList.size();i++)
        {
      	  if(objList.get(i).equals(searchItem))
      	  {
      		obj=objList.get(i);
      	  }
        }
		return obj;
	}
	
}
