package com.photel.data.gen.ddbb;

import java.util.Comparator;

import com.photel.interfaces.data.gen.IGenScripts;

public class ScriptsComparator implements Comparator<IGenScripts> {

	@Override
	public int compare(IGenScripts s1, IGenScripts s2) {
		int ret = s1.getGenOrder().compareTo(s2.getGenOrder());
		return ret;
	}

	

	
}
